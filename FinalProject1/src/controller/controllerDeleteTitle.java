package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.modelTitle;

/**
 * Servlet implementation class controllerDeleteTitle
 */
@WebServlet("/deleteTitle")
public class controllerDeleteTitle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controllerDeleteTitle() {
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
		modelTitle mt = new modelTitle();
		int ttID = Integer.parseInt(request.getParameter("ttID"));
		if(mt.DeleteTitle(ttID)>0){
			response.sendRedirect(request.getContextPath()+"/indexTitle?msg=del1");
		}else{
			response.sendRedirect(request.getContextPath()+"/indexTitle?msg=del0");
		}
	}

}
