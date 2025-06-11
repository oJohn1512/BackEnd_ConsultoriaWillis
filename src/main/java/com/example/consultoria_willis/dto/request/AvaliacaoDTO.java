package com.example.consultoria_willis.dto.request;

public class AvaliacaoDTO {
    private Long id;
    private String nome_cliente;
    private String avaliacao;
    private String comentario;

    public AvaliacaoDTO(Long id, String nome_cliente, String avaliacao, String comentario) {
        this.id = id;
        this.nome_cliente = nome_cliente;
        this.avaliacao = avaliacao;
        this.comentario = comentario;
    }


    public AvaliacaoDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

}
