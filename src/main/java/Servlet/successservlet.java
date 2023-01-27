package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.dao;
import dto.Cd;

/**
 * Servlet implementation class quizquiz
 */
@WebServlet("/successservlet")
public class successservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public successservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String composer = request.getParameter("composer");
		String onsale = request.getParameter("onsale");
		String isbnStr = request.getParameter("isbn");
		
		int isbn = Integer.parseInt(isbnStr);
		
	Cd cd = new Cd(title,composer,onsale,isbn);
	
	int result = dao.cd(cd);
	
	String view = "";
	if(result == 1) {
		 view = "WEB-INF/view/successs.jsp";
	} else {
		view = "WEB-INF/view/fail.jsp";
	}
	RequestDispatcher dispatcher = request.getRequestDispatcher(view);
	dispatcher.forward(request, response);
	}
	
		
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
