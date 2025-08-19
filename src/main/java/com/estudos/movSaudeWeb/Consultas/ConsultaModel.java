package com.estudos.movSaudeWeb.Consultas;

import com.estudos.movSaudeWeb.Pacientes.PacienteModel;
import com.estudos.movSaudeWeb.Psicologos.PsicologoModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tb_consulta")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "data")
    private int id;

    @Column(name = "data")
    private LocalDate data;

    @Column(name = "data")
    private LocalTime horario;


    private PsicologoModel psicologo;

    @ManyToOne(mappedBy = "consulta")
    @JsonIgnore
    private PacienteModel paciente;

}
