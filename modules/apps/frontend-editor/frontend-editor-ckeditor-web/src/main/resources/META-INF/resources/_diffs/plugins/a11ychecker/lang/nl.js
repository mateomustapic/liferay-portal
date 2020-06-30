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

CKEDITOR.plugins.setLang('a11ychecker', 'nl', {
	toolbar: 'Toegankelijkheid controleren',
	closeBtn: 'Afsluiten',
	testability: {
		0: 'opmerking',
		0.5: 'waarschuwing',
		1: 'fout',
	},
	ignoreBtn: 'Negeren',
	ignoreBtnTitle: 'Probleem negeren',
	stopIgnoreBtn: 'Stop negeren',
	listeningInfo:
		'Na handmatige correcties, klik de knop <strong>Opnieuw controleren</strong> hieronder.',
	listeningCheckAgain: 'Opnieuw controleren',
	balloonLabel: 'Toegankelijkheidsassistent',
	navigationNext: 'Volgende',
	navigationNextTitle: 'Volgende probleem',
	navigationPrev: 'Vorige',
	navigationPrevTitle: 'Vorige probleem',
	quickFixButton: 'Quick fix',
	quickFixButtonTitle: 'Probleem oplossen met een quick fix',
	navigationCounter: 'Probleem {current} van {total} ({testability})',
	noIssuesMessage: 'Het document bevat geen toegankelijkheidsproblemen.',
});
