package cn.devcenter.framework.starter.web.controller;

import cn.devcenter.framework.starter.web.annotation.RestController;
import cn.devcenter.framework.starter.web.config.property.DefaultViewProperties;
import cn.devcenter.model.result.AjaxResult;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@RestController
public class DefaultViewController extends BaseController {

    @RequestMapping(value = "/running-status", method = RequestMethod.GET)
    public AjaxResult<RunningStatus> status(ViewControllerRegistry registry) {
        RunningStatus runningStatus = new RunningStatus();
        runningStatus.setStatus("Normal");
        return AjaxResult.newInstance(RunningStatus.class).success("", runningStatus);
    }

    @Data
    private static class RunningStatus {
        private String status;
    }
}
