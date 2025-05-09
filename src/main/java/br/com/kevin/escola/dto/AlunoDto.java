package br.com.kevin.escola.dto;

import br.com.kevin.escola.entities.Aluno;

import java.io.Serializable;
import java.time.Instant;

public class AlunoDto {
    private Long id;
    private String name;
    private String cpf;
    private Instant dataNascimento;

    public AlunoDto(){}
    public AlunoDto(Aluno aluno) {
        this.id = aluno.getId();
        this.name = aluno.getName();
        this.cpf = aluno.getCpf();
        this.dataNascimento = aluno.getDataNascimento();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Instant getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Instant dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
