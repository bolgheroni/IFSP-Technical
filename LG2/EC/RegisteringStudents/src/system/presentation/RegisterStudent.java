package system.presentation;
import java.sql.SQLException;
import java.util.Scanner;
import system.business.Student;
import system.data.StudentDAO;
import system.service.StudentFunctional;
public class RegisterStudent {
//	private StudentFunctional studentService;
	private StudentDAO studentDAO;
	private Scanner scanner;
	public RegisterStudent(StudentFunctional studentService) {
//		this.studentService = studentService;
		this.studentDAO = new StudentDAO();
		scanner = new Scanner(System.in);
	}
	public void register() throws ClassNotFoundException, SQLException {
		System.out.print("Insert your enrollment: ");
		String $1 = scanner.nextLine();
		System.out.print("Insert your name: ");
		String $2 = scanner.nextLine();
		System.out.print("Insert your e-mail: ");
		String $3 = scanner.nextLine();
		System.out.print("Insert your telephone: ");
		String $4 = scanner.nextLine();
		//
//		studentService.register($1, $2, $3, $4);
		studentDAO.register(new Student($1, $2, $3, $4));
	}
}
