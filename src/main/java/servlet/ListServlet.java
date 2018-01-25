package servlet;

import entity.Message;
import service.MessageService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String command = request.getParameter("command");
        String description = request.getParameter(("description"));

        MessageService messageService = new MessageService();
        List<Message> messageList = messageService.queryMessage(command,description);

        request.setAttribute("messageList",messageList);
        request.getRequestDispatcher("/WEB-INF/jsp/demo.jsp").forward(request,response);
    }

}
