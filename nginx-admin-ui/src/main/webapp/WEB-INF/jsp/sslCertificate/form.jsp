<%@include file="../app/taglibs.jsp"%>
<html:view title="{title}">

	<html:block>
		<html:alert state="success" label="{ssl.update.success}"
			rendered="${ operation == 'UPDATE' }"></html:alert>
		<html:alert state="success" label="{ssl.insert.success}"
			rendered="${ operation == 'INSERT' }"></html:alert>
	</html:block>

	<html:block>
		<html:form action="/sslCertificate/saveOrUpdate" multipart="true" 
		   label="{ssl.form}" validation="/sslCertificate/validate">
			<html:input name="id" type="hidden" value="${ sslCertificate.id }"></html:input>
			<html:input name="idNginx" type="hidden" value="${ nginx.id }"></html:input>
			<html:input name="idResourceIdentifierCertificate" type="hidden"
				value="${ virtualHost.resourceIdentifierCertificate.id }"></html:input>
			<html:input name="idResourceIdentifierCertificatePrivateKey" type="hidden"
				value="${ virtualHost.resourceIdentifierCertificatePrivateKey.id }"></html:input>

			<html:formGroup label="{ssl.common.name}" required="true">
				<html:input name="commonName" value="${ sslCertificate.commonName }"
					placeholder="{ssl.common.name.placeholder}" required="true"></html:input>
			</html:formGroup>
			<html:formGroup label="{ssl.certificate}"
				required="${ sslCertificate == null }">
				<html:div>
					<html:link rendered="${ sslCertificate != null }" target="_blank"
						url="/sslCertificate/download/${ sslCertificate.resourceIdentifierCertificate.hash }"
						label="{ssl.certificate.download}"></html:link>
				</html:div>
				<html:input name="certificateFile"
					required="${ sslCertificate == null }" type="file"
					accept=".cer|.der|.crt"></html:input>
			</html:formGroup>
			<html:formGroup label="{ssl.certificate.key}"
				required="${ sslCertificate == null }">
				<html:div rendered="${ sslCertificate != null }" >
					<html:link target="_blank"
						url="/sslCertificate/download/${ sslCertificate.resourceIdentifierCertificatePrivateKey.hash }"
						label="{ssl.certificate.key.download}"></html:link>
				</html:div>
				<html:input name="certificatePrivateKeyFile"
					required="${ sslCertificate == null }" type="file"></html:input>
			</html:formGroup>
		</html:form>
	</html:block>

	<html:block align="center">
		<html:link url="/sslCertificate/list/${ nginx.id }" label="{back}"></html:link>
	</html:block>
</html:view>