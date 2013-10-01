package edu.masterjava.easybakery.common.util.mapper.feedstock;

import java.util.ArrayList;
import java.util.List;

import edu.masterjava.easybakery.persistence.model.feedstock.Unit;
import edu.masterjava.easybakery.web.model.feedstock.UnitUI;

/**
 * Mapeador de unidades de medida.
 * 
 * @author carloshernandezarques
 */
public class UnitMapper {

	/**
	 * Construye una lista de UnitUI a partir de una lista de Unit.
	 * 
	 * @param list
	 * @return
	 */
	public static List<UnitUI> toUIBean(List<Unit> list) {
		
		List<UnitUI> out = new ArrayList<UnitUI>();
		if(!list.isEmpty()) {
			for(Unit unit : list) {
				out.add(toUIBean(unit));
			}
		}
		return out;
	}
	
	/**
	 * Construye un UnitUI a partir de un Unit.
	 * 
	 * @param unit
	 * @return
	 */
	public static UnitUI toUIBean(Unit unit) {
        UnitUI formObject = new UnitUI();
        
        formObject.setId(unit.getId());
        formObject.setDescription(unit.getDescription());
        
        return formObject;
    }
}
