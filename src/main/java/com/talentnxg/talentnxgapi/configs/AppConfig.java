package com.talentnxg.talentnxgapi.configs;

import org.springframework.stereotype.Component;

@Component
public class AppConfig {
	 public static final Integer CODE_SUCCESS = 1;
	 public static final String CODE_SUCCESS_MSG= "success";
	 public static final Integer CODE_SUCCESS_NODATA = -1;
	 public static final String CODE_SUCCESS_NODATAMSG= "Success No Data Found";
	 public static final Integer CODE_FAILED = 89;
	 public static final String CODE_FAILED_MSG= "Error Query";
	 
//	 ###################### AUTHENTICATION SQL ###########################
//	 public static final String selectUserProfileByLogin = "SELECT userid, username, fullname, active, secretpwd, avatarname "
//	 		+ "FROM public.userprofile;";
	 
//	 public static final String selectUserProfileByLogin = "SELECT up.userid, up.username, up.fullname, up.email, up.address, up.alias, up.mobile, "
//	 		+ "up.employeecode, up.avatarname, tn.id, tn.tenant_name, tn.tenant_code, tn.tenant_activation_code "
//	 		+ "FROM public.m_userprofile up INNER JOIN public.m_tenant tn ON up.tenantid = tn.id where up.username=? and up.secretpwd=crypt(?, secretpwd);";
	 
//	 public static final String selectUserProfileByLogin = "SELECT up.userid, up.username, up.fullname, up.email, up.address, up.alias, up.mobile, up.employeecode, \r\n" + 
//	 		"tn.id tenantid, tn.tenant_name, up.avatarname " + 
//	 		"FROM public.userprofile up INNER JOIN public.m_tenant tn ON up.tenantid = tn.id where up.username=? and up.secretpwd=crypt(?, secretpwd);";
		 
	 public static final String selectMUserProfileByLogin = "SELECT up.userid, up.username, up.fullname, up.email, up.address, up.alias, up.mobile, "
		 	+ "up.employeecode, up.avatarname, tn.id, tn.tenant_name, tn.tenant_code, tn.tenant_activation_code "
		 	+ "FROM public.m_userprofile up INNER JOIN public.m_tenant tn ON up.tenantid = tn.id where up.username=? and up.secretpwd=crypt(?, secretpwd);";

/////////////////////////////////////////////////////////////////////////////////////
//	 public static final String selectMainMenu = "SELECT appid, appname, description "
//			 + "FROM public.m_applications "
//			 + "ORDER BY appid;";
//	 
	 
	 public static final String selectMainMenu = "SELECT dp.profileid,dp.appid,ma.appname,ma.description,ma.tenantid from d_profiles dp INNER JOIN m_applications ma ON ma.appid = dp.appid where dp.rolesid in \r\n" + 
	 		"(SELECT dr.roleid FROM public.m_userprofile up Inner join d_roles dr ON dr.usersid = up.userid where up.userid=?);";
	 
	 
	 public static final String selectActiveTab = "SELECT modid, modname, modtitle, modrealpath "
			 + "FROM public.m_modules "
			 + "ORDER BY modid "
			 + "LIMIT 1;";
	 
	 public static final String selectActiveMenu = "SELECT appid, appname "
			 + "FROM public.m_applications "
			 + "ORDER BY appid "
			 + "LIMIT 1;";
	 
//	 public static final String selectTabWorkStructure = "SELECT modid, modname, modtitle, modrealpath "
//			 + "FROM public.m_modules "
//			 + "ORDER BY modid;";
	 
//	 public static final String selectTabWorkStructure = "SELECT * from m_modules where modid in (SELECT da.modid from d_profiles dp INNER JOIN d_applications da ON da.appid = dp.appid where dp.rolesid in (SELECT dr.roleid FROM public.m_userprofile up Inner join d_roles dr ON dr.usersid = up.userid where up.userid=1));";
	 
	 public static final String selectTabWorkStructure = "SELECT modid, modname, modtitle,modroute, modrealpath from m_modules where modid in (SELECT da.modid from d_profiles dp INNER JOIN d_applications da ON da.appid = dp.appid where dp.rolesid in (SELECT dr.roleid FROM public.m_userprofile up Inner join d_roles dr ON dr.usersid = up.userid where up.userid=?));";
	 
	 public static final String selectTabEmployee = "SELECT modid, modname, modtitle, modrealpath "
			 + "FROM public.m_modules "
			 + "WHERE modtype=0 "
			 + "ORDER BY modid;";
	 
	 public static final String selectTabPayroll = "SELECT modid, modname, modtitle, modrealpath "
			 + "FROM public.m_modules "
			 + "WHERE modtype=0 "
			 + "ORDER BY modid;";
	 
	 
////////////////////////////////////// MODULES ///////////////////////////////////////////////////
	 public static final String saveModule = "INSERT INTO m_modules (modname, modtype, modtitle, modroute, modrealpath, modicon, created_by) "
			 + "VALUES (?, ?, ?, ?, ?, ?, ?);";
	 
	 public static final String selectModule = "SELECT modid, modname, modtype, modtitle, modroute, modrealpath, modicon, created_by, created_date, updated_by, updated_date "
			 + "FROM m_modules;";
	 
	 public static final String findModuleById = "SELECT modid, modname, modtype, modtitle, modroute, modrealpath, modicon, created_by, created_date, updated_by, updated_date "
			 + "FROM m_modules "
			 + "WHERE modid=?;";
	 
	 public static final String updateModule = "UPDATE m_modules SET modname=?, modtype=?, modtitle=?, modroute=?, modrealpath=?, modicon=?, updated_by=?, updated_date=current_timestamp "
			 + "WHERE modid=?; ";
	
	 public static final String deleteModuleById = "DELETE FROM m_modules WHERE modid=?;";
	 
/////////////////////////////////////// M APPLICATIONS////////////////////////////////////////////
	 public static final String saveMApplication = "INSERT INTO m_applications (appname, description, created_by, tenantid) "
			 + "VALUES (?, ?, ?, ?);";
	 
	 public static final String selectMApplication = "SELECT appid, appname, description, created_by, created_date, tenantid, updated_by, updated_date "
			 + "FROM m_applications;";
	 
	 public static final String findMApplicationById = "SELECT  appid, appname, description, created_by, created_date, tenantid, updated_by, updated_date "
			 + "FROM m_applications "
			 + "WHERE appid=?;";
	 
	 public static final String updateMApplication = "UPDATE m_applications SET appname=?, description=?, tenantid=?, updated_by=?, updated_date=current_timestamp "
			 + "WHERE appid=?;";
	 
	 public static final String deleteMApplication = "DELETE FROM m_applications WHERE appid=?;"; 
	 
/////////////////////////////////////// D APPLICATIONS////////////////////////////////////////////
	 public static final String saveDApplication = "INSERT INTO d_applications (appid, modid, created_by) "
			 + "VALUES (?, ?, ?);";

	 public static final String selectDApplication = "SELECT integid, appid, modid, created_by, created_date, updated_by, updated_date "
			 + "FROM d_applications;";

	 public static final String findDApplicationById = "SELECT  integid, appid, modid, created_by, created_date, updated_by, updated_date "
			 + "FROM d_applications "
			 + "WHERE integid=?;";

	 public static final String updateDApplication = "UPDATE d_applications SET appid=?, modid=?, updated_by=?, updated_date=current_timestamp "
			 + "WHERE integid=?;";

	 public static final String deleteDApplication = "DELETE FROM d_applications WHERE integid=?;"; 
	 
/////////////////////////////////////// M PROFILES////////////////////////////////////////////
	 public static final String saveMProfile = "INSERT INTO m_profiles (profilesname, tenantid, created_by) "
			 + "VALUES (?, ?, ?);";

	 public static final String selectMProfile = "SELECT profilesid, profilesname, tenantid, created_by, created_date, updated_by, updated_date "
			 + "FROM m_profiles;";

	 public static final String findMProfileById = "SELECT  profilesid, profilesname, tenantid, created_by, created_date, updated_by, updated_date "
			 + "FROM m_profiles "
			 + "WHERE profilesid=?;";

	 public static final String updateMProfile = "UPDATE m_profiles SET profilesname=?, tenantid=?, updated_by=?, updated_date=current_timestamp "
			 + "WHERE profilesid=?;";

	 public static final String deleteMProfile = "DELETE FROM m_profiles WHERE profilesid=?;"; 
	 
/////////////////////////////////////// D PROFILES////////////////////////////////////////////
	 public static final String saveDProfile = "INSERT INTO d_profiles (appid, rolesid, profileid) "
			 + "VALUES (?, ?, ?);";

	 public static final String selectDProfile = "SELECT objid, appid, rolesid, profileid "
			 + "FROM d_profiles;";

	 public static final String findDProfileById = "SELECT  objid, appid, rolesid, profileid "
			 + "FROM d_profiles "
			 + "WHERE objid=?;";

	 public static final String updateDProfile = "UPDATE d_profiles SET appid=?, rolesid=?, profileid=? "
			 + "WHERE objid=?;";

	 public static final String deleteDProfile = "DELETE FROM d_profiles WHERE objid=?;"; 
	 	 
/////////////////////////////////////// M ROLES////////////////////////////////////////////
	 public static final String saveMRole = "INSERT INTO m_roles (rolename, tenantid, created_by, isadmin) "
			 + "VALUES (?, ?, ?, ?);";

	 public static final String selectMRole = "SELECT rolesid, rolename, tenantid, created_by, created_date, updated_by, updated_date, isadmin, roleidrpt "
			 + "FROM m_roles;";

	 public static final String findMRoleById = "SELECT  rolesid, rolename, tenantid, created_by, created_date, updated_by, updated_date, isadmin, roleidrpt "
			 + "FROM m_roles "
			 + "WHERE rolesid=?;";

	 public static final String updateMRole = "UPDATE m_roles SET rolename=?, tenantid=?, updated_by=?, updated_date=current_timestamp, isadmin=? "
			 + "WHERE rolesid=?;";

	 public static final String deleteMRole = "DELETE FROM m_roles WHERE rolesid=?;"; 

//////////////////////////////////D ROLES////////////////////////////////////////////
	 public static final String saveDRole = "INSERT INTO d_roles (roleid, usersid) "
			 + "VALUES (?, ?);";

	 public static final String selectDRole = "SELECT rmemid, roleid, usersid "
			 + "FROM d_roles;";

	 public static final String findDRoleById = "SELECT  rmemid, roleid, usersid "
			 + "FROM d_roles "
			 + "WHERE rmemid=?;";

	 public static final String updateDRole = "UPDATE d_roles SET roleid=?, usersid=? "
			 + "WHERE rmemid=?;";

	 public static final String deleteDRole = "DELETE FROM d_roles WHERE rmemid=?;"; 
	 
//////////////////////////////////////M TENANTS/////////////////////////////////////////
	 public static final String saveMTenant = "INSERT INTO m_tenant (tenant_code, tenant_activation_code, is_active, created_by, tenant_name, created_date) "
			 + "VALUES (?, ?, true, 'SYSTEM', ?, current_timestamp);";
	 
	 public static final String selectMTenant = "SELECT id, tenant_code, tenant_activation_code, is_active, created_by, created_date, updated_by, updated_date, tenant_name "
			 + "FROM m_tenant;";
	  
	 public static final String findMTenantById = "SELECT id, tenant_code, tenant_activation_code, is_active, created_by, created_date, updated_by, updated_date, tenant_name "
			 + "FROM m_tenant "
			 + "WHERE id=?;";
	 
	 public static final String updateMTenant = "UPDATE m_tenant SET tenant_code=?, tenant_activation_code=?, is_active=?, updated_by=?, updated_date=current_timestamp, tenant_name=? "
			 + "WHERE id=?;";
	 
	 public static final String deleteMTenant = "DELETE FROM m_tenant WHERE id=?;";
	 
//////////////////////////////////////M User Profile///////////////////////////////////////
	 public static final String saveMUserprofile = "INSERT INTO m_userprofile (username, fullname, active, secretpwd, avatarname, email, phone, mobile, fax, tenantid, employeecode, city, created_by, created_date) "
			 +"VALUES (?, ?, 1, crypt(?, gen_salt('bf')), 'default', ?, ?, ?, ?, ?, ?, ?, 'SYSTEM', current_timestamp); ";
	 
//////////////////////////////////////M User Profile///////////////////////////////////////
//	 public static final String saveMUserprofile = "INSERT INTO m_userprofile (username, fullname, active, secretpwd, avatarname, email, phone, mobile, fax, tenantid, employeecode, city, created_by, created_date) "
//+"VALUES (?, ?, 1, crypt(?, gen_salt('bf')), 'default', ?, ?, ?, ?, ?, ?, ?, 'SYSTEM', current_timestamp); ";
//	 
	 
	 public static final String selectMUserprofile = "SELECT userid, username, fullname, active, secretpwd, avatarname, email, address, alias, phone, mobile, fax, city, tenantid, employeecode, created_by, created_date, updated_date, updated_by "
			 + "FROM m_userprofile;";
	 
	 public static final String findMUserprofileById = "SELECT userid, username, fullname, active, secretpwd, avatarname, email, address, alias, phone, mobile, fax, city, tenantid, employeecode, created_by, created_date, updated_date, updated_by "
			 + "FROM m_userprofile "
			 + "WHERE userid=?;";
	 
	 public static final String updateMUserprofile = "UPDATE m_userprofile SET username=?, fullname=?, active=?, secretpwd=?, avatarname=?, email=?, address=?, alias=?, phone=?, mobile=?, fax=?, city=?, tenantid=?, employeecode=?, updated_date=current_timestamp, updated_by=? "
			 + "WHERE userid=?;";
	 
	 public static final String deleteMUserprofile = "DELETE FROM m_userprofile WHERE userid=?;";
	 
///////////////////////////////////////M Fieldsbookbyuser////////////////////////////////////
	 public static final String saveMFieldsbookbyuser = "INSERT INTO m_fieldsbookbyusers (modid, userprofileid, modname, listtitleselected, listfieldselected, isactive, created_by, created_date) "
			 + "VALUES (?, ?, ?, ?, ?, ?, ?, current_timestamp);";
	 
	 public static final String selectMFieldsbookbyuser = "SELECT id, modid, userprofileid, modname, listtitleselected, listfieldselected, isactive, created_by, created_date, updated_by, updated_date "
			 + "FROM m_fieldsbookbyusers;";
	 
	 public static final String findMFieldsbookbyuser = "SELECT id, modid, userprofileid, modname, listtitleselected, listfieldselected, isactive, created_by, created_date, updated_by, updated_date "
			 + "FROM m_fieldsbookbyusers "
			 + "WHERE id=?;";
	 
	 public static final String updateMFieldsbookbyuser = "UPDATE m_fieldsbookbyusers set modid=?, userprofileid=?, modname=?, listtitleselected=?, listfieldselected=?, isactive=?, updated_by=?, updated_date=current_timestamp "
			 + "WHERE id=?;";
	 
	 public static final String deleteMFieldsbookbyuser = "DELETE FROM m_fieldsbookbyusers WHERE id=?;";
	 
/////////////////////////////////////////M Company/////////////////////////////////////////////
	 public static final String saveMCompany = "INSERT INTO m_company (tenant_id, company_name, company_code, bank_account, account_name, tax_number, created_by, created_date) "
			 + "VALUES (?, ?, ?, ?, ?, ?, 1, current_timestamp);";
	public static String initialMember1;
}
