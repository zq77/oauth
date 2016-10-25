package com.z.oauth.config;

import org.scribe.builder.ServiceBuilder;

import com.z.oauth.api.WeChatApi;
import com.z.oauth.service.WechatOAuthService;

public enum WeChatConfig {

	INSTANCE;

	private static final String CALLBACK_URL = "http://www.zgjscyw.com/oauth/%s/callback.html";
    
    private static final String appId = "wxa4691e7fcaa1f5a8";
    private static final String appSecret = "b5fcfd7a7a65258b1381ee5e1e2d3a89";

    private WeChatConfig() {}

    public WechatOAuthService getWeixinOAuthService(){
        return (WechatOAuthService) new ServiceBuilder()
            .provider(WeChatApi.class)
            .apiKey(appId)
            .apiSecret(appSecret)
            .scope("snsapi_login")
            .callback(String.format(CALLBACK_URL, OAuthTypes.WECHAT))
            .build();
    }
}
