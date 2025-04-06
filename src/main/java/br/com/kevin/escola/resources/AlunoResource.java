package br.com.kevin.escola.resources;

import br.com.kevin.escola.dto.AlunoDto;
import br.com.kevin.escola.entities.Aluno;
import br.com.kevin.escola.exceptions.NotFoundException;
import br.com.kevin.escola.services.AlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> getById(@PathVariable Long id)  {
        var aluno = alunoService.findById(id);
        return aluno.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        this.alunoService.deleteById(id);
    }

    @PostMapping("")
    public AlunoDto create(@RequestBody Aluno aluno) {
        return alunoService.crete(aluno);
    }
}
