package controller;

import java.io.File;
import java.io.IOException;
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

import bean.Title;
import model.modelTitle;

/**
 * Servlet implementation class controllerAddTitle
 */
@WebServlet("/addTitle")
public class controllerAddTitle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR = "WebContent\\images";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controllerAddTitle() {
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
		if("load".equals(request.getParameter("type"))){ // type = load ni á là mới đầu load trang ra
			RequestDispatcher rd = request.getRequestDispatcher("/addTitle.jsp");//hiển thị trang jsp
			rd.forward(request, response);
		}else{//type khác load có nghĩa là hắn nhấn submit rồi,
			org.apache.commons.fileupload.disk.DiskFileItemFactory fileItemFactory = new org.apache.commons.fileupload.disk.DiskFileItemFactory();
			ServletFileUpload sfu = new ServletFileUpload(fileItemFactory);//đoạn này là tải thư viện éo quan tâm
			List<FileItem> fileItems = null;
			try {
				fileItems = sfu.parseRequest(request);
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String title = "";
			String picture = "";
			String meaning = "";
			String pictureNew = "";
			for (FileItem fileItem : fileItems) {
				if(fileItem.isFormField()){ //is form file có nghĩa là kiểu input ko phải là file
					String fileName = fileItem.getFieldName();
					String fileValue = new String(fileItem.getString().getBytes("ISO-8859-1"),"UTF-8");
					switch (fileName) {
					case "Title": // case lấy theo cái name của thẻ input
						title = fileValue; // gán giá trị ở đây
						break;
					case "Meaning":
						meaning = fileValue;
						break;
					default:
						break;
					}
				}else{ // nếu là file , chổ này tải file nè
					picture = fileItem.getName();
					if(!picture.isEmpty()){ // có upload
						// đổi tên ảnh
						pictureNew = FilenameUtils.getBaseName(picture) + System.nanoTime() + "." + FilenameUtils.getExtension(picture);
						String filePath = request.getServletContext().getRealPath("")+ File.separator + "imgTitle" + File.separator + pictureNew;
						File file = new File(filePath);
						//nó đổi tên ảnh để ko trùng tên
						try {
							fileItem.write(file);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println(filePath);// in đường dẫn gốc trong thư mục chứa ảnh ra cho mình kiểm tra có tồn tại ảnh nớ ko
					}
			
				}
			}
			Title tit = new Title(0, title, pictureNew, meaning);// có dối tượng chổ này r thì add xún thôi 
			// à chổ form add file nhớ thêm mutiltype
			// vậy là xong r đó , làm xong nhớ debug từng dòng , coi nó lấy dữ liệu đc ko, ok, để mai thử coi, bye :v
			//System.out.println(title.toString());
			modelTitle mt = new modelTitle();
			if(mt.InsertTitle(tit)>0){
				response.sendRedirect(request.getContextPath()+"/indexTitle");
			}else{
				response.sendRedirect(request.getContextPath()+"/addTitle");
			}
		}
	}

}
