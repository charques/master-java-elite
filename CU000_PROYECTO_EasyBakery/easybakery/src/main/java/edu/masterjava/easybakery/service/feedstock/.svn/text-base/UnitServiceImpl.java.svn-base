package edu.masterjava.easybakery.service.feedstock;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.masterjava.easybakery.common.util.mapper.feedstock.UnitMapper;
import edu.masterjava.easybakery.persistence.model.feedstock.Unit;
import edu.masterjava.easybakery.persistence.repo.feedstock.UnitRepository;
import edu.masterjava.easybakery.web.model.feedstock.UnitUI;

/**
 * Implementaci—n del servicio de unidades de medida.
 * 
 * @author carloshernandezarques
 */
@Service
public class UnitServiceImpl implements UnitService {

	//private static final Logger LOGGER = LoggerFactory.getLogger(UnitServiceImpl.class);
	
	@Resource
    private UnitRepository unitRepository;
    
    @Transactional(readOnly = true)
    @Override
    public List<UnitUI> findAll() {
        List<Unit> list = unitRepository.findAll();
        return UnitMapper.toUIBean(list);
    }
    
}
