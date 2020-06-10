package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.BookInfo;
import bean.UserInfo;
import dao.Library;

/**
 * Servlet implementation class Bookreturn
 */
@WebServlet("/Bookreturn")
public class Bookreturn extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bookreturn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		//ログインの結果のチェック
		HttpSession session = request.getSession();
		UserInfo usr = (UserInfo)session.getAttribute("usr");

		if(usr == null){
			//セッションの中身がnullであれば不正アクセスと判断し
			//ログイン画面へリダイレクトする。
			String view = "http://localhost:8080/gw?error=1";
			response.sendRedirect(view);

		} else {

			String bookid = request.getParameter("bookid");
			String lore = "貸出可";
			BookInfo book = new BookInfo(lore,bookid);
			Library.updatebook(book);

			String view = "/Booklist";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
