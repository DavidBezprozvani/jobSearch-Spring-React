package com.codeacademy.jobsearch.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.codeacademy.jobsearch.security.SecurityConstants.*;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    private JwtProvider jwtProvider;

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager, JwtProvider jwtProvider) {
        super(authenticationManager);
        this.jwtProvider = jwtProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String authorizationHeader = request.getHeader(AUTHORIZATION_HEADER);

        if (isNotEmpty(authorizationHeader) && authorizationHeader.startsWith(AUTHORIZATION_HEADER_PREFIX)) {
            String jwt = authorizationHeader.replace(AUTHORIZATION_HEADER_PREFIX, "");
            Authentication authentication = jwtProvider.getAuthentication(jwt);

            if (authentication == null) {
                chain.doFilter(request, response);
                return;
            }

            SecurityContextHolder.getContext().setAuthentication(authentication);

        }
        chain.doFilter(request, response);
    }
}
