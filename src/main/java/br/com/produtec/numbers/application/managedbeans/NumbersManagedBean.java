package br.com.produtec.numbers.application.managedbeans;


import br.com.produtec.numbers.domain.entity.numbers.Number;
import br.com.produtec.numbers.domain.service.NumbersService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import java.util.ResourceBundle;

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
    public ResourceBundle labelsBundle = ResourceBundle.getBundle("i18n.labels");

    /**
     *
     */
    @Getter
    private Number number = new Number();

    /**
     *
     */
    public Number save() {
        return numbersService.save(number);
    }
}
