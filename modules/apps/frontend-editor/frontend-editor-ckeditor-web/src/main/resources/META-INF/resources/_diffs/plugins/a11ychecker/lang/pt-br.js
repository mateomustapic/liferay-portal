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

CKEDITOR.plugins.setLang('a11ychecker', 'pt-br', {
	toolbar: 'Verificador de Acessibilidade',
	closeBtn: 'Fechar',
	testability: {
		0: 'observação',
		0.5: 'alerta',
		1: 'erro',
	},
	ignoreBtn: 'Ignorar',
	ignoreBtnTitle: 'Ignorar este problema',
	stopIgnoreBtn: 'Parar de ignorar',
	listeningInfo:
		'Aguardando por mudanças no conteúdo. Quando terminar, clique em <strong>Verificar novamente</strong> abaixo.',
	listeningCheckAgain: 'Verificar novamente',
	balloonLabel: 'Verificador de Acessibilidade',
	navigationNext: 'Próximo',
	navigationNextTitle: 'Próximo problema',
	navigationPrev: 'Anterior',
	navigationPrevTitle: 'Problema anterior',
	quickFixButton: 'Reparar rapidamente',
	quickFixButtonTitle: 'Reparar rapidamente este problema',
	navigationCounter: 'Problema {current} de {total} ({testability})',
	noIssuesMessage:
		'O documento não possui nenhum problema de acessibilidade identificado.',
});
