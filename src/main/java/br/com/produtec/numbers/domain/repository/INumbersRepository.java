package br.com.produtec.numbers.domain.repository;

import br.com.produtec.numbers.domain.entity.numbers.Number;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Emanuel Victor
 * @version 1.0.0
 * @since 1.0.0, 10/09/2019
 */
@Repository
public interface INumbersRepository extends JpaRepository<Number, Long> {

    /**
     * @param filter   String
     * @param pageable Pageable
     * @return Page<Number>
     */
    @Query("FROM Number number WHERE" +
            "   (" +
            "       FILTER(:filter, number.digit) = TRUE" +
            "   )"
    )
    Page<Number> listByFilters(@Param("filter") final String filter, final Pageable pageable);

}
