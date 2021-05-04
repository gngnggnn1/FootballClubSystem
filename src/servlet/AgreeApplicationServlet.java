package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.JoinTeamApplicationDao;

/**
 * Servlet implementation class AgreeApplicationServlet
 */
@WebServlet("/AgreeApplicationServlet")
public class AgreeApplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgreeApplicationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String chosenUserName = (String) request.getSession().getAttribute("chosenUserName");
		JoinTeamApplicationDao jtad = new JoinTeamApplicationDao();
		int teamID = (int) request.getSession().getAttribute("teamID");
		//int teamID = 24;
		jtad.updateApplication(chosenUserName);
		jtad.updateUserTeam(chosenUserName, teamID);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
