package com.example.consultoria_willis.repository;

import com.example.consultoria_willis.model.Cliente;
import com.example.consultoria_willis.model.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface MensagemRepository extends JpaRepository<Mensagem, Long> {
}
