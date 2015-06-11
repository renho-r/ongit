/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.renho;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/websocket/myChat")
public class MyChatAnnotation {

	public static final Map<String, MyChatAnnotation> connections = new HashMap<String, MyChatAnnotation>();

	private Session session;

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public MyChatAnnotation() {
	}

	@OnOpen
	public void start(Session session) {
		this.session = session;
	}

	@OnClose
	public void end() {
		connections.remove(this);
	}

	@OnMessage
	public void incoming(String message) {
		String[] strs = message.split(";");
		if (strs.length >= 2 && "init".equals(strs[0])) {
			connections.put(strs[1], this);
			return;
		}
		try {
			connections.get(strs[0]).session.getBasicRemote().sendText(strs[1]);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@OnError
	public void onError(Throwable t) throws Throwable {
		System.out.println("Chat Error: " + t.toString());
	}
}
