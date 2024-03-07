package com.ys.shared.utils;

public interface EventFactory<D, E> {
    E create(D domain);
}
