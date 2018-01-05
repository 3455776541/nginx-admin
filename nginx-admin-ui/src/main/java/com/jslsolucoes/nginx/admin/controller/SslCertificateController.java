package com.jslsolucoes.nginx.admin.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.inject.Inject;

import com.jslsolucoes.nginx.admin.model.ResourceIdentifier;
import com.jslsolucoes.nginx.admin.model.SslCertificate;
import com.jslsolucoes.nginx.admin.repository.SslCertificateRepository;
import com.jslsolucoes.nginx.admin.repository.impl.OperationResult;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.observer.download.Download;
import br.com.caelum.vraptor.observer.download.InputStreamDownload;
import br.com.caelum.vraptor.observer.upload.UploadedFile;

@Controller
@Path("sslCertificate")
public class SslCertificateController {

	private Result result;
	private SslCertificateRepository sslCertificateRepository;

	public SslCertificateController() {
		this(null, null);
	}

	@Inject
	public SslCertificateController(Result result, SslCertificateRepository sslCertificateRepository) {
		this.result = result;
		this.sslCertificateRepository = sslCertificateRepository;
	}

	public void list() {
		this.result.include("sslCertificateList", sslCertificateRepository.listAll());
	}

	public void form() {
		// form logic
	}

	@Path("download/{hash}")
	public Download download(String hash) throws IOException {
		InputStream inputStream = sslCertificateRepository.download(hash);
		return new InputStreamDownload(inputStream, "application/octet-stream", hash, true, inputStream.available());
	}

	@Path("edit/{id}")
	public void edit(Long id) {
		this.result.include("sslCertificate", sslCertificateRepository.load(new SslCertificate(id)));
		this.result.forwardTo(this).form();
	}

	@Path("delete/{id}")
	public void delete(Long id) throws IOException {
		this.result.include("operation", sslCertificateRepository.deleteWithResource(new SslCertificate(id)));
		this.result.redirectTo(this).list();
	}

	@Post
	public void saveOrUpdate(Long id, String commonName, Long idResourceIdentifierCertificate,
			Long idResourceIdentifierCertificatePrivateKey, UploadedFile certificateFile,
			UploadedFile certificatePrivateKeyFile) throws IOException {
		OperationResult operationResult = sslCertificateRepository.saveOrUpdate(
				new SslCertificate(id, commonName, new ResourceIdentifier(idResourceIdentifierCertificate),
						new ResourceIdentifier(idResourceIdentifierCertificatePrivateKey)),
				certificateFile != null ? certificateFile.getFile() : null,
				certificatePrivateKeyFile != null ? certificatePrivateKeyFile.getFile() : null);
		this.result.include("operation", operationResult.getOperationType());
		this.result.redirectTo(this).edit(operationResult.getId());
	}
}
