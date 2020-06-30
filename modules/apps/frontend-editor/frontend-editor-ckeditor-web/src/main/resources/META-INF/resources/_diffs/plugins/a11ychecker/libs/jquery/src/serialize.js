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

define([
	'./core',
	'./core/toType',
	'./var/rcheckableType',
	'./var/isFunction',
	'./core/init',
	'./traversing', // filter
	'./attributes/prop',
], (jQuery, toType, rcheckableType, isFunction) => {
	'use strict';

	var rbracket = /\[\]$/,
		rCRLF = /\r?\n/g,
		rsubmitterTypes = /^(?:submit|button|image|reset|file)$/i,
		rsubmittable = /^(?:input|select|textarea|keygen)/i;

	function buildParams(prefix, obj, traditional, add) {
		var name;

		if (Array.isArray(obj)) {

			// Serialize array item.

			jQuery.each(obj, (i, v) => {
				if (traditional || rbracket.test(prefix)) {

					// Treat each array item as a scalar.

					add(prefix, v);
				}
				else {

					// Item is non-scalar (array or object), encode its numeric index.

					buildParams(
						prefix +
							'[' +
							(typeof v === 'object' && v != null ? i : '') +
							']',
						v,
						traditional,
						add
					);
				}
			});
		}
		else if (!traditional && toType(obj) === 'object') {

			// Serialize object item.

			for (name in obj) {
				buildParams(
					prefix + '[' + name + ']',
					obj[name],
					traditional,
					add
				);
			}
		}
		else {

			// Serialize scalar item.

			add(prefix, obj);
		}
	}

	// Serialize an array of form elements or a set of
	// key/values into a query string

	jQuery.param = function (a, traditional) {
		var prefix,
			s = [],
			add = function (key, valueOrFunction) {

				// If value is a function, invoke it and use its return value

				var value = isFunction(valueOrFunction)
					? valueOrFunction()
					: valueOrFunction;

				s[s.length] =
					encodeURIComponent(key) +
					'=' +
					encodeURIComponent(value == null ? '' : value);
			};

		if (a == null) {
			return '';
		}

		// If an array was passed in, assume that it is an array of form elements.

		if (Array.isArray(a) || (a.jquery && !jQuery.isPlainObject(a))) {

			// Serialize the form elements

			jQuery.each(a, function () {
				add(this.name, this.value);
			});
		}
		else {

			// If traditional, encode the "old" way (the way 1.3.2 or older
			// did it), otherwise encode params recursively.

			for (prefix in a) {
				buildParams(prefix, a[prefix], traditional, add);
			}
		}

		// Return the resulting serialization

		return s.join('&');
	};

	jQuery.fn.extend({
		serialize() {
			return jQuery.param(this.serializeArray());
		},
		serializeArray() {
			return this.map(function () {

				// Can add propHook for "elements" to filter or add form elements

				var elements = jQuery.prop(this, 'elements');

				return elements ? jQuery.makeArray(elements) : this;
			})
				.filter(function () {
					var type = this.type;

					// Use .is( ":disabled" ) so that fieldset[disabled] works

					return (
						this.name &&
						!jQuery(this).is(':disabled') &&
						rsubmittable.test(this.nodeName) &&
						!rsubmitterTypes.test(type) &&
						(this.checked || !rcheckableType.test(type))
					);
				})
				.map(function (_i, elem) {
					var val = jQuery(this).val();

					if (val == null) {
						return null;
					}

					if (Array.isArray(val)) {
						return jQuery.map(val, (val) => {
							return {
								name: elem.name,
								value: val.replace(rCRLF, '\r\n'),
							};
						});
					}

					return {name: elem.name, value: val.replace(rCRLF, '\r\n')};
				})
				.get();
		},
	});

	return jQuery;
});
