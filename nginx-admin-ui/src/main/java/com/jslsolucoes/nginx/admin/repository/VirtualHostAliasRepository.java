package com.jslsolucoes.nginx.admin.repository;

import java.util.List;

import com.jslsolucoes.nginx.admin.model.Nginx;
import com.jslsolucoes.nginx.admin.model.VirtualHost;
import com.jslsolucoes.nginx.admin.model.VirtualHostAlias;

public interface VirtualHostAliasRepository {

	public void recreate(VirtualHost virtualHost, List<VirtualHostAlias> aliases);

	public void deleteAllFor(VirtualHost virtualHost);

	public List<VirtualHostAlias> listAll(VirtualHost virtualHost);

	public List<VirtualHostAlias> listAllFor(Nginx nginx);

	public VirtualHostAlias load(VirtualHostAlias virtualHostAlias);

}
