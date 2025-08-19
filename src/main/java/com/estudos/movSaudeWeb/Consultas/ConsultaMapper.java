package com.estudos.movSaudeWeb.Consultas;

import com.estudos.movSaudeWeb.Pacientes.PacienteMapper;
import com.estudos.movSaudeWeb.Psicologos.PsicologoMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {PacienteMapper.class, PsicologoMapper.class})
public interface ConsultaMapper {
    ConsultaDTO toDTO(ConsultaModel model);

    ConsultaModel toModel(ConsultaDTO dto);
}
