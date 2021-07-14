package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.EmpDAO;
import common.Employee;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RegisterServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String eid = request.getParameter("eid");
		String last_name = request.getParameter("last_name");
		String em = request.getParameter("email");
		String hd = request.getParameter("hire_date");
		String first_name = request.getParameter("first_name");
		EmpDAO dao = new EmpDAO();
		Employee emp = new Employee();
		emp.setEmployeeId(Integer.parseInt(eid));
		emp.setLastName(last_name);
		emp.setEmail(em);
		emp.setHireDate(hd);
		emp.setFirstName(first_name);
		
//		dao.insertEmp(emp);
		
		System.out.println(eid+','+last_name+','+em+','+hd+','+first_name);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
