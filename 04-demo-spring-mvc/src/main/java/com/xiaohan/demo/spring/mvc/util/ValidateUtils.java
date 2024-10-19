package com.xiaohan.demo.spring.mvc.util;

import org.hibernate.validator.HibernateValidator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import java.util.Set;

public class ValidateUtils {

    private static final Validator validator;

    static {
        validator = Validation.byProvider(HibernateValidator.class)
                .configure()
                .failFast(true) // 快速失败
                .buildValidatorFactory()
                .getValidator();
    }

    public static <T> void validateWithException(T obj) {
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(obj);
        if (constraintViolations.isEmpty()) {
            return;
        }
        StringBuffer sb = new StringBuffer();
        constraintViolations.forEach(constraintViolation -> {
            String field = constraintViolation.getPropertyPath().toString();
            String message = constraintViolation.getMessage();
            String msg = String.format("[%s]: %s", field, message);
            sb.append(msg).append(";");
        });
        // 全局异常处理
        throw new ValidationException(sb.toString());
    }

    public static <T> boolean validate(T obj) {
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(obj);
        return constraintViolations.isEmpty();
    }
}
