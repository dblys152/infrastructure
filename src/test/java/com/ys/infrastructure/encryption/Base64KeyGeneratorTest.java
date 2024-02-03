package com.ys.infrastructure.encryption;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Base64KeyGeneratorTest {
    private static final int KEY_LENGTH_OF_32_BYTES = 44;
    private static final int KEY_LENGTH_OF_64_BYTES = 88;

    private Base64KeyGenerator base64KeyGenerator;

    @BeforeEach
    void setUp() {
        base64KeyGenerator = Base64KeyGenerator.getInstance();
    }

    @Test
    void BASE64_256비트_키를_생성한다() {
        String actual = base64KeyGenerator.generate256Bits();

        assertThat(actual).isNotNull();
        assertThat(actual.length()).isEqualTo(KEY_LENGTH_OF_32_BYTES);
    }

    @Test
    void BASE64_512비트_키를_생성한다() {
        String actual = base64KeyGenerator.generate512Bits();

        assertThat(actual).isNotNull();
        assertThat(actual.length()).isEqualTo(KEY_LENGTH_OF_64_BYTES);
    }
}