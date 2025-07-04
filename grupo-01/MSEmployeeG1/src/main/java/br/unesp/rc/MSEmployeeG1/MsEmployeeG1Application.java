package br.unesp.rc.MSEmployeeG1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.unesp.rc.MSEmployeeG1.entity.Employee;
import br.unesp.rc.MSEmployeeG1.utils.InstanceGenerator;

@SpringBootApplication
public class MsEmployeeG1Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MsEmployeeG1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		Employee entity = InstanceGenerator.getEmployee("123.456.789-00", "bremedmil1");
		System.out.println("\n" + entity + "\n");
		
	}

}
