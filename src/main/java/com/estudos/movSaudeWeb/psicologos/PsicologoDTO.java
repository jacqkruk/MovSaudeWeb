package com.estudos.movSaudeWeb.psicologos;

import com.estudos.movSaudeWeb.consultas.ConsultaDTO;
import com.estudos.movSaudeWeb.consultas.ConsultaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PsicologoDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private Date dataNascimento;
    private String crp;
    private List<ConsultaDTO> consultas;
}
