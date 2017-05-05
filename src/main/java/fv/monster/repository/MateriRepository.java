package fv.monster.repository;

import fv.monster.model.Materi;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fvsaddam - saddamtbg@gmail.com
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public interface MateriRepository extends PagingAndSortingRepository<Materi, Long> {

    public Materi findByNama(String nama);

    public Materi getMateriById(Long id);

}
