package com.z.oauth.config;

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.SinaWeiboApi20;

import com.z.oauth.service.WeiboOAuthService;

public enum WeiboConfig {

	INSTANCE;

	private static final String CALLBACK_URL = "http://www.zgjscyw.com/oauth/%s/callback.html";
	private static final String sinaAppKey = "103097257";
	private static final String sinaAppSecret = "32823bfc273c674b06750b959d60a11e";

    private WeiboConfig() {}
    
    public WeiboOAuthService getSinaOAuthService(){
        return new WeiboOAuthService(new ServiceBuilder()
            .provider(SinaWeiboApi20.class)
            .apiKey(sinaAppKey)
            .apiSecret(sinaAppSecret)
            .callback(String.format(CALLBACK_URL, OAuthTypes.SINA_WEIBO))
            .build());
    }
}
