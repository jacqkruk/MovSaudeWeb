package com.estudos.movSaudeWeb.consultas;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("consulta")
public class ConsultaController {

    private ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarConsulta(@RequestBody ConsultaDTO consulta) {
        ConsultaDTO novaConsulta = consultaService.criarConsulta(consulta);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Consulta criada com sucesso: " + novaConsulta.toString());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ConsultaDTO>> listarConsulta() {
        List<ConsultaDTO> consultas = consultaService.listarConsultas();
        return ResponseEntity.ok(consultas);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarConsultaPorId(@PathVariable Long id) {

        ConsultaDTO consulta = consultaService.listarConsultaPorId(id);

        if (consulta != null) {
            return ResponseEntity.ok(consulta);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Consulta de id: " + id + " não existe em nossos registros");
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarConsultaPorId(@PathVariable Long id, @RequestBody ConsultaDTO consultaAtualizada) {
        ConsultaDTO consulta = consultaService.atualizarConsulta(id, consultaAtualizada);

        if (consulta != null) {
            return ResponseEntity.ok(consulta);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Consulta de id: " + id + " não existe em nossos registros");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarConsultaPorId(@PathVariable Long id) {

        if (consultaService.listarConsultaPorId(id) != null) {
            consultaService.deletarConsultaPorId(id);
            return ResponseEntity.ok("Consulta de id " + id + " excluída com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Consulta de id " + id + " não encontrada");
        }
    }
}
