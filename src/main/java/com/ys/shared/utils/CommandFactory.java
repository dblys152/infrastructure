package com.ys.shared.utils;

public interface CommandFactory<R, C> {
    C create(R request);
}
