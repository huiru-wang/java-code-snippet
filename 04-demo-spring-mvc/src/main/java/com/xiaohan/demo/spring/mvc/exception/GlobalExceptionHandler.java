package com.xiaohan.demo.spring.mvc.exception;

import com.xiaohan.demo.spring.mvc.common.enums.ErrorConstants;
import com.xiaohan.demo.spring.mvc.model.ServiceResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * 异常流顺序：
 * 方法抛出ex --> aop@AfterThrowing可处理异常 --> @RestControllerAdvice --> interceptor.afterCompletion()方法处理
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BusinessException.class)
    public ServiceResult<Void> handleBusinessException(BusinessException e) {
        return ServiceResult.fail(e.getErrorCode(), e.getMessage());
    }

    /**
     * 处理参数异常
     *
     * @param e IllegalArgumentException
     * @return BaseResponse
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({IllegalArgumentException.class, MissingServletRequestParameterException.class, MethodArgumentNotValidException.class})
    public ServiceResult<Void> handleIllegalArgument(Exception e) {
        log.error("IllegalArgument: ", e);
        StringBuilder errorMessage = new StringBuilder(ErrorConstants.PARAM_INVALID.getErrorMessage());
        errorMessage.append(": ");
        if (e instanceof MissingServletRequestParameterException ex) {

            // lombok 校验异常
            String parameterName = ex.getParameterName();
            errorMessage.append(parameterName);

        } else if (e instanceof IllegalArgumentException ex) {

            // Assert 校验异常
            String message = ex.getMessage();
            errorMessage.append(message);

        } else if (e instanceof MethodArgumentNotValidException ex) {

            // @Validate注解异常
            BindingResult bindingResult = ex.getBindingResult();
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            allErrors.forEach(error -> {
                FieldError fieldError = (FieldError) error;
                String field = fieldError.getField();
                String message = fieldError.getDefaultMessage();
                errorMessage.append("[").append(field).append("]: ").append(message);
            });
        }
        return ServiceResult.fail(ErrorConstants.PARAM_INVALID.getErrorCode(), errorMessage.toString());
    }
}
