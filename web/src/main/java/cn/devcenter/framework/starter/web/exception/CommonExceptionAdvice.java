package cn.devcenter.framework.starter.web.exception;

import cn.devcenter.model.exception.ApplicationException;
import cn.devcenter.model.exception.BusinessException;
import cn.devcenter.model.result.AjaxResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.Set;

@ControllerAdvice
@ResponseBody
public class CommonExceptionAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonExceptionAdvice.class);

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public AjaxResult<Object> handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        LOGGER.error("缺少请求参数", e);
        return AjaxResult.newInstance().fail("缺少请求参数");
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public AjaxResult<Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        LOGGER.error("参数解析失败", e);
        return AjaxResult.newInstance().fail("参数解析失败");
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public AjaxResult<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        LOGGER.error("参数验证失败", e);
        BindingResult result = e.getBindingResult();
        FieldError error = result.getFieldError();
        String field = error.getField();
        String code = error.getDefaultMessage();
        String message = String.format("%s:%s", field, code);
        return AjaxResult.newInstance().fail(message);
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public AjaxResult<Object> handleBindException(BindException e) {
        LOGGER.error("参数绑定失败", e);
        BindingResult result = e.getBindingResult();
        FieldError error = result.getFieldError();
        String field = error.getField();
        String code = error.getDefaultMessage();
        String message = String.format("%s:%s", field, code);
        return AjaxResult.newInstance().fail(message);
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public AjaxResult<Object> handleServiceException(ConstraintViolationException e, HttpServletRequest request) {
        LOGGER.error("参数验证失败. uri: " + request.getRequestURI(), e);
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        ConstraintViolation<?> violation = violations.iterator().next();
        String message = violation.getMessage();
        return AjaxResult.newInstance().fail("parameter:" + message);
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public AjaxResult<Object> handleValidationException(ValidationException e, HttpServletRequest request) {
        LOGGER.error("参数验证失败. uri: " + request.getRequestURI(), e);
        return AjaxResult.newInstance().fail("参数验证失败");
    }

    /**
     * 405 - Method Not Allowed
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public AjaxResult<Object> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e, HttpServletRequest request) {
        LOGGER.error("不支持当前请求方法. uri: " + request.getRequestURI(), e);
        return AjaxResult.newInstance().fail("不支持当前请求方法");
    }

    /**
     * 415 - Unsupported Media Type
     */
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public AjaxResult<Object> handleHttpMediaTypeNotSupportedException(Exception e, HttpServletRequest request) {
        LOGGER.error("不支持当前媒体类型. uri: " + request.getRequestURI(), e);
        return AjaxResult.newInstance().fail("不支持当前媒体类型");
    }

    /**
     * 500 - Internal Server Error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(BusinessException.class)
    public AjaxResult<BusinessException> handleServiceException(BusinessException e) {
        LOGGER.error("未处理的业务异常", e);
        return AjaxResult.newInstance(BusinessException.class).fail("服务运行异常");
    }

    /**
     * 500 - Internal Server Error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ApplicationException.class)
    public AjaxResult<ApplicationException> handleServiceException(ApplicationException e) {
        LOGGER.error("未处理的非业务异常", e);
        return AjaxResult.newInstance(ApplicationException.class).fail("服务运行异常");
    }

    /**
     * 500 - Internal Server Error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public AjaxResult<Object> handleException(Throwable e) {
        LOGGER.error("服务器未知异常", e);
        return AjaxResult.newInstance().fail("服务器未知异常");
    }

}