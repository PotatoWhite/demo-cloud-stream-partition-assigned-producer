package me.potato.democloudstreampartitionedproducer.sample;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface Sink {
    String INPUT = "consumer-stream";

    @Input(INPUT)
    SubscribableChannel input();
}