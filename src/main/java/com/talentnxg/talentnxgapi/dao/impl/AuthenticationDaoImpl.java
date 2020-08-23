package com.talentnxg.talentnxgapi.dao.impl;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.google.api.client.json.Json;
import com.talentnxg.talentnxgapi.configs.AppConfig;
import com.talentnxg.talentnxgapi.dao.AuthenticationDao;
import com.talentnxg.talentnxgapi.models.MApplication;
import com.talentnxg.talentnxgapi.models.MCompany;
import com.talentnxg.talentnxgapi.models.MModule;
import com.talentnxg.talentnxgapi.models.MModuleForMenu;
import com.talentnxg.talentnxgapi.models.MSystem;
import com.talentnxg.talentnxgapi.models.Profile;
import com.talentnxg.talentnxgapi.models.MUserprofile;
import com.talentnxg.talentnxgapi.models.MUserprofileCustom1;
import com.talentnxg.talentnxgapi.pojos.ReqLogin;
import com.talentnxg.talentnxgapi.pojos.RespLogin;
import com.talentnxg.talentnxgapi.pojos.RespLoginCst1;

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

	@Override
	public RespLoginCst1 getAuthentication(ReqLogin reqLogin) {
		// TODO Auto-generated method stub
//		RespLogin result = new RespLogin();
		RespLoginCst1 result = new RespLoginCst1();
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
				profile.setTenantId(Integer.parseInt(row.get("tenantid").toString()));
				profile.setTenantName((String)row.get("tenant_name"));
				profile.setUserAvatar((String)row.get("avatarname"));
				profile.setUserId(Integer.parseInt(row.get("userid").toString()));
				profile.setUserName((String)row.get("username"));
				profile.setUserFullname((String)row.get("fullname"));
				profile.setCompanyId(Integer.parseInt(row.get("companyid").toString()));
				profile.setCompanyName((String)row.get("company_name"));
				profile.setIsAdmin(Integer.parseInt(row.get("isadmin").toString()));
	         }
			
			Object[] tmpuserid = new Object[] {new Integer(profile.getUserId())};
			
			///////////Array list for mainMenu///////////
			List<MApplication> mainMenus = new ArrayList<MApplication>();
			List<Map<String, Object>> temporary = (ArrayList<Map<String,Object>>)(jdbcTemplate.queryForList(AppConfig.selectMainMenu, tmpuserid));
//			mainMenus.addAll((Collection<? extends MApplication>) temporary);
//			dp.profileid,dp.appid,ma.appname,ma.description,ma.tenantid
			for(Map<String,Object> row:temporary){
				MApplication mApplication = new MApplication();
				mApplication.setAppid(Integer.parseInt(row.get("appid").toString()));
				mApplication.setAppname((String)row.get("appname"));
				mApplication.setDescription((String)row.get("description"));
				mApplication.setTenantid(Integer.parseInt(row.get("tenantid").toString()));
				mainMenus.add(mApplication);
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
			
			int userid = profile.getUserId();
			Object [] profileuserid = new Object [] { new Integer (userid)};
			List<Map<String, Object>> menus = jdbcTemplate.queryForList(AppConfig.selectActiveMenuByUser, profileuserid);
			if (menus.size() > 0) {
				for (Map<String, Object> menu : menus)
				{
					mainMenu.setAppid(Integer.parseInt(menu.get("appid").toString()));
					mainMenu.setAppname((String)menu.get("appname"));
				}
			}
//			List<Map<String, Object>> menus = jdbcTemplate.queryForList(AppConfig.selectActiveMenu);
//			if (menus.size() > 0) {
//				for (Map<String, Object> menu : menus)
//				{
//					mainMenu.setAppid(Integer.parseInt(menu.get("appid").toString()));
//					mainMenu.setAppname((String)menu.get("appname"));
//				}
//			}
			
			///////////Array list for tabMenu///////////
//			Object [] activeAppid = new Object [] { new Integer (mainMenu.getAppid())};
//			List<MModule> tabMenus = new ArrayList<MModule>();
//			List<Map<String, Object>> temp = (ArrayList<Map<String,Object>>)(jdbcTemplate.queryForList(AppConfig.retrieveMenuByAppid, activeAppid));
//			for(Map<String,Object> row:temp){
//				MModule module = new MModule();
//				module.setModid(Integer.parseInt(row.get("modid").toString()));
//				module.setModname((String)row.get("modname"));
//				module.setModtitle((String)row.get("modtitle"));
//				module.setModroute((String)row.get("modroute"));
//				module.setModrealpath((String)row.get("modrealpath"));
//				tabMenus.add(module);
//		    }
			
			Object [] activeAppid = new Object [] { new Integer (mainMenu.getAppid())};
			List<MModuleForMenu> tabMenus = new ArrayList<MModuleForMenu>();
			List<Map<String, Object>> temp = (ArrayList<Map<String,Object>>)(jdbcTemplate.queryForList(AppConfig.retrieveMenuByAppid, activeAppid));
			for(Map<String,Object> row:temp){
				MModuleForMenu module = new MModuleForMenu();
				module.setModid(Integer.parseInt(row.get("modid").toString()));
				module.setModname((String)row.get("modname"));
				module.setModtype(Integer.parseInt(row.get("modtype").toString()));
				module.setModtitle((String)row.get("modtitle"));
				module.setModroute((String)row.get("modroute"));
				module.setModrealpath((String)row.get("modrealpath"));
				
				List<MModule> childItem = new ArrayList<MModule>();
				if(module.getModtype() == 1) {
					List<Map<String, Object>> itemTemp = (ArrayList<Map<String,Object>>)(jdbcTemplate.queryForList(AppConfig.retrieveMenuByGroupid, module.getModid()));
					for(Map<String,Object> rowChild:itemTemp){
						MModule childModule = new MModule();
						childModule.setModid(Integer.parseInt(rowChild.get("modid").toString()));
						childModule.setModname((String)rowChild.get("modname"));
						childModule.setModtype(Integer.parseInt(rowChild.get("modtype").toString()));
						childModule.setModtitle((String)rowChild.get("modtitle"));
						childModule.setModroute((String)rowChild.get("modroute"));
						childModule.setModrealpath((String)rowChild.get("modrealpath"));
						childModule.setGroupid(Integer.parseInt(rowChild.get("groupid").toString()));
						childItem.add(childModule);
					}
					module.setSubitems(childItem);
				} else {
					module.setSubitems(childItem);
				}
				tabMenus.add(module);
		    }
			result.setTabmenu(tabMenus);
			
		} else {
			result.setCode(AppConfig.CODE_FAILED);
			result.setStatus(AppConfig.CODE_FAILED_MSG);
		}
		result.setProfile(profile);
		result.setTabactive(activeTab);
		result.setMenuactive(mainMenu);
		return result;
	}
	
	
	@Override
	public Object[] getNewReqSetup(MCompany mCompany, MUserprofile mUserprofile) {
		KeyHolder tenantIdKey = new GeneratedKeyHolder();
		KeyHolder userIdKey = new GeneratedKeyHolder();
		KeyHolder companyIdKey = new GeneratedKeyHolder();
		KeyHolder userToCompanyIdKey = new GeneratedKeyHolder();
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
			temp.setString(10, mUserprofile.getCity());
			return temp;
		}, userIdKey);
		
		jdbcTemplate.update(connection -> {
			PreparedStatement temp = connection.prepareStatement(AppConfig.saveMUserToCompany, new String[] {"utcid"});
			temp.setInt(1, userIdKey.getKey().intValue());
			temp.setInt(2, tenantIdKey.getKey().intValue());
			temp.setInt(3, tenantIdKey.getKey().intValue());
			return temp;
		}, userToCompanyIdKey);
		
		Object[] result = new Object[] { new Integer(tenantIdKey.getKey().intValue()), 
				new Integer(companyIdKey.getKey().intValue()), 
				new Integer(userIdKey.getKey().intValue())};
		return result;
	}
	
	@Override
	public Iterable<MModule> getMenuAppWorkStructure() {
		List<MModule> tabMenus = new ArrayList<MModule>();
		List<Map<String, Object>> temp = (ArrayList<Map<String,Object>>)(jdbcTemplate.queryForList(AppConfig.selectTabWorkStructure));
//		tabMenus.addAll((Collection<? extends MModule>) temp);
		for(Map<String,Object> row:temp){
//			tabMenus.add((MModule) i.values());
			MModule module = new MModule();
			module.setModid(Integer.parseInt(row.get("modid").toString()));
			module.setModname((String)row.get("modname"));
			module.setModtype(Integer.parseInt(row.get("modtype").toString()));
			module.setModtitle((String)row.get("modtitle"));
			module.setModroute((String)row.get("modroute"));
			module.setModrealpath((String)row.get("modrealpath"));
			module.setModicon((String)row.get("modicon"));
			module.setCreatedBy((String)row.get("created_by"));
			module.setCreatedDate((Date)row.get("created_date"));
			module.setUpdatedBy((String)row.get("updated_by"));
			module.setUpdatedDate((Date)row.get("updated_date"));
			tabMenus.add(module);
			
	    }
		return tabMenus;
	}
	
	@Override
	public Iterable<MModule> getMenuAppEmployee() {
		List<MModule> tabMenus = new ArrayList<MModule>();
		List<Map<String, Object>> temp = (ArrayList<Map<String,Object>>)(jdbcTemplate.queryForList(AppConfig.selectTabEmployee));
//		tabMenus.addAll((Collection<? extends MModule>) temp);
		for(Map<String,Object> row:temp){
//			tabMenus.add((MModule) i.values());
			MModule module = new MModule();
			module.setModid(Integer.parseInt(row.get("modid").toString()));
			module.setModname((String)row.get("modname"));
			module.setModtype(Integer.parseInt(row.get("modtype").toString()));
			module.setModtitle((String)row.get("modtitle"));
			module.setModroute((String)row.get("modroute"));
			module.setModrealpath((String)row.get("modrealpath"));
			module.setModicon((String)row.get("modicon"));
			module.setCreatedBy((String)row.get("created_by"));
			module.setCreatedDate((Date)row.get("created_date"));
			module.setUpdatedBy((String)row.get("updated_by"));
			module.setUpdatedDate((Date)row.get("updated_date"));
			tabMenus.add(module);
	    }
		return tabMenus;
	}
	
	@Override
	public Iterable<MModule> getMenuAppPayroll() {
		List<MModule> tabMenus = new ArrayList<MModule>();
		List<Map<String, Object>> temp = (ArrayList<Map<String,Object>>)(jdbcTemplate.queryForList(AppConfig.selectTabPayroll));
//		tabMenus.addAll((Collection<? extends MModule>) temp);
		for(Map<String,Object> i:temp){
//			tabMenus.add((MModule) i.values());
	    }
		return tabMenus;
	}

	@Override
	public Iterable<MModule> getListModulesByAppid(Integer appid) {
		List<MModule> tabMenus = new ArrayList<MModule>();
		Object[] parameter = new Object[] { new Integer (appid)} ;
		List<Map<String, Object>> rows = (ArrayList<Map<String,Object>>)(jdbcTemplate.queryForList(AppConfig.retrieveMenuByAppid, parameter));
		if(rows.size() > 0) {
			for (Map<String, Object> row : rows) {
				MModule temp = new MModule();
				temp.setModid(Integer.parseInt(row.get("modid").toString()));
				temp.setModname((String)row.get("modname"));
				temp.setModtitle((String)row.get("modtitle"));
				temp.setModtype(Integer.parseInt(row.get("modtype").toString()));
				temp.setModroute((String)row.get("modroute"));
				temp.setModrealpath((String)row.get("modrealpath"));
				tabMenus.add(temp);
			}
		}
		return tabMenus;
	}

	@Override
	public String emailAuth(String email) {
		Object [] parameter = new Object [] {new String (email)};
		String newPassword = "123456$#@$^@1ERF";
		MUserprofile mUserprofile = new MUserprofile();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(AppConfig.emailAuth, parameter);
		if (rows.size() > 0) {
			for (Map<String, Object> row : rows) {
				mUserprofile.setUserid(Integer.parseInt(row.get("userid").toString()));
				mUserprofile.setUsername((String)row.get("username"));
				mUserprofile.setFullname((String)row.get("fullname"));
				mUserprofile.setActive(Integer.parseInt(row.get("active").toString()));
				mUserprofile.setSecretpwd((String)row.get("secretpwd"));
				mUserprofile.setAvatarname((String)row.get("avatarname"));
				mUserprofile.setEmail((String)row.get("email"));
				mUserprofile.setAddress((String)row.get("address"));
				mUserprofile.setAlias((String)row.get("alias"));
				mUserprofile.setPhone((String)row.get("phone"));
				mUserprofile.setMobile((String)row.get("mobile"));
				mUserprofile.setFax((String)row.get("fax"));
				mUserprofile.setCity((String)row.get("city"));
				mUserprofile.setTenantid(Integer.parseInt(row.get("tenantid").toString()));
				mUserprofile.setEmployeecode((String)row.get("employeecode"));
				mUserprofile.setCreatedBy((String)row.get("created_by"));
				mUserprofile.setCreatedDate((Date)row.get("created_date"));
				mUserprofile.setUpdatedBy((String)row.get("updated_by"));
				mUserprofile.setUpdatedDate((Date)row.get("updated_date"));
			}
			if(mUserprofile.getEmail() != null && mUserprofile.getEmail().equals(email)) {
				jdbcTemplate.update(connection -> {
					PreparedStatement temp = connection.prepareStatement(AppConfig.resetPassword);
					temp.setString(1, newPassword);
					temp.setString(2, email);
					return temp;
				});
				return newPassword;
			}
			else {
				return null;
			}
		}
		return null;
	}

	@Override
	public boolean changePassword(MUserprofileCustom1 mUserprofileCst1) {
		MUserprofile mUserprofile = new MUserprofile();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(AppConfig.checkPassword, mUserprofileCst1.getUserId(), mUserprofileCst1.getSecretpwd());
		if (rows.size() > 0) {
			for (Map<String, Object> row : rows) {
				mUserprofile.setUserid(Integer.parseInt(row.get("userid").toString()));
				mUserprofile.setUsername((String)row.get("username"));
				mUserprofile.setFullname((String)row.get("fullname"));
				mUserprofile.setActive(Integer.parseInt(row.get("active").toString()));
				mUserprofile.setSecretpwd((String)row.get("secretpwd"));
				mUserprofile.setAvatarname((String)row.get("avatarname"));
				mUserprofile.setEmail((String)row.get("email"));
				mUserprofile.setAddress((String)row.get("address"));
				mUserprofile.setAlias((String)row.get("alias"));
				mUserprofile.setPhone((String)row.get("phone"));
				mUserprofile.setMobile((String)row.get("mobile"));
				mUserprofile.setFax((String)row.get("fax"));
				mUserprofile.setCity((String)row.get("city"));
				mUserprofile.setTenantid(Integer.parseInt(row.get("tenantid").toString()));
				mUserprofile.setEmployeecode((String)row.get("employeecode"));
				mUserprofile.setCreatedBy((String)row.get("created_by"));
				mUserprofile.setCreatedDate((Date)row.get("created_date"));
				mUserprofile.setUpdatedBy((String)row.get("updated_by"));
				mUserprofile.setUpdatedDate((Date)row.get("updated_date"));
			}
			if(mUserprofile.getUserid() != null && mUserprofile.getUserid().equals(mUserprofileCst1.getUserId())) {
				jdbcTemplate.update(connection -> {
					PreparedStatement temp = connection.prepareStatement(AppConfig.changePassword);
					temp.setString(1, mUserprofileCst1.getNewPassword());
					temp.setInt(2, mUserprofile.getUserid());
					return temp;
				});
				return true;
			}
			else {

			}
			
		}
		return false;
	}
	
}
