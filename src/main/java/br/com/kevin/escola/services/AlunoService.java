package br.com.kevin.escola.services;

import br.com.kevin.escola.entities.Aluno;
import br.com.kevin.escola.repositories.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> findAll() {
        return this.alunoRepository.findAll();
    }
}
