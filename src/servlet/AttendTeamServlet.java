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
 * Servlet implementation class AttendTeamServlet
 */
@WebServlet("/AttendTeamServlet")
public class AttendTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AttendTeamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		Team team = (Team)request.getSession().getAttribute("chosenTeam");
		int teamID = team.getTeamID();
		String userName = (String) request.getSession().getAttribute("userName");
		//String userName = "lgn";
		UserDao ud = new UserDao();
		String userRealName = ud.getRealNameByUserName(userName);
		TeamDao td = new TeamDao();
		td.sendJoinTeamApplication(teamID, userName, userRealName);
		response.sendRedirect("https://www.dongqiudi.com");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
