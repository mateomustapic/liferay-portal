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

define(['../core', '../deferred'], (jQuery) => {
	'use strict';

	// These usually indicate a programmer mistake during development,
	// warn about them ASAP rather than swallowing them by default.

	var rerrorNames = /^(Eval|Internal|Range|Reference|Syntax|Type|URI)Error$/;

	jQuery.Deferred.exceptionHook = function (error, stack) {

		// Support: IE 8 - 9 only
		// Console exists when dev tools are open, which can happen at any time

		if (
			window.console &&
			window.console.warn &&
			error &&
			rerrorNames.test(error.name)
		) {
			window.console.warn(
				'jQuery.Deferred exception: ' + error.message,
				error.stack,
				stack
			);
		}
	};
});
