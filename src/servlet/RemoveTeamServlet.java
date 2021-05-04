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
 * Servlet implementation class RemoveTeamServlet
 */
@WebServlet("/RemoveTeamServlet")
public class RemoveTeamServlet extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		TeamDao td = new TeamDao();
		int teamID = Integer.valueOf(request.getParameter("teamID"));
		td.removeTeam(teamID);
		UserDao ud = new UserDao();
		ud.removeTeamUser(teamID);
		ud.setUserTeamAfterRemoveTeam(teamID);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
