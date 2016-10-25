package com.z.oauth.service;

import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONPath;
import com.z.model.OAuthUser;
import com.z.oauth.config.OAuthTypes;

/**
 * 新浪微博 oauth
 * 
 * @author Walter
 * 
 */
public class WeiboOAuthService extends CustomOAuthServiceImpl {

	public WeiboOAuthService(OAuthService build) {
		super(build, OAuthTypes.SINA_WEIBO);
	}

	private static final String PROTECTED_RESOURCE_URL = "https://api.weibo.com/oauth2/get_token_info";

	@Override
    public OAuthUser getOAuthUser(Token accessToken) {
        OAuthRequest request = new OAuthRequest(Verb.POST, PROTECTED_RESOURCE_URL);
        this.signRequest(accessToken, request);
        Response response = request.send();
        OAuthUser oAuthUser = new OAuthUser();
        oAuthUser.setoAuthType(getoAuthType());
		System.out.println("===============weibo====getOAuthUser==================");
		System.out.println(response.getBody());
		System.out.println("=====================================");
        oAuthUser.setoAuthId(JSONPath.eval(JSON.parse(response.getBody()), "$.uid").toString());
        return oAuthUser;
    }

}
