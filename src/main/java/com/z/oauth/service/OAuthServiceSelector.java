package com.z.oauth.service;

import java.util.ArrayList;
import java.util.List;

import com.z.oauth.config.QQConfig;
import com.z.oauth.config.WeChatConfig;
import com.z.oauth.config.WeiboConfig;

public enum OAuthServiceSelector {

	INSTANCE;

	private static List<CustomOAuthService> serviceList;
	
	static {
		synchronized (OAuthServiceSelector.class) {
			if (serviceList == null) {
				serviceList = new ArrayList<CustomOAuthService>(); 
			}
			serviceList.clear();
			serviceList.add(WeChatConfig.INSTANCE.getWeixinOAuthService());
			serviceList.add(WeiboConfig.INSTANCE.getSinaOAuthService());
			serviceList.add(QQConfig.INSTANCE.getQQOAuthService());
		}
	}

	public CustomOAuthService getOAuthService(String type){
		for (CustomOAuthService item : serviceList) {
			if (item.getoAuthType().equals(type)) {
				return item;
			}
		}
		return null;
    }

	public List<CustomOAuthService> getServiceList() {
		return serviceList;
	}
}
