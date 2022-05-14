package idat.edu.pe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.dto.HospitalRequestDTO;
import idat.edu.pe.dto.HospitalResponseDTO;
import idat.edu.pe.model.Hospital;
import idat.edu.pe.repository.HospitalRepoitory;

@Service
public class HospitalserviceImpl implements HospitalService {

	
	@Autowired
	private HospitalRepoitory repository;
	
	@Override
	public void guardarHospital(HospitalRequestDTO h) {
		Hospital hospital = new Hospital();
		
		hospital.setIdhospital(h.getIdhospitalRq());
		hospital.setNombre(h.getNombreRq());
		hospital.setDescripcion(h.getDescripcionRq());
		hospital.setDistrito(h.getDistritoRq());
		
		repository.save(hospital);

	}

	@Override
	public void eliminarHospital(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public void editarHopital(HospitalRequestDTO h) {
		
		Hospital hospital = new Hospital();
		
		hospital.setIdhospital(h.getIdhospitalRq());
		hospital.setNombre(h.getNombreRq());
		hospital.setDescripcion(h.getDescripcionRq());
		hospital.setDistrito(h.getDistritoRq());
		
		repository.saveAndFlush(hospital);

	}

	@Override
	public List<HospitalResponseDTO> listarHospital() {
		List<Hospital> hospitales = repository.findAll();
		
		List<HospitalResponseDTO> dto = new ArrayList<HospitalResponseDTO>();
		HospitalResponseDTO hospitalDto = null;
		
		for (Hospital hospital : hospitales) {
			hospitalDto = new HospitalResponseDTO();
			
			hospitalDto.setIdhospitalRp(hospital.getIdhospital());
			hospitalDto.setNombreRp(hospital.getNombre());
			hospitalDto.setDescripcionRp(hospital.getDescripcion());
			hospitalDto.setDistritoRp(hospital.getDistrito());
			
			dto.add(hospitalDto);
		}
		return dto;
	}

	@Override
	public HospitalResponseDTO hospitalById(Integer id) {
		
		Hospital hospital = repository.findById(id).orElse(null);
		HospitalResponseDTO hospitalDto = new HospitalResponseDTO();
		
		hospitalDto = new HospitalResponseDTO();		
		hospitalDto.setIdhospitalRp(hospital.getIdhospital());
		hospitalDto.setNombreRp(hospital.getNombre());
		hospitalDto.setDescripcionRp(hospital.getDescripcion());
		hospitalDto.setDistritoRp(hospital.getDistrito());
		
		return hospitalDto;
	}

}
