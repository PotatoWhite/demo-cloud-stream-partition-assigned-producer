package me.potato.democloudstreampartitionedproducer.sample;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Source {
    String OUTPUT = "producer-stream";

    @Output(Source.OUTPUT)
    MessageChannel output();
}