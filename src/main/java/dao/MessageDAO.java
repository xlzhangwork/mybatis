package dao;

import db.DBAccess;
import entity.Message;
import org.apache.ibatis.session.SqlSession;
import org.springframework.test.context.jdbc.Sql;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MessageDAO {

    public List<Message> queryMessage(String command, String description) {

        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        List<Message> messageList = new ArrayList<Message>();
        Message message = new Message();
        message.setCommand(command);
        message.setDescription(description);
        try {
            sqlSession = dbAccess.getSqlSession();
            messageList = sqlSession.selectList("xlzhang.queryMessageList",message);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(sqlSession != null)
                sqlSession.close();
        }

        return messageList;

    }

    public void deleteMessage(int id){
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;

        try {
            sqlSession = dbAccess.getSqlSession();
            sqlSession.delete("xlzhang.deleteMessage",id);
            //这个提交commit必须要有，否则不生效！
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(sqlSession != null)
                sqlSession.close();
        }

    }

}
