package com.david.littleairbook.security;

public class SecurityConstants {
	public static final String SECRET = "i-go-to-school-by-bus";
    public static final long EXPIRATION_TIME = 864_000_000_000L; // 10000 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
}
