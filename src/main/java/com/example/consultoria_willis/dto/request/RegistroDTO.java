package com.example.consultoria_willis.dto.request;

import com.example.consultoria_willis.util.UserRole;

public record RegistroDTO(String login, String senha, UserRole role, String email, String empresa, String telefone) {
}
