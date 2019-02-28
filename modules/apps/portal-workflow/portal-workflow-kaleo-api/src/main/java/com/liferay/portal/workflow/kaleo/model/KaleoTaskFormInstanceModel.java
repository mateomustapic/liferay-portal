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

package com.liferay.portal.workflow.kaleo.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.MVCCModel;
import com.liferay.portal.kernel.model.ShardedModel;

import java.util.Date;

/**
 * The base model interface for the KaleoTaskFormInstance service. Represents a row in the &quot;KaleoTaskFormInstance&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.portal.workflow.kaleo.model.impl.KaleoTaskFormInstanceModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.portal.workflow.kaleo.model.impl.KaleoTaskFormInstanceImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KaleoTaskFormInstance
 * @generated
 */
@ProviderType
public interface KaleoTaskFormInstanceModel
	extends BaseModel<KaleoTaskFormInstance>, GroupedModel, MVCCModel,
			ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a kaleo task form instance model instance should use the {@link KaleoTaskFormInstance} interface instead.
	 */

	/**
	 * Returns the primary key of this kaleo task form instance.
	 *
	 * @return the primary key of this kaleo task form instance
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this kaleo task form instance.
	 *
	 * @param primaryKey the primary key of this kaleo task form instance
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this kaleo task form instance.
	 *
	 * @return the mvcc version of this kaleo task form instance
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this kaleo task form instance.
	 *
	 * @param mvccVersion the mvcc version of this kaleo task form instance
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the kaleo task form instance ID of this kaleo task form instance.
	 *
	 * @return the kaleo task form instance ID of this kaleo task form instance
	 */
	public long getKaleoTaskFormInstanceId();

	/**
	 * Sets the kaleo task form instance ID of this kaleo task form instance.
	 *
	 * @param kaleoTaskFormInstanceId the kaleo task form instance ID of this kaleo task form instance
	 */
	public void setKaleoTaskFormInstanceId(long kaleoTaskFormInstanceId);

	/**
	 * Returns the group ID of this kaleo task form instance.
	 *
	 * @return the group ID of this kaleo task form instance
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this kaleo task form instance.
	 *
	 * @param groupId the group ID of this kaleo task form instance
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this kaleo task form instance.
	 *
	 * @return the company ID of this kaleo task form instance
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this kaleo task form instance.
	 *
	 * @param companyId the company ID of this kaleo task form instance
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this kaleo task form instance.
	 *
	 * @return the user ID of this kaleo task form instance
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this kaleo task form instance.
	 *
	 * @param userId the user ID of this kaleo task form instance
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this kaleo task form instance.
	 *
	 * @return the user uuid of this kaleo task form instance
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this kaleo task form instance.
	 *
	 * @param userUuid the user uuid of this kaleo task form instance
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this kaleo task form instance.
	 *
	 * @return the user name of this kaleo task form instance
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this kaleo task form instance.
	 *
	 * @param userName the user name of this kaleo task form instance
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this kaleo task form instance.
	 *
	 * @return the create date of this kaleo task form instance
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this kaleo task form instance.
	 *
	 * @param createDate the create date of this kaleo task form instance
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this kaleo task form instance.
	 *
	 * @return the modified date of this kaleo task form instance
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this kaleo task form instance.
	 *
	 * @param modifiedDate the modified date of this kaleo task form instance
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the kaleo definition version ID of this kaleo task form instance.
	 *
	 * @return the kaleo definition version ID of this kaleo task form instance
	 */
	public long getKaleoDefinitionVersionId();

	/**
	 * Sets the kaleo definition version ID of this kaleo task form instance.
	 *
	 * @param kaleoDefinitionVersionId the kaleo definition version ID of this kaleo task form instance
	 */
	public void setKaleoDefinitionVersionId(long kaleoDefinitionVersionId);

	/**
	 * Returns the kaleo instance ID of this kaleo task form instance.
	 *
	 * @return the kaleo instance ID of this kaleo task form instance
	 */
	public long getKaleoInstanceId();

	/**
	 * Sets the kaleo instance ID of this kaleo task form instance.
	 *
	 * @param kaleoInstanceId the kaleo instance ID of this kaleo task form instance
	 */
	public void setKaleoInstanceId(long kaleoInstanceId);

	/**
	 * Returns the kaleo task ID of this kaleo task form instance.
	 *
	 * @return the kaleo task ID of this kaleo task form instance
	 */
	public long getKaleoTaskId();

	/**
	 * Sets the kaleo task ID of this kaleo task form instance.
	 *
	 * @param kaleoTaskId the kaleo task ID of this kaleo task form instance
	 */
	public void setKaleoTaskId(long kaleoTaskId);

	/**
	 * Returns the kaleo task instance token ID of this kaleo task form instance.
	 *
	 * @return the kaleo task instance token ID of this kaleo task form instance
	 */
	public long getKaleoTaskInstanceTokenId();

	/**
	 * Sets the kaleo task instance token ID of this kaleo task form instance.
	 *
	 * @param kaleoTaskInstanceTokenId the kaleo task instance token ID of this kaleo task form instance
	 */
	public void setKaleoTaskInstanceTokenId(long kaleoTaskInstanceTokenId);

	/**
	 * Returns the kaleo task form ID of this kaleo task form instance.
	 *
	 * @return the kaleo task form ID of this kaleo task form instance
	 */
	public long getKaleoTaskFormId();

	/**
	 * Sets the kaleo task form ID of this kaleo task form instance.
	 *
	 * @param kaleoTaskFormId the kaleo task form ID of this kaleo task form instance
	 */
	public void setKaleoTaskFormId(long kaleoTaskFormId);

	/**
	 * Returns the form values of this kaleo task form instance.
	 *
	 * @return the form values of this kaleo task form instance
	 */
	@AutoEscape
	public String getFormValues();

	/**
	 * Sets the form values of this kaleo task form instance.
	 *
	 * @param formValues the form values of this kaleo task form instance
	 */
	public void setFormValues(String formValues);

	/**
	 * Returns the form value entry group ID of this kaleo task form instance.
	 *
	 * @return the form value entry group ID of this kaleo task form instance
	 */
	public long getFormValueEntryGroupId();

	/**
	 * Sets the form value entry group ID of this kaleo task form instance.
	 *
	 * @param formValueEntryGroupId the form value entry group ID of this kaleo task form instance
	 */
	public void setFormValueEntryGroupId(long formValueEntryGroupId);

	/**
	 * Returns the form value entry ID of this kaleo task form instance.
	 *
	 * @return the form value entry ID of this kaleo task form instance
	 */
	public long getFormValueEntryId();

	/**
	 * Sets the form value entry ID of this kaleo task form instance.
	 *
	 * @param formValueEntryId the form value entry ID of this kaleo task form instance
	 */
	public void setFormValueEntryId(long formValueEntryId);

	/**
	 * Returns the form value entry uuid of this kaleo task form instance.
	 *
	 * @return the form value entry uuid of this kaleo task form instance
	 */
	@AutoEscape
	public String getFormValueEntryUuid();

	/**
	 * Sets the form value entry uuid of this kaleo task form instance.
	 *
	 * @param formValueEntryUuid the form value entry uuid of this kaleo task form instance
	 */
	public void setFormValueEntryUuid(String formValueEntryUuid);

	/**
	 * Returns the metadata of this kaleo task form instance.
	 *
	 * @return the metadata of this kaleo task form instance
	 */
	@AutoEscape
	public String getMetadata();

	/**
	 * Sets the metadata of this kaleo task form instance.
	 *
	 * @param metadata the metadata of this kaleo task form instance
	 */
	public void setMetadata(String metadata);

}