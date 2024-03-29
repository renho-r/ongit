/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package renho;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.HelloWord;
import com.renho.Receive;

public final class Client {

    private Client() {
    }

    public static void main(String args[]) throws Exception {
        // START SNIPPET: client
    	//Spring调用
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"client-beans.xml"});
        HelloWord client = (HelloWord)context.getBean("client");
        String response = client.sayHi("Joe");
        System.out.println("Response: " + response);
//        System.exit(0);
        // END SNIPPET: client
        ClassPathXmlApplicationContext context2 = new ClassPathXmlApplicationContext(new String[] {"client-beans.xml"});
        Receive client2 = (Receive)context2.getBean("receive");
        String response2 = client2.sendXML("Joe");
        System.out.println("Response: " + response2);
    }
}
