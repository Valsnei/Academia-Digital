package me.dio.academia.digital.controller;

import me.dio.academia.digital.service.Impl.AlunoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoServiceImpl service;

    @GetMapping
    public List<Aluno> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Aluno create(@RequestBody AlunoForm form) {
        return service.create(form);}

        @GetMapping("/avaliacoes/{id}")
        public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(@PathVariable Long id) {
            return service.getAllAvaliacaofisicaId(id);
        }

        @GetMapping
        public List<Aluno> getAll(@RequestParam(value = "dataDeNascimento", required = false)
                                          String dataDeNascimento){

            return service.getAll(dataDeNascimento);
        }

    public void setService(AlunoServiceImpl service) {
      this.service = service;
    }
}

