package com.estudos.movSaudeWeb.consultas;

import com.estudos.movSaudeWeb.pacientes.PacienteDTO;
import com.estudos.movSaudeWeb.pacientes.PacienteModel;
import com.estudos.movSaudeWeb.psicologos.PsicologoDTO;
import com.estudos.movSaudeWeb.psicologos.PsicologoModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ConsultaMapperTest {

    @Autowired
    private ConsultaMapper consultaMapper;

    @Test
    public void deveMapearConsultaParaConsultaDTO() {
        // criando objetos simulados
        PacienteModel paciente = new PacienteModel();
        paciente.setId(1L);
        paciente.setNome("Jake");

        PsicologoModel psicologo = new PsicologoModel();
        psicologo.setId(2L);
        psicologo.setNome("Ana Sofia");

        ConsultaModel consulta = new ConsultaModel();
        consulta.setId(100L);
        consulta.setData(LocalDate.of(2025, 8, 19));
        consulta.setPaciente(paciente);
        consulta.setPsicologo(psicologo);

        /*
         // Mapeando para DTO
        ConsultaDTO dto = consultaMapper.toDTO(consulta);

        // Verificações
        assertNotNull(dto);
        assertEquals(consulta.getId(), dto.getId());
        assertEquals(consulta.getData(), dto.getData());
        assertEquals("Jake", dto.getPaciente().getNome());
        assertEquals("Ana Sofia", dto.getPsicologo().getNome());
         */

    }

    @Test
    public void deveMapearConsultaDTOParaConsulta() {
        // Criando DTOs simulados
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setId(1L);
        pacienteDTO.setNome("Jake");

        PsicologoDTO psicologoDTO = new PsicologoDTO();
        psicologoDTO.setId(2L);
        psicologoDTO.setNome("Ana Sofia");

        ConsultaDTO dto = new ConsultaDTO();
        dto.setId(100L);
        dto.setData(LocalDate.of(2025, 8, 19));
        dto.setPaciente(pacienteDTO);
        dto.setPsicologo(psicologoDTO);

        /*
         // Mapeando para entidade
        ConsultaModel consulta = consultaMapper.toEntity(dto);

        // Verificações
        assertNotNull(consulta);
        assertEquals(dto.getId(), consulta.getId());
        assertEquals(dto.getData(), consulta.getData());
        assertEquals("Jake", consulta.getPaciente().getNome());
        assertEquals("Ana Sofia", consulta.getPsicologo().getNome());
         */

    }
}
