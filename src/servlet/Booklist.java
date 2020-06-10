package servlet;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class Booklist
 */
@WebServlet("/Booklist")
public class Booklist extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Booklist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//処理の始めにログイン状態のチェックを行う。
		HttpSession session = request.getSession();
		UserInfo usr = (UserInfo)session.getAttribute("usr");

		if(usr == null){
			//セッションの中身がnullであれば不正アクセスと判断し
			//ログイン画面へリダイレクトする。
			String view = "http://localhost:8080/gw?error=1";
			response.sendRedirect(view);

		} else {
			//そうでなければ、メニュー画面へフォワードする。

			ArrayList<BookInfo> list = Library.selectAllBook();
			ArrayList<BookInfo> list2 = new ArrayList<BookInfo>();
			for( BookInfo s : list){
			list2.add( new BookInfo(s.getBookid(),s.getBookname(),s.getAuthor(),s.getCompany(),s.getLore()) );
			}
			request.setAttribute("list", list2);

			String view = "/WEB-INF/view/list.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
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
