/**
 * Copyright (C) 2010-2012 eBusiness Information, Excilys Group
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed To in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.androidannotations.processing;

import com.sun.codemodel.JMethod;
import com.sun.codemodel.JVar;

public class TextWatcherHolder {

	final JMethod afterTextChangedMethod;

	final JMethod beforeTextChangedMethod;

	final JMethod onTextChangedMethod;

	final JVar viewVariable;

	public TextWatcherHolder(//
			JMethod afterTextChangedMethod, //
			JMethod beforeTextChangedMethod, //
			JMethod onTextChangedMethod, JVar viewVariable) {

		this.afterTextChangedMethod = afterTextChangedMethod;
		this.beforeTextChangedMethod = beforeTextChangedMethod;
		this.onTextChangedMethod = onTextChangedMethod;
		this.viewVariable = viewVariable;

	}

}
