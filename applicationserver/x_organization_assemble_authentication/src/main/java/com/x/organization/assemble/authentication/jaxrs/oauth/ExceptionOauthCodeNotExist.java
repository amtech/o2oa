package com.x.organization.assemble.authentication.jaxrs.oauth;

import com.x.base.core.project.exception.PromptException;

class ExceptionOauthCodeNotExist extends PromptException {

	private static final long serialVersionUID = 4132300948670472899L;

	ExceptionOauthCodeNotExist(String id) {
		super("oauthCode:{} not exist.", id);
	}
}
