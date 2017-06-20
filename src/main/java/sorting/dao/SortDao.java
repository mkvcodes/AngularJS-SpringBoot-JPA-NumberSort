package sorting.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import sorting.entity.SortingValues;

/**
 * @author Murali
 * Bean repository library to connect to DB 
 *
 */
@Transactional
public interface SortDao extends CrudRepository<SortingValues, Long> {

} 
