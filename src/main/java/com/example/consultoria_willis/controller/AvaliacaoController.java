package com.example.consultoria_willis.controller;

import com.example.consultoria_willis.dto.request.AvaliacaoDTO;
import com.example.consultoria_willis.service.AvaliacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {
    private final AvaliacaoService avaliacaoService;

    public AvaliacaoController(AvaliacaoService avaliacaoService) {
        this.avaliacaoService = avaliacaoService;
    }

    @GetMapping
    public ResponseEntity<List<AvaliacaoDTO>> listarProjetos(){
        return ResponseEntity.ok(avaliacaoService.listarAvaliacoes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvaliacaoDTO> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(avaliacaoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<AvaliacaoDTO> criarProjeto(@RequestBody AvaliacaoDTO avaliacaoDTO){
        return ResponseEntity.ok(avaliacaoService.criarAvaliacao(avaliacaoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AvaliacaoDTO> atualizarProjeto(@PathVariable Long id, @RequestBody AvaliacaoDTO avaliacaoDTO){
        return ResponseEntity.ok(avaliacaoService.atualizarAvaliacao(id,avaliacaoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProjeto(@PathVariable Long id){
        avaliacaoService.excluirAvaliacao(id);
        return ResponseEntity.noContent().build();
    }

}
