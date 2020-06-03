<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/asset_categories_navigation/init.jsp" %>

<%
AssetCategoriesNavigationDisplayContext assetCategoriesNavigationDisplayContext = new AssetCategoriesNavigationDisplayContext(request, renderResponse);

if (assetCategoriesNavigationDisplayContext.hidePortletWhenEmpty() && !assetCategoriesNavigationDisplayContext.hasCategories()) {
	renderRequest.setAttribute(WebKeys.PORTLET_CONFIGURATOR_VISIBILITY, Boolean.TRUE);
%>

	<div class="alert alert-info">
		<liferay-ui:message key="there-are-no-categories" />
	</div>

<%
}
%>

<div class="categories-tree container-fluid-1280" id="<%= assetCategoriesNavigationDisplayContext.getNamespace() %>categoriesContainer">
	<react:component
		data="<%= assetCategoriesNavigationDisplayContext.getData() %>"
		module="asset_categories_navigation/js/AssetCategoriesNavigationTreeView"
	/>
</div>

<%
if (assetCategoriesNavigationDisplayContext.getCategoryId() > 0) {
	AssetCategoryUtil.addPortletBreadcrumbEntries(assetCategoriesNavigationDisplayContext.getCategoryId(), request, renderResponse.createRenderURL(), false);
}
%>