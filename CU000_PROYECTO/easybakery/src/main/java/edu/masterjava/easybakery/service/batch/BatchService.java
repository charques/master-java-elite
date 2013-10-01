package edu.masterjava.easybakery.service.batch;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import edu.masterjava.easybakery.web.model.batch.BatchUI;

/**
 * Interface del servicio de lotes.
 * 
 * @author carloshernandezarques
 */
public interface BatchService {

	/**
	 * Crea un lote.
	 * @param created
	 * @return
	 */
    public BatchUI create(BatchUI created);

    /**
     * Elimina una lote.
     * @param batchId
     * @return
     * @throws BatchNotFoundException
     */
    @Secured ({"ROLE_ADMIN"})
    public BatchUI delete(Integer batchId) throws BatchNotFoundException;

    /**
     * Busca todos los lotes.
     * @return
     */
    public List<BatchUI> findAll();

    /**
     * Busca un lote por id.
     * @param id    
     * @return 
     */
    public BatchUI findById(Integer id);

    /**
     * Actualiza la informaci—n de un lote.
     * @param updated
     * @return
     * @throws BatchNotFoundException
     */
    public BatchUI update(BatchUI updated) throws BatchNotFoundException;
    
    /**
     * Calcula la cantidad de ingredientes de un lote en funci—n de
     * la cantidad total y su coste.
     * @param created
     * @return
     */
    public BatchUI calcBatch(BatchUI batch);

}
