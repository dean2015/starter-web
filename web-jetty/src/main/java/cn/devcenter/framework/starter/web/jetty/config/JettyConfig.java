package cn.devcenter.framework.starter.web.jetty.config;

import cn.devcenter.framework.starter.web.jetty.config.Property.JettyProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JettyConfig {

    @Autowired
    private JettyProperties jettyProperties;

}
