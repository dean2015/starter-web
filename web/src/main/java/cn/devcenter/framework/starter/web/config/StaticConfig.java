/**
* @Copyright: (c) 2017 DLFC. All rights reserved. 
*
* @name: StaticConfig.java 
* @description: 
*
* @version: 1.0
* @date : May 5, 2017 
* @author: dean 
*
* @Modification  History:<br>
*  Date          Author         Version        Discription
*  May 5, 2017       dean        1.0             <修改原因描述>
*/

package cn.devcenter.framework.starter.web.config;


import cn.devcenter.framework.starter.web.config.property.StaticResourceMappingProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Map.Entry;

/**
 * @name: StaticConfig
 * @description:
 * 
 * @version 1.0
 * @author Gao Song
 *
 */
@Configuration
public class StaticConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private StaticResourceMappingProperties staticResourceMappingProperties;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        for (Entry<String, String> entry : staticResourceMappingProperties.getMappingMap()
                .entrySet()) {
            registry.addResourceHandler(entry.getKey()).addResourceLocations(entry.getValue());
        }
    }

}
