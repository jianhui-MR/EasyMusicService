package rex.service;

import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Component
public class ServiceInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取session
        HttpSession session = request.getSession();
        String token = request.getParameter("token");
        //判断是否有参数token,若无则重定向到toLogin让用户重新登录
        if (token == null || token.equals(""))
            response.sendRedirect("/User/toLogin");
        //比较客户端传上来的token是否与session中的token一致，若一致则通过，若不一致则让用户重新登录
        if (token.equals(session.getAttribute("token"))) {
            return true;
        } else {
            response.sendRedirect("/User/toLogin");
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("处理器后方法");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("处理器完成方法");
    }
}
