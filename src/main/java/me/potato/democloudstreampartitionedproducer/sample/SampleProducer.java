package me.potato.democloudstreampartitionedproducer.sample;

import lombok.Getter;
import org.springframework.cloud.stream.annotation.EnableBinding;


@Getter
@EnableBinding(Source.class)
public class SampleProducer {

    private final Source source;

    public SampleProducer(Source source) {
        this.source = source;
    }
}
