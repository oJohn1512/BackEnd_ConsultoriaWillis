package com.example.consultoria_willis.dto;

import com.example.consultoria_willis.dto.request.ClienteDTO;

import java.util.List;

public class ApiResponse {
    private String message;
    private List<ClienteDTO> clienteDTO;


    public ApiResponse(String message, List<ClienteDTO> clienteDTO) {
        this.message = message;
        this.clienteDTO = clienteDTO;
    }

    public ApiResponse(String message) {
        this.message = message;
    }

    public List<ClienteDTO> getClienteDTO() {
        return clienteDTO;
    }

    public void setClienteDTO(List<ClienteDTO> clienteDTO) {
        this.clienteDTO = clienteDTO;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
