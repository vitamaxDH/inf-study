package kr.co.infStudy.oauth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.util.StringUtils;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;

public class NaverLoginBO {

	private final static String CLIENT_ID = "HtZ1JRONvahOHpe9Cvep";
	private final static String CLIENT_SECRET = "ShaiiQpIxv";
	private final static String REDIRECT_URI = "http://localhost:8090/infStudy/callback";
	private final static String SESSION_STATE = "oauth_state";
    private final static String PROFILE_API_URL = "https://openapi.naver.com/v1/nid/me";
    
    
    /* 네아로 인증 URL 생성 METHOD*/
    public String getAuthorizationUrl(HttpSession session) {
    	
//    	세션 유효성 검증을 위하여 난수 생성
    	String  state = generateRandomString();
//    	생성한 난수 값을 session에 저장
    	setSession(session, state);
    	
//    	scribe에서 젲공하는 인증 URL 생성 기능을 이용하여 네아로 인증 URL 생성
    	OAuth20Service oauthService = new ServiceBuilder()
    					.apiKey(CLIENT_ID)
    					.apiSecret(CLIENT_SECRET)
    					.callback(REDIRECT_URI)
    					.state(state)	//앞에서 생성한 난수값을 인증 URL 생성시 사용함
    					.build(NaverLoginApi.instance());
    	
    	return oauthService.getAuthorizationUrl();
    }
	
    public OAuth2AccessToken getAccessToken(HttpSession session, String code, String state ) throws IOException{
    	
    	String sessionState = getSession(session);
    	if(StringUtils.pathEquals(sessionState, state)) {
    		
    		OAuth20Service oauthService = new ServiceBuilder()
    						.apiKey(CLIENT_ID)
    						.apiSecret(CLIENT_SECRET)
    						.callback(REDIRECT_URI)
    						.state(state)
    						.build(NaverLoginApi.instance());
    		
    		OAuth2AccessToken accessToken = oauthService.getAccessToken(code);
    		return accessToken;
    	}
    	
    	return null;
    	
    }
    
    private String generateRandomString() {
        return UUID.randomUUID().toString();
    }

    /* http session에 데이터 저장 */
    private void setSession(HttpSession session,String state){
        session.setAttribute(SESSION_STATE, state);     
    }

    /* http session에서 데이터 가져오기 */ 
    private String getSession(HttpSession session){
        return (String) session.getAttribute(SESSION_STATE);
    }
    /* Access Token을 이용하여 네이버 사용자 프로필 API를 호출 */
    public String getUserProfile(OAuth2AccessToken oauthToken) throws IOException{

        OAuth20Service oauthService =new ServiceBuilder()
                .apiKey(CLIENT_ID)
                .apiSecret(CLIENT_SECRET)
                .callback(REDIRECT_URI).build(NaverLoginApi.instance());

            OAuthRequest request = new OAuthRequest(Verb.GET, PROFILE_API_URL, oauthService);
        oauthService.signRequest(oauthToken, request);
        Response response = request.send();
        return response.getBody();
    }

    public void naverProfile() {
    	String token = "YOUT_ACCESS_TOKEN";
    	String header = "Bearer"+ token;
    	try {
    		String apiURL="https://openapi.naver.com/v1/nid/me";
    		
    		URL url = new URL(apiURL);
    		HttpURLConnection con = (HttpURLConnection) url.openConnection();
    		con.setRequestMethod("GET");
    		con.setRequestProperty("Authorization", header);
    		int responseCode = con.getResponseCode();
    		BufferedReader br;
    		if(responseCode ==200) {
    			br=new BufferedReader(new InputStreamReader(con.getInputStream()));
    		} else {
    			br=new BufferedReader(new InputStreamReader(con.getErrorStream()));
    		}
    		String inputLine;
    		StringBuffer response = new StringBuffer();
    		while((inputLine=br.readLine())!=null){
    			response.append(inputLine);
    		}
    		br.close();
    		System.out.println(response.toString());
    	} catch(Exception e) {
    		System.out.println(e);
    	}
    }
    
			
}
