package com.ys.infrastructure.encryption;

import java.security.SecureRandom;
import java.util.Base64;

public class Base64KeyGenerator {
    private static final int BYTES_OF_256_BITS = 32;
    private static final int BYTES_OF_512_BITS = 64;

    private static Base64KeyGenerator instance;

    public static Base64KeyGenerator getInstance() {
        if (instance == null) {
            instance = new Base64KeyGenerator();
        }
        return instance;
    }

    public String generate256Bits() {
        return generate(BYTES_OF_256_BITS);
    }

    public String generate512Bits() {
        return generate(BYTES_OF_512_BITS);
    }

    private String generate(int length) {
        byte[] randomBytes = generateRandomBytes(length);

        return encodeToBase64(randomBytes);
    }

    private byte[] generateRandomBytes(int length) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] randomBytes = new byte[length];
        secureRandom.nextBytes(randomBytes);
        return randomBytes;
    }

    private String encodeToBase64(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }
}
