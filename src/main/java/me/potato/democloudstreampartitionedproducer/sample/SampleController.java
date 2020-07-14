package me.potato.democloudstreampartitionedproducer.sample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SampleController {

    private final SampleProducer sampleProducer;

    private final KafkaTemplate kafkaTemplate;

    public SampleController(SampleProducer sampleProducer, KafkaTemplate kafkaTemplate) {
        this.sampleProducer = sampleProducer;
        this.kafkaTemplate  = kafkaTemplate;
    }

    @PostMapping("/sample")
    public ResponseEntity createAMessage(@RequestBody SampleDto message) {
        log.info("{}", message);

        boolean result = sampleProducer.getSource().output()
                .send(MessageBuilder
                              .withPayload(message)
                              .setHeader("partitionKey", message.getPartitionKey())
                              .build()
                );
        if(!result)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
