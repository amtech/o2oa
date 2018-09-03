package com.x.attendance.assemble.control.jaxrs.attendancestatistic.exception;

import com.x.base.core.project.exception.PromptException;

public class ExceptionTopUnitNameEmpty extends PromptException {

	private static final long serialVersionUID = 1859164370743532895L;

	public ExceptionTopUnitNameEmpty() {
		super("系统未获取到查询参数顶层组织名称name，无法进行数据查询");
	}
}
