package com.example.consultoria_willis.dto.request;

public class MensagemDTO {
    private Long id;
    private String nome;
    private String email;
    private String assunto;
    private String mensagem;
    private boolean respondido;

    public MensagemDTO() {

    }

    public MensagemDTO(Long id, String nome, String email, String assunto, String mensagem, boolean respondido) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.assunto = assunto;
        this.mensagem = mensagem;
        this.respondido = respondido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public boolean isRespondido() {
        return respondido;
    }

    public void setRespondido(boolean respondido) {
        this.respondido = respondido;
    }
}
