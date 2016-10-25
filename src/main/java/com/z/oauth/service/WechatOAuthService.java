package com.z.oauth.service;

import org.scribe.builder.api.DefaultApi20;
import org.scribe.model.OAuthConfig;
import org.scribe.model.OAuthConstants;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuth20ServiceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONPath;
import com.z.model.OAuthUser;
import com.z.oauth.config.OAuthTypes;

/**
 * 微信 oauth
 * 
 * @author Walter
 * 
 */
public class WechatOAuthService extends OAuth20ServiceImpl implements CustomOAuthService {

	private final DefaultApi20 api;
	private final OAuthConfig config;
	private final String authorizationUrl;

	public WechatOAuthService(DefaultApi20 api, OAuthConfig config) {
		super(api, config);
		this.api = api;
		this.config = config;
		this.authorizationUrl = getAuthorizationUrl(null);
	}

	@Override
	public Token getAccessToken(Token requestToken, Verifier verifier) {
		OAuthRequest request = new OAuthRequest(api.getAccessTokenVerb(),
				api.getAccessTokenEndpoint());
		request.addQuerystringParameter("appid", config.getApiKey());
		request.addQuerystringParameter("secret", config.getApiSecret());
		request.addQuerystringParameter(OAuthConstants.CODE,
				verifier.getValue());
		if (config.hasScope()) {
			request.addQuerystringParameter(OAuthConstants.SCOPE,
					config.getScope());
		}
		Response response = request.send();
		String responceBody = response.getBody();
		System.out.println("=================wechat====================");
		System.out.println(responceBody);
		System.out.println("=====================================");
		Object result = JSON.parse(responceBody);
		return new Token(JSONPath.eval(result, "$.access_token").toString(),
				"", responceBody);
	}

	@Override
	public OAuthUser getOAuthUser(Token accessToken) {
		OAuthUser oAuthUser = new OAuthUser();
		oAuthUser.setoAuthType(getoAuthType());
		Object result = JSON.parse(accessToken.getRawResponse());
		System.out.println("===============wechat======================");
		System.out.println(result);
		System.out.println("=====================================");
		oAuthUser.setoAuthId(JSONPath.eval(result, "$.openid").toString());
		return oAuthUser;
	}

	@Override
	public String getoAuthType() {
		return OAuthTypes.WECHAT;
	}

	public String getAuthorizationUrl() {
		return authorizationUrl;
	}

}
