package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CoachDao;
import dao.UserDao;
import entity.Coach;
import entity.User;

/**
 * Servlet implementation class AddCoachServlet
 */
@WebServlet("/AddCoachServlet")
public class AddCoachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCoachServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String coachName = request.getParameter("coachName");
		String grade = request.getParameter("coachGrade");
		int isFullTime = Integer.valueOf(request.getParameter("isFullTime"));
		String userName = request.getParameter("coachUserName");
		String password = request.getParameter("coachPassword");
		Coach coach = new Coach(userName, grade, isFullTime, coachName);
		User user = new User(userName, password, coachName);
		CoachDao cd = new CoachDao();
		cd.addCoach(coach);
		UserDao ud = new UserDao();
		ud.coachRegister(user);
		response.sendRedirect("QueryUserServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
