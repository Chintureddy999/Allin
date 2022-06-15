Http Status codes

200     OK

401   UNAUTHORISED

403   Forbidden(Authenticated but not allowed to access a resource)

This project uses Data base authentication Authentication
 
Steps for applying Spring Security

1)To add dependency in pom.xml
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
		
		
	By default one user with username:user
	and password: displayed on console :28e71063-f4d3-463a-babc-309a1e3f8ced
	
	problem?=Every time we run application new password is generated.
	
	Above is the default behaviour (functionality)we are getting from Spring Security

	we want to have custom userName and password.
	
	2) To write configuration class
	
	Spring security is giving implicit support for an attack known as -CSRF(Cross Site Request Forgery)
	PoST request doesn't work
	So we need do additional configuration as follows-
	-----------------------------------------------------------------------------------------------
	JWT
	JWT stands for Json web token.
	JWT consists of three parts
	Header.payload.signature.
	Header consists of algorithm used to generate the token.
	Payload consists of claim is additional data about user entity.
	        eg.username,expiration time etc
	signature consists of typically secret key(String which is known only to server to validate the token
	
	eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.-header
	eyJuYW1lIjoiemVuc2FyIiwiZXhwIjoxNjUzODk0Nzk3fQ.--payload
	gHT5uUGcwwQ6JurjF8Lr2pISn0ANVf7s_rSfSON3FitWnqBnBtmxtBgc7EYapwM33Yf4N-wb_-eg92p0EPEQlg---signature
	