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

define(['../core', '../event', '../event/trigger'], (jQuery) => {
	'use strict';

	jQuery.fn.extend({
		bind(types, data, fn) {
			return this.on(types, null, data, fn);
		},
		unbind(types, fn) {
			return this.off(types, null, fn);
		},

		delegate(selector, types, data, fn) {
			return this.on(types, selector, data, fn);
		},
		undelegate(selector, types, fn) {

			// ( namespace ) or ( selector, types [, fn] )

			return arguments.length === 1
				? this.off(selector, '**')
				: this.off(types, selector || '**', fn);
		},

		hover(fnOver, fnOut) {
			return this.mouseenter(fnOver).mouseleave(fnOut || fnOver);
		},
	});

	jQuery.each(
		(
			'blur focus focusin focusout resize scroll click dblclick ' +
			'mousedown mouseup mousemove mouseover mouseout mouseenter mouseleave ' +
			'change select submit keydown keypress keyup contextmenu'
		).split(' '),
		(_i, name) => {

			// Handle event binding

			jQuery.fn[name] = function (data, fn) {
				return arguments.length > 0
					? this.on(name, null, data, fn)
					: this.trigger(name);
			};
		}
	);
});
