package cn.devcenter.framework.starter.web.jetty.config.Property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = JettyProperties.PREFIX)
public class JettyProperties {

    public static final String PREFIX = "server.jetty";

    public int minThreads = 100;

    public int maxThreads = 200;

    public int getMinThreads() {
        return minThreads;
    }

    public void setMinThreads(int minThreads) {
        this.minThreads = minThreads;
    }

    public int getMaxThreads() {
        return maxThreads;
    }

    public void setMaxThreads(int maxThreads) {
        this.maxThreads = maxThreads;
    }
}