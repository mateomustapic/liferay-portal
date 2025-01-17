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

package com.liferay.portal.tools.rest.builder;

import java.io.File;

/**
 * @author Peter Shin
 */
public class RESTBuilderInvoker {

	public static RESTBuilder invoke(
			File baseDir, RESTBuilderArgs restBuilderArgs)
		throws Exception {

		return new RESTBuilder(
			_getAbsolutePath(baseDir, restBuilderArgs.getApiDirName()),
			restBuilderArgs.getApiPackagePath(), restBuilderArgs.getAuthor(),
			_getAbsolutePath(baseDir, restBuilderArgs.getCopyrightFileName()),
			_getAbsolutePath(baseDir, restBuilderArgs.getInputFileName()));
	}

	private static String _getAbsolutePath(File baseDir, String fileName) {
		if ((fileName == null) || fileName.isEmpty()) {
			return null;
		}

		File file = new File(baseDir, fileName);

		String absolutePath = file.getAbsolutePath();

		return absolutePath.replace('\\', '/');
	}

}