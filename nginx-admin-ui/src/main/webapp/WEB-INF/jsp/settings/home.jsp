<%@include file="../app/taglibs.jsp"%>
<html:view title="{title}">
	<html:tabPanel>
		<html:tab active="true" label="{nginx.settings}" url="/nginx/edit"></html:tab>
		<html:tab label="{app.settings}" url="/app/edit"></html:tab>
		<html:tab label="{smtp.settings}" url="/smtp/settings"></html:tab>
		<html:tab label="{password.change}" url="/user/changePassword"></html:tab>
	</html:tabPanel>
</html:view>