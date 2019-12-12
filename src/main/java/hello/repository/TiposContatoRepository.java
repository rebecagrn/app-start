package hello.repository;

import hello.model.TiposContato;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by rebeca on 08/02/2019.
 */
public interface TiposContatoRepository extends JpaRepository<TiposContato, Integer> {
}
