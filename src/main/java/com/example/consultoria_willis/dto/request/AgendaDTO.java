package com.example.consultoria_willis.dto.request;

import com.google.api.client.util.DateTime;

public class AgendaDTO {
    private String dataHorarioAgendamento;
    private String emailCliente;


    public DateTime getDataHorarioAgendamento() {
        return new DateTime(dataHorarioAgendamento);
    }

    public void setDataHorarioAgendamento(String dataHorarioAgendamento) {
        this.dataHorarioAgendamento = dataHorarioAgendamento;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }
}
