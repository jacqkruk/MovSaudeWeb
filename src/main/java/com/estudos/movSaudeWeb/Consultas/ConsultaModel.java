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
    private Long id;

    @Column(name = "data")
    private LocalDate data;

    @Column(name = "data")
    private LocalTime horario;

    @ManyToOne
    @JoinColumn(name = "psicologo_id")
    private PsicologoModel psicologo;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private PacienteModel paciente;

}
