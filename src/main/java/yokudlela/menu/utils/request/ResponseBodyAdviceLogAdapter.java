package yokudlela.menu.utils.request;

import yokudlela.menu.utils.logging.CustomRequestLoggingFilter;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import net.logstash.logback.argument.StructuredArguments;
import org.aspectj.lang.annotation.AdviceName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 *
 * @author oe
 */
@RestControllerAdvice
@Slf4j
@Component
public class ResponseBodyAdviceLogAdapter implements ResponseBodyAdvice {

    @Autowired
    RequestBean rq;

    @Autowired
    HttpServletRequest req;

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;//returnType.getParameterType().isAssignableFrom(ResponseEntity.class);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        rq.getWatcher().stop();
        log.info("" + body,
                StructuredArguments.keyValue("uri", req.getRequestURI()),
                StructuredArguments.keyValue(CustomRequestLoggingFilter.TIME_SPENT, rq.getWatcher().getTotalTimeMillis())
        );

        return body ;
    }


}
