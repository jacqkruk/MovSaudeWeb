package com.estudos.movSaudeWeb.pacientes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    /*  ---------- RESPONSE ENTITY ----------
    Classe do Spring Framework que representa respostas HTTP (status, cabeçalhos, corpo)
    Função: definir o status HTTP (200 ok, 404 Not Found, etc)
            adicionar cabeçalhos personaliados (Location, Content-Type, etc)
            enviar corpo de resposta ("Usuário não encontrado", etc)
     */

    // Adicionar paciente (CREATE)
    @PostMapping("/criar")
    // o metodo recebe os dados do paciente via requisição HTTP POST,
    // @RequestBody indica que os dados do paciente virão no corpo da requisição, geralmente
    // em formato JSON, e serão convertidos automaticamente para um objeto PacienteDTO
    public ResponseEntity<String> criarPaciente(@RequestBody PacienteDTO paciente) {
        //cria objeto do tipo DTO que recebe os dados informados pelo cliente,
        // e chama o serviço que acessa o bd para criar o novo paciente
        PacienteDTO novoPaciente = pacienteService.criarPaciente(paciente);
        // retorna ao cliente uma resposta HTTP com status 201 CREATED
        // e corpo da resposta contendo uma mensagem de sucesso
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Paciente criado com sucesso: " + novoPaciente.getNome());
    }

    // Mostrar todos os paciente (READ)
    // anotação que indica que o metodo será chamado quando o cliente fizer uma requisição HTTP GET
    // para o endpoint /listar
    @GetMapping("/listar")
    public ResponseEntity<List<PacienteDTO>> listarPacientes() {
        // cria uma lista do tipo DTO,
        //  e chama o serviço que acessa o bd para buscar todos os pacientes cadastrados
        List<PacienteDTO> pacientes = pacienteService.listarPacientes();
        // retorna uma resposta HTTP com status 200 ok
        // e o corpo da resposta contendo a lista de pacientes
        return ResponseEntity.ok(pacientes);
    }

    // Mostrar paciente por ID (READ)
    @GetMapping("/listar/{id}")
    // metodo que retorna um tipo genérico
    // @PathVariable é uma variável de caminho (na URL) passada pelo usuário
    public ResponseEntity<?> listarPacientesPorId(@PathVariable Long id) {
        // cria um objeto do tipo DTO,
        //  e chama o serviço que acessa o bd para buscar o paciente cadastrado no id informado
        PacienteDTO paciente = pacienteService.listarPacientePorId(id);
        // se o paciente não for nulo
        if (paciente != null) {
            // retorna uma resposta HTTP com status 200 ok
            return ResponseEntity.ok(paciente);
        } else {
            // retorna uma resposta HTTP com status 404 NOT_FOUND,
            // e corpo com mensagem de texto
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Paciente com o id: " + id + " não existe nos nossos registros");
        }
    }

    // Alterar dados dos pacientes (UPDATE)
    @PutMapping("/alterar/{id}")
    // o metodo recebe uma variável de caminho da url, e os dados do paciente no corpo da requisição
    // em formato JSON, que serão convertidos automaticamente para um objeto PacienteDTO
    // e retorna um tipo genérico
    public ResponseEntity<?> alterarPacientePorId(@PathVariable Long id,
                                                  @RequestBody PacienteDTO pacienteAtualizado) {
        // cria objeto DTO e chama serviço que altera os valores no objeto paciente
        PacienteDTO paciente = pacienteService.atualizarPaciente(id, pacienteAtualizado);
        // se o paciente não for nulo
        if (paciente != null) {
            // retorna resposta com status 200 ok e o novo paciente com valores alterados
            return ResponseEntity.ok(paciente);
        } else {
            // retorna resposta com status 404 NOT_FOUND e corpo de mensagem de erro
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Paciente com id:" + id + " não existe em nossos registros");
        }
    }

    // Deletar paciente (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarPacientePorId(@PathVariable Long id) {
        // chama o serviço que busca o paciente no bd, e se ele não for nulo...
        if (pacienteService.listarPacientePorId(id) != null) {
            // deleta o paciente do bd
            pacienteService.deletarPacientePorId(id);
            // retorna uma mensagem de sucesso
            return ResponseEntity.ok("Paciente de id " + id + " deletado com sucesso");
        } else {
            // retorna uma mensagem de erro
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Paciente de id " + id + " não encontrado");
        }
    }

}
