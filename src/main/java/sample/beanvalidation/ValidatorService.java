/*
 * Copyright 2014-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package sample.beanvalidation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Component
public class ValidatorService {

	@Autowired
	public Validator validator;

	@Bean
	public javax.validation.Validator localValidatorFactoryBean() {
		return new LocalValidatorFactoryBean();
	}

	public <T> void validate(T bean) {
		Set<ConstraintViolation<T>> constraintViolations = validator.validate(bean);
		for (ConstraintViolation<T> constraintViolation : constraintViolations) {
			System.out.println(constraintViolation);
		}
	}
}
