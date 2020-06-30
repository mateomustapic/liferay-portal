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

define(['../var/document', '../var/support'], (document, support) => {
	'use strict';

	(function () {
		var input = document.createElement('input'),
			select = document.createElement('select'),
			opt = select.appendChild(document.createElement('option'));

		input.type = 'checkbox';

		// Support: Android <=4.3 only
		// Default value for a checkbox should be "on"

		support.checkOn = input.value !== '';

		// Support: IE <=11 only
		// Must access selectedIndex to make default options select

		support.optSelected = opt.selected;

		// Support: IE <=11 only
		// An input loses its value after becoming a radio

		input = document.createElement('input');
		input.value = 't';
		input.type = 'radio';
		support.radioValue = input.value === 't';
	})();

	return support;
});
