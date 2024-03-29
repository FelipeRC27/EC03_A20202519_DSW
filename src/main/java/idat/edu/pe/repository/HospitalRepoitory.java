package idat.edu.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import idat.edu.pe.model.Hospital;

@Repository
public interface HospitalRepoitory extends JpaRepository<Hospital, Integer>{

}
