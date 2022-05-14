package idat.edu.pe.service;

import java.util.List;

import idat.edu.pe.dto.HospitalRequestDTO;
import idat.edu.pe.dto.HospitalResponseDTO;

public interface HospitalService {

	public void guardarHospital(HospitalRequestDTO h);
	public void eliminarHospital(Integer id);
	public void editarHopital(HospitalRequestDTO h);
	public List<HospitalResponseDTO> listarHospital();
	public HospitalResponseDTO hospitalById(Integer id);
	
}
