package com.ys.infrastructure.queue;

public interface QueueNameMapping<T> {
    T get(String key);
}
