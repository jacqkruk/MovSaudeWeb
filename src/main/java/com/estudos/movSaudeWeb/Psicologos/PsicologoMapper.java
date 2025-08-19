package com.estudos.movSaudeWeb.Psicologos;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PsicologoMapper {
    PsicologoDTO toDTO(PsicologoModel model);
    PsicologoModel toModel(PsicologoDTO dto);

}
