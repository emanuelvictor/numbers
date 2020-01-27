package br.com.produtec.numbers.domain.repository;

import br.com.produtec.numbers.domain.entity.numbers.Number;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Emanuel Victor
 * @version 1.0.0
 * @since 1.0.0, 10/09/2019
 */
@Repository
public interface INumbersRepository extends JpaRepository<Number, Long> {

}
