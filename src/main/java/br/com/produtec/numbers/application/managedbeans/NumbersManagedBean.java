package br.com.produtec.numbers.application.managedbeans;


import br.com.produtec.numbers.domain.entity.numbers.Number;
import br.com.produtec.numbers.domain.service.NumbersService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.IOException;
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
     * @param id
     */
    public void initialize(long id) {
        if (!FacesContext.getCurrentInstance().isPostback()) {
            this.number = this.numbersService.findById(id);
        }
    }

    /**
     *
     */
    public void save() {
        numbersService.save(number);
        changeToDetail(number.getId());
    }

    /**
     *
     */
    private void changeToDetail(final long id) {
        try {
            final String url = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + "/number-detail.jsf?numberId=" + id;
            FacesContext.getCurrentInstance().getExternalContext().redirect(url);
        } catch (IOException ignored) {
        }
    }

    /**
     *
     */
    public String changeToInsert() {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + "/numbers.jsf?faces-redirect=true";
    }

}
