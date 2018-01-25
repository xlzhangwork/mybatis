package service;

import dao.MessageDAO;

public class DeleteService {

    public void deleteMessage(String id){
        if(id != null && !"".equals(id.trim())){
            MessageDAO messageDAO = new MessageDAO();
            messageDAO.deleteMessage(Integer.valueOf(id));
        }
    }
}
