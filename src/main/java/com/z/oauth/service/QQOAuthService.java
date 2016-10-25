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
 * 新浪微博 oAuth
 * 
 * @author Walter
 * 
 */
public class QQOAuthService extends CustomOAuthServiceImpl {

    public QQOAuthService(OAuthService oAuthService) {
		super(oAuthService, OAuthTypes.QQ);
	}

	private static final String PROTECTED_RESOURCE_URL = "https://graph.qq.com/oauth2.0/me";

    @Override
    public OAuthUser getOAuthUser(Token accessToken) {
        OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL);
        this.signRequest(accessToken, request);
        Response response = request.send();
        OAuthUser oAuthUser = new OAuthUser();
        oAuthUser.setoAuthType(getoAuthType());
        // qq 返回的是一个 callback( {"client_id":"101358720","openid":"0E25FB5D48DE269E7D7EFB557567A08B"} );
		// 所以需要解析一下，要不然会报错的
		String result = response.getBody();
		result = result.substring(result.indexOf("(") + 1, result.lastIndexOf(")"));
        oAuthUser.setoAuthId(JSONPath.eval(JSON.parse(result), "$.openid").toString());
        return oAuthUser;
    }
}
