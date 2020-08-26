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

CKEDITOR.on('dialogDefinition', (event) => {
	if (event.editor === ckEditor) {
		var boundingWindow = event.editor.window;

		var dialogDefinition = event.data.definition;

		var dialog = event.data.dialog;

		var onShow = dialogDefinition.onShow;

		dialogDefinition.onShow = function () {
			if (typeof onShow === 'function') {
				onShow.apply(this, arguments);
			}

			centerDialog();
		};

		var centerDialog = function () {
			var dialogSize = dialog.getSize();

			var x = window.innerWidth / 2 - dialogSize.width / 2;
			var y = window.innerHeight / 2 - dialogSize.height / 2;

			dialog.move(x, y, false);
		};

		AUI().use('aui-debounce', (A) => {
			boundingWindow.on(
				'resize',
				A.debounce(() => {
					centerDialog();
				}, 250)
			);
		});

		var clearEventHandler = function () {
			Liferay.detach('resize', boundingWindow);
		};

		Liferay.once('destroyPortlet', clearEventHandler);

		if (dialog.getName() === 'image2') {
			var infoTab = dialogDefinition.getContents('info');

			var spacingBox = {
				children: [
					{
						children: [
							{
								commit(widget) {
									widget.setData('hspace', this.getValue());

									var hspace = widget.data.hspace;

									var imageElement = widget.parts.image;
									if (imageElement) {
										if (hspace) {
											imageElement.setStyle(
												'margin-left',
												`${hspace}px`
											);
											imageElement.setStyle(
												'margin-right',
												`${hspace}px`
											);
										}
									}
								},
								id: 'hspace',
								label: 'HSpace',
								requiredContent:
									'img{margin-left,margin-right}',
								setup(widget) {
									this.setValue(widget.data.hspace);
								},
								type: 'text',

								validate: CKEDITOR.dialog.validate.integer(
									'Error! HSpace must be a whole number.'
								),
							},
						],
						type: 'hbox',
					},
					{
						children: [
							{
								commit(widget) {
									widget.setData('vspace', this.getValue());

									var vspace = widget.data.vspace;

									var imageElement = widget.parts.image;
									if (imageElement) {
										if (vspace) {
											imageElement.setStyle(
												'margin-bottom',
												`${vspace}px`
											);
											imageElement.setStyle(
												'margin-top',
												`${vspace}px`
											);
										}
									}
								},
								id: 'vspace',
								label: 'VSpace',
								requiredContent:
									'img{margin-top,margin-bottom}',
								setup(widget) {
									this.setValue(widget.data.vspace);
								},
								type: 'text',

								validate: CKEDITOR.dialog.validate.integer(
									'Error! VSpace must be a whole number.'
								),
							},
						],
						type: 'hbox',
					},
				],
				id: 'spacingBox',
				type: 'hbox',
			};

			infoTab.add(spacingBox);
		}
	}
});
