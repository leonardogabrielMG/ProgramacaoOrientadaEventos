package pacote.dominio;

import java.util.Date;

public abstract class Pessoa {
    private String nome;
    private Date nascimento;
    private String genero;
    private String cpf;
    private String telefone;

    public Pessoa(String nome, Date nascimento, String genero, String cpf, String telefone) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.genero = genero;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
}
