package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import common.EmpDAO;
import common.Employee;


@WebServlet("/EmpJsonServ")
public class EmpJsonServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EmpJsonServ() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// { "data": [ [], [], [] ] }  // empl_demo
		PrintWriter out = response.getWriter();  // 페이지 출력
		Gson gson = new Gson(); 
		new GsonBuilder().create();
		
		List<HashMap<String, Object>> list = EmpDAO.getInstance().selectAll();
		outprint(selectAll(list));
//		EmpDAO dao = new EmpDAO();
//		List<Employee> list = dao.getEmpList();
//		JsonArray oArr = new JsonArray();
//		for (Employee emp : list) {
//			JsonArray iArr = new JsonArray();
//			iArr.add(emp.getEmployeeId());
//			iArr.add(emp.getFirstName());
//			iArr.add(emp.getLastName());
//			iArr.add(emp.getEmail());
//			iArr.add(emp.getHireDate());
//			iArr.add(emp.getSalary());
//			
//			oArr.add(iArr);
//		}
//		JsonObject obj = new JsonObject();
//		obj.add("data", oArr);
//		
//		out.println(gson.toJson(obj));
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
