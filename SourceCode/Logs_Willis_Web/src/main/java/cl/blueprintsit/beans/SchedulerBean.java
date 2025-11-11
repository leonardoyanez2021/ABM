package cl.blueprintsit.beans;

import cl.blueprintsit.process.AccessParameters;
import cl.blueprintsit.process.ReadSFTPJob;
import cl.blueprintsit.type.ConnectionBD;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.sql.SQLException;
import java.util.*;
import java.util.Calendar;

@Startup
@Singleton(name = "SchedulerBean")
public class SchedulerBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(SchedulerBean.class);

    private Scheduler scheduler;
    private Trigger trigger;
    private JobDetail job;

    @PostConstruct
    private void init() {
        try {
            scheduler = new StdSchedulerFactory().getScheduler();
            scheduler.start();

            ConnectionBD connectionBD = new ConnectionBD();
            String time = connectionBD.findTimeEje();
            String[] timeEje = time.split(":");

            job = JobBuilder.newJob(ReadSFTPJob.class).withIdentity("TareaScheduleLog").build();
            if (timeEje[0].equals("00")) { //En que momento va a iniciar la tarea
                trigger = TriggerBuilder.newTrigger()
                        .withIdentity("triggerTareaScheduleLog")
                        .startNow()
                        .withSchedule(SimpleScheduleBuilder.repeatMinutelyForever(Integer.parseInt(timeEje[1])))
                        .build();
            } else {
                trigger = TriggerBuilder.newTrigger()
                        .withIdentity("triggerTareaScheduleLog")
                        .startNow()
                        .withSchedule(SimpleScheduleBuilder.repeatHourlyForever(Integer.parseInt(timeEje[0])))
                        .build();
            }
            //scheduleJob(scheduler, "ReadSFTPJob", ReadSFTPJob.class);

        } catch (Exception e) {
            LOGGER.error("Error iniciando Scheduler ", e);
        }
    }


    public void startWorking() throws SchedulerException, SQLException {
        LOGGER.info("Iniciar: Job inicializado");
        new ConnectionBD().statusProcess(AccessParameters.process_nextEjecution, AccessParameters.processing, null);

        ConnectionBD connectionBD = new ConnectionBD();
        String time = connectionBD.findTimeEje();
        String[] timeEje = time.split(":");
        if (timeEje[0].equals("00")) { //En que momento va a iniciar la tarea
            trigger = TriggerBuilder.newTrigger()
                    .withIdentity("triggerTareaScheduleLog")
                    .withSchedule(SimpleScheduleBuilder.repeatMinutelyForever(Integer.parseInt(timeEje[1])))
                    .build();
        } else {
            trigger = TriggerBuilder.newTrigger()
                    .withIdentity("triggerTareaScheduleLog")
                    .withSchedule(SimpleScheduleBuilder.repeatHourlyForever(Integer.parseInt(timeEje[0])))
                    .build();
        }

        scheduler.scheduleJob(job, trigger);
    }

    public void startNow() throws SchedulerException {
        if(scheduler.getCurrentlyExecutingJobs().size() == 0){
            LOGGER.info("Iniciar Ahora: Se reinicia el job a las " + new Date());
            scheduler.scheduleJob(job, trigger);
            return;
        }
        LOGGER.info("Iniciar Ahora: Se inicia el job a las " + new Date());
        scheduler.triggerJob(job.getKey());
    }

    public void stopWorking() throws SchedulerException, SQLException {
        LOGGER.info("Detener: Job detenido");
        new ConnectionBD().statusProcess(AccessParameters.process_nextEjecution, AccessParameters.forProcess, null);
        scheduler.unscheduleJob(trigger.getKey());
    }

    @PreDestroy
    public void shutdownScheduler() {
        if (scheduler != null) {
            try {
                LOGGER.info("Apagando Scheduler. No se ejecutarán procesos demonio hasta que no se reinicie la aplicación.");
                scheduler.shutdown(false);

            } catch (SchedulerException e) {
                LOGGER.error("Error al apagar Scheduler ", e);
            }
        }
    }

}