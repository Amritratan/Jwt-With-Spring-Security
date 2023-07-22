package com.example.SpringSecurityTest.securities;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, org.springframework.security.core.AuthenticationException authException) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        PrintWriter writer = response.getWriter();

        if (authException instanceof UsernameNotFoundException) {
            // This block handles the case when the username (name) is not found.
            writer.println("Username not found.");
        } else if (authException instanceof BadCredentialsException) {
            // This block handles the case when the username (name) is found but the password is incorrect.
            writer.println("Invalid credentials.");
        } else if (authException instanceof LockedException) {
            // This block handles the case when the user account is locked.
            writer.println("Account locked. Please contact support.");
        } else {
            // This block handles other authentication errors.
            writer.println("Access Denied !! " + authException.getMessage());
        }
    }
}
