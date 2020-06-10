package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.UserInfo;

public class Pass {
	//①DBアクセスに必要な情報の定数を定義

		//接続先DBのURL(jdbc:mysql://[ホスト名orIPアドレス]:[ポート番号]/[データベース名]?serverTimezone=JST)
		private static final String url = "jdbc:mysql://localhost:3306/gw?serverTimezone=JST";
		//ユーザ
		private static final String user = "root";
		//パスワード
		private static final String pw = "kazu1313";

		//1件のみ検索するSELECT文を実行するメソッドのサンプル
		//引数は検索する学生のID
		public static  UserInfo serchUser(String a,String b){
			//②アクセスに必要な変数の初期化
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try{
				//③JDBCドライバをロードする
				Class.forName("com.mysql.cj.jdbc.Driver");

				//④データベースと接続する(コネクションを取ってくる)
				//第1引数→接続先URL
				//第2引数→ユーザ名
				//第3引数→パスワード
				con = DriverManager.getConnection(url, user, pw);

				//⑤SQL文の元を作成する
				String sql = "SELECT * FROM pass WHERE  id= ? and pw = ?";

				//⑥SQLを実行するための準備(構文解析)
				pstmt = con.prepareStatement(sql);

				//⑦プレースホルダに値を設定
				pstmt.setString(1, a);
				pstmt.setString(2, b);
				//⑧SQLを実行し、DBから結果を受領する
				//※更新系SQLとはメソッドが違うので注意！！更新系はexecuteUpdate()
				rs = pstmt.executeQuery();

				//⑨参照先のカーソルを移動する
				rs.next();

				//⑩ResultSetからデータを取り出す
				//get～で取り出す際の型を指定する
				//引数は検索結果のカラム名を指定する(SQLのASで変更している場合は注意)
				String id = rs.getString("id");
				String pw = rs.getString("pw");

				//⑪返却用Beanのインスタンスを生成しreturnする
				UserInfo result = new UserInfo(id,pw);
				return result;

			}  catch (SQLException e){
				System.out.println("DBアクセスに失敗しました。");
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				System.out.println("DBアクセスに失敗しました。");
				e.printStackTrace();
			} finally {
				//⑫DBとの切断処理
				try {
					//nullかチェックしないとNullPointerExceptionが
					//発生してしまうためチェックしている。
					if( pstmt != null){
						pstmt.close();
					}
				} catch(SQLException e){
					System.out.println("DB切断時にエラーが発生しました。");
					e.printStackTrace();
				}

				try {
					if( con != null){
						con.close();
					}
				} catch (SQLException e){
					System.out.println("DB切断時にエラーが発生しました。");
					e.printStackTrace();
				}
			}

			//途中でExceptionが発生した時はnullを返す。
			return null;
		}
}


