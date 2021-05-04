package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FieldDao;
import dao.FieldReserveDao;
import entity.Field;
import entity.FieldReserve;

/**
 * Servlet implementation class QueryMyFieldReserve
 */
@WebServlet("/QueryMyFieldReserveServlet")
public class QueryMyFieldReserveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryMyFieldReserveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		FieldReserveDao fd = new FieldReserveDao();
		List<FieldReserve> fieldList = new ArrayList<FieldReserve>();
		String userName = (String) request.getSession().getAttribute("userName");
		fieldList = fd.queryFieldReserve(userName);
		if(fieldList.size() == 0) {
			response.sendRedirect("NoSuchData.jsp");
		}
		else {
			request.setAttribute("fieldReserveList", fieldList);
			request.getRequestDispatcher("myField.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
