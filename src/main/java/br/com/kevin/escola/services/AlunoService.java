package br.com.kevin.escola.services;

import br.com.kevin.escola.dto.AlunoDto;
import br.com.kevin.escola.entities.Aluno;
import br.com.kevin.escola.exceptions.ResourceNotFoundException;
import br.com.kevin.escola.repositories.AlunoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @Transactional(readOnly = true)
    public List<AlunoDto> findAll() {
        List<Aluno> alunos = alunoRepository.findAll();
        return alunos.stream().map(AlunoDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public AlunoDto findById(Long id)  {
        Aluno aluno = this.alunoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID" + id + " not found"));
        return new AlunoDto(aluno);
    }

    public void deleteById(Long id) {
        this.alunoRepository.deleteById(id);
    }

//    public AlunoDto create(AlunoDto aluno) {
//        var createdAluno = this.alunoRepository.save(aluno);
//        return new AlunoDto(createdAluno.getId(), createdAluno.getName());
//    }
}
