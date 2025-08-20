package com.estudos.movSaudeWeb.pacientes;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<PacienteModel, Long> {
}
