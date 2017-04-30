package fv.monster.repository;

import fv.monster.model.Materi;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author fvsaddam - saddamtbg@gmail.com
 */
public interface MateriRepository extends PagingAndSortingRepository<Materi, Long> {

    public Materi findByNama(String nama);

    public Materi getMateriById(Long id);

}
