/**
 * 
 */
package edu.masterjava.ejb.tarea03;

import java.util.Timer;
import java.util.TimerTask;

import javax.ejb.EJB;

/**
 * @author carloshernandezarques
 *
 */
public class DelayEjbClient {

	@EJB
    static StateTestBeanLocal beanLocal;
	
	static Timer timer;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		new DelayEjbClient();
		
	}
	
	public DelayEjbClient() {
		StateTestBean bean = (StateTestBean) beanLocal;
		bean.setValue(30);
		
	    timer = new Timer();
	    timer.schedule(new GetValueFromEjbTask(bean), 60000);
	  }

	class GetValueFromEjbTask extends TimerTask {
		
		StateTestBean bean;
		
		public GetValueFromEjbTask(StateTestBean pBean) {
			bean = pBean;
		}
		
	    public void run() {
	    	int valor = bean.getValue();
	    	System.out.println("valor: " + valor);
	    	System.exit(0);
	    }
	  }
}
