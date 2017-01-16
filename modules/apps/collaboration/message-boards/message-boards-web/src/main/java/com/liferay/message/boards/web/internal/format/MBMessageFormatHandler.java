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

package com.liferay.message.boards.web.internal.format;

import com.liferay.message.boards.web.internal.util.MBAttachmentFileEntryReference;

import java.util.List;

/**
 * @author Alejandro Tardín
 */
public interface MBMessageFormatHandler {

	public String replaceImageReferences(
		String body,
		List<MBAttachmentFileEntryReference> mbAttachmentFileEntryReferences);

	public String FORMAT_KEY = "format";

}