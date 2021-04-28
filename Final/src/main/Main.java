package main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import controller.EmployeeController;

public class Main {
	private static final String CONFIG_LOCATION = "beans.xml";
	public static void main(String[] args) {
			ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);
			EmployeeController controller = context.getBean("controller", EmployeeController.class);
			controller.handleRequest();
			context.close();
	}
}