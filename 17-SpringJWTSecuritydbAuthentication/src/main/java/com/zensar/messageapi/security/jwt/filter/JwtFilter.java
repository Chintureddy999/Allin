package com.zensar.messageapi.security.jwt.filter;



import java.io.IOException;



import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;



import com.zensar.messageapi.security.jwt.util.JWTUtil;



//This class is used to fetch token and check if it is valid
public class JwtFilter extends BasicAuthenticationFilter {



public JwtFilter(AuthenticationManager authenticationManager) {
super(authenticationManager);
}
@Override
protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
throws IOException, ServletException {

System.out.println("In doFilterInternal");

// Bearer token
//1 Fetch the token

String authorizationHeaderValue = request.getHeader("Authorization");



if(authorizationHeaderValue!=null)
{
	String token = authorizationHeaderValue.substring(7);
//2 validate the token
JWTUtil util = new JWTUtil();
try {
	util.validateToken(token);


//3 if it is valid allow user to access resource

UsernamePasswordAuthenticationToken authenticationToken;
authenticationToken=new UsernamePasswordAuthenticationToken("zensar",null,
AuthorityUtils.createAuthorityList("ROLE_USER"));
SecurityContextHolder.getContext().setAuthentication(authenticationToken);
}
catch(Exception e)
{

e.printStackTrace();

//4 it is not valid don't allow user
throw e;

}
}
// Calling doFilter method is Must so That next filter in chain will execute
chain.doFilter(request,response);
}
}
