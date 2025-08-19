package com.estudos.movSaudeWeb.Pacientes;

import com.estudos.movSaudeWeb.Consultas.ConsultaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_paciente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacienteModel {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "email")
    private String email;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "data_nascimento")
    private Date dataNascimento;

    @OneToMany
    @JoinColumn(name = "consulta_id")
    private List<ConsultaModel> consulta;

}
