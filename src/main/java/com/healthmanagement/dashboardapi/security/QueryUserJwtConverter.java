package com.healthmanagement.dashboardapi.security;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.*;
import java.util.stream.Collectors;

import static com.healthmanagement.dashboardapi.Constants.NA;

public class QueryUserJwtConverter implements Converter<Jwt, AbstractAuthenticationToken> {
    public static final String REALM_ACCESS_CLAIM = "realm_access";
    public static final String ROLES_CLAIM = "roles";
    public static final String SCOPE_CLAIM = "scope";
    public static final String USERNAME_CLAIM = "prefered_username";
    public static final String DEFALT_ROLE_PREFIX = "ROLE_";
    public static final String DEFAULT_SCOPE_PREFIX = "SCOPE";
    public static final String SCOPE_SEPARATOR = " ";
    private final QueryUserDetailsService queryUserDetailsService;

    public QueryUserJwtConverter(QueryUserDetailsService queryUserDetailsService) {
        this.queryUserDetailsService = queryUserDetailsService;
    }

    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {
        Collection<GrantedAuthority> authoritiesFromJwt = getAuthoritiesFromJwt(jwt);
        return Optional.ofNullable(queryUserDetailsService.loadUserByUsername(jwt.getClaimAsString(USERNAME_CLAIM)))
                .map(userDetails -> {
                    ((QueryUser) userDetails).setAuthorities(authoritiesFromJwt);
                    return new UsernamePasswordAuthenticationToken(userDetails, NA, authoritiesFromJwt);
                })
                .orElseThrow(() -> new BadCredentialsException("User could not be found!!!"));


    }

    private Collection<GrantedAuthority> getAuthoritiesFromJwt(Jwt jwt) {
        return getCombinedAuthorities(jwt)
                .stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    private Collection<String> getCombinedAuthorities(Jwt jwt) {
        Collection<String> authorities = getRoles(jwt);
        authorities.addAll(getScopes(jwt));
        return authorities;
    }

    private Collection<String> getRoles(Jwt jwt) {
        Object roles = ((Map<String, Object>) jwt.getClaims()
                .get(REALM_ACCESS_CLAIM)).get(ROLES_CLAIM);
        if (roles instanceof Collection) {
            return ((Collection<String>) roles).stream()
                    .map(authority -> DEFALT_ROLE_PREFIX + authority.toUpperCase())
                    .collect(Collectors.toList());

        }
        return Collections.emptyList();
    }

    private Collection<String> getScopes(Jwt jwt) {
        Object scopes = jwt.getClaims()
                .get(SCOPE_CLAIM);
        if (scopes instanceof String) {
            return Arrays.stream(((String) scopes).split(SCOPE_SEPARATOR))
                    .map(authority -> DEFAULT_SCOPE_PREFIX + authority.toUpperCase())
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
