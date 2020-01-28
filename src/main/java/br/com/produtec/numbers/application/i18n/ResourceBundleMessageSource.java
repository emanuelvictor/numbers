package br.com.produtec.numbers.application.i18n;

import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.util.Assert;

import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * @author Emanuel Victor
 * @version 1.0.0
 * @since 1.0.0, 10/09/2019
 */
public class ResourceBundleMessageSource extends ReloadableResourceBundleMessageSource {

    /**
     *
     */
    public ResourceBundleMessageSource() {
        MessageSourceHolder.setMessageSource(this);
    }

    /**
     * @param locale Locale
     * @return Properties
     */
    public Properties getProperties(final Locale locale) {
        super.clearCacheIncludingAncestors();

        final PropertiesHolder propertiesHolder = super.getMergedProperties(locale);
        return propertiesHolder.getProperties();
    }

    /**
     * @param resourceBundleName
     */
    public static ResourceBundle getBundle(final String resourceBundleName) {
        Assert.notNull(resourceBundleName, "Informe o resource bundle");

        return ResourceBundle.getBundle(resourceBundleName);
    }

}
