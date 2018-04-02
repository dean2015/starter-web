package cn.devcenter.framework.starter.web.controller;

import cn.devcenter.framework.starter.web.util.ServletUtil;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public abstract class BaseController {

    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;

    @ModelAttribute
    protected void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        session = request.getSession();
        init();
    }

    protected void init() {

    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public HttpSession getSession() {
        return session;
    }

    public HttpServletRequest getOriginalRequest() {
        return ServletUtil.getRequest();
    }

    public HttpServletResponse getOriginalResponse() {
        return ServletUtil.getResponse();
    }

}
