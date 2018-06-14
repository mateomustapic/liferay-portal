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

<%@ include file="/render/init.jsp" %>

<%
CPContentHelper cpContentHelper = (CPContentHelper)request.getAttribute(CPContentWebKeys.CP_CONTENT_HELPER);

CPCatalogEntry cpCatalogEntry = cpContentHelper.getCPCatalogEntry(request);
CPInstance cpInstance = cpContentHelper.getDefaultCPInstance(request);

long cpDefinitionId = cpCatalogEntry.getCPDefinitionId();
%>

<div class="container-fluid product-detail" id="<portlet:namespace /><%= cpCatalogEntry.getCPDefinitionId() %>ProductContent">
	<div class="product-detail-header">
		<h2 class="commerce-title"><%= cpCatalogEntry.getName() %></h2>

		<div class="autofit-float autofit-row product-detail-secondary-info">
			<div class="autofit-col">
				<div class="commerce-sku">
					<span class='<%= (cpInstance == null) ? "hide" : StringPool.BLANK %>' data-text-cp-instance-sku-show><%= LanguageUtil.format(request, "sku-x", StringPool.BLANK) %></span>

					<span data-text-cp-instance-sku><%= (cpInstance == null) ? StringPool.BLANK : cpInstance.getSku() %></span>
				</div>
			</div>

			<div class="autofit-col">
				<div class="commerce-manufacturer-part-number">
					<span class='<%= (cpInstance == null) ? "hide" : StringPool.BLANK %>' data-text-cp-instance-manufacturer-part-number-show><%= LanguageUtil.format(request, "manufacturer-part-number-x", StringPool.BLANK) %></span>

					<span data-text-cp-instance-manufacturer-part-number><%= (cpInstance == null) ? StringPool.BLANK : cpInstance.getManufacturerPartNumber() %></span>
				</div>
			</div>

			<div class="autofit-col">
				<div class="commerce-gtin">
					<span class='<%= (cpInstance == null) ? "hide" : StringPool.BLANK %>' data-text-cp-instance-gtin-show><%= LanguageUtil.format(request, "gtin-x", StringPool.BLANK) %></span>

					<span data-text-cp-instance-gtin><%= (cpInstance == null) ? StringPool.BLANK : cpInstance.getGtin() %></span>
				</div>
			</div>
		</div>
	</div>

	<div class="product-detail-body">
		<div class="product-detail-image-widget-column">
			<div class="product-detail-image-widget">
				<div class="product-detail-thumbnail-column">

					<%
					List<CPAttachmentFileEntry> cpAttachmentFileEntries = cpContentHelper.getImages(cpDefinitionId);

					String[] imageOverflowUrls = new String[cpAttachmentFileEntries.size()];

					for (int i = 0; i < cpAttachmentFileEntries.size(); i++) {
						CPAttachmentFileEntry cpAttachmentFileEntry = cpAttachmentFileEntries.get(i);

						String url = cpContentHelper.getImageURL(cpAttachmentFileEntry.getFileEntry(), themeDisplay);

						imageOverflowUrls = ArrayUtil.append(imageOverflowUrls, url);
					%>

						<c:choose>
							<c:when test="<%= i > 2 %>">
								<c:if test="<%= i == 3 %>">
									<div class="product-detail-thumbnail-container product-detail-thumbnail-text-container" id="<portlet:namespace />thumbs-container">
										<a class="thumb thumb-text" data-toggle="modal" href="#<portlet:namespace />ImageWidgetModal">
											+ <%= cpAttachmentFileEntries.size() - i %>
										</a>
									</div>
								</c:if>
							</c:when>
							<c:otherwise>
								<div class="product-detail-thumbnail-container" id="<portlet:namespace />thumbs-container">
									<a class="thumb thumb-image" data-standard="<%= url %>" href="<%= url %>">
										<img class="img-fluid" src="<%= url %>">
									</a>
								</div>
							</c:otherwise>
						</c:choose>

					<%
					}
					%>

				</div>

				<c:if test="<%= Validator.isNotNull(cpCatalogEntry.getDefaultImageFileUrl()) %>">
					<div class="product-detail-image-column">
						<div class="full-image product-detail-image-container">
							<div class="easyzoom easyzoom--adjacent product-detail-image">
								<a href="<%= cpCatalogEntry.getDefaultImageFileUrl() %>" tabindex="-1">
									<img class="img-fluid" id="<portlet:namespace />full-image" src="<%= cpCatalogEntry.getDefaultImageFileUrl() %>">
								</a>
							</div>
						</div>
					</div>
				</c:if>
			</div>

			<div class="product-detail-social-navigation">
				<ul class="nav">
					<li class="nav-item">
						<a href="#1">
							<aui:icon image="social-facebook" markupView="lexicon" />
						</a>
					</li>
					<li class="nav-item">
						<a href="#1">
							<aui:icon image="twitter" markupView="lexicon" />
						</a>
					</li>
					<li class="nav-item">
						<a href="#1">
							<aui:icon image="social-linkedin" markupView="lexicon" />
						</a>
					</li>
					<li class="nav-item">
						<a href="#1">
							<span class="icon-instagram"></span>
						</a>
					</li>
					<li class="nav-item">
						<a href="#1">
							<span class="icon-youtube-play"></span>
						</a>
					</li>
				</ul>
			</div>
		</div>

		<div class="product-detail-info">
			<div class="autofit-float autofit-row product-detail-info-header">
				<div class="autofit-col autofit-col-expand">
					<h2 class="commerce-price" data-text-cp-instance-price>
						<c:if test="<%= cpInstance != null %>">
							<liferay-commerce:price CPDefinitionId="<%= cpDefinitionId %>" CPInstanceId="<%= cpInstance.getCPInstanceId() %>" />
						</c:if>
					</h2>
				</div>

				<c:if test="<%= cpInstance != null %>">
					<div class="autofit-col autofit-col-expand">
						<div class="autofit-section">
							was
							<strong data-text-cp-instance-price>
								<liferay-commerce:price
									CPDefinitionId="<%= cpDefinitionId %>"
									CPInstanceId="<%= cpInstance.getCPInstanceId() %>"
								/>
							</strong>
						</div>
					</div>
				</c:if>

				<c:if test="<%= cpInstance != null %>">
					<div class="autofit-col autofit-col-expand">
						<div class="autofit-section">
							<strong>You save <span data-text-placeholder>0%</span></strong>
						</div>
					</div>
				</c:if>

				<c:if test="<%= cpInstance != null %>">
					<div class="autofit-col">
						<div class="autofit-section">
							<a href="#placeholder">
								more discount info
								<aui:icon image="info-circle" markupView="lexicon" />
							</a>
						</div>
					</div>
				</c:if>
			</div>

			<c:if test="<%= cpInstance != null %>">
				<liferay-commerce:tier-price
					CPInstanceId="<%= cpInstance.getCPInstanceId() %>"
					taglibQuantityInputId='<%= renderResponse.getNamespace() + cpDefinitionId + "Quantity" %>'
				/>
			</c:if>

			<div class="form-group-autofit product-detail-info-selections">
				<div class="commerce-quantity-input form-group-item">
					<liferay-commerce:quantity-input
						CPDefinitionId="<%= cpDefinitionId %>"
						useSelect="<%= false %>"
					/>
				</div>

				<div class="commerce-size-input form-group-item">
					<%= cpContentHelper.renderOptions(renderRequest, renderResponse) %>
				</div>
			</div>

			<div class="autofit-float autofit-row autofit-row-center product-detail-info-actions">
				<div class="autofit-col">
					<liferay-commerce-cart:add-to-cart
						CPDefinitionId="<%= cpDefinitionId %>"
						CPInstanceId="<%= (cpInstance == null) ? 0 : cpInstance.getCPInstanceId() %>"
						elementClasses="btn-primary text-truncate"
						productContentId='<%= renderResponse.getNamespace() + cpDefinitionId + "ProductContent" %>'
						taglibQuantityInputId='<%= renderResponse.getNamespace() + cpDefinitionId + "Quantity" %>'
					/>
				</div>

				<div class="autofit-col">
					<a href="#placeholder">Add to List +</a>
				</div>
			</div>

			<div class="autofit-float autofit-row">
				<liferay-commerce:compare-product CPDefinitionId="<%= cpDefinitionId %>" />
			</div>
		</div>

		<c:if test="<%= !ArrayUtil.isEmpty(imageOverflowUrls) %>">
			<div aria-hidden="true" aria-labelledby="" class="fade modal modal-hidden product-detail-image-widget-modal" id="<portlet:namespace />ImageWidgetModal" role="dialog" tabindex="-1">
				<div class="modal-dialog modal-full-screen" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<div class="modal-title"><%= cpCatalogEntry.getName() %></div>

							<button aria-label="Close" class="close" data-dismiss="modal" type="button">
								<aui:icon image="times" markupView="lexicon" />
							</button>
						</div>

						<div class="modal-body">
							<div class="carousel" data-interval="false" data-ride="carousel" id="carouselExampleFade">
								<div class="carousel-inner">

									<%
									for (int i = 0; i > imageOverflowUrls.length; i++) {
										String url = imageOverflowUrls[i];

										String carouselItemCssClass = "carousel-item";

										if ((imageOverflowUrls.length > 3) && url.equals(imageOverflowUrls[3])) {
											carouselItemCssClass += " active";
										}
									%>

										<div class="<%= carouselItemCssClass %>">
											<div class="carousel-item-image">
												<img alt="Product Image" class="img-fluid" src="<%= url %>">
											</div>

											<div class="carousel-index"><%= i %>/<%= imageOverflowUrls.length %></div>
										</div>

									<%
									}
									%>

									<a class="carousel-control-prev" data-slide="prev" href="#carouselExampleFade" role="button">
										<aui:icon image="angle-left" markupView="lexicon" />

										<span class="sr-only">Previous</span>
									</a>

									<a class="carousel-control-next" data-slide="next" href="#carouselExampleFade" role="button">
										<aui:icon image="angle-right" markupView="lexicon" />

										<span class="sr-only">Next</span>
									</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:if>
	</div>

	<%
	List<CPDefinitionSpecificationOptionValue> cpDefinitionSpecificationOptionValues = cpContentHelper.getCPDefinitionSpecificationOptionValues(cpDefinitionId);
	List<CPOptionCategory> cpOptionCategories = cpContentHelper.getCPOptionCategories(scopeGroupId);
	List<CPAttachmentFileEntry> cpAttachmentFileEntries = cpContentHelper.getCPAttachmentFileEntries(cpDefinitionId);
	%>

	<div class="product-detail-description">
		<ul class="nav nav-underline nav-underline-light" role="tablist">
			<li class="nav-item" role="presentation">
				<a aria-controls="<portlet:namespace />description" aria-expanded="true" class="active nav-link" data-toggle="tab" href="#<portlet:namespace />description" role="tab">
					<%= LanguageUtil.get(resourceBundle, "description") %>
				</a>
			</li>

			<c:if test="<%= cpContentHelper.hasCPDefinitionSpecificationOptionValues(cpDefinitionId) %>">
				<li class="nav-item" role="presentation">
					<a aria-controls="<portlet:namespace />specification" aria-expanded="false" class="nav-link" data-toggle="tab" href="#<portlet:namespace />specification" role="tab">
						<%= LanguageUtil.get(resourceBundle, "specifications") %>
					</a>
				</li>
			</c:if>

			<c:if test="<%= !cpAttachmentFileEntries.isEmpty() %>">
				<li class="nav-item" role="presentation">
					<a aria-controls="<portlet:namespace />attachments" aria-expanded="false" class="nav-link" data-toggle="tab" href="#<portlet:namespace />attachments" role="tab">
						<%= LanguageUtil.get(resourceBundle, "attachments") %>
					</a>
				</li>
			</c:if>
		</ul>

		<div class="tab-content">
			<div class="active fade show tab-pane" id="<portlet:namespace />description">
				<p><%= cpCatalogEntry.getDescription() %></p>
			</div>

			<c:if test="<%= cpContentHelper.hasCPDefinitionSpecificationOptionValues(cpDefinitionId) %>">
				<div class="fade tab-pane" id="<portlet:namespace />specification">
					<c:if test="<%= !cpDefinitionSpecificationOptionValues.isEmpty() %>">
						<div class="row">
							<div class="col-lg-6">
								<div class="table-responsive">
									<table class="table">

										<%
										for (CPDefinitionSpecificationOptionValue cpDefinitionSpecificationOptionValue : cpDefinitionSpecificationOptionValues) {
											CPSpecificationOption cpSpecificationOption = cpDefinitionSpecificationOptionValue.getCPSpecificationOption();
										%>

											<tr>
												<td class="table-title"><%= cpSpecificationOption.getTitle(languageId) %></td>
												<td class="table-value"><%= cpDefinitionSpecificationOptionValue.getValue(languageId) %></td>
											</tr>

										<%
										}
										%>

									</table>
								</div>
							</div>
						</div>
					</c:if>

					<%
					for (CPOptionCategory cpOptionCategory : cpOptionCategories) {
						List<CPDefinitionSpecificationOptionValue> categorizedCPDefinitionSpecificationOptionValues = cpContentHelper.getCategorizedCPDefinitionSpecificationOptionValues(cpDefinitionId, cpOptionCategory.getCPOptionCategoryId());
					%>

						<c:if test="<%= !categorizedCPDefinitionSpecificationOptionValues.isEmpty() %>">
							<div class="table-responsive">
								<table class="table table-bordered table-striped">
									<tr>
										<th><%= cpOptionCategory.getTitle(languageId) %></th>
										<th></th>
									</tr>

									<%
									for (CPDefinitionSpecificationOptionValue cpDefinitionSpecificationOptionValue : categorizedCPDefinitionSpecificationOptionValues) {
										CPSpecificationOption cpSpecificationOption = cpDefinitionSpecificationOptionValue.getCPSpecificationOption();
									%>

										<tr>
											<td class="table-title"><%= cpSpecificationOption.getTitle(languageId) %></td>
											<td class="table-value"><%= cpDefinitionSpecificationOptionValue.getValue(languageId) %></td>
										</tr>

									<%
									}
									%>

								</table>
							</div>
						</c:if>

					<%
					}
					%>

				</div>
			</c:if>

		<c:if test="<%= !cpAttachmentFileEntries.isEmpty() %>">
			<div class="fade tab-pane" id="<portlet:namespace />attachments">
				<div class="table-responsive">
					<table class="table">
						<tr>

							<%
							int attachmentsCount = 0;

							for (CPAttachmentFileEntry curCPAttachmentFileEntry : cpAttachmentFileEntries) {
								FileEntry fileEntry = curCPAttachmentFileEntry.getFileEntry();
							%>

								<td>
									<span><%= curCPAttachmentFileEntry.getTitle(themeDisplay.getLanguageId()) %></span>

									<span>
										<aui:icon cssClass="icon-monospaced" image="download" markupView="lexicon" url="<%= cpContentHelper.getDownloadFileEntryURL(fileEntry, themeDisplay) %>" />
									</span>
								</td>

								<%
								attachmentsCount = attachmentsCount + 1;

								if (attachmentsCount >= 2) {
								%>

									</tr>
									<tr>

								<%
									attachmentsCount = 0;
								}
								%>

							<%
							}
							%>

						<tr>
					</table>
				</div>
			</div>
		</c:if>
	</div>
</div>

<aui:script>
	var easyzoom = $('.easyzoom').easyZoom();
	var easyzoomApi = easyzoom.filter('.easyzoom').data('easyZoom');

	$('.product-detail-image-widget .thumb-image').on(
		'click',
		function(event) {
			var $this = $(this);

			event.preventDefault();

			easyzoomApi.swap($this.data('standard'), $this.attr('href'));
		}
	);
</aui:script>

<aui:script use="liferay-commerce-product-content">
	var productContent = new Liferay.Portlet.ProductContent(
		{
			cpDefinitionId: <%= cpDefinitionId %>,
			fullImageSelector : '#<portlet:namespace />full-image',
			namespace: '<portlet:namespace />',
			productContentSelector: '#<portlet:namespace /><%= cpDefinitionId %>ProductContent',
			thumbsContainerSelector : '#<portlet:namespace />thumbs-container',
			viewAttachmentURL: '<%= String.valueOf(cpContentHelper.getViewAttachmentURL(liferayPortletRequest, liferayPortletResponse)) %>'
		}
	);

	Liferay.component('<portlet:namespace /><%= cpDefinitionId %>ProductContent', productContent);
</aui:script>