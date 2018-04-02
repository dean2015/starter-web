package cn.devcenter.framework.starter.web.annotation;


import org.springframework.stereotype.Controller;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Controller
@org.springframework.web.bind.annotation.RestController
public @interface RestController {
    String value() default "";
}
