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
package org.androidannotations.validation;

import java.lang.annotation.Annotation;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;

import org.androidannotations.annotations.SystemService;
import org.androidannotations.helper.TargetAnnotationHelper;
import org.androidannotations.helper.ValidatorHelper;
import org.androidannotations.model.AndroidSystemServices;
import org.androidannotations.model.AnnotationElements;

public class SystemServiceValidator implements ElementValidator {

	private final AndroidSystemServices androidSystemServices;
	private ValidatorHelper validatorHelper;

	public SystemServiceValidator(ProcessingEnvironment processingEnv, AndroidSystemServices androidSystemServices) {
		TargetAnnotationHelper annotationHelper = new TargetAnnotationHelper(processingEnv, getTarget());
		validatorHelper = new ValidatorHelper(annotationHelper);
		this.androidSystemServices = androidSystemServices;
	}

	@Override
	public Class<? extends Annotation> getTarget() {
		return SystemService.class;
	}

	@Override
	public boolean validate(Element element, AnnotationElements validatedElements) {

		IsValid valid = new IsValid();

		validatorHelper.enclosingElementHasEnhancedComponentAnnotation(element, validatedElements, valid);

		validatorHelper.androidService(androidSystemServices, element, valid);

		validatorHelper.isNotPrivate(element, valid);

		return valid.isValid();
	}

}
