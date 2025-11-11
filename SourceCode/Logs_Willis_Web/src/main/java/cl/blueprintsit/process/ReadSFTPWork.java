package cl.blueprintsit.process;


import java.sql.SQLException;
import java.util.*;
import java.util.Calendar;

import cl.blueprintsit.dao.ConfigurationLogDAO;
import cl.blueprintsit.dao.EstadoProcesoDAO;
import cl.blueprintsit.entity.EstadoProceso;
import cl.blueprintsit.type.ConnectionBD;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
/**
 * Created by BlueprintsIT on 4/22/2016.
 */


/*clase deprecada pq esta hecha como el loly */
@Deprecated
public class ReadSFTPWork {

    static private final org.slf4j.Logger log = LoggerFactory.getLogger(ReadSFTPWork.class);

    private SchedulerFactory factoria = new StdSchedulerFactory();
    private Scheduler horario;
    Trigger trigger = null;
    JobDetail job = null;
    boolean flagProcess = false;



    private void createWork() {
        try {
            ConnectionBD connectionBD = new ConnectionBD();

           if(horario==null)
            horario = factoria.getScheduler();//Obteniendo el horario

            if (flagProcess && horario.isStarted() ==false){
                horario.start(); //Creando la programacion//Inicia el horario de la tarea a ejecutar
                connectionBD.statusProcess(AccessParameters.process_nextEjecution, AccessParameters.processing, null);

                log.info("Creada tarea de trabajo");
            }else{
                horario.shutdown();
                connectionBD.statusProcess(AccessParameters.process_nextEjecution, AccessParameters.forProcess, null);
                log.info("Terminada tarea de trabajo");
            }
        } catch (Exception ex) {
            log.error("Problemas al ejecutar la tarea de trabajo", ex);
        }
    }

    @PostConstruct
    public void starWork(Boolean flag) throws SQLException, SchedulerException {
        flagProcess = flag;

        if(Boolean.FALSE == flagProcess){
            stopJobs();
        }

        if(horario.getCurrentlyExecutingJobs().size() > 0){
            return;
        }

        if (this.horario == null) {
            this.createWork();
        }

        //Informacion sobre la tarea
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

        try {
            this.horario.scheduleJob(job, trigger);
            log.info("Agendado Job para trabajo");
        } catch (SchedulerException ex) {
            log.error(ex.getMessage());
        }

    }

    @PreDestroy
    public void stopJobs() {
        if (horario != null) {
            try {
                horario.shutdown(false);
            } catch (SchedulerException e) {
                log.error("Error while closing scheduler", e);
            }
        }
    }

}
