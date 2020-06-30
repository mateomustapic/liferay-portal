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
	'./var/isFunction',
	'./core/init',
	'./manipulation', // clone
	'./traversing', // parent, contents
], (jQuery, isFunction) => {
	'use strict';

	jQuery.fn.extend({
		wrapAll(html) {
			var wrap;

			if (this[0]) {
				if (isFunction(html)) {
					html = html.call(this[0]);
				}

				// The elements to wrap the target around

				wrap = jQuery(html, this[0].ownerDocument).eq(0).clone(true);

				if (this[0].parentNode) {
					wrap.insertBefore(this[0]);
				}

				wrap.map(function () {
					var elem = this;

					while (elem.firstElementChild) {
						elem = elem.firstElementChild;
					}

					return elem;
				}).append(this);
			}

			return this;
		},

		wrapInner(html) {
			if (isFunction(html)) {
				return this.each(function (i) {
					jQuery(this).wrapInner(html.call(this, i));
				});
			}

			return this.each(function () {
				var self = jQuery(this),
					contents = self.contents();

				if (contents.length) {
					contents.wrapAll(html);
				}
				else {
					self.append(html);
				}
			});
		},

		wrap(html) {
			var htmlIsFunction = isFunction(html);

			return this.each(function (i) {
				jQuery(this).wrapAll(
					htmlIsFunction ? html.call(this, i) : html
				);
			});
		},

		unwrap(selector) {
			this.parent(selector)
				.not('body')
				.each(function () {
					jQuery(this).replaceWith(this.childNodes);
				});

			return this;
		},
	});

	return jQuery;
});
