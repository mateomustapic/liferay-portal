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

package com.liferay.layout.page.template.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.AttachedModel;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;

/**
 * The base model interface for the LayoutPageTemplateStructure service. Represents a row in the &quot;LayoutPageTemplateStructure&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.layout.page.template.model.impl.LayoutPageTemplateStructureModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.layout.page.template.model.impl.LayoutPageTemplateStructureImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LayoutPageTemplateStructure
 * @generated
 */
@ProviderType
public interface LayoutPageTemplateStructureModel
	extends AttachedModel, BaseModel<LayoutPageTemplateStructure>, GroupedModel,
			ShardedModel, StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a layout page template structure model instance should use the {@link LayoutPageTemplateStructure} interface instead.
	 */

	/**
	 * Returns the primary key of this layout page template structure.
	 *
	 * @return the primary key of this layout page template structure
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this layout page template structure.
	 *
	 * @param primaryKey the primary key of this layout page template structure
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this layout page template structure.
	 *
	 * @return the uuid of this layout page template structure
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this layout page template structure.
	 *
	 * @param uuid the uuid of this layout page template structure
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the layout page template structure ID of this layout page template structure.
	 *
	 * @return the layout page template structure ID of this layout page template structure
	 */
	public long getLayoutPageTemplateStructureId();

	/**
	 * Sets the layout page template structure ID of this layout page template structure.
	 *
	 * @param layoutPageTemplateStructureId the layout page template structure ID of this layout page template structure
	 */
	public void setLayoutPageTemplateStructureId(
		long layoutPageTemplateStructureId);

	/**
	 * Returns the group ID of this layout page template structure.
	 *
	 * @return the group ID of this layout page template structure
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this layout page template structure.
	 *
	 * @param groupId the group ID of this layout page template structure
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this layout page template structure.
	 *
	 * @return the company ID of this layout page template structure
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this layout page template structure.
	 *
	 * @param companyId the company ID of this layout page template structure
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this layout page template structure.
	 *
	 * @return the user ID of this layout page template structure
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this layout page template structure.
	 *
	 * @param userId the user ID of this layout page template structure
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this layout page template structure.
	 *
	 * @return the user uuid of this layout page template structure
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this layout page template structure.
	 *
	 * @param userUuid the user uuid of this layout page template structure
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this layout page template structure.
	 *
	 * @return the user name of this layout page template structure
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this layout page template structure.
	 *
	 * @param userName the user name of this layout page template structure
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this layout page template structure.
	 *
	 * @return the create date of this layout page template structure
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this layout page template structure.
	 *
	 * @param createDate the create date of this layout page template structure
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this layout page template structure.
	 *
	 * @return the modified date of this layout page template structure
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this layout page template structure.
	 *
	 * @param modifiedDate the modified date of this layout page template structure
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the fully qualified class name of this layout page template structure.
	 *
	 * @return the fully qualified class name of this layout page template structure
	 */
	@Override
	public String getClassName();

	public void setClassName(String className);

	/**
	 * Returns the class name ID of this layout page template structure.
	 *
	 * @return the class name ID of this layout page template structure
	 */
	@Override
	public long getClassNameId();

	/**
	 * Sets the class name ID of this layout page template structure.
	 *
	 * @param classNameId the class name ID of this layout page template structure
	 */
	@Override
	public void setClassNameId(long classNameId);

	/**
	 * Returns the class pk of this layout page template structure.
	 *
	 * @return the class pk of this layout page template structure
	 */
	@Override
	public long getClassPK();

	/**
	 * Sets the class pk of this layout page template structure.
	 *
	 * @param classPK the class pk of this layout page template structure
	 */
	@Override
	public void setClassPK(long classPK);

	/**
	 * Returns the data of this layout page template structure.
	 *
	 * @return the data of this layout page template structure
	 */
	@AutoEscape
	public String getData();

	/**
	 * Sets the data of this layout page template structure.
	 *
	 * @param data the data of this layout page template structure
	 */
	public void setData(String data);

}