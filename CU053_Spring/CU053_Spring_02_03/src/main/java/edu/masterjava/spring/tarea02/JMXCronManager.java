package edu.masterjava.spring.tarea02;

import org.quartz.SchedulerException;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;

/**
 * Expone un metodo para reiniciar el cron via JMX.
 * 
 * @author carloshernandezarques
 * 
 */
public class JMXCronManager {

	private PeriodicTask task;
	private ThreadPoolTaskScheduler scheduler;

	/**
	 * Reinicia el scheduler.
	 * @throws InterruptedException 
	 * 
	 * @throws SchedulerException
	 */
	public void restartScheduler(String expresion) throws InterruptedException  {

		scheduler.shutdown();
		scheduler.initialize();
		scheduler.schedule(new Runnable() {
			public void run() {
				task.imprimir();
			}
		}, new CronTrigger(expresion));
	}

	/**
	 * @return the task
	 */
	public PeriodicTask getTask() {
		return task;
	}

	/**
	 * @param task the task to set
	 */
	public void setTask(PeriodicTask task) {
		this.task = task;
	}

	/**
	 * @return the scheduler
	 */
	public ThreadPoolTaskScheduler getScheduler() {
		return scheduler;
	}

	/**
	 * @param scheduler the scheduler to set
	 */
	public void setScheduler(ThreadPoolTaskScheduler scheduler) {
		this.scheduler = scheduler;
	}

	
}
