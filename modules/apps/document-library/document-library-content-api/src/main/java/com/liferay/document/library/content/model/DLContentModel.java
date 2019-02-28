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

package com.liferay.document.library.content.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.ShardedModel;

import java.sql.Blob;

/**
 * The base model interface for the DLContent service. Represents a row in the &quot;DLContent&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.document.library.content.model.impl.DLContentModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.document.library.content.model.impl.DLContentImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DLContent
 * @generated
 */
@ProviderType
public interface DLContentModel extends BaseModel<DLContent>, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a document library content model instance should use the {@link DLContent} interface instead.
	 */

	/**
	 * Returns the primary key of this document library content.
	 *
	 * @return the primary key of this document library content
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this document library content.
	 *
	 * @param primaryKey the primary key of this document library content
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the content ID of this document library content.
	 *
	 * @return the content ID of this document library content
	 */
	public long getContentId();

	/**
	 * Sets the content ID of this document library content.
	 *
	 * @param contentId the content ID of this document library content
	 */
	public void setContentId(long contentId);

	/**
	 * Returns the group ID of this document library content.
	 *
	 * @return the group ID of this document library content
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this document library content.
	 *
	 * @param groupId the group ID of this document library content
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this document library content.
	 *
	 * @return the company ID of this document library content
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this document library content.
	 *
	 * @param companyId the company ID of this document library content
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the repository ID of this document library content.
	 *
	 * @return the repository ID of this document library content
	 */
	public long getRepositoryId();

	/**
	 * Sets the repository ID of this document library content.
	 *
	 * @param repositoryId the repository ID of this document library content
	 */
	public void setRepositoryId(long repositoryId);

	/**
	 * Returns the path of this document library content.
	 *
	 * @return the path of this document library content
	 */
	@AutoEscape
	public String getPath();

	/**
	 * Sets the path of this document library content.
	 *
	 * @param path the path of this document library content
	 */
	public void setPath(String path);

	/**
	 * Returns the version of this document library content.
	 *
	 * @return the version of this document library content
	 */
	@AutoEscape
	public String getVersion();

	/**
	 * Sets the version of this document library content.
	 *
	 * @param version the version of this document library content
	 */
	public void setVersion(String version);

	/**
	 * Returns the data of this document library content.
	 *
	 * @return the data of this document library content
	 */
	public Blob getData();

	/**
	 * Sets the data of this document library content.
	 *
	 * @param data the data of this document library content
	 */
	public void setData(Blob data);

	/**
	 * Returns the size of this document library content.
	 *
	 * @return the size of this document library content
	 */
	public long getSize();

	/**
	 * Sets the size of this document library content.
	 *
	 * @param size the size of this document library content
	 */
	public void setSize(long size);

}