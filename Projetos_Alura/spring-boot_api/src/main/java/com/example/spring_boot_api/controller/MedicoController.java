package com.example.spring_boot_api.controller;

import com.example.spring_boot_api.models.Medico;
import com.example.spring_boot_api.service.MedicoService;
import com.example.spring_boot_api.web.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("medicos")
public class  MedicoController {
    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }
    /*Por padrão, o método http devolve o código 200 se a requisição for processada com sucesso.
    Devolve o código 201 quando da criação de um registro em banco de dados, além de devolver
    no corpo da resposta os dados do novo recurso/registro cadastrado
    Tem de devolver também um cabeçalho HTTP chamado location, que é o endereço utilizado para
    a criação do novo recurso/registro*/

    @PostMapping
    public ResponseEntity<?> cadastrarMedico(@RequestBody @Valid DadosMedicoDTO dadosMedicoDTO,
                                             UriComponentsBuilder uriComponentsBuilder){
        var medico = medicoService.cadastrarMedico(dadosMedicoDTO);
        var uri = uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(uri).body(new UpdateMedicoDTO(medico));
    }

    @GetMapping
    public ResponseEntity<Page<ListMedicoDTO>>listarMedicos(@PageableDefault(size = 10, sort = {"nome"})
                                            Pageable pageable){
         var page = medicoService.listarMedicosDTO(pageable);
         return ResponseEntity.ok(page);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizarMedico(@RequestBody @Valid UpdatePessoaDTO updatePessoaDTO,
                                                           @PathVariable Long id){
       return medicoService.atualizaMedico(updatePessoaDTO);
    }
    //Por padrão, o http devolve o código 204 pra dizer que a requisição foi processada com sucesso
    //e que não possui um corpo

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarMedico(@PathVariable Long id){
        return medicoService.deletarMedico(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalharMedico (@RequestBody @PathVariable Long id) {
        return medicoService.detalharMedico(id);
    }
}
