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

CKEDITOR.plugins.setLang('a11ychecker', 'en', {
	toolbar: 'Check Accessibility',
	closeBtn: 'Close',
	testability: {
		0: 'notice',
		0.5: 'warning',
		1: 'error',
	},
	ignoreBtn: 'Ignore',
	ignoreBtnTitle: 'Ignore this issue',
	stopIgnoreBtn: 'Stop ignoring',
	listeningInfo:
		'Waiting for manual content changes. When done, click <strong>Check again</strong> below.',
	listeningCheckAgain: 'Check again',
	balloonLabel: 'Accessibility Checker',
	navigationNext: 'Next',
	navigationNextTitle: 'Next issue',
	navigationPrev: 'Previous',
	navigationPrevTitle: 'Previous issue',
	quickFixButton: 'Quick fix',
	quickFixButtonTitle: 'Quick fix this issue',
	navigationCounter: 'Issue {current} of {total} ({testability})',
	noIssuesMessage: 'The document does not contain any accessibility issues.',
});
