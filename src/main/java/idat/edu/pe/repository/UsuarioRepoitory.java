package idat.edu.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import idat.edu.pe.model.Usuariocliente;

@Repository
public interface UsuarioRepoitory extends JpaRepository<Usuariocliente, Integer>{

}
