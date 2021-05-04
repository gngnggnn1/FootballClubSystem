package servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ThreadDao;
import entity.Threads;

/**
 * Servlet implementation class PostThreadAdminServlet
 */
@WebServlet("/PostThreadAdminServlet")
public class PostThreadAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostThreadAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String topic = request.getParameter("topic");
		String detail = request.getParameter("detail");
		int threadGrade = Integer.valueOf(request.getParameter("threadGrade"));
		Date date = new Date();
		Timestamp time = new Timestamp(date.getTime());
		String userName = (String) request.getSession().getAttribute("userName");
		//String userName = "admin";
		Threads threads = new Threads(topic, userName, time, detail, threadGrade);
		ThreadDao td = new ThreadDao();
		td.addAdminThread(threads);
		response.sendRedirect("QueryThreadAdminServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
