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

define(['../core', '../core/toType', '../var/isFunction'], (
	jQuery,
	toType,
	isFunction
) => {
	'use strict';

	// Multifunctional method to get and set values of a collection
	// The value/s can optionally be executed if it's a function

	var access = function (elems, fn, key, value, chainable, emptyGet, raw) {
		var i = 0,
			len = elems.length,
			bulk = key == null;

		// Sets many values

		if (toType(key) === 'object') {
			chainable = true;
			for (i in key) {
				access(elems, fn, i, key[i], true, emptyGet, raw);
			}

			// Sets one value

		}
		else if (value !== undefined) {
			chainable = true;

			if (!isFunction(value)) {
				raw = true;
			}

			if (bulk) {

				// Bulk operations run against the entire set

				if (raw) {
					fn.call(elems, value);
					fn = null;

					// ...except when executing function values

				}
				else {
					bulk = fn;
					fn = function (elem, _key, value) {
						return bulk.call(jQuery(elem), value);
					};
				}
			}

			if (fn) {
				for (; i < len; i++) {
					fn(
						elems[i],
						key,
						raw ? value : value.call(elems[i], i, fn(elems[i], key))
					);
				}
			}
		}

		if (chainable) {
			return elems;
		}

		// Gets

		if (bulk) {
			return fn.call(elems);
		}

		return len ? fn(elems[0], key) : emptyGet;
	};

	return access;
});
