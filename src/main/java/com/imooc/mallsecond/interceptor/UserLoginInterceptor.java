package com.imooc.mallsecond.interceptor;

import com.imooc.mallsecond.consts.MallConst;
import com.imooc.mallsecond.exception.UserLoginException;
import com.imooc.mallsecond.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 描述: TODO
 */
@Slf4j
public class UserLoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle...");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(MallConst.CURRENT_USER);
        if (user == null) {
            throw new UserLoginException("未能登录异常");
        }
        return true;
    }
}
