package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MatchDao;
import entity.Match;

/**
 * Servlet implementation class QueryFinishedMatchServlet
 */
@WebServlet("/QueryFinishedMatchServlet")
public class QueryFinishedMatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryFinishedMatchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		MatchDao md = new MatchDao();
		List<Match> matchList = new ArrayList<Match>();
		matchList = md.queryFinishedMatch();
		if(matchList.size() == 0) {
			response.sendRedirect("NoSuchData.jsp");
		}
		else {
			request.setAttribute("finishedMatchList", matchList);
			request.getRequestDispatcher("finishedMatch.jsp").forward(request, response);
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
