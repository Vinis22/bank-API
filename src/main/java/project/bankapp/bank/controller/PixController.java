package project.bankapp.bank.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.bankapp.bank.dto.PixDTO;
import project.bankapp.bank.model.Pix;
import project.bankapp.bank.service.PixService;

@RestController
@RequestMapping("/api/pix")
public class PixController {

    private final PixService pixService;

    public PixController(PixService pixService) {
        this.pixService = pixService;
    }

    @PostMapping
    public ResponseEntity<Pix> registerKey(@RequestBody PixDTO dto) {
        Pix pix = pixService.registerKey(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(pix);
    }

    @GetMapping
    public ResponseEntity<java.util.List<Pix>> listAllKeys() {
        return ResponseEntity.ok(pixService.listAllKeys());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pix> findKeyById(@PathVariable Long id) {
        return ResponseEntity.ok(pixService.findById(id));
    }

    @GetMapping("/key/{key}")
    public ResponseEntity<Pix> findByKey(@PathVariable String key) {
        return ResponseEntity.ok(pixService.findByKey(key));
    }
}