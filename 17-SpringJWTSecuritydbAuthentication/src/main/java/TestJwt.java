import java.util.Scanner;

import com.zensar.messageapi.security.jwt.util.JWTUtil;

public class TestJwt {

	public static void main(String[] args) {
		
		JWTUtil util=new JWTUtil();
		String token=util.generateToken("zensar");
		new Scanner(System.in).next();//this is to make sure programs halts
		                              //so that time expires and token becomes in valid
		try {
		util.validateToken(token);
		//System.out.println(util.generateToken("zensar"));
		System.out.println("Token is valid");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Token is not valid");
		}

	}

}
