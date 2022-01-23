package com.house.shiro;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.house.util.JwtUtil;
import com.house.util.ResponseResult;
import lombok.extern.log4j.Log4j2;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @Author xpdxz
 * @ClassName JwtFilter
 * @Description TODO
 * @Date 2022/1/9 11:04
 */
@Log4j2
public class JwtFilter extends BasicHttpAuthenticationFilter {

    private ObjectMapper objectMapper;

    public JwtFilter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    private void responseError(ServletResponse response, int status, String message) {
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        servletResponse.setStatus(HttpStatus.OK.value());
        servletResponse.setContentType("application/json;charset=utf-8");
        servletResponse.setCharacterEncoding("UTF-8");
        try {
            String result = objectMapper.writeValueAsString(ResponseResult.error(status, message));
            servletResponse.getWriter().append(result);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    private String getJwt(ServletRequest request) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if ("jwt".equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        log.debug("进入preHandle");
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        if (httpServletRequest.getMethod().equals(HttpMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
        String jwt = getJwt(request);
        if (jwt == null) {
            responseError(response, HttpStatus.UNAUTHORIZED.value(), "非法请求，请先登录");
            return false;
        }
        return super.preHandle(request, response);
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        log.debug("执行isAccessAllowed");
        try {
            return executeLogin(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        log.debug("尝试登录");
        return true;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        log.debug("进入onAccessDenied");
        //把服务端request转换客户端request把服务端response转换客户端response
        this.sendChallenge(request, response);
        responseError(response, HttpStatus.UNAUTHORIZED.value(), "非法请求，请先登录");
        return false;
    }

    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
        log.debug("创建token");
        return new JwtToken(getJwt(request));
    }


    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        String jwt = (String) token.getCredentials();
        boolean result = JwtUtil.signToken(jwt);
        if (result) {
            request.setAttribute("id", JwtUtil.getBodyMessage("id", jwt).toString());
            request.setAttribute("userInfoId", JwtUtil.getBodyMessage("userInfoId", jwt).toString());
        }
        return result;
    }
}
