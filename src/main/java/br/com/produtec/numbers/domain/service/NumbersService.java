package br.com.produtec.numbers.domain.service;

import br.com.produtec.numbers.domain.entity.numbers.Number;
import br.com.produtec.numbers.domain.repository.INumbersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * @author Emanuel Victor
 * @version 1.0.0
 * @since 1.0.0, 27/01/2020
 */
@Service
@RequiredArgsConstructor
public class NumbersService {

    /**
     *
     */
    private final INumbersRepository numbersRepository;

    /**
     * @param number
     * @return
     */
    @Transactional
    public Number save(final Number number) {

        Assert.isTrue(number.getDigit() != null, "O dígito não pode ser nulo");
        Assert.isTrue(number.getDigit() <= 100 && number.getDigit() > 0, "Os números devem estar entre 1 e 100");

        return numbersRepository.findByDigit(number.getDigit()).orElseGet(() -> numbersRepository.save(number));

    }

    /**
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public Number findById(final long id) {
        return this.numbersRepository.findById(id).orElseThrow(() -> new RuntimeException("Number not found"));
    }
}
