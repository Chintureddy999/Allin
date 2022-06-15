package client;

import java.util.Base64;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ClientBasic {

	public static void main(String[] args) {
		//following is the URL on server we want to access
		String url="http://localhost:8082/api/message";
		
		//RestTemplate is a class given by spring to consume Restweb service
		RestTemplate rt=new RestTemplate();
		String credentials="zensar:zensar";
		
		//following line is used to convert string credentials to base64encodedform
		//using Base64 class given by java
		//because server expects credentials in this form
		
		byte[]encode=Base64.getEncoder().encode(credentials.trim().getBytes());
		String encodedCredentials =new String(encode).trim();
		System.out.println(encodedCredentials);
		//this encoded credentials need to be passed to server using http header (Authorization)
		//it is done as follows
		
		HttpHeaders headers=new HttpHeaders();
		headers.add("Authorization","Basic "+encodedCredentials);
		HttpEntity<String>entity=new HttpEntity<String>(headers);
		ResponseEntity<String> exchange = rt.exchange(url, HttpMethod.GET, entity, String.class);
		System.out.println(exchange.getBody());

	}

}
