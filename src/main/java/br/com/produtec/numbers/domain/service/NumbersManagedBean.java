package br.com.produtec.numbers.domain.service;


import br.com.produtec.numbers.domain.entity.numbers.Number;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;

@ViewScoped
@ManagedBean
public class NumbersManagedBean {

    /**
     *
     */
    @Autowired
    private NumbersService numbersService;

    /**
     *
     */
    @Getter
    private Number number = new Number();

    /**
     *
     */
    public void save() {
        numbersService.save(number);
        System.out.println("asdfa");
    }
}
