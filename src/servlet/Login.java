package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserInfo;
import dao.Pass;
import util.Pw;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		session.setAttribute("id", id);
		//pwhash
		String hashedStr = Pw.getSafetyPassword(pw, id);
		UserInfo usr = Pass.serchUser(id,hashedStr);

		//ログインの結果のチェック
		if(usr == null){
			String view = "http://localhost:8080/gw?error=1";
			response.sendRedirect(view);

		} else {

			//ログイン成功と判断し、セッションスコープにユーザ情報を格納
			session.setAttribute("usr", usr);

			//メニュー画面へフォワードする。
			String view = "/WEB-INF/view/menu.jsp";
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
