package com.ys.shared.queue;

public interface QueueNameMapping<T> {
    T get(String key);
}
