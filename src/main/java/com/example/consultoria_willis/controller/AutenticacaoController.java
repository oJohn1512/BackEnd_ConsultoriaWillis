package com.example.consultoria_willis.controller;

import com.example.consultoria_willis.dto.request.AutenticacaoDTO;
import com.example.consultoria_willis.dto.request.RegistroDTO;
import com.example.consultoria_willis.dto.response.LoginResponseDTO;
import com.example.consultoria_willis.security.TokenService;
import com.example.consultoria_willis.model.User;
import com.example.consultoria_willis.repository.UsuarioRepository;
import com.example.consultoria_willis.util.UserRole;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AutenticacaoDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.senha());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.gerarToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/cadastro")
    public ResponseEntity cadastro(@RequestBody @Valid RegistroDTO data) {
        if (this.usuarioRepository.findByLogin(data.login()) != null ) return ResponseEntity.badRequest().build();


        String senhaCriptograda = new BCryptPasswordEncoder().encode(data.senha());
        User novoUsuario = new User(data.login(), senhaCriptograda, UserRole.USER, data.email(), data.empresa(), data.telefone());

        usuarioRepository.save(novoUsuario);

        return ResponseEntity.ok().build();
    }

}
