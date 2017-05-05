package org.nibiru.mobile.demo.server;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/message")
public class MessageService {
	private static final Set<MessageService> connections = new CopyOnWriteArraySet<MessageService>();
	private Session session;

	@OnOpen
	public void start(Session session) {
		this.session = session;
		connections.add(this);
	}

	@OnClose
	public void end() {
		connections.remove(this);
	}

	@OnMessage
	public void echoTextMessage(Session session, String msg, boolean last) {
		for (MessageService client : connections) {
			try {
				synchronized (client) {
					client.session.getBasicRemote().sendText(msg);
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
