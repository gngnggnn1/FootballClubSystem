package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseInfDao;
import dao.FieldDao;
import dao.FieldReserveDao;
import dao.TeamDao;
import dao.ThreadDao;
import dao.UserDao;
import entity.Field;
import entity.Team;
import entity.Threads;

/**
 * Servlet implementation class ToHomePageServlet
 */
@WebServlet("/ToHomePageServlet")
public class ToHomePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToHomePageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		FieldDao fd = new FieldDao();
		List<Field> fieldList = new ArrayList<Field>();
		fieldList = fd.queryField();
		request.setAttribute("fieldList", fieldList);
		TeamDao td = new TeamDao();
		List<Team> teamList = new ArrayList<Team>();
		teamList = td.queryTeam();
		request.setAttribute("teamList", teamList);
		ThreadDao thd = new ThreadDao();
		List<Threads> list = new ArrayList<Threads>();
		list = thd.queryThreads();
		request.setAttribute("threadList", list);
		UserDao ud = new UserDao();
		int userSum = ud.userSum();
		request.setAttribute("userSum", userSum);
		int playerSum = ud.playerSum();
		request.setAttribute("playerSum", playerSum);
		FieldReserveDao frd = new FieldReserveDao();
		int fieldReserveSum = frd.fieldReserveSum();
		request.setAttribute("fieldReserveSum", fieldReserveSum);
		int teamSum = td.teamSum();
		request.setAttribute("teamSum", teamSum);
		CourseInfDao cid = new CourseInfDao();
		int courseInfSum = cid.courseInfSum();
		request.setAttribute("courseInfSum", courseInfSum);
		request.getRequestDispatcher("homePageAdmin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
