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
package com.jslsolucoes.nginx.admin.nginx.parser.directive;

import java.util.List;

public class ServerDirective implements Directive {

	private Integer port;
	private List<String> aliases;
	private String sslCertificate;
	private String sslCertificateKey;
	private List<LocationDirective> locations;

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public List<String> getAliases() {
		return aliases;
	}

	public void setAliases(List<String> aliases) {
		this.aliases = aliases;
	}

	public String getSslCertificate() {
		return sslCertificate;
	}

	public void setSslCertificate(String sslCertificate) {
		this.sslCertificate = sslCertificate;
	}

	public String getSslCertificateKey() {
		return sslCertificateKey;
	}

	public void setSslCertificateKey(String sslCertificateKey) {
		this.sslCertificateKey = sslCertificateKey;
	}

	public List<LocationDirective> getLocations() {
		return locations;
	}

	public void setLocations(List<LocationDirective> locations) {
		this.locations = locations;
	}

	@Override
	public DirectiveType type() {
		return DirectiveType.SERVER;
	}

}
