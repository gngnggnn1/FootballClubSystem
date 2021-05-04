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
import dao.CourseInfDao;
import entity.Course;
import entity.CourseInf;

/**
 * Servlet implementation class QueryUserCourse
 */
@WebServlet("/QueryUserCourseServlet")
public class QueryUserCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryUserCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		CourseInfDao fd = new CourseInfDao();
		String userName = (String) request.getSession().getAttribute("userName");
		List<CourseInf> courseList = new ArrayList<CourseInf>();
		courseList = fd.queryMyCourseInf(userName);
		if(courseList.size() == 0) {
			response.sendRedirect("NoSuchData.jsp");
		}
		else {
			request.setAttribute("courseList", courseList);
			request.getRequestDispatcher("userCourse.jsp").forward(request, response);
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
