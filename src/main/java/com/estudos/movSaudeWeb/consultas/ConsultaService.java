package com.estudos.movSaudeWeb.consultas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConsultaService {

    private ConsultaRepository consultaRepository;
    private ConsultaMapper consultaMapper;

    public ConsultaService(ConsultaRepository consultaRepository, ConsultaMapper consultaMapper) {
        this.consultaRepository = consultaRepository;
        this.consultaMapper = consultaMapper;
    }

    public ConsultaDTO criarConsulta(ConsultaDTO consultaDTO) {
        ConsultaModel consulta = consultaMapper.map(consultaDTO);
        consulta = consultaRepository.save(consulta);
        return consultaMapper.map(consulta);
    }

    public List<ConsultaDTO> listarConsultas() {
        List<ConsultaModel> consultas = consultaRepository.findAll();
        return consultas.stream()
                .map(consultaMapper::map)
                .collect(Collectors.toList());
    }

    public ConsultaDTO listarConsultaPorId(Long id) {
        Optional<ConsultaModel> consultaPorId = consultaRepository.findById(id);
        return consultaPorId.map(consultaMapper::map).orElse(null);
    }

    public ConsultaDTO atualizarConsulta(Long id, ConsultaDTO consultaDTO) {
        Optional<?> consultaExistente = consultaRepository.findById(id);

        if (consultaExistente.isPresent()) {
            ConsultaModel consultaAtualizada = consultaMapper.map(consultaDTO);
            consultaAtualizada.setId(id);
            ConsultaModel consultaSalva = consultaRepository.save(consultaAtualizada);
            return consultaMapper.map(consultaSalva);
        }
        return null;
    }

    public void deletarConsultaPorId(Long id) {
        consultaRepository.deleteById(id);
    }
}
