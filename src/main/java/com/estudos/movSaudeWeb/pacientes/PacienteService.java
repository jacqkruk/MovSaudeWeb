package com.estudos.movSaudeWeb.pacientes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PacienteService {

    // extende a interface JPARepository do SpringFramework
    private PacienteRepository pacienteRepository;
    // converte objetos DTO para Model e vice-versa
    private PacienteMapper pacienteMapper;

    // Constructor
    public PacienteService(PacienteRepository pacienteRepository, PacienteMapper pacienteMapper) {
        this.pacienteRepository = pacienteRepository;
        this.pacienteMapper = pacienteMapper;
    }

    // Metodo GET - busca dados no bd
    public List<PacienteDTO> listarPacientes() {
        // cria lista do tipo Model, e pede para PacienteRepository listar todos os valores no bd
        List<PacienteModel> pacientes = pacienteRepository.findAll();
        // cria um fluxo de dados a partir da lista,e permite fazer filtragens,
        // mapeamento ordenação e redução, etc, sem mudar a lista original
        return pacientes.stream()
                // converte o fluxo de dados 'pacientes' do tipo Model para tipo DTO
                .map(pacienteMapper::map)
                // converte o fluxo de dados de volta para lista
                .collect(Collectors.toList());
    }

    public PacienteDTO listarPacientePorId(Long id) {
        // cria uma classe Optional do tipo PacienteModel, que pode estar vazia ou não
        // esse Optional recebe o valor buscado no bd a partir de um id informado
        Optional<PacienteModel> pacientePorId = pacienteRepository.findById(id);
        // se encontrar o paciente, converte de Model para DTO,
        // ou retorna nulo se não encontrar TODO: ao invés de nulo, retornar exceção personalizada
        return pacientePorId.map(pacienteMapper::map).orElse(null);
    }

    // Metodo POST - cria novos registros no bd
    public PacienteDTO criarPaciente(PacienteDTO pacienteDTO) {
        // pega o objeto PacienteDTO que acabou de ser criado e converte para Model
        // para poder salvar no bd
        PacienteModel paciente = pacienteMapper.map(pacienteDTO);
        // salva no bd e retorna o objeto salvo
        paciente = pacienteRepository.save(paciente);
        // converte o objeto Model para DTO e o retorna ao controller
        return pacienteMapper.map(paciente);
    }

    // metodo DELETE
    public void deletarPacientePorId(Long id) {
        pacienteRepository.deleteById(id);
    }

    // metodo PUT - atualiza o registro por completo no bd
    public PacienteDTO atualizarPaciente(Long id, PacienteDTO pacienteDTO) {
        // cria o Optional do tipo model, procura o registro por id no bd
        Optional<PacienteModel> pacienteExistente = pacienteRepository.findById(id);
        // se o paciente existir...
        if (pacienteExistente.isPresent()) {
            // converte ele de DTO para Model
            PacienteModel pacienteAtualizado = pacienteMapper.map(pacienteDTO);
            // garante que o objeto atualizado substitua o existente mantendo o id,
            // e não crie um novo registro
            pacienteAtualizado.setId(id);
            // salva o objeto no bd e o retorna - com o metodo save()
            PacienteModel pacienteSalvo = pacienteRepository.save(pacienteAtualizado);
            // mapeia de volta para DTO e retorna para o controller
            return pacienteMapper.map(pacienteSalvo);
        }
        // se o paciente do id informado não existir, retorna nulo
        // TODO: retornar exceção ao invés de nulo
        return null;
    }
}
