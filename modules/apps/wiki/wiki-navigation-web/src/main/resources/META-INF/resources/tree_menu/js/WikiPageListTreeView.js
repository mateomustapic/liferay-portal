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

const WikiPageListTreeView = (menuItems) => {
	const testNodes = [
		{
			id: 1,
			name: 'test page 1',
			children: [
				{
					id: 44,
					name: 'test subpage 1',
				},
			],
		},
		{
			id: 2,
			name: 'test page 2',
		},
	];

	console.log('menuItems');
	console.log(menuItems);
	console.log('testNodes');
	console.log(testNodes);

	return (
		<>
			<Treeview
				multiSelection={false}
				NodeComponent={Treeview.Card}
				nodes={testNodes}
			/>
		</>
	);
};

export default WikiPageListTreeView;
