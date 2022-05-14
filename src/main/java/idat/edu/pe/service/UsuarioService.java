package idat.edu.pe.service;

import java.util.List;

import idat.edu.pe.dto.UsuarioRequestDTO;
import idat.edu.pe.dto.UsuarioResponseDTO;

public interface UsuarioService {

	public void guardarUsuario(UsuarioRequestDTO u);
	public void eliminarUsuario(Integer id);
	public void editarUsuario(UsuarioRequestDTO u);
	public List<UsuarioResponseDTO> listarUsuario();
	public UsuarioResponseDTO usuarioById(Integer id);
}
