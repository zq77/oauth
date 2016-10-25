package com.z.oauth.config;

import org.scribe.builder.ServiceBuilder;

import com.z.oauth.api.QQApi;
import com.z.oauth.service.QQOAuthService;

public enum QQConfig {

	INSTANCE;

	private static final String CALLBACK_URL = "http://www.zgjscyw.com/oauth/%s/callback.html";

    private static final String appId = "101358720";
    private static final String appkey = "b361b4ca5fe0f936167afedc9c171814";

    private QQConfig() {}

    public QQOAuthService getQQOAuthService(){
        return new QQOAuthService(new ServiceBuilder()
            .provider(new QQApi("b361b4ca5fe0f936167afedc9c171814"))
            .apiKey(appId)
            .apiSecret(appkey)
            .callback(String.format(CALLBACK_URL, OAuthTypes.QQ))
            .build());
    }
}
