package idat.edu.pe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.dto.ClienteRequestDTO;
import idat.edu.pe.dto.ClienteResponseDTO;
import idat.edu.pe.model.Cliente;
import idat.edu.pe.repository.ClienteRepoitory;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepoitory repository;
	
	
	@Override
	public void guardarCliente(ClienteRequestDTO c) {
		Cliente cliente = new Cliente();
		cliente.setIdcliente(c.getIdclienteRq());		
		cliente.setNombre(c.getNombreRq());
		cliente.setCelular(c.getCelularRq());
		repository.save(cliente);
	}

	@Override
	public void eliminarCliente(Integer id) {
		repository.deleteById(id);

	}

	@Override
	public void editarCliente(ClienteRequestDTO c) {
		Cliente cliente = new Cliente();
		
		cliente.setIdcliente(c.getIdclienteRq());
		cliente.setNombre(c.getNombreRq());
		cliente.setCelular(c.getCelularRq());
		
		repository.saveAndFlush(cliente);

	}

	@Override
	public List<ClienteResponseDTO> listarCliente() {
		List<Cliente> clientes = repository.findAll();
		
		List<ClienteResponseDTO> dto = new ArrayList<ClienteResponseDTO>();
		ClienteResponseDTO clienteDto = null;
		
		for (Cliente cliente:clientes) {
			clienteDto = new ClienteResponseDTO();
			
			clienteDto.setIdclienteRp(cliente.getIdcliente());
			clienteDto.setNombreRp(cliente.getNombre());
			clienteDto.setCelularRp(cliente.getCelular());
			
			dto.add(clienteDto);			
		}
		return dto;
	}

	@Override
	public ClienteResponseDTO clienteById(Integer id) {

		Cliente cliente= repository.findById(id).orElse(null);
		ClienteResponseDTO clienteDto = new ClienteResponseDTO();
		
		clienteDto = new ClienteResponseDTO();
		clienteDto.setIdclienteRp(cliente.getIdcliente());
		clienteDto.setNombreRp(cliente.getNombre());
		clienteDto.setCelularRp(cliente.getCelular());
		
		return clienteDto;
		
	}

}
