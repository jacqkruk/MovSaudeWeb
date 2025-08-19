package com.estudos.movSaudeWeb.Consultas;

import com.estudos.movSaudeWeb.Pacientes.PacienteModel;
import com.estudos.movSaudeWeb.Psicologos.PsicologoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaDTO {

    private Long id;
    private LocalDate data;
    private LocalTime horario;
    private PsicologoModel psicologo;
    private PacienteModel paciente;
}
