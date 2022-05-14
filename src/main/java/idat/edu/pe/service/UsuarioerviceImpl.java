package idat.edu.pe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.dto.UsuarioRequestDTO;
import idat.edu.pe.dto.UsuarioResponseDTO;
import idat.edu.pe.model.Usuariocliente;
import idat.edu.pe.repository.UsuarioRepoitory;

@Service
public class UsuarioerviceImpl implements UsuarioService {

	
	@Autowired
	private UsuarioRepoitory repository;	
	
	@Override
	public void guardarUsuario(UsuarioRequestDTO u) {

		Usuariocliente usuario = new Usuariocliente();
		usuario.setIdusuario(u.getIdusuarioRq());
		usuario.setUsuario(u.getUsuarioRq());
		usuario.setPassword(u.getPasswordRq());
		usuario.setRol(u.getRolRq());
		repository.save(usuario);
	}

	@Override
	public void eliminarUsuario(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public void editarUsuario(UsuarioRequestDTO u) {
		
		Usuariocliente usuario = new Usuariocliente();
		
		usuario.setIdusuario(u.getIdusuarioRq());
		usuario.setUsuario(u.getUsuarioRq());
		usuario.setPassword(u.getPasswordRq());
		usuario.setRol(u.getRolRq());
		
		repository.saveAndFlush(usuario);

	}

	@Override
	public List<UsuarioResponseDTO> listarUsuario() {
		
		List<Usuariocliente> usuarios = repository.findAll();
		
		List<UsuarioResponseDTO> dto = new ArrayList<UsuarioResponseDTO>();
		UsuarioResponseDTO usuarioDto = null;
		
		for (Usuariocliente usuario : usuarios) {
			usuarioDto = new UsuarioResponseDTO();
			
			usuarioDto.setIdusuarioRp(usuario.getIdusuario());
			usuarioDto.setUsuarioRp(usuario.getUsuario());
			usuarioDto.setPasswordRp(usuario.getPassword());
			usuarioDto.setRolRp(usuario.getRol());
			
			dto.add(usuarioDto);
		}
		return dto;
	}

	@Override
	public UsuarioResponseDTO usuarioById(Integer id) {

		Usuariocliente usuario = repository.findById(id).orElse(null);
		UsuarioResponseDTO usuarioDto = new UsuarioResponseDTO();
		
		usuarioDto = new UsuarioResponseDTO();		
		usuarioDto.setIdusuarioRp(usuario.getIdusuario());
		usuarioDto.setUsuarioRp(usuario.getUsuario());
		usuarioDto.setPasswordRp(usuario.getPassword());
		usuarioDto.setRolRp(usuario.getRol());
		
		return usuarioDto;
		
	}

}
