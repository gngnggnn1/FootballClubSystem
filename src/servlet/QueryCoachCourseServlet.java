package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDao;
import entity.Course;

/**
 * Servlet implementation class QueryCoachCourse
 */
@WebServlet("/QueryCoachCourseServlet")
public class QueryCoachCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryCoachCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		CourseDao fd = new CourseDao();
		String coachUserName = (String) request.getSession().getAttribute("userName");
		List<Course> courseList = new ArrayList<Course>();
		courseList = fd.queryCoachCourse(coachUserName);
		if(courseList.size() == 0) {
			response.sendRedirect("NoSuchData.jsp");
		}
		else{
			request.setAttribute("courseList", courseList);
			request.getRequestDispatcher("coachCourse.jsp").forward(request, response);
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
