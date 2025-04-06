package br.com.kevin.escola.dto;

import java.time.Instant;

public class AlunoDto {
    private String name;
    private String cpf;
    private Instant dataNascimento;

    public AlunoDto(String name, String cpf, Instant dataNascimento) {
        this.name = name;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
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
