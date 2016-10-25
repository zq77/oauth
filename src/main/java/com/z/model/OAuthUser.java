package com.z.model;

import java.io.Serializable;

/**
 * oauth 存储表
 * 第三方登陆用到
 * @author Walter
 *
 */
public class OAuthUser implements Serializable {

	private static final long serialVersionUID = -9153255643810786243L;

	private Long id;

	private Long userId;
	private User user;

	private String oAuthType;
    private String oAuthId;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getoAuthType() {
		return oAuthType;
	}
	public void setoAuthType(String oAuthType) {
		this.oAuthType = oAuthType;
	}
	public String getoAuthId() {
		return oAuthId;
	}
	public void setoAuthId(String oAuthId) {
		this.oAuthId = oAuthId;
	}
}
