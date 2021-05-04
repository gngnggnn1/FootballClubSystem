package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MatchDao;
import entity.Match;

/**
 * Servlet implementation class ModifyMatchServlet
 */
@WebServlet("/ModifyMatchServlet")
public class ModifyMatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyMatchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int matchID = (int) request.getSession().getAttribute("matchID");
		String score = request.getParameter("score");
		String matchDescription = request.getParameter("matchDescription");
		Match match = new Match(matchID, score, matchDescription);
		MatchDao md = new MatchDao();
		md.updateMatch(match);
		response.sendRedirect("QueryFinishedMatchServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
