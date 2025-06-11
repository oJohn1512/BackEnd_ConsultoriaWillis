package com.example.consultoria_willis.repository;

import com.example.consultoria_willis.model.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao,Long> {

}
