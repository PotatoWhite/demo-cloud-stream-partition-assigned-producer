package me.potato.democloudstreampartitionedproducer.sample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

@Slf4j
@EnableBinding(Sink.class)
public class SampleConsumer {

    private final Sink sink;

    public SampleConsumer(Sink sink) {
        this.sink = sink;
    }

    @StreamListener(Sink.INPUT)
    public void handler(@Payload SampleDto inMessage, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        log.info("RECEIVED  {}. {} ", partition, inMessage);
    }
}
