package br.unesp.rc.MSCondominiumG1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.unesp.rc.MSCondominiumG1.entity.Condominium;
import br.unesp.rc.MSCondominiumG1.entity.CondominiumType;
import br.unesp.rc.MSCondominiumG1.repository.CondominiumRepository;
import br.unesp.rc.MSCondominiumG1.utils.InstanceGenerator;

@SpringBootApplication
public class MsCondominiumG1Application implements CommandLineRunner {

    @Autowired
    private CondominiumRepository condominiumRepository;

    public static void main(String[] args) {
        SpringApplication.run(MsCondominiumG1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Condominium entity = InstanceGenerator.getCondominium("Central Park Tower", CondominiumType.APARTMENT);


        entity.getAreas().forEach(area -> area.setCondominium(entity));
        entity.getUnits().forEach(unit -> unit.setCondominium(entity));

        condominiumRepository.save(entity); 
        System.out.println("\nCondomínio salvo com sucesso.\n");
    }

}
