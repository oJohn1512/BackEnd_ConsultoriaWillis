package com.example.consultoria_willis.service;

import com.example.consultoria_willis.dto.request.ClienteDTO;
import com.example.consultoria_willis.model.Cliente;
import com.example.consultoria_willis.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    public ClienteRepository clienteRepository;

    public List<ClienteDTO> listarClientes(){
        return clienteRepository.findAll().stream()
                .map(cliente -> new ClienteDTO(cliente.getId(), cliente.getNome(), cliente.getEmail(),cliente.getSenha(),cliente.getTelefone(),cliente.getMensagem()))
                .collect(Collectors.toList());
    }

    public ClienteDTO buscarPorId(Long id){
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não existe"));
        return new ClienteDTO(cliente.getId(),cliente.getNome(),cliente.getEmail(), cliente.getSenha(), cliente.getTelefone(),cliente.getMensagem());
    }

    public ClienteDTO criarCliente(ClienteDTO clienteDTO){
        Cliente novoCliente = new Cliente(clienteDTO.getNome(),clienteDTO.getEmail(), clienteDTO.getSenha(), clienteDTO.getTelefone(),clienteDTO.getMensagem());
        Cliente clienteSalvo = clienteRepository.save(novoCliente);
        return new ClienteDTO(clienteSalvo.getId(),clienteSalvo.getNome(),clienteSalvo.getEmail(),clienteDTO.getSenha(),clienteSalvo.getTelefone(),clienteSalvo.getMensagem());
    }

    public ClienteDTO atualizarCliente(Long id, ClienteDTO clienteDTO){
        Cliente clienteExistente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não existe"));
        clienteExistente.setNome(clienteDTO.getNome());
        clienteExistente.setEmail(clienteDTO.getEmail());
        clienteExistente.setSenha(clienteDTO.getSenha());
        clienteExistente.setTelefone(clienteDTO.getTelefone());
        clienteExistente.setMensagem(clienteDTO.getMensagem());

        Cliente clienteAtualizado = clienteRepository.save(clienteExistente);
        return new ClienteDTO(clienteAtualizado.getId(),clienteAtualizado.getNome(),clienteAtualizado.getEmail(),clienteDTO.getSenha(),clienteAtualizado.getTelefone(),clienteAtualizado.getMensagem());
    }

    public void excluirCliente(Long id){
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não existe"));
        clienteRepository.deleteById(cliente.getId());
    }
}
