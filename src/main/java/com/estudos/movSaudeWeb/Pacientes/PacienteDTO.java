package com.estudos.movSaudeWeb.Pacientes;


import com.estudos.movSaudeWeb.Consultas.ConsultaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacienteDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private Date dataNascimento;
    private List<ConsultaModel> consultas;
}
