package org.soban.messenger2.resources;

import java.awt.PageAttributes.MediaType;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.soban.messenger2.model.Messages;
import org.soban.messenger2.service.MessageService;

@Path("/messages")
public class MessageResources {

	MessageService messageService = new MessageService();

	@GET
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<Messages> getAllMessages() {
		return messageService.getAllMessages();
	}

	@GET
	@Path("/{messageId}")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public Messages getMessage(@PathParam("messageId") long id) {
		return messageService.getMessage(id);
	}

	@POST
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public Messages addMessage(Messages message) {
		Messages addedMessage = messageService.addMessage(message);
		return addedMessage;
	}

	@PUT
	@Path("/{messageId}")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public Messages updateMessage(@PathParam("messageId") long id, Messages message) {
		message.setId(id);
		return messageService.updateMessage(message);
	}

	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") long id) {
		messageService.removeMessage(id);
	}

}
