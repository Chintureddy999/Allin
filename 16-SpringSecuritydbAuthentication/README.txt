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