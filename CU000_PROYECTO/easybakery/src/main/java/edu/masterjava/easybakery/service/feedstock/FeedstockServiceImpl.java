package edu.masterjava.easybakery.service.feedstock;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import edu.masterjava.easybakery.common.util.mapper.feedstock.FeedstockMapper;
import edu.masterjava.easybakery.persistence.model.feedstock.Feedstock;
import edu.masterjava.easybakery.persistence.repo.feedstock.FeedstockRepository;
import edu.masterjava.easybakery.web.model.feedstock.FeedstockUI;

/**
 * Implementaci—n del servicio de materias primas.
 * 
 * @author carloshernandezarques
 */
@Service
public class FeedstockServiceImpl implements FeedstockService {

	private static final Logger LOGGER = LoggerFactory.getLogger(FeedstockServiceImpl.class);
	
	@Resource
    private FeedstockRepository feedstockRepository;
    
	@Transactional
    @Override
    public FeedstockUI create(FeedstockUI created) {
        
        Feedstock feedstock = Feedstock.getBuilder(created.getDescription(), created.getPrice(), created.getUnitId()).build();
        feedstock = feedstockRepository.save(feedstock);
        return FeedstockMapper.toUIBean(feedstock);
    }

    @Transactional(rollbackFor = FeedstockNotFoundException.class)
    @Override
	public FeedstockUI delete(Integer feedstockId) throws FeedstockNotFoundException, DataIntegrityViolationException {
        
        Feedstock deleted = feedstockRepository.findOne(feedstockId);
        
        if (deleted == null) {
            LOGGER.debug("No se ha encontrado la materia prima con id: " + feedstockId);
            throw new FeedstockNotFoundException();
        }
        
        feedstockRepository.delete(deleted);
        
        return FeedstockMapper.toUIBean(deleted);
    }
    
    @ExceptionHandler(IOException.class)
    @Transactional(readOnly = true)
    @Override
    public List<FeedstockUI> findAll() {
        List<Feedstock> list = feedstockRepository.findAll();
        return FeedstockMapper.toUIBean(list);
    }

    @Transactional(readOnly = true)
    @Override
    public FeedstockUI findById(Integer id) {
        Feedstock feedstock = feedstockRepository.findOne(id);
        return FeedstockMapper.toUIBean(feedstock);
    }

    @Transactional(rollbackFor = FeedstockNotFoundException.class)
    @Override
    public FeedstockUI update(FeedstockUI updated) throws FeedstockNotFoundException {
        
        Feedstock feedstock = feedstockRepository.findOne(updated.getId());
        
        if (feedstock == null) {
            LOGGER.debug("No se ha encontrado la materia prima con id: " + updated.getId());
            throw new FeedstockNotFoundException();
        }
        
        feedstock.update(updated.getDescription(), updated.getPrice(), updated.getUnitId());

        return FeedstockMapper.toUIBean(feedstock);
    }

	public void setFeedstockRepository(FeedstockRepository feedstockRepository) {
		this.feedstockRepository = feedstockRepository;
	}
    
}
