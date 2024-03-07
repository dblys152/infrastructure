package com.ys.shared.queue;

import java.util.HashMap;
import java.util.Map;

public class RabbitMqExchangeNameMapping implements QueueNameMapping<RabbitMqExchange> {
    private final Map<String, RabbitMqExchange> exchangeMap = new HashMap<>();

    public void add(String key, RabbitMqExchange rabbitMqExchange) {
        exchangeMap.put(key, rabbitMqExchange);
    }

    @Override
    public RabbitMqExchange get(String key) {
        return exchangeMap.get(key);
    }
}
