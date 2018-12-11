package book.life.config;

import book.life.api.Api;
import book.life.api.ApiGenerator;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2018/3/23.
 */

@RestControllerAdvice
public class RequestExceptionHandlerConfig {
    @ExceptionHandler(value= MethodArgumentNotValidException.class)
    public Api<String> MethodArgumentNotValidHandler(HttpServletRequest request, MethodArgumentNotValidException exception)
    {
        // 按需重新封装需要返回的错误信息
        String msg = exception.getBindingResult().getFieldError().getDefaultMessage();
        return ApiGenerator.fail(msg);
    }
}
