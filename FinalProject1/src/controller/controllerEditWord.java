package controller;

import java.io.IOException;
import java.sql.Blob;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Word;
import model.modelWord;

/**
 * Servlet implementation class controllerEditWord
 */
@WebServlet("/editWord")
public class controllerEditWord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controllerEditWord() {
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
		int wID = 0;
		if(request.getParameter("wID")!=null){
			wID = Integer.parseInt(request.getParameter("wID"));
		}
		if(request.getParameter("edit")!=null){
			int IDTitle = Integer.parseInt(request.getParameter("IDTitle"));
			String Word = request.getParameter("Word");
			String Meaning = request.getParameter("Meaning");
			String Picture = request.getParameter("Picture");
			String Sound = request.getParameter("Sound");
			Word word = new Word(wID, IDTitle, Word, Meaning, Picture, Sound);
			if(mw.UpdateWord(word)>0){
				response.sendRedirect(request.getContextPath()+"/indexWord");
			}else{
				response.sendRedirect(request.getContextPath()+"/editWord?wID="+wID+"&msg=trungten");
			}
		}else{
			request.setAttribute("editWord", mw.getWord(wID));
			RequestDispatcher rd = request.getRequestDispatcher("/editWord.jsp");
			rd.forward(request, response);
		}
	}

}
