package project.bankapp.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.bankapp.bank.model.Agency;
import project.bankapp.bank.repository.AgencyRepository;
import project.bankapp.bank.dto.AgencyDTO;

import java.util.List;
import java.util.Optional;

@Service
public class AgencyService {

    private final AgencyRepository agencyRepository;

    @Autowired
    public AgencyService(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    public Agency createAgency(Agency agency) {
        return agencyRepository.save(agency);
    }

    public List<Agency> listAgencies() {
        return agencyRepository.findAll();
    }

    public Optional<Agency> editAgency(Long id, Agency agencyDetails) {
        return agencyRepository.findById(id).map(agency -> {
            agency.setName(agencyDetails.getName());
            agency.setCnpj(agencyDetails.getCnpj());
            agency.setAddress(agencyDetails.getAddress());
            agency.setPhone(agencyDetails.getPhone());
            agency.setDigit(agencyDetails.getDigit());
            return agencyRepository.save(agency);
        });
    }

    public void deleteAgency(Long id) {
        agencyRepository.deleteById(id);
    }

    public Optional<Agency> getAgencyById(Long id) {
        return agencyRepository.findById(id);
    }

    public AgencyDTO createAgencyFromDTO(AgencyDTO agencyDTO) {
        Agency agency = new Agency();
        agency.setName(agencyDTO.getName());
        agency.setCnpj(agencyDTO.getCnpj());
        agency.setAddress(agencyDTO.getAddress());
        agency.setPhone(agencyDTO.getPhone());
        agency.setDigit(agencyDTO.getDigit());
        Agency savedAgency = agencyRepository.save(agency);
        AgencyDTO savedDTO = new AgencyDTO();
        savedDTO.setId(savedAgency.getId());
        savedDTO.setName(savedAgency.getName());
        savedDTO.setCnpj(savedAgency.getCnpj());
        savedDTO.setAddress(savedAgency.getAddress());
        savedDTO.setPhone(savedAgency.getPhone());
        savedDTO.setDigit(savedAgency.getDigit());
        return savedDTO;
    }

    public Optional<AgencyDTO> editAgencyFromDTO(Long id, AgencyDTO agencyDTO) {
        return agencyRepository.findById(id).map(agency -> {
            agency.setName(agencyDTO.getName());
            agency.setCnpj(agencyDTO.getCnpj());
            agency.setAddress(agencyDTO.getAddress());
            agency.setPhone(agencyDTO.getPhone());
            agency.setDigit(agencyDTO.getDigit());
            Agency updatedAgency = agencyRepository.save(agency);
            AgencyDTO dto = new AgencyDTO();
            dto.setId(updatedAgency.getId());
            dto.setName(updatedAgency.getName());
            dto.setCnpj(updatedAgency.getCnpj());
            dto.setAddress(updatedAgency.getAddress());
            dto.setPhone(updatedAgency.getPhone());
            dto.setDigit(updatedAgency.getDigit());
            return dto;
        });
    }
}