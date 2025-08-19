package com.estudos.movSaudeWeb.Psicologos;

import com.estudos.movSaudeWeb.Consultas.ConsultaModel;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
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
    private List<ConsultaModel> consultas;
}
