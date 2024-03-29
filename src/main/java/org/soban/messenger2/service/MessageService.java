package org.soban.messenger2.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.soban.messenger2.database.DatabaseClass;
import org.soban.messenger2.model.Messages;

public class MessageService {

	private Map<Long, Messages> messages = DatabaseClass.getMessages();
	
	public MessageService() {
		messages.put(1L, new Messages(1, "Hello World", "soban"));
		messages.put(2L, new Messages(2, "Hello Jersey", "Soban"));
	}
	
	public List<Messages> getAllMessages(){
		return new ArrayList<Messages>(messages.values());
	}
	
	public Messages getMessage(long id) {
		return messages.get(id);
	}	
	
	public Messages addMessage(Messages message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	public Messages updateMessage(Messages message) {
		if (message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	public Messages removeMessage(long id) {
		return messages.remove(id);
	}
}
