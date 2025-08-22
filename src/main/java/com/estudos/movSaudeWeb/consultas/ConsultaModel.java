package com.estudos.movSaudeWeb.consultas;

import com.estudos.movSaudeWeb.pacientes.PacienteModel;
import com.estudos.movSaudeWeb.psicologos.PsicologoModel;
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
    @Column(name = "id")
    private Long id;

    @Column(name = "data")
    private LocalDate data;

    @Column(name = "horario")
    private LocalTime horario;

    @ManyToOne
    @JoinColumn(name = "psicologo_id")
    private PsicologoModel psicologo;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private PacienteModel paciente;

}
