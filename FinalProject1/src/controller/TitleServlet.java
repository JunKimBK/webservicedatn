package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import model.TitleService;

@WebServlet("/TitleServlet")
public class TitleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TitleServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TitleService ts = new TitleService();
		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(ts.getListTitle());
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}
}
