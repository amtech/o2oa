package com.x.cms.assemble.control.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.x.base.core.container.EntityManagerContainer;
import com.x.base.core.container.factory.EntityManagerContainerFactory;
import com.x.base.core.entity.annotation.CheckPersistType;
import com.x.base.core.project.tools.ListTools;
import com.x.cms.assemble.control.jaxrs.permission.element.PermissionInfo;
import com.x.cms.assemble.control.jaxrs.permission.element.PermissionName;
import com.x.cms.core.entity.Document;

public class PermissionOperateService {

	/**
	 * 根据文档ID，为文档设置用户访问和管理权限
	 * @param document
	 * @param readerList
	 * @param authorList
	 * @throws Exception
	 */
	public void refreshDocumentPermission( String docId, List<PermissionInfo> readerList, List<PermissionInfo> authorList ) throws Exception {
		List<PermissionInfo> permissionList = composeDocmentAllPermissions(readerList, authorList);
		try {
			//将读者以及作者信息持久化到数据库中
			refreshDocumentPermission( docId, permissionList );
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 *根据读者和作者组织所有的权限对象列表
	 * @param readerList
	 * @param authorList
	 * @throws Exception
	 */
	public List<PermissionInfo> composeDocmentAllPermissions( List<PermissionInfo> readerList, List<PermissionInfo> authorList ) throws Exception {
		List<PermissionInfo> permissionList = new ArrayList<>();
		
		//添加读者信息，如果没有限定读者，那么所有可访问分类的用户可读
		if ( ListTools.isEmpty( readerList ) ) {
			permissionList.add( new PermissionInfo( PermissionName.READER, "所有人", "所有人", "所有人" ) );
		} else {
			for( PermissionInfo p : readerList ) {
				permissionList.add( new PermissionInfo( PermissionName.READER, p.getPermissionObjectType(), p.getPermissionObjectName(), p.getPermissionObjectName() ));
			}
		}
		
		//将所有的作者都添加到阅读者里去
		if ( authorList != null && !authorList.isEmpty() ) {
			for( PermissionInfo p : authorList ) {
				permissionList.add( new PermissionInfo( PermissionName.READER, p.getPermissionObjectType(), p.getPermissionObjectName(), p.getPermissionObjectName() ));
				//添加作者信息，作者可以对文档进行编辑
				permissionList.add( new PermissionInfo( PermissionName.AUTHOR, p.getPermissionObjectType(), p.getPermissionObjectName(), p.getPermissionObjectName() ));
			}
		}
		
		return permissionList;
	}
	
	/**
	 * 根据文档ID，为文档设置用户访问和管理权限
	 * @param docmentId
	 * @param permissionList
	 * @throws Exception 
	 */
	public void refreshDocumentPermission( String docId, List<PermissionInfo> permissionList ) throws Exception {
		if( StringUtils.isEmpty(docId) ){
			throw new Exception( "docId is empty！" );
		}
		try ( EntityManagerContainer emc = EntityManagerContainerFactory.instance().create() ) {
			emc.beginTransaction( Document.class );
			Document document = emc.find( docId, Document.class );
			
			if( document != null ) {
				//清空文档权限信息
				document.setManagerList( null );
				document.setReadPersonList( null );
				document.setReadUnitList( null );
				document.setReadGroupList( null );
				document.setAuthorPersonList( null );
				document.setAuthorUnitList( null );
				document.setAuthorGroupList( null );
				
				if( ListTools.isNotEmpty( permissionList ) ){
					for( PermissionInfo permission : permissionList ){
						if( "管理".equals( permission.getPermission() )) {
							document.addManagerList(permission.getPermissionObjectCode());
						}else if( "读者".equals( permission.getPermission() ) || "阅读".equals( permission.getPermission() )) {
							if( "人员".equals( permission.getPermissionObjectType() )) {
								document.addReadPersonList(permission.getPermissionObjectCode());
							}else if( "部门".equals(  permission.getPermissionObjectType() ) || "组织".equals( permission.getPermissionObjectType() )) {
								document.addReadUnitList(permission.getPermissionObjectCode());
							}else if( "群组".equals( permission.getPermissionObjectType() )) {
								document.addReadGroupList(permission.getPermissionObjectCode());
							}else if( "所有人".equals( permission.getPermissionObjectCode() )) {
								document.addReadPersonList("所有人");
							}
						}else if( "作者".equals( permission.getPermission() )) {
							if( "人员".equals( permission.getPermissionObjectType() )) {
								document.addAuthorPersonList(permission.getPermissionObjectCode());
							}else if( "部门".equals(  permission.getPermissionObjectType() ) || "组织".equals( permission.getPermissionObjectType() )) {
								document.addAuthorUnitList(permission.getPermissionObjectCode());
							}else if( "群组".equals( permission.getPermissionObjectType() )) {
								document.addAuthorGroupList(permission.getPermissionObjectCode());
							}else if( "所有人".equals( permission.getPermissionObjectCode() )) {
								document.addAuthorPersonList("所有人");
							}
						}
					}
				}
				
				if( ListTools.isEmpty( document.getReadPersonList() ) && ListTools.isEmpty( document.getReadUnitList() ) 
						&& ListTools.isEmpty( document.getReadGroupList() )) {
					//可读范围都为空，则是所有人可访问
					document.addReadPersonList("所有人");
					document.addReadPersonList(document.getCreatorPerson());
				}
				if( ListTools.isEmpty( document.getAuthorPersonList() ) && ListTools.isEmpty( document.getAuthorUnitList() ) 
						&& ListTools.isEmpty( document.getAuthorGroupList() )) {
					//编辑全部都为空，则是创建人可编辑
					document.addAuthorPersonList( document.getCreatorPerson() );
					document.addAuthorPersonList( document.getCreatorPerson() );
				}
				if( ListTools.isEmpty( document.getManagerList() ) ) {
					//管理全部都为空，则是创建人可以管理
					document.addManagerList( document.getCreatorPerson() );
					document.addManagerList( document.getCreatorPerson() );
				}
		
				emc.check( document , CheckPersistType.all );
				emc.commit();
			}
		} catch ( Exception e ) {
			throw e;
		}
	}
	
}
