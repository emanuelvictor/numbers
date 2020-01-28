package br.com.produtec.numbers.domain.service;

import br.com.produtec.numbers.AbstractIntegrationTests;
import br.com.produtec.numbers.domain.entity.numbers.Number;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

public class NumbersServiceIntegrationTests extends AbstractIntegrationTests {

    /**
     *
     */
    @Autowired
    private NumbersService numbersService;

    /**
     *
     */
    @Test
    @Sql({"/dataset/truncate-all-tables.sql"})
    public void insertNumberMustPass() {

        final Number number = new Number();
        number.setDigit((short) 64);
        number.calculateNumbers();

        numbersService.save(number);

        Assert.assertNotNull(number.getId());
        Assert.assertNotNull(number.getDigit());
        Assert.assertNotNull(number.getNumbers());
        Assert.assertNotNull(number.getProcessingTime());

    }

    /**
     *
     */
    @Test(expected = java.lang.IllegalArgumentException.class)
    @Sql({"/dataset/truncate-all-tables.sql"})
    public void insertNumberOutsideTheRangeMustFail() {

        final Number number = new Number();
        number.setDigit((short) 164);

        numbersService.save(number);

    }

    /**
     *
     */
    @Test(expected = java.lang.IllegalArgumentException.class)
    @Sql({"/dataset/truncate-all-tables.sql"})
    public void insertNumberWithDigitNullMustFail() {

        final Number number = new Number();

        numbersService.save(number);

    }

    /**
     *
     */
    @Test
    @Sql({"/dataset/truncate-all-tables.sql", "/dataset/numbers.sql"})
    public void findNumberByIdMustPass() {

        final Number number = this.numbersService.findById(1L);

        Assert.assertNotNull(number.getId());
        Assert.assertNotNull(number.getDigit());
        Assert.assertNotNull(number.getProcessingTime());

    }

    /**
     *
     */
    @Test(expected = java.lang.RuntimeException.class)
    @Sql({"/dataset/truncate-all-tables.sql", "/dataset/numbers.sql"})
    public void findNumberByIdMustFail() {

        final Number number = this.numbersService.findById(95L);

        Assert.assertNotNull(number.getId());
        Assert.assertNotNull(number.getDigit());
        Assert.assertNotNull(number.getProcessingTime());

    }

    /**
     *
     */
    @Test
    @Sql({"/dataset/truncate-all-tables.sql", "/dataset/numbers.sql"})
    public void updateNumberMustPass() {

        final Number number = this.numbersService.findById(1L);

        final int oldDigit = number.getDigit();

        number.setDigit((short) 4);

        this.numbersService.save(number);

        Assert.assertNotNull(number.getId());
        Assert.assertNotNull(number.getDigit());
        Assert.assertNotNull(number.getProcessingTime());
        Assert.assertNotEquals(oldDigit, (short) number.getDigit());

    }

    /**
     *
     */
    @Test(expected = java.lang.IllegalArgumentException.class)
    @Sql({"/dataset/truncate-all-tables.sql", "/dataset/numbers.sql"})
    public void updateNumberOutsideTheRangeMustFail() {

        final Number number = this.numbersService.findById(1L);

        number.setDigit((short) 213);

        numbersService.save(number);

    }

    /**
     *
     */
    @Test(expected = java.lang.IllegalArgumentException.class)
    @Sql({"/dataset/truncate-all-tables.sql", "/dataset/numbers.sql"})
    public void updateNumberWithDigitNullMustFail() {

        final Number number = this.numbersService.findById(1L);

        number.setDigit(null);

        numbersService.save(number);

    }
}
