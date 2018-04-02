package cn.devcenter.framework.starter.web.config;

import cn.devcenter.framework.starter.web.exception.CommonExceptionAdvice;
import cn.devcenter.framework.starter.web.exception.MyHandlerExceptionResolver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Gao Song
 */
@Configuration
public class WebExceptionConfig {

    @ConditionalOnMissingBean(MyHandlerExceptionResolver.class)
    @Bean
    public CommonExceptionAdvice getCommonExceptionAdvice() {
        return new CommonExceptionAdvice();
    }

}
