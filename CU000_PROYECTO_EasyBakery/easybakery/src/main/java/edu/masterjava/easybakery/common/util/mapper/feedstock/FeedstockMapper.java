package edu.masterjava.easybakery.common.util.mapper.feedstock;

import java.util.ArrayList;
import java.util.List;

import edu.masterjava.easybakery.persistence.model.feedstock.Feedstock;
import edu.masterjava.easybakery.persistence.model.feedstock.Unit;
import edu.masterjava.easybakery.web.model.feedstock.FeedstockUI;

/**
 * Mapeador de materias primas.
 * 
 * @author carloshernandezarques
 */
public class FeedstockMapper {

	/**
	 * Construye una lista de FeedstockUI a partir de una lista de Feedstock.
	 * 
	 * @param ingredientList
	 * @return
	 */
	public static List<FeedstockUI> toUIBean(List<Feedstock> list) {

		List<FeedstockUI> out = new ArrayList<FeedstockUI>();
		if (!list.isEmpty()) {
			for (Feedstock feedstock : list) {
				out.add(toUIBean(feedstock));
			}
		}
		return out;
	}

	/**
	 * Construye un FeedstockUI a partir de un Feedstock.
	 * 
	 * @param feedstock
	 * @return
	 */
	public static FeedstockUI toUIBean(Feedstock feedstock) {
		FeedstockUI feedstockUI = new FeedstockUI();

		feedstockUI.setId(feedstock.getId());
		feedstockUI.setDescription(feedstock.getDescription());
		feedstockUI.setPrice(feedstock.getPrice());
		Unit unit = feedstock.getUnit();
		if (unit != null) {
			feedstockUI.setUnit(UnitMapper.toUIBean(unit));
			feedstockUI.setUnitId(unit.getId());
		}
		
		return feedstockUI;
	}

}
