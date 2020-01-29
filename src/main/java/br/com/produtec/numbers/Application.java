package br.com.produtec.numbers;

import br.com.produtec.numbers.application.i18n.ResourceBundleMessageSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

//import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Emanuel Victor
 * @version 1.0.0
 * @since 1.0.0, 10/09/2019
 */
@EnableAsync
@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean.class)
public class Application extends SpringBootServletInitializer {

    /**
     * Run the Spring Boot application
     *
     * @param args {String[]} command line arguments
     */
    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }


    /**
     * @param application SpringApplicationBuilder
     * @return SpringApplicationBuilder
     */
    @Override
    protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    /**
     * @return MessageSource
     */
    @Bean
    public MessageSource messageSource() {
        final ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setAlwaysUseMessageFormat(true);
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setBasenames("classpath:i18n/exceptions", "classpath:i18n/labels", "classpath:i18n/messages");
        messageSource.setUseCodeAsDefaultMessage(true);
        return messageSource;
    }

}
