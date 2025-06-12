package project.bankapp.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.bankapp.bank.dto.AgencyDTO;
import project.bankapp.bank.model.Agency;
import project.bankapp.bank.service.AgencyService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/agencies")
public class AgencyController {
    private final AgencyService agencyService;

    @Autowired
    public AgencyController(AgencyService agencyService) {
        this.agencyService = agencyService;
    }

    @PostMapping
    public ResponseEntity<AgencyDTO> createAgency(@RequestBody AgencyDTO agencyDTO) {
        AgencyDTO savedDTO = agencyService.createAgencyFromDTO(agencyDTO);
        return new ResponseEntity<>(savedDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public List<AgencyDTO> listAgencies() {
        return agencyService.listAgencies().stream().map(agency -> {
            AgencyDTO dto = new AgencyDTO();
            dto.setId(agency.getId());
            dto.setName(agency.getName());
            dto.setCnpj(agency.getCnpj());
            dto.setAddress(agency.getAddress());
            dto.setPhone(agency.getPhone());
            dto.setDigit(agency.getDigit());
            return dto;
        }).collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgencyDTO> editAgency(@PathVariable Long id, @RequestBody AgencyDTO agencyDTO) {
        return agencyService.editAgencyFromDTO(id, agencyDTO)
                .map(updatedDTO -> ResponseEntity.ok(updatedDTO))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgency(@PathVariable Long id) {
        agencyService.deleteAgency(id);
        return ResponseEntity.noContent().build();
    }
} 