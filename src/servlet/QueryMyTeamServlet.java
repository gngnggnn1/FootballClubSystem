package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TeamDao;
import dao.UserDao;
import entity.Team;

/**
 * Servlet implementation class QueryMyTeamServlet
 */
@WebServlet("/QueryMyTeamServlet")
public class QueryMyTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryMyTeamServlet() {
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
		UserDao ud = new UserDao();
		int teamID = ud.getTeamIDByUserName(userName);
		TeamDao td = new TeamDao();
		Team team = td.getTeamByID(teamID);
		request.setAttribute("myTeam", team);
		request.getRequestDispatcher("myTeam.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
