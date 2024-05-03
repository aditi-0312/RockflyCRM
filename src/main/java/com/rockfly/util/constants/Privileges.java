package com.rockfly.util.constants;

public enum Privileges {
	RESET_ANY_USER_PASSWORD(1l, "RESET_ANY_USER_PASSWORD"), ACCESS_ADMIN_PANEL(2l, "ACCESS_ADMIN_PANEL"),
	ACCESS_MAIN_INVENTORY(3l, "ACCESS_MAIN_INVENTORY"), ACCESS_SALES_TABLE(4l, "ACCESS_SALES_TABLE"),
	ACCESS_DISPATCHER_TABLE(5l, "ACCESS_DISPATCHER_TABLE");

	private Long id;
	private String privilege;

	private Privileges(Long id, String privilege) {
		this.id = id;
		this.privilege = privilege;
	}

	public Long getId() {
		return id;
	}

	public String getPrivilege() {
		return privilege;
	}

}
