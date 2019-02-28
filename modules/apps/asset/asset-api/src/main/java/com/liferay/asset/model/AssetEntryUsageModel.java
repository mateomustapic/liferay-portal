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

package com.liferay.asset.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.AttachedModel;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedGroupedModel;

import java.util.Date;

/**
 * The base model interface for the AssetEntryUsage service. Represents a row in the &quot;AssetEntryUsage&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.asset.model.impl.AssetEntryUsageModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.asset.model.impl.AssetEntryUsageImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssetEntryUsage
 * @generated
 */
@ProviderType
public interface AssetEntryUsageModel
	extends AttachedModel, BaseModel<AssetEntryUsage>, ShardedModel,
			StagedGroupedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a asset entry usage model instance should use the {@link AssetEntryUsage} interface instead.
	 */

	/**
	 * Returns the primary key of this asset entry usage.
	 *
	 * @return the primary key of this asset entry usage
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this asset entry usage.
	 *
	 * @param primaryKey the primary key of this asset entry usage
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this asset entry usage.
	 *
	 * @return the uuid of this asset entry usage
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this asset entry usage.
	 *
	 * @param uuid the uuid of this asset entry usage
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the asset entry usage ID of this asset entry usage.
	 *
	 * @return the asset entry usage ID of this asset entry usage
	 */
	public long getAssetEntryUsageId();

	/**
	 * Sets the asset entry usage ID of this asset entry usage.
	 *
	 * @param assetEntryUsageId the asset entry usage ID of this asset entry usage
	 */
	public void setAssetEntryUsageId(long assetEntryUsageId);

	/**
	 * Returns the group ID of this asset entry usage.
	 *
	 * @return the group ID of this asset entry usage
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this asset entry usage.
	 *
	 * @param groupId the group ID of this asset entry usage
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this asset entry usage.
	 *
	 * @return the company ID of this asset entry usage
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this asset entry usage.
	 *
	 * @param companyId the company ID of this asset entry usage
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this asset entry usage.
	 *
	 * @return the user ID of this asset entry usage
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this asset entry usage.
	 *
	 * @param userId the user ID of this asset entry usage
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this asset entry usage.
	 *
	 * @return the user uuid of this asset entry usage
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this asset entry usage.
	 *
	 * @param userUuid the user uuid of this asset entry usage
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this asset entry usage.
	 *
	 * @return the user name of this asset entry usage
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this asset entry usage.
	 *
	 * @param userName the user name of this asset entry usage
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this asset entry usage.
	 *
	 * @return the create date of this asset entry usage
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this asset entry usage.
	 *
	 * @param createDate the create date of this asset entry usage
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this asset entry usage.
	 *
	 * @return the modified date of this asset entry usage
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this asset entry usage.
	 *
	 * @param modifiedDate the modified date of this asset entry usage
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the asset entry ID of this asset entry usage.
	 *
	 * @return the asset entry ID of this asset entry usage
	 */
	public long getAssetEntryId();

	/**
	 * Sets the asset entry ID of this asset entry usage.
	 *
	 * @param assetEntryId the asset entry ID of this asset entry usage
	 */
	public void setAssetEntryId(long assetEntryId);

	/**
	 * Returns the fully qualified class name of this asset entry usage.
	 *
	 * @return the fully qualified class name of this asset entry usage
	 */
	@Override
	public String getClassName();

	public void setClassName(String className);

	/**
	 * Returns the class name ID of this asset entry usage.
	 *
	 * @return the class name ID of this asset entry usage
	 */
	@Override
	public long getClassNameId();

	/**
	 * Sets the class name ID of this asset entry usage.
	 *
	 * @param classNameId the class name ID of this asset entry usage
	 */
	@Override
	public void setClassNameId(long classNameId);

	/**
	 * Returns the class pk of this asset entry usage.
	 *
	 * @return the class pk of this asset entry usage
	 */
	@Override
	public long getClassPK();

	/**
	 * Sets the class pk of this asset entry usage.
	 *
	 * @param classPK the class pk of this asset entry usage
	 */
	@Override
	public void setClassPK(long classPK);

	/**
	 * Returns the portlet ID of this asset entry usage.
	 *
	 * @return the portlet ID of this asset entry usage
	 */
	@AutoEscape
	public String getPortletId();

	/**
	 * Sets the portlet ID of this asset entry usage.
	 *
	 * @param portletId the portlet ID of this asset entry usage
	 */
	public void setPortletId(String portletId);

	/**
	 * Returns the last publish date of this asset entry usage.
	 *
	 * @return the last publish date of this asset entry usage
	 */
	@Override
	public Date getLastPublishDate();

	/**
	 * Sets the last publish date of this asset entry usage.
	 *
	 * @param lastPublishDate the last publish date of this asset entry usage
	 */
	@Override
	public void setLastPublishDate(Date lastPublishDate);

}