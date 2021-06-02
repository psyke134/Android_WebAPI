package Utils;

import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class JWT 
{
	private String header;
	private String payload;
	private String secretKey;
	
	public JWT(String header, String payload, String secretKey)
	{
		this.header = header;
		this.payload = payload;
		this.secretKey = secretKey;
	}
	
	private String GetBase64Encoded(String someJson)
	{
		return Base64.getUrlEncoder().encodeToString(someJson.getBytes());
	}
	
	public String getToken()
	{
		String encodedHeader = GetBase64Encoded(header);
		String encodedPayload = GetBase64Encoded(payload);
		
		String signature = encodedHeader + "." + encodedPayload;
		byte[] encodedSignature;
		
		try 
		{
		Mac mac = Mac.getInstance("HmacSHA256");
	    SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes("UTF-8"), "HmacSHA256");
	    mac.init(secretKeySpec);
	    encodedSignature = mac.doFinal(signature.getBytes("UTF-8"));
		}
		catch(Exception e)
		{
			encodedSignature = null;
		}
		
		String finalSignature = Base64.getEncoder().encodeToString(encodedSignature);
		String token = encodedHeader + "." + encodedPayload + "." + finalSignature;
		
		return token;
	}
}
