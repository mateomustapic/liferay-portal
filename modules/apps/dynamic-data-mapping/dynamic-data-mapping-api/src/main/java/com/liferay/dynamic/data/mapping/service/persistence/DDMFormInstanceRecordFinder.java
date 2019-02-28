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

package com.liferay.dynamic.data.mapping.service.persistence;

import aQute.bnd.annotation.ProviderType;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public interface DDMFormInstanceRecordFinder {

	public int countByF_S(long ddmFormInstanceId, int status);

	public java.util.List
		<com.liferay.dynamic.data.mapping.model.DDMFormInstanceRecord>
			findByF_S(
				long ddmFormInstanceId, int status, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.liferay.dynamic.data.mapping.model.
						DDMFormInstanceRecord> orderByComparator);

}