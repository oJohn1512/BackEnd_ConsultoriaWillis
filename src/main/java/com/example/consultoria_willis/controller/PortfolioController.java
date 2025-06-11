package com.example.consultoria_willis.controller;

import com.example.consultoria_willis.dto.request.PortfolioDTO;
import com.example.consultoria_willis.service.PortfolioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {
    private final PortfolioService portfolioService;

    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @GetMapping
    public ResponseEntity<List<PortfolioDTO>> listarProjetos(){
        return ResponseEntity.ok(portfolioService.listarProjetos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PortfolioDTO> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(portfolioService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<PortfolioDTO> criarProjeto(@RequestBody PortfolioDTO portfolioDTO){
        return ResponseEntity.ok(portfolioService.criarProjeto(portfolioDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PortfolioDTO> atualizarProjeto(@PathVariable Long id, @RequestBody PortfolioDTO portfolioDTO){
        return ResponseEntity.ok(portfolioService.atualizarProjeto(id,portfolioDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProjeto(@PathVariable Long id){
        portfolioService.excluirProjeto(id);
        return ResponseEntity.noContent().build();
    }
}
