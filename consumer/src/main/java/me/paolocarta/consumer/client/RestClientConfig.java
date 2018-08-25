package me.paolocarta.consumer.client;

import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RestClientConfig {

	@Bean
	public Decoder decoder() {
		return new JacksonDecoder();
	}

	@Bean
	public Encoder encoder() {
		return new JacksonEncoder();
	}

}
