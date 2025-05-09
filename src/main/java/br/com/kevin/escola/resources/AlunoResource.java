package br.com.kevin.escola.resources;

import br.com.kevin.escola.dto.AlunoDto;
import br.com.kevin.escola.entities.Aluno;
import br.com.kevin.escola.services.AlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController()
@RequestMapping("/alunos")
public class AlunoResource {

    private final AlunoService alunoService;

    public AlunoResource(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping("")
    public ResponseEntity<List<AlunoDto>> getAll() {
        return ResponseEntity.ok(alunoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoDto> getById(@PathVariable Long id)  {
         return ResponseEntity.ok(alunoService.findById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        this.alunoService.deleteById(id);
    }

    @PostMapping("")
    public ResponseEntity<AlunoDto> create(@RequestBody AlunoDto aluno) {
        aluno = alunoService.create(aluno);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(aluno.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
}
