package cn.devcenter.framework.starter.web.config;

import cn.devcenter.framework.starter.web.config.property.DefaultViewProperties;
import cn.devcenter.framework.starter.web.controller.DefaultViewController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class DefaultView extends WebMvcConfigurerAdapter {

    @Autowired
    private DefaultViewProperties defaultViewProperties;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:" + defaultViewProperties.getUri());
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }

    @Bean
    public DefaultViewController getDefaultViewController() {
        return new DefaultViewController();
    }
}
