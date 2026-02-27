package br.unesp.rc.MSResidentG1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.unesp.rc.MSResidentG1.entity.Resident;
import br.unesp.rc.MSResidentG1.utils.InstanceGenerator;

@SpringBootApplication
public class MsResidentG1Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(MsResidentG1Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		Resident entity = InstanceGenerator.getResident("123.456.789-00", "bremedmil1");

		System.out.println("\n" + entity + "\n");
	}
}
