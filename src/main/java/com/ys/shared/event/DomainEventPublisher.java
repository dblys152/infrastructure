package com.ys.shared.event;

import java.time.LocalDateTime;

public interface DomainEventPublisher<T> {
    void publish(String eventType, T payload, LocalDateTime publishedAt);
}
