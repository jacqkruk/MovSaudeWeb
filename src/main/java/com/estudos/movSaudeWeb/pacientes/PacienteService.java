package com.estudos.movSaudeWeb.pacientes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PacienteService {

    private PacienteRepository pacienteRepository;
    private PacienteMapper pacienteMapper;

    public PacienteService(PacienteRepository pacienteRepository, PacienteMapper pacienteMapper) {
        this.pacienteRepository = pacienteRepository;
        this.pacienteMapper = pacienteMapper;
    }

    public List<PacienteDTO> listarPacientes() {
        List<PacienteModel> pacientes = pacienteRepository.findAll();
        return pacientes.stream()
                .map(pacienteMapper::map)
                .collect(Collectors.toList());
    }

    public PacienteDTO listarPacientePorId(Long id) {
        Optional<PacienteModel> pacientePorId = pacienteRepository.findById(id);
        return pacientePorId.map(pacienteMapper::map).orElse(null);
    }

    public PacienteDTO criarPaciente(PacienteDTO pacienteDTO) {
        PacienteModel paciente = pacienteMapper.map(pacienteDTO);
        paciente = pacienteRepository.save(paciente);
        return pacienteMapper.map(paciente);
    }

    public void deletarPacientePorId(Long id) {
        pacienteRepository.deleteById(id);
    }

    public PacienteDTO atualizarPaciente(Long id, PacienteDTO pacienteDTO) {
        Optional<PacienteModel> pacienteExistente = pacienteRepository.findById(id);
        if (pacienteExistente.isPresent()) {
            PacienteModel pacienteAtualizado = pacienteMapper.map(pacienteDTO);
            pacienteAtualizado.setId(id);
            PacienteModel pacienteSalvo = pacienteRepository.save(pacienteAtualizado);
            return pacienteMapper.map(pacienteSalvo);
        }
        return null;
    }
}
