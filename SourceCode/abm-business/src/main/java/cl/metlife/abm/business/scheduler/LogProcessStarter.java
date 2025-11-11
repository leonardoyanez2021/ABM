package cl.metlife.abm.business.scheduler;

import cl.metlife.abm.business.execution.LogProcessExecutionManager;
import cl.metlife.abm.business.execution.ProcessExecutionManager;
import cl.metlife.abm.domain.Process;
import cl.metlife.abm.persistence.dao.ProcessTypeDAO;

import javax.ejb.EJB;
import javax.ejb.ScheduleExpression;
import javax.ejb.Stateless;
import javax.ejb.Timer;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by BluePrints Developer on 25-01-2017.
 */
@Stateless
public class LogProcessStarter {

    @EJB
    LogProcessExecutionManager logProcessExecutionManager;

    @EJB
    ProcessTypeDAO processTypeDAO;

    @EJB
    LogProcessTimerManager logProcessTimerManager;

    public void programmaticStart(Process process) {
        Timer timer=null;
        Date nextTimeout=null;
        Date lastTimeout=null;
        try {
            timer = logProcessTimerManager.getTimerForProcess(process);
            nextTimeout = timer.getNextTimeout();
            lastTimeout = getLastTimeout(nextTimeout);
            switch (Integer.parseInt(process.getRangoTypeId().toString())) {
                case 1:
                    lastTimeout = SumaRestarFecha(new Date(), -1, 'D');
                    break;
                case 2:
                    lastTimeout = SumaRestarFecha(new Date(), -7, 'D');
                    break;
                case 3:
                    lastTimeout = SumaRestarFecha(new Date(), -1, 'M');
                    break;
                case 4:
                    lastTimeout = SumaRestarFecha(new Date(), -1, 'Y');
                    break;
                default:
                    break;
            }
        }catch(Exception e){
            System.out.println(String.format(" exeption %s",e.getMessage()));
        }
        if(timer!=null){

            timer.getTimeRemaining();
            if(lastTimeout!=null){
                logProcessExecutionManager.execute(process, lastTimeout, null,Process.PROGRAMMED_EXECUTION);
            }
       }
    }

    private Date getLastTimeout(Date nextTimeout) {
        Date now = new Date();
        Date f2 = nextTimeout;

        Long diff = nextTimeout.getTime() - now.getTime();

        return new Date( now.getTime() - diff);
    }

    public Date SumaRestarFecha(Date fecha, int sumaresta, char opcion)
    {
        Calendar calendar = Calendar.getInstance();
        try
        {
            calendar.setTime(fecha);
            switch (opcion)
            {
                case 'D':
                    calendar.add(Calendar.DAY_OF_WEEK, sumaresta);
                    break;
                case 'M':
                    calendar.add(Calendar.MONTH, sumaresta);
                    break;
                case 'Y':
                    calendar.add(Calendar.YEAR, sumaresta);
                    break;
                default:
                    break;
            }
        }
        catch(Exception e)
        {
            System.out.println("Error:\n" + e);
        }
        return calendar.getTime();
    }

}
