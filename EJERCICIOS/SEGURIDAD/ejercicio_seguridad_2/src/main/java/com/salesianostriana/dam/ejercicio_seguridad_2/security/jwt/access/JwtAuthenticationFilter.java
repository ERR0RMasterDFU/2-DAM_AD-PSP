package com.salesianostriana.dam.ejercicio_seguridad_2.security.jwt.access;

import ch.qos.logback.core.util.StringUtil;
import com.salesianostriana.dam.ejercicio_seguridad_2.user.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter
        //extends OncePerRequestFilter
{
/*
    private final UserService userService;
    private final JwtService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = getJwtAccessTokenFromRequest(request);

        //Validar el token
        //Si es válido autneticar al usuario

        if(StringUtils.hasText(token))

        filterChain.doFilter(request, response);
    }

    private String getJwtAccessTokenFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader(jwtService.TOKEN_HEADER);

        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith(JwtService.TOKEN_PREFIX)){
            return bearerToken.substring(JwtService)
        }
    }*/


}
