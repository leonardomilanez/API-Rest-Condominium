package br.unesp.rc.MSCondominiumG1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.unesp.rc.MSCondominiumG1.entity.Condominium;
import br.unesp.rc.MSCondominiumG1.entity.CondominiumType;
import br.unesp.rc.MSCondominiumG1.utils.InstanceGenerator;

@SpringBootApplication
public class MsCondominiumG1Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MsCondominiumG1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Condominium entity = InstanceGenerator.getCondominium("Condomínio Central Park", CondominiumType.APARTMENT);
        System.out.println("\n" + entity + "\n");
    }

}
