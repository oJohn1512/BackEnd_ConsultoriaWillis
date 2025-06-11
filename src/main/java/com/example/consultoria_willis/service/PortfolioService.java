package com.example.consultoria_willis.service;

import com.example.consultoria_willis.dto.request.PortfolioDTO;
import com.example.consultoria_willis.model.Portfolio;
import com.example.consultoria_willis.repository.PortfolioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PortfolioService {

    private final PortfolioRepository portfolioRepository;

    public PortfolioService(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }

    public List<PortfolioDTO> listarProjetos(){
        return portfolioRepository.findAll().stream()
                .map(portfolio -> new PortfolioDTO(portfolio.getId(), portfolio.getTitulo(),portfolio.getImagem_url(),portfolio.getDescricao(),portfolio.getLink_demo()))
                .collect(Collectors.toList());
    }

    public PortfolioDTO buscarPorId(Long id){
        Portfolio portfolio = portfolioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projeto não existe"));
        return new PortfolioDTO(portfolio.getId(),portfolio.getTitulo(),portfolio.getImagem_url(),portfolio.getDescricao(),portfolio.getLink_demo());
    }

    public PortfolioDTO criarProjeto(PortfolioDTO portfolioDTO){
        Portfolio novoProjeto = new Portfolio(null,portfolioDTO.getTitulo(),portfolioDTO.getImagem_url(),portfolioDTO.getDescricao(),portfolioDTO.getLink_demo());
        Portfolio projetoSalvo = portfolioRepository.save(novoProjeto);
        return new PortfolioDTO(projetoSalvo.getId(),projetoSalvo.getTitulo(),projetoSalvo.getImagem_url(),projetoSalvo.getDescricao(),projetoSalvo.getLink_demo());
    }

    public PortfolioDTO atualizarProjeto(Long id, PortfolioDTO portfolioDTO){
        Portfolio projetoExistente = portfolioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projeto não existe"));
        projetoExistente.setTitulo(portfolioDTO.getTitulo());
        projetoExistente.setImagem_url(portfolioDTO.getImagem_url());
        projetoExistente.setDescricao(portfolioDTO.getDescricao());
        projetoExistente.setLink_demo(portfolioDTO.getLink_demo());

        Portfolio projetoAtualizado = portfolioRepository.save(projetoExistente);
        return new PortfolioDTO(projetoAtualizado.getId(),projetoAtualizado.getTitulo(),projetoAtualizado.getImagem_url(),projetoAtualizado.getDescricao(), projetoAtualizado.getLink_demo());
    }

    public void excluirProjeto(Long id){
        portfolioRepository.deleteById(id);
    }
}
