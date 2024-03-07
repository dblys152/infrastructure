package com.ys.shared.event;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;

@Slf4j
public class EventMessageEnvelopProcessTemplate {
    private final EventValidator eventValidator;

    public EventMessageEnvelopProcessTemplate() {
        this.eventValidator = new EventValidator();
    }

    public <T> EventMessageEnvelopProcessReturn doProcess(String eventMessage, Class<T> aEventClass, Consumer<T> processor) {
        try {
            if (eventMessage == null) {
                log.error("EventMessage is null");
                return EventMessageEnvelopProcessReturn.IGNORE;
            }

            if (aEventClass == null) {
                log.error("aEventClass is null");
                return EventMessageEnvelopProcessReturn.RETRY;
            }

            if (processor == null) {
                log.error("processor is null");
                return EventMessageEnvelopProcessReturn.RETRY;
            }

            DomainEvent<T> domainEvent = DomainEvent.deserialize(eventMessage, aEventClass);

            eventValidator.validateAndThrow(domainEvent.getPayload());

            log.info(String.format("Received a message. DomainEventId is %s, EventType is %s, PublishedAt is %s",
                    domainEvent.getId(), domainEvent.getType(), domainEvent.getPublishedAt()));

            processor.accept(domainEvent.getPayload());

            return EventMessageEnvelopProcessReturn.SUCCESS;
        } catch (EventValidateException e) {
            log.error(String.format("%s has violationMessages. Messages: '%s'", e.getEventType(), e.getViolationMessages()), e);
            return EventMessageEnvelopProcessReturn.IGNORE;
        } catch (Exception e) {
            log.error("Failed to process of EventMessageEnvelop");
            e.printStackTrace();
            return EventMessageEnvelopProcessReturn.RETRY;
        }
    }
}
