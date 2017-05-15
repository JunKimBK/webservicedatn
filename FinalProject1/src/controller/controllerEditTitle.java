package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Title;
import model.modelTitle;

/**
 * Servlet implementation class controllerEditTitle
 */
@WebServlet("/editTitle")
public class controllerEditTitle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controllerEditTitle() {
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
		int ttID = 0;
		if(request.getParameter("ttID")!= null ){
			ttID = Integer.parseInt(request.getParameter("ttID"));
		}
		if(request.getParameter("edit")!=null){
			String Title = request.getParameter("Title");
			System.out.println(Title);
			String Path = request.getParameter("Path");
			String Meaning = request.getParameter("Meaning");
			Title tit = new Title(ttID, Title, Path, Meaning);
			if(mt.UpdateTitle(tit)>0){
				response.sendRedirect(request.getContextPath()+"/indexTitle");
			}else{
				response.sendRedirect(request.getContextPath()+"/editTitle?ttID="+ttID+"&msg=trungten");
			}
		}else{
			request.setAttribute("editTitle", mt.getTitle(ttID));
			RequestDispatcher rd = request.getRequestDispatcher("/editTitle.jsp");
			rd.forward(request, response);
		}
	}

}
