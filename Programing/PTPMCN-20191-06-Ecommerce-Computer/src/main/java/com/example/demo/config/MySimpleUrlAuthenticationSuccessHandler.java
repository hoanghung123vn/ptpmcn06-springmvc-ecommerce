package com.example.demo.config;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @author Hung Hoang
 * @version 1.0 Dec 22, 2019
 * @project_name PTPMCN-20191-06-Ecommerce-Computer
 * @teacher_name Duc Vuong Vu
 * @class_name MySimpleUrlAuthenticationSuccessHandler.java
 * @description TODO
 */
public class MySimpleUrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    protected Log logger = LogFactory.getLog(this.getClass());

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException {
        
        handle(request, response, authentication);
        clearAuthenticationAttributes(request);
    }

    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException {
        
        String targetUrl = determineTargetUrl(authentication);
        if (response.isCommitted()) {
            logger.debug("Response has already been committed. Unable to redirect to " + targetUrl);
            return;
        }
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    protected String determineTargetUrl(Authentication authentication) {
        boolean isAdmin = false;
        boolean isManager = false;
        boolean isStocker = false;
        boolean isShipper = false;
        boolean isEmployee = false;
        boolean isMember = false;
        java.util.Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority grantedAuthority : authorities) {
            if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
                isAdmin = true;
                break;
            } else if (grantedAuthority.getAuthority().equals("ROLE_MANAGER")) {
                isManager = true;
                break;
            } else if (grantedAuthority.getAuthority().equals("ROLE_STOCKER")) {
                isStocker = true;
                break;
            } else if (grantedAuthority.getAuthority().equals("ROLE_SHIPPER")) {
                isShipper = true;
                break;
            } else if (grantedAuthority.getAuthority().equals("ROLE_EMPLOYEE")) {
                isEmployee = true;
                break;
            } else if (grantedAuthority.getAuthority().equals("ROLE_MEMBER")) {
                isMember = true;
                break;
            }
        }

        if (isAdmin) {
            return "/admin/statistical";
        } else if (isManager) {
            return "/";
        } else if (isStocker) {
            return "/stocker/orders";
        } else if (isShipper) {
            return "/shipper/orders";
        } else if (isEmployee) {
            return "/";
        } else if (isMember) {
            return "/";
        } else {
            throw new IllegalStateException();
        }
    }

    protected void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }

    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }

    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }
}
