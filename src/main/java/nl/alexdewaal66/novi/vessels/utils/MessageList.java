package nl.alexdewaal66.novi.vessels.utils;

import java.util.ArrayList;
import java.util.List;

public class MessageList {

    List<String> messages = new ArrayList<String>();

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public MessageList addMessage(String message) {
        this.messages.add(message);
        return this;
    }

    public MessageList clear() {
        this.clear();
        return this;
    }
}
