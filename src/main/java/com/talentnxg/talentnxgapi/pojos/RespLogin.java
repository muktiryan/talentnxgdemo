package com.talentnxg.talentnxgapi.pojos;

import java.util.List;

import com.talentnxg.talentnxgapi.models.MApplication;
import com.talentnxg.talentnxgapi.models.MModule;
import com.talentnxg.talentnxgapi.models.Profile;

public class RespLogin {
	private Integer code;
	private String status;
	private Profile profile;
	private List<MModule> tabmenu;
	private List<MApplication> mainmenu;
	private MModule tabactive;
	private MApplication menuactive;
	
	public RespLogin() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}


	public List<MModule> getTabmenu() {
		return tabmenu;
	}


	public void setTabmenu(List<MModule> tabmenu) {
		this.tabmenu = tabmenu;
	}


	public List<MApplication> getMainmenu() {
		return mainmenu;
	}


	public void setMainmenu(List<MApplication> mainmenu) {
		this.mainmenu = mainmenu;
	}


	public MModule getTabactive() {
		return tabactive;
	}


	public void setTabactive(MModule tabactive) {
		this.tabactive = tabactive;
	}


	public MApplication getMenuactive() {
		return menuactive;
	}


	public void setMenuactive(MApplication menuactive) {
		this.menuactive = menuactive;
	}
	
}
