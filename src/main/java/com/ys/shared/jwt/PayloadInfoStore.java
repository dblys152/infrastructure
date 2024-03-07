package com.ys.shared.jwt;

public class PayloadInfoStore {
    public static final ThreadLocal<PayloadInfo> THREAD_LOCAL = new ThreadLocal<>();
}
