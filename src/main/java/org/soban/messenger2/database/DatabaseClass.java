package org.soban.messenger2.database;

import java.util.HashMap;
import java.util.Map;

import org.soban.messenger2.model.Messages;

public class DatabaseClass {

	private static Map<Long, Messages> messages = new HashMap<>();

	
	public static Map<Long, Messages> getMessages() {
		return messages;
	}
	
	
	
	
	
}
