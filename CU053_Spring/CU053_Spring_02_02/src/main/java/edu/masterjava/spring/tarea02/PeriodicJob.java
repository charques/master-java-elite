package edu.masterjava.spring.tarea02;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class PeriodicJob extends QuartzJobBean {
	
	private PeriodicTask periodicTask;

	public void setRunMeTask(PeriodicTask periodicTask) {
		this.periodicTask = periodicTask;
	}

	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {

		periodicTask.imprimir();

	}

}
