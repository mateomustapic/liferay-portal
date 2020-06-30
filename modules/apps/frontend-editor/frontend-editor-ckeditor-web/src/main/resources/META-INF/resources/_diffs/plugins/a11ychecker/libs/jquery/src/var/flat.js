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

define(['./arr'], (arr) => {
	'use strict';

	// Support: IE 9 - 11+, Edge 18+, Android Browser 4.0 - 4.3 only, iOS 7 - 11 only, Safari 11 only,
	// Firefox <= 61 only
	// Provide fallback for browsers without Array#flat.

	return arr.flat
		? function (array) {
				return arr.flat.call(array);
		  }
		: function (array) {
				return arr.concat.apply([], array);
		  };
});
