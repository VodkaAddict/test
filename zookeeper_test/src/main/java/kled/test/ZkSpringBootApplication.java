/*
 * Copyright 2012-2013 the original author or authors.
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

package kled.test;

import com.nepxion.aquarius.lock.LockExecutor;
import com.nepxion.aquarius.lock.LockTemplate;
import com.nepxion.aquarius.lock.annotation.EnableLock;
import org.apache.curator.framework.recipes.locks.InterProcessLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableLock
public class ZkSpringBootApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ZkSpringBootApplication.class, args);
	}

	@Bean
	public LockTemplate lockTemplate(LockExecutor lockExecutor){
		return new LockTemplate(lockExecutor);
	}
}
