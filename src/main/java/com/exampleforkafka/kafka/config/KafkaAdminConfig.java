package com.exampleforkafka.kafka.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaAdminConfig {
	
	@Value(value = "${spring.kafka.topic}")
	private String topic;
	
	@Value(value ="${spring.kafka.bootstrap-servers}")
	private String bootStrapAddress;

	@Bean
	public KafkaAdmin kafkaAdmin() {
		Map<String, Object> mapp= new LinkedHashMap<>();
        //Map configs = new HashMap();
		mapp.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapAddress);

		return new KafkaAdmin(mapp);
		
	}
	@Bean
	public NewTopic newtopiccreate() {
		return new NewTopic(topic, 1,(short) 1);
		
	}
}
