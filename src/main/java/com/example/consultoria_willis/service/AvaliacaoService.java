package com.example.consultoria_willis.service;

import com.example.consultoria_willis.dto.request.AvaliacaoDTO;
import com.example.consultoria_willis.model.Avaliacao;
import com.example.consultoria_willis.repository.AvaliacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AvaliacaoService {
    private final AvaliacaoRepository avaliacaoRepository;

    public AvaliacaoService(AvaliacaoRepository avaliacaoRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
    }

    public List<AvaliacaoDTO> listarAvaliacoes(){
        return avaliacaoRepository.findAll().stream()
                .map(avaliacao -> new AvaliacaoDTO(avaliacao.getId(),avaliacao.getNome_cliente(),avaliacao.getAvaliacao(),avaliacao.getComentario()))
                .collect(Collectors.toList());
    }

    public AvaliacaoDTO buscarPorId(Long id){
        Avaliacao avaliacao = avaliacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Avaliação não encontrada"));
        return new AvaliacaoDTO(avaliacao.getId(),avaliacao.getNome_cliente(),avaliacao.getAvaliacao(),avaliacao.getComentario());
    }

    public AvaliacaoDTO criarAvaliacao(AvaliacaoDTO avaliacaoDTO){
        Avaliacao novaAvaliacao = new Avaliacao(null,avaliacaoDTO.getNome_cliente(),avaliacaoDTO.getAvaliacao(),avaliacaoDTO.getComentario());
        Avaliacao avaliacaoSalva = avaliacaoRepository.save(novaAvaliacao);
        return new AvaliacaoDTO(avaliacaoSalva.getId(),avaliacaoSalva.getNome_cliente(),avaliacaoSalva.getAvaliacao(),avaliacaoSalva.getComentario());
    }

    public AvaliacaoDTO atualizarAvaliacao(Long id, AvaliacaoDTO avaliacaoDTO){
        Avaliacao avaliacaoExistente = avaliacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Avaliação não encontrada"));

        avaliacaoExistente.setNome_cliente(avaliacaoExistente.getNome_cliente());
        avaliacaoExistente.setAvaliacao(avaliacaoDTO.getAvaliacao());
        avaliacaoExistente.setComentario(avaliacaoDTO.getComentario());

        Avaliacao avaliacaoAtualizada = avaliacaoRepository.save(avaliacaoExistente);
        return new AvaliacaoDTO(avaliacaoAtualizada.getId(),avaliacaoAtualizada.getNome_cliente(),avaliacaoAtualizada.getAvaliacao(),avaliacaoAtualizada.getComentario());
    }

    public void excluirAvaliacao(Long id){
        avaliacaoRepository.deleteById(id);
    }

}
