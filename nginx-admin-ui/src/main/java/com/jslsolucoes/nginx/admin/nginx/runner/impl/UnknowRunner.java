/*******************************************************************************
 * Copyright 2016 JSL Solucoes LTDA - https://jslsolucoes.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.jslsolucoes.nginx.admin.nginx.runner.impl;

import com.jslsolucoes.nginx.admin.model.Nginx;
import com.jslsolucoes.nginx.admin.nginx.runner.Runner;
import com.jslsolucoes.nginx.admin.nginx.runner.RunnerType;
import com.jslsolucoes.nginx.admin.os.OperationalSystemType;
import com.jslsolucoes.runtime.RuntimeResult;
import com.jslsolucoes.runtime.RuntimeResultType;
import com.jslsolucoes.vaptor4.misc.i18n.Messages;

@RunnerType(OperationalSystemType.UNKNOW)
public class UnknowRunner implements Runner {

	private static final RuntimeResult RUNTIME_RESULT = new RuntimeResult(RuntimeResultType.ERROR,
			Messages.getString("machine.runner.not.found"));

	@Override
	public RuntimeResult start() {
		return RUNTIME_RESULT;
	}

	@Override
	public RuntimeResult stop() {
		return RUNTIME_RESULT;
	}

	@Override
	public RuntimeResult restart() {
		return RUNTIME_RESULT;
	}

	@Override
	public RuntimeResult status() {
		return RUNTIME_RESULT;
	}

	@Override
	public Runner configure(Nginx nginx) {
		return this;
	}

	@Override
	public RuntimeResult testConfig() {
		return RUNTIME_RESULT;
	}

	@Override
	public RuntimeResult version() {
		return RUNTIME_RESULT;
	}

	@Override
	public RuntimeResult reload() {
		return RUNTIME_RESULT;
	}
}
