package br.com.kevin.escola.services;

import br.com.kevin.escola.dto.AlunoDto;
import br.com.kevin.escola.entities.Aluno;
import br.com.kevin.escola.exceptions.NotFoundException;
import br.com.kevin.escola.repositories.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> findAll() {
        return this.alunoRepository.findAll();
    }

    public Optional<Aluno> findById(Long id)  {
        return this.alunoRepository.findById(id);
    }

    public void deleteById(Long id) {
        this.alunoRepository.deleteById(id);
    }

    public AlunoDto crete(Aluno aluno) {
        var createdAluno = this.alunoRepository.save(aluno);
        return new AlunoDto(createdAluno.getName(), createdAluno.getCpf(), createdAluno.getDataNascimento());
    }
}
