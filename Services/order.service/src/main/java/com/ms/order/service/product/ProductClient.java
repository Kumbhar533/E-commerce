package com.ms.order.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ms.order.service.exception.BussinessException;
import com.ms.order.service.request.response.PurchaseRequest;
import com.ms.order.service.request.response.PurchaseResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductClient {

	@Value("${application.config.product-url")
	private String url;

	private final RestTemplate restTemplate;

	public List<PurchaseResponse> purchaseProducts(List<PurchaseRequest> purchaseRequest) {

		HttpHeaders headers = new HttpHeaders();

		headers.set(HttpHeaders.CONTENT_TYPE, "application/json");

		HttpEntity<List<PurchaseRequest>> requestEntity = new HttpEntity(purchaseRequest, headers);
		ParameterizedTypeReference<List<PurchaseResponse>> responseType = new ParameterizedTypeReference<List<PurchaseResponse>>() {
		};

		ResponseEntity<List<PurchaseResponse>> reponseEntity = restTemplate.exchange(url + "/purchase", HttpMethod.POST,
				requestEntity, responseType);

		if (reponseEntity.getStatusCode().isError()) {
			throw new BussinessException("An error occured while processing products purchase");
		}
		return reponseEntity.getBody();

	}

}
