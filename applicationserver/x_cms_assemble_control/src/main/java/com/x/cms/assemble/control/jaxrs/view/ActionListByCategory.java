package com.x.cms.assemble.control.jaxrs.view;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import com.x.base.core.container.EntityManagerContainer;
import com.x.base.core.container.factory.EntityManagerContainerFactory;
import com.x.base.core.entity.JpaObject;
import com.x.base.core.project.annotation.FieldDescribe;
import com.x.base.core.project.bean.WrapCopier;
import com.x.base.core.project.bean.WrapCopierFactory;
import com.x.base.core.project.cache.ApplicationCache;
import com.x.base.core.project.http.ActionResult;
import com.x.base.core.project.http.EffectivePerson;
import com.x.base.core.project.tools.SortTools;
import com.x.cms.assemble.control.Business;
import com.x.cms.assemble.control.factory.ViewFactory;
import com.x.cms.core.entity.element.View;

import net.sf.ehcache.Element;

public class ActionListByCategory extends BaseAction {
	
	@SuppressWarnings("unchecked")
	protected ActionResult<List<Wo>> execute( HttpServletRequest request, EffectivePerson effectivePerson, String categoryId ) throws Exception {
		ActionResult<List<Wo>> result = new ActionResult<>();
		List<Wo> wraps = null;
		
		String cacheKey = ApplicationCache.concreteCacheKey( "category", categoryId );
		Element element = cache.get(cacheKey);
		
		if ((null != element) && ( null != element.getObjectValue()) ) {
			wraps = (List<Wo>) element.getObjectValue();
			result.setData( wraps );
		} else {
			try (EntityManagerContainer emc = EntityManagerContainerFactory.instance().create()) {			
				Business business = new Business(emc);			
				//如判断用户是否有查看所有视图的权限，如果没权限不允许继续操作
				if (!business.viewEditAvailable( request, effectivePerson )) {
					throw new Exception("person{name:" + effectivePerson.getDistinguishedName() + "} 用户没有查询全部视图的权限！");
				}
				//如果有权限，继续操作
				ViewFactory viewFactory  = business.getViewFactory();
				List<String> ids = viewFactory.listByCategoryId( categoryId );//获取指定应用的所有视图列表
				List<View> viewList = viewFactory.list( ids );//查询ID IN ids 的所有视图信息列表

				if( viewList != null && !viewList.isEmpty() ){
					wraps = Wo.copier.copy( viewList );//将所有查询出来的有状态的对象转换为可以输出的过滤过属性的对象
					SortTools.desc( wraps, "sequence" );
					
					for( Wo wo :  wraps ){
						//根据FormId补充FormName
						if(StringUtils.isNotEmpty( wo.getFormId() )) {
							wo.setFormName( formServiceAdv.getNameWithId( wo.getFormId() ) );
						}
					}
				}
				
				cache.put(new Element( cacheKey, wraps ));
				result.setData(wraps);
			} catch (Throwable th) {
				th.printStackTrace();
				result.error(th);
			}
		}
		
		return result;
	}
	
	public static class Wo extends View {
		
		private static final long serialVersionUID = -5076990764713538973L;
		
		public static List<String> Excludes = new ArrayList<String>();
		
		@FieldDescribe("绑定的表单名称.")
		private String formName = null;

		public static WrapCopier<View, Wo> copier = WrapCopierFactory.wo( View.class, Wo.class, null, JpaObject.FieldsInvisible);

		public String getFormName() {
			return formName;
		}

		public void setFormName(String formName) {
			this.formName = formName;
		}
	}
}