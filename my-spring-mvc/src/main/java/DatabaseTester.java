

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.mycompany.mvc.domain.Employees;
import com.mycompany.mvc.service.EmployeesService;

public class DatabaseTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:app-context.xml");
		ctx.refresh();
		
		System.out.println("App context initialized successfully");
		
		EmployeesService employeesService = ctx.getBean("employeesService", EmployeesService.class);
		
		List<Employees> employees = employeesService.findAll();
		
		for (Employees employee: employees) {
			System.out.println(employee);
		}
		
//		Employees employee = employeesService.findById(101);
//		System.out.println(employee);

	}

}
