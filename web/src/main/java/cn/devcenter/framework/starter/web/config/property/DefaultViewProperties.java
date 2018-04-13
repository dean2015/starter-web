package cn.devcenter.framework.starter.web.config.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = DefaultViewProperties.PREFIX)
@Data
public class DefaultViewProperties {

    public static final String PREFIX = "devcenter.default.view";

    private String uri = "/running-status";

}
