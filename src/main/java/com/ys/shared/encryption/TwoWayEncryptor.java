package com.ys.shared.encryption;

public interface TwoWayEncryptor {
    String encrypt(String message, String secretKey);

    String decrypt(String message, String secretKey);
}
