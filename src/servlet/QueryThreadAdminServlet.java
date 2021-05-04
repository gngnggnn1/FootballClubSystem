package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ThreadDao;
import entity.Threads;

/**
 * Servlet implementation class QueryThreadServlet
 */
@WebServlet("/QueryThreadAdminServlet")
public class QueryThreadAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryThreadAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		ThreadDao td = new ThreadDao();
		List<Threads> list = new ArrayList<Threads>();
		list = td.queryThreads();
		request.setAttribute("threadList", list);
		List<Threads> adminList = new ArrayList<Threads>();
		adminList = td.queryAdminThreads();
		request.setAttribute("adminThreadList", adminList);
		int threadSum = td.threadSum();
		request.setAttribute("threadSum", threadSum);
		int adminThreadSum = td.adminThreadSum();
		request.setAttribute("adminThreadSum", adminThreadSum);
		request.getRequestDispatcher("forumAdmin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}