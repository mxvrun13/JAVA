package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import common.EmpDAO;
import common.Employee;


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeleteServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String eid = request.getParameter("eid");
				
		EmpDAO dao = new EmpDAO();
		Employee emp = dao.selectEmp(eid);
		dao.deleteEmp(emp);
		
		Gson gson = new GsonBuilder().create();
//		gson.toJson(emp);
		
		PrintWriter out = response.getWriter();
		out.println(gson.toJson(emp));
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
