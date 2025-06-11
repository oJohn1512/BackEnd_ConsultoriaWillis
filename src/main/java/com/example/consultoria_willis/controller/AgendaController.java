package com.example.consultoria_willis.controller;

import com.example.consultoria_willis.dto.request.AgendaDTO;
import com.example.consultoria_willis.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agenda")
public class AgendaController {

    @Autowired
    AgendaService service;

    @PostMapping
    public ResponseEntity marcarMeet(@RequestBody AgendaDTO agendamento) {
        return ResponseEntity.ok(service.marcarMeet(agendamento.getDataHorarioAgendamento(), agendamento.getEmailCliente()));
    }
}
