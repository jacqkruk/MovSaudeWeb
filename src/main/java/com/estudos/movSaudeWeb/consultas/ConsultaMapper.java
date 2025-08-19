package com.estudos.movSaudeWeb.consultas;

import com.estudos.movSaudeWeb.pacientes.PacienteMapper;
import com.estudos.movSaudeWeb.psicologos.PsicologoMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {PacienteMapper.class, PsicologoMapper.class})
public interface ConsultaMapper {
    ConsultaDTO toDTO(ConsultaModel model);
    ConsultaModel toEntity(ConsultaDTO dto);
}
