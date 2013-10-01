package edu.masterjava.easybakery.service.dashboard;

import java.util.List;

import edu.masterjava.easybakery.web.model.dashboard.BatchGraphUI;

/**
 * Interface del servicio de dashboard.
 * 
 * @author carloshernandezarques
 */
public interface DashboardService {

	/**
	 * Obtiene los datos de una gr‡fica de lotes.
	 * @param batchGraph
	 * @return
	 * @throws GraphDataException 
	 */
    public BatchGraphUI getGraph(BatchGraphUI batchGraph) throws GraphDataException;
    
    /**
     * Obtiene la lista de a–os para los que hay lotes registrados.
     * @return
     */
    public List<Integer> getYearList();

}
