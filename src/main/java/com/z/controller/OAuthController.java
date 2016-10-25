package com.z.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.scribe.model.Token;
import org.scribe.model.Verifier;

import com.z.model.OAuthUser;
import com.z.oauth.service.CustomOAuthService;
import com.z.oauth.service.OAuthServiceSelector;

public class OAuthController {

	private static final Logger LOGGER = Logger.getLogger(OAuthController.class);

	// 配置的回掉方法
//    @RequestMapping(value = "/oauth/{type}/callback.html", method=RequestMethod.GET)
//	public String callback( HttpServletRequest request, @RequestParam(value = "code", required = true) String code, @PathVariable(value = "type") String type){
    public String callback( HttpServletRequest request, String code, String type){
        CustomOAuthService oAuthService = OAuthServiceSelector.INSTANCE.getOAuthService(type);
        if (oAuthService == null) {
        	return "redirect:/404.html";
        }
        Token accessToken = oAuthService.getAccessToken(null, new Verifier(code));
        // 1. 根据token 查询 oauth 信息
        OAuthUser oAuthInfo = oAuthService.getOAuthUser(accessToken);
        
        // 2. 从数据库查询 是否在数据库存在

        // 3. 没有的话注册用户
        
        // 4. 初始化用户到session
        return "redirect:/";
    }
}
