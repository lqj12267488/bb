package cn.itcast.service;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component("aaa")
public class AuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    //自定义失败处理器
    private String url = "/failer.jsp";
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        if (exception instanceof BadCredentialsException) {
            request.setAttribute("msg","密码错误");
        }
        if (exception instanceof DisabledException) {
            request.setAttribute("msg","账号不可用");
        }
        //super.onAuthenticationFailure(request, response, exception);
        request.getRequestDispatcher(url).forward(request,response);
    }
}
