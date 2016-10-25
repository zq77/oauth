package com.z.model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    private static final long serialVersionUID = -5880881656633990439L;

    private Long id;

    private String username;

    private String password;

    /**
     * 昵称.
     */
    private String nickname;

    /**
     * 头像.
     */
    private String logo;

    /**
     * 注册时间
     */
    private Date registerTime;

    /**
     * 是否是第三方登陆, 默认为false
     */
    private Boolean isOAuth;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getLogo() {
		return logo;
	}

	public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

	public Boolean getIsOAuth() {
		return isOAuth;
	}

	public void setIsOAuth(Boolean isOAuth) {
		this.isOAuth = isOAuth;
	}

}
