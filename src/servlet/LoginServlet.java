package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TeamDao;
import dao.UserDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		UserDao ud = new UserDao();
		TeamDao td = new TeamDao();
		int result = ud.login(userName, password);
		if(result == 1) {
			request.setAttribute("userName", userName);
			request.getRequestDispatcher("indexAdmin.jsp").forward(request, response);
		}
		else if(result == 2) {
			request.setAttribute("userName", userName);
			request.getRequestDispatcher("indexUser.jsp").forward(request, response);
		}
		else if(result == 3) {
		    request.setAttribute("teamID", td.getTeamIDByUserName(userName));
		    request.setAttribute("userName", userName);
		    request.getRequestDispatcher("indexTeam.jsp").forward(request, response);
		}
		else if(result == 4) {
			request.setAttribute("userName", userName);
			request.getRequestDispatcher("indexCoach.jsp").forward(request, response);
		}
		else response.sendRedirect("reLogin.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
