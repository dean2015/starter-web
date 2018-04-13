package cn.devcenter.framework.starter.web.config.property;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@ConfigurationProperties(prefix = StaticResourceMappingProperties.PREFIX)
public class StaticResourceMappingProperties {

    public static final String PATTERN_SEPERATOR = "\\|";

    public static final String MAPPING_SEPERATOR = "=";

    public static final String PREFIX = "static.resource";

    private String mapping;

    private transient Map<String, String> mappingMap;

    public String getMapping() {
        return mapping;
    }

    public void setMapping(String mapping) {
        this.mapping = mapping;
    }

    public Map<String, String> getMappingMap() {
        if (null == mappingMap) {
            mappingMap = new HashMap<>();
            assembleMap(mappingMap);
        }
        return mappingMap;
    }

    private void assembleMap(Map<String, String> map) {
        if (!StringUtils.isBlank(mapping)) {
            String[] mappingPatterns = mapping.split(PATTERN_SEPERATOR);
            for (String mappingPattern : mappingPatterns) {
                if (!StringUtils.isBlank(mappingPattern)) {
                    String[] mapper = mappingPattern.split(MAPPING_SEPERATOR);
                    if (mapper.length == 2) {
                        mappingMap.put(mapper[0], mapper[1]);
                    }
                }
            }
        }
    }
}
