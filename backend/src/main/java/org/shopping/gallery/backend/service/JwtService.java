package org.shopping.gallery.backend.service;

import io.jsonwebtoken.Claims;

public interface JwtService {
    String getToken(String key, Object value);

    Claims getClaims(String key);

    boolean isValid(String token);

    int getId(String token);
}
