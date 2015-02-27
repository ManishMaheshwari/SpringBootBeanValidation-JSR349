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

import javax.annotation.PostConstruct;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Person {

	@Value("${person.name}")
	@NotNull
	@Size(min = 4, max = 100)
	private String name;

	@Value("${person.age}")
	@Min(18)
	@Max(100)
	private int age;

	@Value("${person.married}")
	private boolean married;

	@Value("${person.country}")
	@NotNull
	@Size(min = 4, max = 8)
	private String country;

	@Value("${person.email}")
	@Pattern(regexp = "^(.+)@(.+)$")
	private String email;

	@Autowired
	private ValidatorService validatorService;

	@PostConstruct
	public void validate() {
		validatorService.validate(this);
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", married=" + married
				+ ", country=" + country + ", email=" + email + "]";
	}

}
