package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.JoinTeamApplicationDao;
import dao.UserDao;
import entity.JoinTeamApplication;
import entity.User;

/**
 * Servlet implementation class QueryJoinTeamApplicationServlet
 */
@WebServlet("/QueryJoinTeamApplicationServlet")
public class QueryJoinTeamApplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryJoinTeamApplicationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		JoinTeamApplicationDao jtad = new JoinTeamApplicationDao();
		List<JoinTeamApplication> list = new ArrayList<JoinTeamApplication>();
		int teamID = (int) request.getSession().getAttribute("teamID");
		list = jtad.queryJoinTeamApplication(teamID);
		if(list.size() == 0) {
			response.sendRedirect("NoSuchData.jsp");
		}
		else {
			List<User> userList = new ArrayList<User>();
			UserDao ud = new UserDao();
			for(int i = 0; i < list.size(); i++) {
				userList.add(ud.queryUserByUserName(list.get(i).getUserName()));
			}
			request.setAttribute("userList", userList);
			request.getRequestDispatcher("joinTeamApplication.jsp").forward(request, response);
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
