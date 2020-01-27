package br.com.produtec.numbers.application.navigation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Emanuel Victor
 * @version 1.0.0
 * @since 1.0.0, 10/09/2019
 */
@Controller
public class NavigationController {

    /**
     * @return String
     */
    @GetMapping("/")
    public String numbers() {
        return "numbers.xhtml";
    }
}
