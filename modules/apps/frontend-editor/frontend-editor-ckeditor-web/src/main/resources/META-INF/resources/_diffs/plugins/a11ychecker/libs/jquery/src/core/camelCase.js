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

define([], () => {
	'use strict';

	// Matches dashed string for camelizing

	var rmsPrefix = /^-ms-/,
		rdashAlpha = /-([a-z])/g;

	// Used by camelCase as callback to replace()

	function fcamelCase(_all, letter) {
		return letter.toUpperCase();
	}

	// Convert dashed to camelCase; used by the css and data modules
	// Support: IE <=9 - 11, Edge 12 - 15
	// Microsoft forgot to hump their vendor prefix (#9572)

	function camelCase(string) {
		return string.replace(rmsPrefix, 'ms-').replace(rdashAlpha, fcamelCase);
	}

	return camelCase;
});
