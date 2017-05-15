package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import model.WordService;

@WebServlet("/WordServlet")
public class WordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WordServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WordService ws = new WordService();
		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(ws.getListWord());
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}

}
