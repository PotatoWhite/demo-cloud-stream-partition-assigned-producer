package me.potato.democloudstreampartitionedproducer.sample;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties
public class SampleDto implements Serializable {
    private String data;
    private int    partitionKey;

}
