package com.rockfly.util.constants;

public enum Roles {
	ADMIN("ROLE_ADMIN"),SALES("ROLE_SALES"),BILLER("ROLE_BILLER");
	
	private String role;
	private Roles(String role) {
		this.role=role;
	}
	public String getRole() {
		return role;
	}
}
