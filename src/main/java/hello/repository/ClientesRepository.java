package hello.repository;

import hello.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by rebeca on 08/02/2019.
 */
public interface ClientesRepository extends JpaRepository<Clientes, Integer> {
}
