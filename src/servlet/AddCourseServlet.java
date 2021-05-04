package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDao;
import dao.UserDao;
import entity.Course;

/**
 * Servlet implementation class AddCourseServlet
 */
@WebServlet("/AddCourseServlet")
public class AddCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String courseName = request.getParameter("courseName");
		String courseGrade = request.getParameter("courseGrade");
		String time = request.getParameter("time");
		String description = request.getParameter("description");
		String userName = (String) request.getSession().getAttribute("userName");
		UserDao ud = new UserDao();
		String coachName = ud.getRealNameByUserName(userName);
		Course course = new Course(courseName, courseGrade, coachName, userName, time, description);
		CourseDao cd = new CourseDao();
		cd.addCourse(course);
		response.sendRedirect("QueryCoachCourseServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
