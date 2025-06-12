package project.bankapp.bank.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.bankapp.bank.model.Pix;
import project.bankapp.bank.repository.PixRepository;
import project.bankapp.bank.dto.PixDTO;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PixService {

    private final PixRepository pixRepository;

    public Pix registerKey(PixDTO pixDTO) {
        Pix pix = new Pix();
        pix.setKeyType(pixDTO.getKeyType());
        pix.setKeyValue(pixDTO.getKeyValue());
        return pixRepository.save(pix);
    }

    public java.util.List<Pix> listAllKeys() {
        return pixRepository.findAll();
    }

    public Pix findById(Long id) {
        return pixRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Key not found"));
    }

    public Pix findByKey(String key) {
        return pixRepository.findByKeyValue(key)
                .orElseThrow(() -> new RuntimeException("Key not found"));
    }

    public String findKeyByValue(String key) {
        Optional<Pix> pix = pixRepository.findByKeyValue(key);
        return pix.map(Pix::getKeyValue).orElseThrow(() -> new RuntimeException("Key not found"));
    }
}