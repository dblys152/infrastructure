package com.ys.infrastructure.utils;

import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class IpFinderTest {
    private static final String ANY_IP = "121.161.242.189";
    private static final String LOCAL_IP = "127.0.0.1";
    private IpFinder ipFinder;

    @BeforeEach
    void setUp() {
        ipFinder = IpFinder.getInstance();
    }

    @Test
    void IP를_찾는다() {
        HttpServletRequest request = mock(HttpServletRequest.class);
        given(request.getHeader("X-Forwarded-For")).willReturn(ANY_IP);

        String actual = ipFinder.find(request);

        assertThat(actual).isNotNull();
        assertThat(actual).isEqualTo(ANY_IP);
    }

    @Test
    void IP를_찾지_못하면_로컬_IP를_반환한다() {
        HttpServletRequest request = mock(HttpServletRequest.class);

        String actual = ipFinder.find(request);

        assertThat(actual).isNotNull();
        assertThat(actual).isEqualTo(LOCAL_IP);
    }
}