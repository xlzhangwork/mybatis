package service;

import dao.MessageDAO;
import entity.Message;

import java.util.List;

public class MessageService {

    public List<Message> queryMessage(String command,String description){
        MessageDAO messageDAO = new MessageDAO();
        return messageDAO.queryMessage(command,description);
    }
}
