package controller;

import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import com.sun.org.apache.bcel.internal.util.ByteSequence;

import bean.Title;
import bean.Word;
import javafx.util.converter.ByteStringConverter;
import model.modelWord;

/**
 * Servlet implementation class controllerAddWord
 */
@WebServlet("/addWord")
public class controllerAddWord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controllerAddWord() {
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
		if("load".equals(request.getParameter("type"))){ 
			RequestDispatcher rd = request.getRequestDispatcher("/addWord.jsp");
			rd.forward(request, response);
		}else{
			org.apache.commons.fileupload.disk.DiskFileItemFactory fileItemFactory = new org.apache.commons.fileupload.disk.DiskFileItemFactory();
			ServletFileUpload sfu = new ServletFileUpload(fileItemFactory);
			List<FileItem> fileItems = null;
			try {
				fileItems = sfu.parseRequest(request);
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			int IDtitle = 0;
			String word = "";
			String meaning = "";
			String picture = "";
			String sound = "";
			String pictureNew = "";
			String soundNew = "";
			for (FileItem fileItem : fileItems) {
				if(fileItem.isFormField()){
					String fileName = fileItem.getFieldName();
					String fileValue = new String(fileItem.getString().getBytes("ISO-8859-1"),"UTF-8");
					switch (fileName) {
					case "IDTitle": // case lấy theo cái name của thẻ input
						IDtitle = Integer.parseInt(fileValue); // gán giá trị ở đây
						break;
					case "Word":
						word = fileValue;
						break;
					case "Meaning": // case lấy theo cái name của thẻ input
						meaning = fileValue; // gán giá trị ở đây
						break;
					case "Picture":
						picture = fileValue;
						break;
					case "Sound": // case lấy theo cái name của thẻ input
						sound = fileValue; // gán giá trị ở đây
						break;
					}
				}
				else{ // nếu là file , chổ này tải file nè
					switch (fileItem.getFieldName()) {
					case "Picture":
						picture = fileItem.getName();
						pictureNew = FilenameUtils.getBaseName(picture) + System.nanoTime() + "." + FilenameUtils.getExtension(picture);
						String filePath = request.getServletContext().getRealPath("")+ File.separator + "imgWord" + File.separator + pictureNew;
						File file = new File(filePath);
						try {
							fileItem.write(file);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println(request.getServletContext().getRealPath(""));
						break;

					case "Sound":
						sound = fileItem.getName();
						soundNew = FilenameUtils.getBaseName(sound) + System.nanoTime() + "." + FilenameUtils.getExtension(sound);
						String filePath1 = request.getServletContext().getRealPath("")+ File.separator + "mpSound" + File.separator + soundNew;
						File file1 = new File(filePath1);
						try {
							fileItem.write(file1);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println(request.getServletContext().getRealPath(""));
						break;
					}
					/*if(!picture.isEmpty()){ // có upload
						// đổi tên ảnh
						pictureNew = FilenameUtils.getBaseName(picture) + System.nanoTime() + "." + FilenameUtils.getExtension(picture);
						String filePath = request.getServletContext().getRealPath("")+ File.separator + "imgWord" + File.separator + pictureNew;
						File file = new File(filePath);
						try {
							fileItem.write(file);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println(request.getServletContext().getRealPath(""));// in đường dẫn gốc trong thư mục chứa ảnh ra cho mình kiểm tra có tồn tại ảnh nớ ko
					}*/
				}
			}
			modelWord mw = new modelWord();
			Word wor = new Word(0, IDtitle, word, meaning, pictureNew, soundNew);
			System.out.println(word.toString());
			if(mw.InsertWord(wor)>0){
				response.sendRedirect(request.getContextPath()+"/indexWord");
			}else{
				response.sendRedirect(request.getContextPath()+"/addWord");
			}
		}
		
	}

}
