package br.unesp.rc.MSResidentG1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unesp.rc.MSResidentG1.entity.Resident;

public interface ResidentRepository extends JpaRepository<Resident, Long> {

    Resident findByCpf(String cpf);
}
