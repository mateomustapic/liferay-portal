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

package com.liferay.portal.tools.java.parser;

import com.liferay.petra.string.StringBundler;

/**
 * @author Hugo Huijser
 */
public class JavaWhileStatement extends JavaLoopStatement {

	public JavaWhileStatement(JavaExpression conditionJavaExpression) {
		_conditionJavaExpression = conditionJavaExpression;
	}

	public void setExecutionJavaTerm(JavaTerm executionJavaTerm) {
		_executionJavaTerm = executionJavaTerm;
	}

	@Override
	public String toString(
		String indent, String prefix, String suffix, int maxLineLength) {

		StringBundler sb = appendLabelName(indent);

		if (_executionJavaTerm == null) {
			appendNewLine(
				sb, _conditionJavaExpression, indent, "while (", ")" + suffix,
				maxLineLength);

			return sb.toString();
		}

		appendNewLine(
			sb, _conditionJavaExpression, indent, "while (", ") ",
			maxLineLength);

		indent = "\t" + getIndent(getLastLine(sb));

		append(
			sb, _executionJavaTerm, indent, "", _executionJavaTerm.getSuffix(),
			maxLineLength);

		return sb.toString();
	}

	private final JavaExpression _conditionJavaExpression;
	private JavaTerm _executionJavaTerm;

}