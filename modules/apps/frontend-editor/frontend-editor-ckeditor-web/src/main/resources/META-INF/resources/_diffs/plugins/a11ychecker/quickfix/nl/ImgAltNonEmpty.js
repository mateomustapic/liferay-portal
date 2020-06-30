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
		langCode: 'nl',
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
				altLabel: 'Alternatieve tekst',
				errorTooLong:
					'Alternatieve tekst is te lang. Deze mag maximaal {limit} karaktersbevatten terwijl opgegeven tekst {length} bevat',
				errorWhitespace:
					'Alternatieve tekst mag niet alleen uit spaties bestaan',
				errorSameAsFileName:
					'Alt-tekst van de afbeelding mag niet hetzelfde zijn als de bestandsnaam',
				errorEmpty: 'Alternatieve tekst mag niet leeg zijn',
			};
			CKEDITOR.plugins.a11ychecker.quickFixes.add(
				'nl/ImgAltNonEmpty',
				ImgAltNonEmpty
			);
		},
	});
})();
