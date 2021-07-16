package comment;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/CommentsServlet")
public class CommentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CommentsServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 한글 처리
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");

		PrintWriter out = response.getWriter();
		String cmd = request.getParameter("cmd"); // 주소?cmd=~ 입력 시
		if (cmd == null) { // 요청 정보가 없을 시 에러 대신 해당 문구 출력
			StringBuffer sb = new StringBuffer();
			sb.append("<result>"); // 문장 추가 메소드, xml 사용
			sb.append("<code>error</code>");
			sb.append("<data>");
			sb.append("cmd null");
			sb.append("</data>");
			sb.append("</result>");
			out.print(sb.toString());
			// {"code":"error", "data":"cmd null"} = json
		} else if (cmd.equals("selectAll")) { // 전체 조회
			List<HashMap<String, Object>> list = CommentsDAO.getInstance().selectAll();
			out.print(selectAll(list));
		} else if (cmd.equals("insert")) { // 전체 조회
			Comments comment = new Comments();
			comment.setContent(request.getParameter("content"));
			comment.setName(request.getParameter("name"));
			HashMap<String, Object> map = CommentsDAO.getInstance().insert(comment);
			out.println(toXML(map));
		}
	}
	
	private String toXML(HashMap<String, Object> map) {
		StringBuilder sb = new StringBuilder();
		sb.append("<result>");
		sb.append("<code>");
		sb.append(map.get("code"));
		sb.append("</code>");
		sb.append("<data>");
		Gson gson = new GsonBuilder().create();
		sb.append(gson.toJson(map));
		sb.append("</data>");
		sb.append("</result>");
		
		return sb.toString();
	}

	private String selectAll(List<HashMap<String, Object>> list) {
		StringBuffer sb = new StringBuffer();
		sb.append("<result>");
		sb.append("<code>success</code>");
		sb.append("<data>");
		sb.append("[");
		for (int i = 0; i < list.size(); i++) {
			HashMap<String, Object> map = list.get(i);
			sb.append("{");
			sb.append("id:" + map.get("id"));
			sb.append(", name:'" + map.get("name"));
			sb.append("', content:'" + map.get("content"));
			sb.append("'}");
			if (i != list.size() - 1) {
				sb.append(",");
			}
		}
		sb.append("]");
		sb.append("</data>");
		sb.append("</result>");

		return sb.toString();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
