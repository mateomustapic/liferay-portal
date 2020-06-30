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

/**
 * @license Copyright (c) 2014-2018, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or https://ckeditor.com/license
 */

(function () {
	'use strict';

	CKEDITOR.plugins.a11ychecker.quickFixes.get({
		langCode: 'en',
		name: 'ImgAlt',
		callback(ImgAlt) {

			/**
			 * Fixes the image with missing alt attribute, requiring non-empty alt.
			 *
			 * @constructor
			 */
			function ImgAltNonEmpty(issue) {
				ImgAlt.call(this, issue);
			}

			ImgAltNonEmpty.prototype = new ImgAlt();
			ImgAltNonEmpty.prototype.constructor = ImgAltNonEmpty;

			ImgAltNonEmpty.prototype.validate = function (formAttributes) {
				var ret = [],
					proposedAlt = formAttributes.alt + '';

				if (!proposedAlt) {
					ret.push(this.lang.errorEmpty);
				}

				if (!ret.length) {
					ret = ImgAlt.prototype.validate.call(this, formAttributes);
				}

				return ret;
			};

			ImgAltNonEmpty.prototype.lang = {
				altLabel: 'Alternative text',
				errorTooLong:
					'Alternative text is too long. It should be up to {limit} characters while your has {length}',
				errorWhitespace:
					'Alternative text can not only contain whitespace characters',
				errorSameAsFileName:
					'Image alt should not be the same as the file name',
				errorEmpty: 'Alternative text can not be empty',
			};
			CKEDITOR.plugins.a11ychecker.quickFixes.add(
				'en/ImgAltNonEmpty',
				ImgAltNonEmpty
			);
		},
	});
})();
