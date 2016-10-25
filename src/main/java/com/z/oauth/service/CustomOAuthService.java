package com.z.oauth.service;

import org.scribe.model.Token;
import org.scribe.oauth.OAuthService;

import com.z.model.OAuthUser;

public interface CustomOAuthService extends OAuthService {

	String getoAuthType();

    String getAuthorizationUrl();

    OAuthUser getOAuthUser(Token accessToken);
}
