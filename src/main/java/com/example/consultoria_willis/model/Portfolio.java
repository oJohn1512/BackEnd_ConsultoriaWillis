package com.example.consultoria_willis.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private String imagem_url;
    private String link_demo;

    public Portfolio() {

    }

    public Portfolio(Long id, String titulo, String imagem_url, String descricao, String link_demo) {
        this.id = id;
        this.titulo = titulo;
        this.imagem_url = imagem_url;
        this.descricao = descricao;
        this.link_demo = link_demo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem_url() {
        return imagem_url;
    }

    public void setImagem_url(String imagem_url) {
        this.imagem_url = imagem_url;
    }

    public String getLink_demo() {
        return link_demo;
    }

    public void setLink_demo(String link_demo) {
        this.link_demo = link_demo;
    }
}
