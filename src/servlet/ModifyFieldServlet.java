package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FieldDao;
import entity.Field;

/**
 * Servlet implementation class ModifyFieldServlet
 */
@WebServlet("/ModifyFieldServlet")
public class ModifyFieldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyFieldServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String description = request.getParameter("description");
		int size = Integer.valueOf(request.getParameter("size"));
		int price = Integer.valueOf(request.getParameter("price"));
		int hasLight = Integer.valueOf(request.getParameter("hasLight"));
		int inDoor = Integer.valueOf(request.getParameter("inDoor"));
		int realGrass = Integer.valueOf(request.getParameter("realGrass"));
		int hasShop = Integer.valueOf(request.getParameter("hasShop"));
		int fieldID = (Integer)request.getSession().getAttribute("fieldID");
		
		Field field = new Field(fieldID, description, size, price, hasLight, inDoor, realGrass, hasShop);
		FieldDao fd = new FieldDao();
		fd.updateField(field);
		response.sendRedirect("QueryFieldServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
