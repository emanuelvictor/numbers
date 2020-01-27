package br.com.produtec.numbers.domain.entity;

import br.com.produtec.numbers.domain.entity.numbers.Number;
import org.junit.Test;
import org.springframework.util.Assert;

public class NumbersUnitsTests {

    /**
     *
     */
    @Test
    public void testCalculateNumbers() {

        final Number number = new Number();
        number.setDigit((short) 64);
        number.calculateNumbers();

        Assert.isTrue(number.getDigit() == number.getNumbers().size(), "o número de dígitos diverge");
        Assert.isTrue(number.getProcessingTime() != null, "Não foi possível calcular o tempo de processamento");

    }

}
