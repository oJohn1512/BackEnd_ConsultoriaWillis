package com.example.consultoria_willis.service;

import com.example.consultoria_willis.dto.request.MensagemDTO;
import com.example.consultoria_willis.model.Mensagem;
import com.example.consultoria_willis.repository.MensagemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MensagemService {
    private final MensagemRepository mensagemRepository;

    public MensagemService(MensagemRepository mensagemRepository) {
        this.mensagemRepository = mensagemRepository;
    }

    public List<MensagemDTO> listarMensagens(){
        return mensagemRepository.findAll().stream()
                .map(mensagem -> new MensagemDTO(mensagem.getId(),mensagem.getNome(), mensagem.getEmail(),mensagem.getAssunto(), mensagem.getMensagem(),mensagem.isRespondido()))
                .collect(Collectors.toList());
    }

    public MensagemDTO buscarPorId(Long id){
        Mensagem mensagem = mensagemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mensagem não existe"));
        return new MensagemDTO(mensagem.getId(),mensagem.getNome(), mensagem.getEmail(),mensagem.getAssunto(), mensagem.getMensagem(),mensagem.isRespondido());
    }

    public MensagemDTO criarMensagem(MensagemDTO mensagemDTO){
        Mensagem novaMensagem = new Mensagem(null, mensagemDTO.getNome(), mensagemDTO.getEmail(), mensagemDTO.getAssunto(), mensagemDTO.getMensagem(), mensagemDTO.isRespondido());
        Mensagem mensagemSalva = mensagemRepository.save(novaMensagem);
        return new MensagemDTO(mensagemDTO.getId(),mensagemDTO.getNome(), mensagemDTO.getEmail(),mensagemDTO.getAssunto(), mensagemDTO.getMensagem(),mensagemDTO.isRespondido());
    }

    public MensagemDTO mensagemRespondida(Long id){
        Mensagem mensagemExistente = mensagemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mensagem não existe"));
        mensagemExistente.setRespondido(true);

        Mensagem mensagemFoiRespondida = mensagemRepository.save(mensagemExistente);
        return new MensagemDTO(mensagemFoiRespondida.getId(),mensagemFoiRespondida.getNome(),mensagemFoiRespondida.getEmail(),
                mensagemFoiRespondida.getAssunto(),mensagemFoiRespondida.getMensagem(), mensagemFoiRespondida.isRespondido());
    }

    public void deletarMensagem(Long id){
        Mensagem mensagem = mensagemRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Mensagem não existe"));
        mensagemRepository.deleteById(mensagem.getId());
    }
}
