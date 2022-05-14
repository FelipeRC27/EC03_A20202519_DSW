package idat.edu.pe.service;

import java.util.List;

import idat.edu.pe.dto.ClienteRequestDTO;
import idat.edu.pe.dto.ClienteResponseDTO;

public interface ClienteService {
	
	public void guardarCliente(ClienteRequestDTO c);
	public void eliminarCliente(Integer id);
	public void editarCliente(ClienteRequestDTO c);
	public List<ClienteResponseDTO> listarCliente();
	public ClienteResponseDTO clienteById(Integer id);

}
