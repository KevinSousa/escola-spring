package br.com.kevin.escola.resources;

import br.com.kevin.escola.entities.Aluno;
import br.com.kevin.escola.services.AlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/alunos")
public class AlunoResource {

    private final AlunoService alunoService;

    public AlunoResource(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping("")
    public ResponseEntity<List<Aluno>> getAll() {
        return ResponseEntity.ok(alunoService.findAll());
    }
}
