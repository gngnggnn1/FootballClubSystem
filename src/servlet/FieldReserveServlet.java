package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FieldReserveDao;
import entity.Field;

/**
 * Servlet implementation class FieldReserveServlet
 */
@WebServlet("/FieldReserveServlet")
public class FieldReserveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FieldReserveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String userName = (String) request.getSession().getAttribute("userName");
		//String userName = "lgn";
		String date = request.getParameter("date");
		String fieldName = request.getParameter("fieldName1");
		FieldReserveDao frd = new FieldReserveDao();
		frd.reserveField(userName, fieldName, date);
		response.sendRedirect("QueryMyFieldReserveServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
