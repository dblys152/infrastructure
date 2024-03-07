package com.ys.shared.queue;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value(staticConstructor = "of")
public class RabbitMqExchange {
    @NotNull
    String name;

    String routingKey;
}
