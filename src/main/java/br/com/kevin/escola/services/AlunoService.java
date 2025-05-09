package br.com.kevin.escola.services;

import br.com.kevin.escola.dto.AlunoDto;
import br.com.kevin.escola.entities.Aluno;
import br.com.kevin.escola.exceptions.DatabaseException;
import br.com.kevin.escola.exceptions.ResourceNotFoundException;
import br.com.kevin.escola.repositories.AlunoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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
    public AlunoDto findById(Long id) {
        Aluno aluno = this.alunoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID" + id + " not found"));
        return new AlunoDto(aluno);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void deleteById(Long id) {
        try {
            this.alunoRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Resource ID" + id + " not found");
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }

    @Transactional
    public AlunoDto create(AlunoDto alunoDto) {

        Aluno aluno = new Aluno();
        aluno.setName(alunoDto.getName());
        aluno.setCpf(alunoDto.getCpf());
        aluno.setDataNascimento(alunoDto.getDataNascimento());

        Aluno createdAluno = this.alunoRepository.save(aluno);
        return new AlunoDto(createdAluno);
    }

    @Transactional
    public AlunoDto update(Long id, AlunoDto alunoDto) {
        try {
            Aluno aluno = alunoRepository.getReferenceById(id);
            aluno.setName(alunoDto.getName());
            aluno.setCpf(alunoDto.getCpf());
            aluno.setDataNascimento(alunoDto.getDataNascimento());
            return new AlunoDto(aluno);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("ID" + id + " not found");
        }
    }
}
