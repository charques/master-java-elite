package edu.masterjava.easybakery.service.dashboard;

import java.text.DateFormatSymbols;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import edu.masterjava.easybakery.persistence.model.batch.BatchStatistics;
import edu.masterjava.easybakery.persistence.repo.batch.BatchRepository;
import edu.masterjava.easybakery.web.model.dashboard.BatchGraphUI;
import edu.masterjava.easybakery.web.model.dashboard.GraphDataSetsUI;
import edu.masterjava.easybakery.web.model.dashboard.GraphUI;

/**
 * Implementaci—n del servicio de lotes.
 * 
 * @author carloshernandezarques
 */
@Service
public class DashboardServiceImpl implements DashboardService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DashboardServiceImpl.class);

	@Resource
	private BatchRepository batchRepository;

	@Override
	public BatchGraphUI getGraph(BatchGraphUI batchGraph) throws GraphDataException {

		BatchStatistics statistics = new BatchStatistics();
		statistics.setRecipeId(batchGraph.getRecipeId());
		statistics.setYear(batchGraph.getYear());
		statistics.setType(batchGraph.getGraphType());
		statistics = batchRepository.getBatchStatisticsByYear(statistics);

		Integer data[] = statistics.getData();
		if (data == null) {
			LOGGER.debug("No hay datos.");
			throw new GraphDataException();
		}

		// Construye el GraphUI
		GraphUI graph = new GraphUI();
		String[] months = (new DateFormatSymbols()).getMonths();
		graph.setLabels(months);
		GraphDataSetsUI dataset = new GraphDataSetsUI();
		dataset.setFillColor("rgba(72, 130, 20, 0.5)");
		dataset.setStrokeColor("rgba(72, 130, 20,1)"); // rgb(206, 243, 164)
		dataset.setData(statistics.getData());
		graph.setDatasets(new GraphDataSetsUI[] { dataset });
		graph.setTotal(statistics.getTotal());
		
		batchGraph.setGraph(graph);
		return batchGraph;
	}

	@Override
	public List<Integer> getYearList() {
		return batchRepository.getBatchYears();
	}

}
