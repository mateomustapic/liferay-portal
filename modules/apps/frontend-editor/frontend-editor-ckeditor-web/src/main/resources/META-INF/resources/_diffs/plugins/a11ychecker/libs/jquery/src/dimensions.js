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

define(['./core', './core/access', './var/isWindow', './css'], (
	jQuery,
	access,
	isWindow
) => {
	'use strict';

	// Create innerHeight, innerWidth, height, width, outerHeight and outerWidth methods

	jQuery.each({Height: 'height', Width: 'width'}, (name, type) => {
		jQuery.each(
			{padding: 'inner' + name, content: type, '': 'outer' + name},
			(defaultExtra, funcName) => {

				// Margin is only for outerHeight, outerWidth

				jQuery.fn[funcName] = function (margin, value) {
					var chainable =
							arguments.length &&
							(defaultExtra || typeof margin !== 'boolean'),
						extra =
							defaultExtra ||
							(margin === true || value === true
								? 'margin'
								: 'border');

					return access(
						this,
						(elem, type, value) => {
							var doc;

							if (isWindow(elem)) {

								// $( window ).outerWidth/Height return w/h including scrollbars (gh-1729)

								return funcName.indexOf('outer') === 0
									? elem['inner' + name]
									: elem.document.documentElement[
											'client' + name
									  ];
							}

							// Get document width or height

							if (elem.nodeType === 9) {
								doc = elem.documentElement;

								// Either scroll[Width/Height] or offset[Width/Height] or client[Width/Height],
								// whichever is greatest

								return Math.max(
									elem.body['scroll' + name],
									doc['scroll' + name],
									elem.body['offset' + name],
									doc['offset' + name],
									doc['client' + name]
								);
							}

							return value === undefined
								? // Get width or height on the element, requesting but not forcing parseFloat

								  jQuery.css(elem, type, extra)
								: // Set width or height on the element

								  jQuery.style(elem, type, value, extra);
						},
						type,
						chainable ? margin : undefined,
						chainable
					);
				};
			}
		);
	});

	return jQuery;
});
