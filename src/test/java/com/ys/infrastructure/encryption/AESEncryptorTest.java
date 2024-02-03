package com.ys.infrastructure.encryption;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AESEncryptorTest {
    private static final String MESSAGE = "yyyy123ssss@gmail.com";
    private static final String SECRET_KEY_32BYTES = "Q1RNUy1URVNULU9GLUVOQ1JZUFRJT04K";

    private AESEncryptor aesEncryptor;

    @BeforeEach
    void setUp() {
        aesEncryptor = new AESEncryptor();
    }

    @Test
    void ASE_암호화_한다() {
        String actual = aesEncryptor.encrypt(MESSAGE, SECRET_KEY_32BYTES);
        assertThat(actual).isNotNull();
    }

    @Test
    void ASE_암호화_시_메시지가_null이면_null을_반환한다() {
        String actual = aesEncryptor.encrypt(null, SECRET_KEY_32BYTES);

        assertThat(actual).isNull();
    }

    @Test
    void ASE_복호화_한다() {
        String encryptionMessage = aesEncryptor.encrypt(MESSAGE, SECRET_KEY_32BYTES);

        String actual = aesEncryptor.decrypt(encryptionMessage, SECRET_KEY_32BYTES);

        assertThat(actual).isNotNull();
        assertThat(actual).isEqualTo(MESSAGE);
    }

    @Test
    void ASE_복호화_시_메시지가_null이면_null을_반환한다() {
        String encryptionMessage = aesEncryptor.encrypt(null, SECRET_KEY_32BYTES);

        String actual = aesEncryptor.decrypt(encryptionMessage, SECRET_KEY_32BYTES);

        assertThat(actual).isNull();
    }

    @Test
    void ASE_복호화_시_암호화가_안_된_메지시면_메시지_그대로_반환한다() {
        String actual = aesEncryptor.decrypt(MESSAGE, SECRET_KEY_32BYTES);

        assertThat(actual).isNotNull();
        assertThat(actual).isEqualTo(MESSAGE);
    }
}