package com.dream.qixing.mobile.control.action.common;

import java.util.ArrayList;
import java.util.List;

import com.dream.qixing.mobile.config.ApiAction;
import com.dream.qixing.mobile.control.action.BaseAction;
import com.dream.qixing.mobile.mapping.ApiField;
import com.dream.qixing.mobile.mapping.ApiListField;
import com.dream.qixing.mobile.model.common.Role;

@ApiAction("common.role.show")
public class QueryRoleInfoAction extends BaseAction {
	
	
	@ApiListField("roles")
	@ApiField("role")
	List<Role> roles ;

	public String execute(){
		roles = new ArrayList<Role>();
		Role role = new Role();
		role.setRoleId(100);
		role.setRoleName("队长");
		roles.add(role);
		role = new Role();
		role.setRoleId(101);
		role.setRoleName("前旗");
		roles.add(role);
		role = new Role();
		role.setRoleId(111);
		role.setRoleName("后旗");
		roles.add(role);
		role = new Role();
		role.setRoleId(200);
		role.setRoleName("队医");
		roles.add(role);
		role = new Role();
		role.setRoleId(201);
		role.setRoleName("维修");
		roles.add(role);
		role = new Role();
		role.setRoleId(300);
		role.setRoleName("普通成员");
		roles.add(role);
		this.setIsSuccessful(true);
		this.setStatusCode(200);
		this.setDescription("success");
		return "";
	}
	@Override
	public String getResponseName() {
		
		return null;
	}
	
	
}
