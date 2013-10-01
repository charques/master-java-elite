package edu.masterjava.easybakery.service.feedstock;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.annotation.Secured;

import edu.masterjava.easybakery.web.model.feedstock.FeedstockUI;


/**
 * Interface del servicio de materias primas.
 * 
 * @author carloshernandezarques
 */
public interface FeedstockService {

	/**
	 * Crea una materia prima.
	 * @param created
	 * @return
	 */
    public FeedstockUI create(FeedstockUI created);

    /**
     * Elimina una materia prima.
     * @param feedstockId
     * @return
     * @throws FeedstockNotFoundException
     * @throws DataIntegrityViolationException
     */
    @Secured ({"ROLE_ADMIN"})
    public FeedstockUI delete(Integer feedstockId) throws FeedstockNotFoundException, DataIntegrityViolationException;

    /**
     * Busca todas las materias primas.
     * @return
     */
    public List<FeedstockUI> findAll();

    /**
     * Busca una materia prima por id.
     * @param id
     * @return
     */
    public FeedstockUI findById(Integer id);

    /**
     * Actualiza la informaci—n de una materia prima.
     * @param updated
     * @return
     * @throws PersonNotFoundException
     */
    public FeedstockUI update(FeedstockUI updated) throws FeedstockNotFoundException;

}
