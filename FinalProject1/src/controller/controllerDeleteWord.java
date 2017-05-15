package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.modelWord;

/**
 * Servlet implementation class controllerDeleteWord
 */
@WebServlet("/deleteWord")
public class controllerDeleteWord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controllerDeleteWord() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		modelWord mw = new modelWord();
		int wID = Integer.parseInt(request.getParameter("wID"));
		if(mw.DeleteWord(wID)>0){
			response.sendRedirect(request.getContextPath()+"/indexWord?msg=del1");
		}else{
			response.sendRedirect(request.getContextPath()+"/indexWord?msg=del0");
		}
	}

}
