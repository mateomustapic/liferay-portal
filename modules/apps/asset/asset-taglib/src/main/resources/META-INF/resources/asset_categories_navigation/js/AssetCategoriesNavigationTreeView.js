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
import PropTypes from 'prop-types';
import React from 'react';

const AssetCategoriesNavigationTreeView = ({categories, namespace, nodes}) => {

	// var treeViews = A.all(
	// 	'#<%= namespace %>taglibAssetCategoriesNavigationPanel .lfr-asset-category-list-container'
	// );

	// treeViews.each(function (item, index, collection) {
	// 	var assetCategoryList = item.one('.lfr-asset-category-list');

	// 	var treeView = new A.TreeView({
	// 		boundingBox: item,
	// 		contentBox: assetCategoryList,
	// 		type: 'normal',
	// 	}).render();

	// 	var selected = assetCategoryList.one('.tree-node .tag-selected');

	// 	if (selected) {
	// 		var selectedChild = treeView.getNodeByChild(selected);

	// 		selectedChild.expand();

	// 		selectedChild.eachParent(function (node) {
	// 			if (node instanceof A.TreeNode) {
	// 				node.expand();
	// 			}
	// 		});
	// 	}
	// });

	var testNodes = [
		{
			categoryId: 36317,
			id: 1,
			name: 'Category 01',
		},
	];

	console.log(categories);

	// console.log(vocabularies[0].name);

	console.log(testNodes);
	console.log(namespace);

	return (
		<div>
			{testNodes[0].name}

			<Treeview NodeComponent={Treeview.Card} nodes={testNodes} />
		</div>
	);
};

AssetCategoriesNavigationTreeView.propTypes = {
	namespace: PropTypes.string,
};

export default AssetCategoriesNavigationTreeView;
