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
import entity.User;;

/**
 * Servlet implementation class AddTeamServlet
 */
@WebServlet("/AddTeamServlet")
public class AddTeamServlet extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		// TODO Auto-generated method stub
		String teamName = request.getParameter("teamName");
		String description = request.getParameter("description");
		int teamGrade = Integer.valueOf(request.getParameter("teamGrade"));
		String captainName = request.getParameter("captainName");
		String contact = request.getParameter("contact");
		String userName = request.getParameter("teamUserName");
		String password = request.getParameter("teamPassword");
		
		Team team = new Team(teamName, teamGrade, captainName, contact, description);
		TeamDao td = new TeamDao();
		td.addTeam(team);
		int teamID = td.getTeamID();
		
		UserDao ud = new UserDao();
		User user = new User(userName, password, teamID);
		ud.teamRegister(user);
		response.sendRedirect("QueryTeamServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
