package cn.itcast.service;

import cn.itcast.domain.SysLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Aspect
@Component
public class LogAspectUtil {
    @Autowired
    private LogService logService;
    @Autowired
    private HttpServletRequest request;

    SysLog log;

    //切入点表达式
    @Pointcut(value = "execution(* cn.itcast..*.*(..))")
    public void pointCut() {

    }


    //前置通知
    @Before(value = "pointCut()")
    public void before(JoinPoint joinPoint) {
        log = new SysLog();
        log.setVisitTime(new Date());
        SecurityContext context = SecurityContextHolder.getContext();
        User user = (User) context.getAuthentication().getPrincipal();
        log.setUsername(user.getUsername());
        String ip = request.getRemoteAddr();
        log.setIp(ip);
        //访问的方法
        String name = joinPoint.getSignature().getName();
        //访问的类
        Class<?> aClass = joinPoint.getTarget().getClass();
        String simpleName = aClass.getSimpleName();
        log.setMethod(simpleName + " " + name);
    }
    //后置通知

    @AfterReturning(value = "pointCut()")
    public void after() {
        //成功的通知
        log.setExecuteMsg("操作成功");
        log.setExecuteResult("success");
        log.setExecuteTime(new Date().getTime() - log.getVisitTime().getTime());
        logService.add(log);
    }

    //异常通知
    @AfterThrowing(value = "pointCut()")
    public void exception() {
        log.setExecuteMsg("操作失败");
        log.setExecuteResult("error");
        log.setExecuteTime(new Date().getTime() - log.getVisitTime().getTime());
        logService.add(log);
    }
}
