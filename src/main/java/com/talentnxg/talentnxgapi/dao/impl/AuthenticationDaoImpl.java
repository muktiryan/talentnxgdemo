package com.talentnxg.talentnxgapi.dao.impl;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.talentnxg.talentnxgapi.configs.AppConfig;
import com.talentnxg.talentnxgapi.dao.AuthenticationDao;
import com.talentnxg.talentnxgapi.models.MApplication;
import com.talentnxg.talentnxgapi.models.MCompany;
import com.talentnxg.talentnxgapi.models.MModule;
import com.talentnxg.talentnxgapi.models.Profile;
import com.talentnxg.talentnxgapi.models.MUserprofile;
import com.talentnxg.talentnxgapi.pojos.ReqLogin;
import com.talentnxg.talentnxgapi.pojos.RespLogin;

@Repository
public class AuthenticationDaoImpl implements AuthenticationDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public String insertUser(MUserprofile userprofile) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	@SuppressWarnings("unchecked")
//	public RespLogin getAuthentication(ReqLogin reqLogin) {
//		// TODO Auto-generated method stub
//		RespLogin result = new RespLogin();
//		Profile profile = new Profile();
//		MModule activeTab = new MModule();
//		MApplication mainMenu = new MApplication();
//		
////		System.out.println("########## user : "+reqLogin.getIdentifier()+", pwd : "+reqLogin.getPassword());
//		Object[] parameters = new Object[] {new String(reqLogin.getIdentifier()), new String(reqLogin.getPassword())};
//		List<Map<String, Object>> rows = jdbcTemplate.queryForList(AppConfig.selectUserProfileByLogin, parameters);
//		if(rows.size() > 0) {
//			result.setCode(AppConfig.CODE_SUCCESS);
//			result.setStatus(AppConfig.CODE_SUCCESS_MSG);
//			for (Map<String, Object> row : rows) 
//	        {
//				profile.setTenantid(Integer.parseInt(row.get("id").toString()));
//				profile.setTenantname((String)row.get("tenant_name"));
//				profile.setUseravatar((String)row.get("avatarname"));
//				profile.setUserid(Integer.parseInt(row.get("userid").toString()));
//				profile.setUsername((String)row.get("username"));
//				profile.setFullname((String)row.get("fullname"));
//	         }
//		
//		///////////Array list for tabMenu///////////
//		List<MModule> tabMenus = new ArrayList<MModule>();
//		List<Map<String, Object>> temp = (ArrayList<Map<String,Object>>)(jdbcTemplate.queryForList(AppConfig.selectTabWorkStructure));
//		tabMenus.addAll((Collection<? extends MModule>) temp);
//		result.setTabmenu(tabMenus);
//		
//		///////////Array list for mainMenu///////////
//		List<MApplication> mainMenus = new ArrayList<MApplication>();
//		List<Map<String, Object>> temporary = (ArrayList<Map<String,Object>>)(jdbcTemplate.queryForList(AppConfig.selectMainMenu));
//		mainMenus.addAll((Collection<? extends MApplication>) temporary);
//		result.setMainmenu(mainMenus);
//		
//		//////////////////Active Tab////////////////////
//		List<Map<String, Object>> tabs = jdbcTemplate.queryForList(AppConfig.selectActiveTab);
//		if (tabs.size() > 0) {
//			for (Map<String, Object> tab : tabs)
//			{
//				activeTab.setModid(Integer.parseInt(tab.get("modid").toString()));
//				activeTab.setModname((String)tab.get("modname"));
//				activeTab.setModtitle((String)tab.get("modtitle"));
//				activeTab.setModrealpath((String)tab.get("modrealpath"));
//			}
//		}
//		
//		///////////////Active Menu///////////////////
//		List<Map<String, Object>> menus = jdbcTemplate.queryForList(AppConfig.selectActiveMenu);
//		if (menus.size() > 0) {
//			for (Map<String, Object> menu : menus)
//			{
//				mainMenu.setAppid(Integer.parseInt(menu.get("appid").toString()));
//				mainMenu.setAppname((String)menu.get("appname"));
//			}
//		}
//		
//			
//		} else {
//			result.setCode(AppConfig.CODE_FAILED);
//			result.setStatus(AppConfig.CODE_FAILED_MSG);
//		}
//		
//		result.setProfile(profile);
//		result.setTabactive(activeTab);
//		result.setMenuactive(mainMenu);
//		return result;
//	}
	@SuppressWarnings("unchecked")
	@Override
	public RespLogin getAuthentication(ReqLogin reqLogin) {
		// TODO Auto-generated method stub
		RespLogin result = new RespLogin();
		Profile profile = new Profile();
		MModule activeTab = new MModule();
		MApplication mainMenu = new MApplication();
//		System.out.println("########## user : "+reqLogin.getIdentifier()+", pwd : "+reqLogin.getPassword());
		Object[] parameters = new Object[] {new String(reqLogin.getIdentifier()), new String(reqLogin.getPassword())};
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(AppConfig.selectMUserProfileByLogin, parameters);
		if(rows.size() > 0) {
			result.setCode(AppConfig.CODE_SUCCESS);
			result.setStatus(AppConfig.CODE_SUCCESS_MSG);
			for (Map<String, Object> row : rows) 
	        {
				profile.setTenantId(Integer.parseInt(row.get("id").toString()));
				profile.setTenantName((String)row.get("tenant_name"));
				profile.setUserAvatar((String)row.get("avatarname"));
				profile.setUserId(Integer.parseInt(row.get("userid").toString()));
				profile.setUserName((String)row.get("username"));
				profile.setUserFullname((String)row.get("fullname"));
	         }
			
			Object[] tmpuserid = new Object[] {new Integer(profile.getUserId())};
			///////////Array list for tabMenu///////////
			List<MModule> tabMenus = new ArrayList<MModule>();
			List<Map<String, Object>> temp = (ArrayList<Map<String,Object>>)(jdbcTemplate.queryForList(AppConfig.selectTabWorkStructure, tmpuserid));
//			tabMenus.addAll((Collection<? extends MModule>) temp);
			for(Map<String,Object> i:temp){
				tabMenus.add((MModule) i.values());
		    }
			result.setTabmenu(tabMenus);
			
			///////////Array list for mainMenu///////////
			List<MApplication> mainMenus = new ArrayList<MApplication>();
			List<Map<String, Object>> temporary = (ArrayList<Map<String,Object>>)(jdbcTemplate.queryForList(AppConfig.selectMainMenu, tmpuserid));
//			mainMenus.addAll((Collection<? extends MApplication>) temporary);
			for(Map<String,Object> i:temporary){
				mainMenus.add((MApplication) i.values());
		    }
			
			result.setMainmenu(mainMenus);
			
			//////////////////Active Tab////////////////////
			List<Map<String, Object>> tabs = jdbcTemplate.queryForList(AppConfig.selectActiveTab);
			if (tabs.size() > 0) {
				for (Map<String, Object> tab : tabs)
				{
					activeTab.setModid(Integer.parseInt(tab.get("modid").toString()));
					activeTab.setModname((String)tab.get("modname"));
					activeTab.setModtitle((String)tab.get("modtitle"));
					activeTab.setModrealpath((String)tab.get("modrealpath"));
				}
			}
			///////////////Active Menu///////////////////
			List<Map<String, Object>> menus = jdbcTemplate.queryForList(AppConfig.selectActiveMenu);
			if (menus.size() > 0) {
				for (Map<String, Object> menu : menus)
				{
					mainMenu.setAppid(Integer.parseInt(menu.get("appid").toString()));
					mainMenu.setAppname((String)menu.get("appname"));
				}
			}
			
		} else {
			result.setCode(AppConfig.CODE_FAILED);
			result.setStatus(AppConfig.CODE_FAILED_MSG);
		}
		result.setProfile(profile);
		result.setTabactive(activeTab);
		result.setMenuactive(mainMenu);
		return result;
	}
	
	// new setup
	
	@Override
	public Object[] getNewReqSetup(MCompany mCompany, MUserprofile mUserprofile) {
		KeyHolder tenantIdKey = new GeneratedKeyHolder();
		KeyHolder userIdKey = new GeneratedKeyHolder();
		KeyHolder companyIdKey = new GeneratedKeyHolder();
		jdbcTemplate.update(connection -> {
			PreparedStatement temp = connection.prepareStatement(AppConfig.saveMTenant, new String[]{"id"});
			temp.setString(1, mCompany.getCompanyname());
			temp.setString(2, mCompany.getCompanylogo());
			temp.setString(3, mCompany.getCompanyname());
			return temp;
		}, tenantIdKey);

		jdbcTemplate.update(connection -> {
			PreparedStatement temp = connection.prepareStatement(AppConfig.saveMCompany, new String[]{"id"});
			temp.setInt(1, tenantIdKey.getKey().intValue());
			temp.setString(2, mCompany.getCompanyname());
			temp.setString(3, mCompany.getCompanycode());
			temp.setString(4, mCompany.getBankaccount());
			temp.setString(5, mCompany.getAccountname());
			temp.setString(6, mCompany.getTaxnumber());
			return temp;
		}, companyIdKey);
		
		jdbcTemplate.update(connection -> {
			PreparedStatement temp = connection.prepareStatement(AppConfig.saveMUserprofile, new String[] {"userid"});
			temp.setString(1, mUserprofile.getUsername());
			temp.setString(2, mUserprofile.getFullname());
			temp.setString(3, mUserprofile.getSecretpwd());
			temp.setString(4, mUserprofile.getEmail());
			temp.setString(5, mUserprofile.getPhone());
			temp.setString(6, mUserprofile.getMobile());
			temp.setString(7, mUserprofile.getFax());
			temp.setInt(8, tenantIdKey.getKey().intValue());
			temp.setString(9, mUserprofile.getEmployeecode());
			return temp;
		}, userIdKey);
		
		Object[] result = new Object[] { new Integer(tenantIdKey.getKey().intValue()), 
				new Integer(companyIdKey.getKey().intValue()), 
				new Integer(userIdKey.getKey().intValue())};
		return result;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Iterable<MModule> getMenuAppWorkStructure() {
		List<MModule> tabMenus = new ArrayList<MModule>();
		List<Map<String, Object>> temp = (ArrayList<Map<String,Object>>)(jdbcTemplate.queryForList(AppConfig.selectTabWorkStructure));
//		tabMenus.addAll((Collection<? extends MModule>) temp);
		for(Map<String,Object> i:temp){
			tabMenus.add((MModule) i.values());
	    }
		return tabMenus;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Iterable<MModule> getMenuAppEmployee() {
		List<MModule> tabMenus = new ArrayList<MModule>();
		List<Map<String, Object>> temp = (ArrayList<Map<String,Object>>)(jdbcTemplate.queryForList(AppConfig.selectTabEmployee));
//		tabMenus.addAll((Collection<? extends MModule>) temp);
		for(Map<String,Object> i:temp){
			tabMenus.add((MModule) i.values());
	    }
		return tabMenus;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Iterable<MModule> getMenuAppPayroll() {
		List<MModule> tabMenus = new ArrayList<MModule>();
		List<Map<String, Object>> temp = (ArrayList<Map<String,Object>>)(jdbcTemplate.queryForList(AppConfig.selectTabPayroll));
//		tabMenus.addAll((Collection<? extends MModule>) temp);
		for(Map<String,Object> i:temp){
			tabMenus.add((MModule) i.values());
	    }
		return tabMenus;
	}

	
}
