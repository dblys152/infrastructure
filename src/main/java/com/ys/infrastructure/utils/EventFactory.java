package com.ys.infrastructure.utils;

public interface EventFactory<D, E> {
    E create(D domain);
}
