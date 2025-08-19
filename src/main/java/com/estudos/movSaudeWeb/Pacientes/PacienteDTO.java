package com.estudos.movSaudeWeb.Pacientes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacienteDTO {

    private int id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private Date dataNascimento;
    private ConsultaModel consulta;
}
