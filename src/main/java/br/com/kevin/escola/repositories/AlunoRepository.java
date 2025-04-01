package br.com.kevin.escola.repositories;

import br.com.kevin.escola.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno,Long> {
}
