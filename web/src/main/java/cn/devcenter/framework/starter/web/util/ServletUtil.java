package cn.devcenter.framework.starter.web.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请求相关工具类
 *
 * @author gaosong
 *
 */
public class ServletUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServletUtil.class);

    /**
     * 获取当前请求对象
     */
    public static HttpServletRequest getRequest() {
        try {
            return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                    .getRequest();
        } catch (Exception e) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("获取当前请求对象错误", e);
            }
            return null;
        }
    }

    /**
     * 获取当前响应对象
     */
    public static HttpServletResponse getResponse() {
        try {
            return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                    .getResponse();
        } catch (Exception e) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("获取当前请求对象错误", e);
            }
            return null;
        }
    }

}
