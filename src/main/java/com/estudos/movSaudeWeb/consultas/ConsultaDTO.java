package com.estudos.movSaudeWeb.consultas;

import com.estudos.movSaudeWeb.pacientes.PacienteDTO;
import com.estudos.movSaudeWeb.psicologos.PsicologoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaDTO {

    private Long id;
    private LocalDate data;
    private LocalTime horario;
    private PsicologoDTO psicologo;
    private PacienteDTO paciente;
}
