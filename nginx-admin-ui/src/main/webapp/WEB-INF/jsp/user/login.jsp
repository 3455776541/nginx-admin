<%@include file="../app/taglibs.jsp"%>
<html:view title="{title}">
	<html:container>

		<html:block>
			<html:div>
				<html:img url="/image/logo.png" width="150" height="150"
					shape="circle" alt="logo" cssClass="center-block"></html:img>
			</html:div>
			<html:div cssClass="text-center">
				<html:h1>
					<html:small>
						<fmt:message key="title"></fmt:message> - <html:span name="version"></html:span>
					</html:small>
				</html:h1>
			</html:div>
		</html:block> 

		<html:block>
			<html:form action="/user/authenticate" label="{authentication}">
				<html:formGroup>
					<html:alert state="warning"
						rendered="${ passwordRecovery }">
						<fmt:message key="password.recovered">
							<fmt:param value="${ passwordRecoveryForEmailAddress }"></fmt:param>
						</fmt:message>
					</html:alert>
				</html:formGroup>
				
				<html:formGroup>
					<html:alert state="danger"
						rendered="${ authenticationFailed }"
						label="{authentication.failed}">
					</html:alert>
				</html:formGroup>
				<html:formGroup label="{identification}" required="true">
					<html:input name="identification" required="true"
						placeholder="{identification.placeholder}"></html:input>
				</html:formGroup>
				<html:formGroup label="{password}" required="true">
					<html:input name="password" type="password" required="true"
						placeholder="{password.placeholder}"></html:input>
				</html:formGroup>
				<html:toolbar>
					<html:button type="submit" label="{authenticate}" state="primary"></html:button>
				</html:toolbar>
			</html:form>
		</html:block>


		<html:block align="center">
			<html:link url="/user/resetPassword" label="{forgot.password}"></html:link>
		</html:block>

	</html:container>
	
	<ajax:function url="/version" name="version" executeOnDocumentLoad="true">
		<ajax:onSuccess>
			<ajax:target type="html" data="version" target="version"></ajax:target>
		</ajax:onSuccess>
	</ajax:function>

</html:view>