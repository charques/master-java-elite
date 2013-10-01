package edu.masterjava.easybakery.service.feedstock;

import java.util.List;

import edu.masterjava.easybakery.web.model.feedstock.UnitUI;


/**
 * Interface del servicio de unidades de medida.
 * 
 * @author carloshernandezarques
 */
public interface UnitService {

    /**
     * Busca todas las unidades de medida.
     * @return
     */
    public List<UnitUI> findAll();

}
