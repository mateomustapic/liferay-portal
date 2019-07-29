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

AUI.add(
	'liferay-store',
	function(A) {
		var Lang = A.Lang;

		var Store = function(key, value) {
			var method;

			if (Lang.isFunction(value)) {
				method = 'get';

				if (Array.isArray(key)) {
					method = 'getAll';
				}
			} else {
				method = 'set';

				if (Lang.isObject(key)) {
					method = 'setAll';
				} else if (arguments.length === 1) {
					method = null;
				}
			}

			if (method) {
				Store[method].apply(Store, arguments);
			}
		};

		A.mix(Store, {
			get: function(key, callback) {
				Liferay.Util.Store.get(key, callback);
			},

			getAll: function(keys, callback) {
				Liferay.Util.Store.getAll(keys, callback);
			},

			set: function(key, value) {
				Liferay.Util.Store.set(key, value);
			},

			setAll: function(obj) {
				Liferay.Util.Store.setAll(obj);
			}
		});

		Liferay.Store = Store;
	},
	'',
	{
		requires: ['aui-base']
	}
);
