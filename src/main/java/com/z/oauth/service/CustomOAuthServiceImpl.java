package com.z.oauth.service;

import org.scribe.model.OAuthRequest;
import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

import com.z.model.OAuthUser;

/**
 * 公用的oauth 接口(微信除外， 它的 getToken 需要的参数不一样)
 * @author Walter
 *
 */
public abstract class CustomOAuthServiceImpl implements CustomOAuthService {

	private final OAuthService oAuthService;
	private final String oAuthType;

    public CustomOAuthServiceImpl(OAuthService oAuthService, String type) {
        super();
        this.oAuthService = oAuthService;
        this.oAuthType = type;
    }

    @Override
    public Token getRequestToken() {
        return oAuthService.getRequestToken();
    }

    @Override
    public Token getAccessToken(Token requestToken, Verifier verifier) {
        return oAuthService.getAccessToken(requestToken, verifier);
    }

    @Override
    public void signRequest(Token accessToken, OAuthRequest request) {
        oAuthService.signRequest(accessToken, request);
    }

    @Override
    public String getVersion() {
        return oAuthService.getVersion();
    }

    @Override
    public String getAuthorizationUrl(Token requestToken) {
        return oAuthService.getAuthorizationUrl(requestToken);
    }

    public String getoAuthType() {
        return oAuthType;
    }

	@Override
	public String getAuthorizationUrl() {
		return oAuthService.getAuthorizationUrl(null);
	}

}
