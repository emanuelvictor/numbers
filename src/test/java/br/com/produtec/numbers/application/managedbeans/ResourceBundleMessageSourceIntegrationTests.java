package br.com.produtec.numbers.application.managedbeans;

import br.com.produtec.numbers.AbstractIntegrationTests;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleMessageSourceIntegrationTests extends AbstractIntegrationTests {

    /**
     *
     */
    private static final ResourceBundle labelsBundle = ResourceBundle.getBundle("i18n.labels");

    /**
     *
     */
    @Autowired
    MessageSource messageSource;

    /**
     *
     */
    @Test
    public void resourceBundleFromSpringContainerNotNullMustPass() {
        Assert.assertNotNull(messageSource);
        Assert.assertNotNull(messageSource.getMessage("numbers", new String[]{}, Locale.US));
    }

    /**
     *
     */
    @Test
    public void resourceBundleFromSpringContainerVerifyContentMustPass() {
        Assert.assertEquals(messageSource.getMessage("numbers", new String[]{}, Locale.US), "Numbers");
    }

    /**
     *
     */
    @Test
    public void resourceBundleFromStaticApplicationNotNullMustPass() {
        Assert.assertNotNull(labelsBundle.getString("numbers"));
    }
    /**
     *
     */
    @Test
    public void resourceBundleFromStaticApplicationVerifyContentMustPass() {
        final ResourceBundle enLabelsBundle = ResourceBundle.getBundle("i18n.labels", Locale.US);
        Assert.assertEquals(enLabelsBundle.getString("numbers"), "Numbers");
    }


}
