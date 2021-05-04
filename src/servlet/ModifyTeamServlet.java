package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TeamDao;
import entity.Team;

/**
 * Servlet implementation class ModifyTeamServlet
 */
@WebServlet("/ModifyTeamServlet")
public class ModifyTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyTeamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int teamID = (Integer)request.getSession().getAttribute("teamID");
		String teamName = request.getParameter("teamName");
		int teamGrade = Integer.valueOf(request.getParameter("teamGrade"));
		String captainName = request.getParameter("captainName");
		String contact = request.getParameter("contact");
		String description = request.getParameter("description");
		Team team = new Team(teamID, teamName, teamGrade, captainName, contact, description);
		TeamDao td = new TeamDao();
		td.updateTeam(team);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
