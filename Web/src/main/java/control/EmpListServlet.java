package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.EmpDAO;
import common.Employee;


@WebServlet("/EmpListServlet")
public class EmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EmpListServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
//		out.println("{\"id\":1, \"first_name\":\"Hong\", \"last_name\" : \"GilDong\"}"); // {"id":1, "first_name":"Hong", "last_name" : "GilDong", "email" : "sdf", "hire_date" : "sdfsf"}
		EmpDAO dao = new EmpDAO();
		out.println("[");
		for (Employee emp : dao.getEmpList()) {
			out.println("{\"id\":"+emp.getEmployeeId()+", \"first_name\":\""+emp.getFirstName()+"\", \"last_name\" : \""+emp.getLastName()+"\", \"email\" : \""+emp.getEmail()+"\", \"hire_date\" : \""+emp.getHireDate()+"\"}");
		}
		out.println("]");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
