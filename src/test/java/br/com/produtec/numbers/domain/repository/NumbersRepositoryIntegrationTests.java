package br.com.produtec.numbers.domain.repository;

import br.com.produtec.numbers.AbstractIntegrationTests;
import br.com.produtec.numbers.domain.entity.numbers.Number;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

public class NumbersRepositoryIntegrationTests extends AbstractIntegrationTests {

    /**
     *
     */
    @Autowired
    private INumbersRepository numbersRepository;

    /**
     *
     */
    @Test
    @Sql({"/dataset/truncate-all-tables.sql"})
    public void insertNumberMustPass() {

        final Number number = new Number();
        number.setDigit((short) 64);
        number.calculateNumbers();

        numbersRepository.save(number);

        Assert.assertNotNull(number.getId());
        Assert.assertNotNull(number.getDigit());
        Assert.assertNotNull(number.getNumbers());
        Assert.assertNotNull(number.getProcessingTime());

    }

    /**
     *
     */
    @Test(expected = javax.validation.ConstraintViolationException.class)
    @Sql({"/dataset/truncate-all-tables.sql"})
    public void insertNumberOutsideTheRangeMustFail() {

        final Number number = new Number();
        number.setDigit((short) 164);

        numbersRepository.save(number);

    }

    /**
     *
     */
    @Test(expected = javax.validation.ConstraintViolationException.class)
    @Sql({"/dataset/truncate-all-tables.sql"})
    public void insertNumberWithDigitNullMustFail() {

        final Number number = new Number();

        numbersRepository.save(number);

    }

    /**
     *
     */
    @Test(expected = org.springframework.dao.DataIntegrityViolationException.class)
    @Sql({"/dataset/truncate-all-tables.sql", "/dataset/numbers.sql"})
    public void insertNumberMustFail() {

        final Number number = new Number();
        number.setDigit((short) 23);

        numbersRepository.save(number);

    }

    /**
     *
     */
    @Test(expected = javax.validation.ConstraintViolationException.class)
    @Sql({"/dataset/truncate-all-tables.sql", "/dataset/numbers.sql"})
    public void insertNegativeNumberMustFail() {

        final Number number = new Number();
        number.setDigit((short) -23);

        numbersRepository.save(number);

    }
}
