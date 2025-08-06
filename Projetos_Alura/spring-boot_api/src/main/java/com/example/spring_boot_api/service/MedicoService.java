package com.example.spring_boot_api.service;

import com.example.spring_boot_api.models.Medico;
import com.example.spring_boot_api.repository.MedicoRepository;
import com.example.spring_boot_api.web.DadosMedicoDTO;
import com.example.spring_boot_api.web.ListMedicoDTO;
import com.example.spring_boot_api.web.UpdateMedicoDTO;
import com.example.spring_boot_api.web.UpdatePessoaDTO;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MedicoService {

    private final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public Medico cadastrarMedico(@Valid DadosMedicoDTO dadosMedicoDTO) {
       var medico = medicoRepository.save(new Medico(dadosMedicoDTO));
       return medico;
    }

    public Page<ListMedicoDTO> listarMedicosDTO(Pageable pageable) {
        return medicoRepository.findAllByAtivoTrue(pageable).map(ListMedicoDTO::new);
    }


    public ResponseEntity<?> atualizaMedico(UpdatePessoaDTO updatePessoaDTO){

            var medico = medicoRepository.getReferenceById(updatePessoaDTO.id());
            medico.atualizaInformacoes(updatePessoaDTO);
            return ResponseEntity.ok(new UpdateMedicoDTO(medico));

    }

    public ResponseEntity deletarMedico(Long id){
            var medico = medicoRepository.getReferenceById(id);
            medico.desativarMedico();
            return ResponseEntity.noContent().build();

    }

    public ResponseEntity detalharMedico(Long id) {
            var medico = medicoRepository.getReferenceById(id);
            return ResponseEntity.ok(new UpdateMedicoDTO(medico));

    }
}
