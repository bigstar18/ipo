/*
 * Copyright 1999-2011 Alibaba Group.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yrdce.ipo.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yrdce.ipo.modules.sys.service.UserService;

public class DemoConsumer {

	public static void main(String[] args) {
		// com.alibaba.dubbo.container.Main.main(args);

		// final String port = "8888";
		// // 测试Rest服务
		// getUser("http://localhost:" + port + "/services/users/1.json");
		// getUser("http://localhost:" + port + "/services/users/1.xml");

		// 测试常规服务
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:META-INF/spring/*.xml");
		context.start();
		UserService userService = context.getBean(UserService.class);
	//	System.out.println(userService.getUser(1L));

	}
	// private static void getUser(String url) {
	// System.out.println("Getting user via " + url);
	// Client client = ClientBuilder.newClient();
	// WebTarget target = client.target(url);
	// Response response = target.request().get();
	// try {
	// if (response.getStatus() != 200) {
	// throw new RuntimeException("Failed with HTTP error code : " + response.getStatus());
	// }
	// System.out.println("Successfully got result: " + response.readEntity(String.class));
	// } finally {
	// response.close();
	// client.close();
	// }
	// }

}