package com.zensar.displayservice.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

// So hard coding URL is not recommended. It is bad design
// @FeignClient(value = "messageservice", url = "http://localhost:7071/api/message")
@FeignClient(value = "messageservice")
public interface MessageFeignClient {

	@GetMapping("/api/message")
	public String callGenerateMessage();
}