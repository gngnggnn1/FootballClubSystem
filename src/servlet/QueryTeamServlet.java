package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TeamDao;
import entity.Team;

/**
 * Servlet implementation class QueryTeamServlet
 */
@WebServlet("/QueryTeamServlet")
public class QueryTeamServlet extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		TeamDao td = new TeamDao();
		List<Team> teamList = new ArrayList<Team>();
		teamList = td.queryTeam();
		if(teamList.size() == 0) {
			response.sendRedirect("NoSuchData.jsp");
		}
		else {
			request.setAttribute("teamList", teamList);
			request.getRequestDispatcher("teams.jsp").forward(request, response);
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
