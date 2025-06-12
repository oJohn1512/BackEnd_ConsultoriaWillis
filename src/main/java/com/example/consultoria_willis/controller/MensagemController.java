package com.example.consultoria_willis.controller;

import com.example.consultoria_willis.dto.request.MensagemDTO;
import com.example.consultoria_willis.service.MensagemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mensagem")
public class MensagemController {

    private final MensagemService mensagemService;

    public MensagemController(MensagemService mensagemService) {
        this.mensagemService = mensagemService;
    }

    @GetMapping
    public ResponseEntity<List<MensagemDTO>> listarMensagens() {
        return ResponseEntity.ok(mensagemService.listarMensagens());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MensagemDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(mensagemService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<MensagemDTO> criarMensagem(@RequestBody MensagemDTO mensagemDTO) {
        return ResponseEntity.ok(mensagemService.criarMensagem(mensagemDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MensagemDTO> atualizarStatusMensagem(@PathVariable Long id) {
        return ResponseEntity.ok(mensagemService.mensagemRespondida(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMensagem(@PathVariable Long id) {
        mensagemService.deletarMensagem(id);
        return ResponseEntity.noContent().build();
    }

}

