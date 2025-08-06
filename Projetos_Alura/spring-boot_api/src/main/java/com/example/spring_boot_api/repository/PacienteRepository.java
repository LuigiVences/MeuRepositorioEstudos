package com.example.spring_boot_api.repository;

import com.example.spring_boot_api.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
