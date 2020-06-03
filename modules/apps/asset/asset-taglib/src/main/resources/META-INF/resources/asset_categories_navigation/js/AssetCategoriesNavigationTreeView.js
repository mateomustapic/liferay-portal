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

import {Treeview} from 'frontend-js-components-web';
import React from 'react';

function buildNodes(vocabularies, categories) {
	const nodes = [];

	vocabularies.forEach((vocabulary) => {
		const child = {
			...vocabulary,
			children: [],
			id: vocabulary.vocabularyId,
		};

		categories.forEach((category) => {
			if (category.vocabularyId === child.id) {
				child.children.push({
					...category,
					id: category.categoryId,
				});
			}
		});

		nodes.push(child);
	});

	return nodes;
}

const AssetCategoriesNavigationTreeView = ({
	categories,
	namespace,
	vocabularies,
}) => {
	const nodes = buildNodes(vocabularies, categories);

	return (
		<div
			className="categories-tree container-fluid-1280"
			id={`${namespace}categoriesContainer`}
		>
			<Treeview NodeComponent={Treeview.Card} nodes={nodes} />
		</div>
	);
};

export default AssetCategoriesNavigationTreeView;
