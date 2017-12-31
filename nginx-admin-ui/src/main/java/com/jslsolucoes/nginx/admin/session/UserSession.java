/*******************************************************************************
 * Copyright 2016 JSL Solucoes LTDA - https://jslsolucoes.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.jslsolucoes.nginx.admin.session;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.jslsolucoes.nginx.admin.model.User;
import com.jslsolucoes.vraptor4.auth.model.AuthFunctionality;
import com.jslsolucoes.vraptor4.auth.model.AuthUser;
import com.jslsolucoes.vraptor4.auth.model.AuthUserSession;

@SuppressWarnings("serial")
@SessionScoped
@Named
public class UserSession implements Serializable,AuthUserSession {

	private User user;

	public void logout() {
		this.user = null;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public List<AuthFunctionality> authFunctionalities() {
		return null;
	}

	@Override
	public AuthUser user() {
		return user;
	}
}
