package com.x.processplatform.assemble.surface.jaxrs.data;

import org.apache.commons.lang3.BooleanUtils;

import com.google.gson.JsonElement;
import com.x.base.core.container.EntityManagerContainer;
import com.x.base.core.container.factory.EntityManagerContainerFactory;
import com.x.base.core.project.exception.ExceptionEntityNotExist;
import com.x.base.core.project.http.ActionResult;
import com.x.base.core.project.http.EffectivePerson;
import com.x.base.core.project.jaxrs.WoId;
import com.x.processplatform.assemble.surface.Business;
import com.x.processplatform.assemble.surface.WorkControl;
import com.x.processplatform.core.entity.content.Work;

class ActionUpdateWithWork extends BaseAction {

	ActionResult<Wo> execute(EffectivePerson effectivePerson, String id, JsonElement jsonElement) throws Exception {
		try (EntityManagerContainer emc = EntityManagerContainerFactory.instance().create()) {
			/** 防止提交空数据清空data */
			if (jsonElement.isJsonNull()) {
				throw new ExceptionNullData();
			}
			if (jsonElement.isJsonArray()) {
				throw new ExceptionArrayData();
			}
			if (jsonElement.isJsonPrimitive()) {
				throw new ExceptionPrimitiveData();
			}
			if (jsonElement.isJsonObject() && jsonElement.getAsJsonObject().entrySet().isEmpty()) {
				throw new ExceptionEmptyData();
			}
			ActionResult<Wo> result = new ActionResult<>();
			Business business = new Business(emc);
			Work work = emc.find(id, Work.class);
			if (null == work) {
				throw new ExceptionEntityNotExist(id, Work.class);
			}
			WoControl control = business.getControl(effectivePerson, work, WoControl.class);
			if (BooleanUtils.isNotTrue(control.getAllowSave())) {
				throw new ExceptionWorkAccessDenied(effectivePerson.getDistinguishedName(), work.getTitle(),
						work.getId());
			}
			/** 先更新title和serial,再更新DataItem,因为旧的DataItem中也有title和serial数据. */
			this.updateTitleSerial(business, work, jsonElement);
			this.updateData(business, work, jsonElement);
			/** 在方法内进行了commit不需要再次进行commit */
			// emc.commit();
			Wo wo = new Wo();
			wo.setId(work.getId());
			result.setData(wo);
			return result;
		}
	}

	public static class Wo extends WoId {

	}

	public static class WoControl extends WorkControl {
	}
}
