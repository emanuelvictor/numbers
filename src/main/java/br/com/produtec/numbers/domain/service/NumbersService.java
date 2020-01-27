package br.com.produtec.numbers.domain.service;

import br.com.produtec.numbers.domain.entity.numbers.Number;
import br.com.produtec.numbers.domain.repository.INumbersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

/**
 * @author Emanuel Victor
 * @version 1.0.0
 * @since 1.0.0, 10/09/2019
 */
@Service
@RequiredArgsConstructor
public class NumbersService {

    /**
     *
     */
    private final INumbersRepository numbersRepository;

    /**
     * @param filter
     * @param pageable
     * @return
     */
    public Page<Number> listByFilters(final String filter, final Pageable pageable) {
        return numbersRepository.listByFilters(filter, pageable);
    }

}
