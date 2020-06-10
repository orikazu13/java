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
 * Servlet implementation class SerchResultServlet
 */
@WebServlet("/result")
public class SerchResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SerchResultServlet() {
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
			//formに入力された検索キー(パラメータ)を取得
			request.setCharacterEncoding("UTF-8");
			String name = request.getParameter("bookname");

			//データベースから値を取得
			BookInfo result = Library.selectBook(name);

			//取得した値をリクエストスコープへ保存
			if(result == null){
				String view = "/WEB-INF/view/error.jsp";
				RequestDispatcher dispatcher = request.getRequestDispatcher(view);
				dispatcher.forward(request, response);

			}else{
				request.setAttribute("book", result);
			}

			//そうでなければ、メニュー画面へフォワードする。
			String view = "/WEB-INF/view/result.jsp";
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
