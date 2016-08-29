/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springbootproject.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author wmfsystem
 */
@Entity
public class Autor extends DefaultDomain<Long> {

    @NotEmpty(message = "O campo nome não pode ser vazio!")
    private String nome;

    @Temporal(javax.persistence.TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotEmpty(message = "O campo nascimento é obrigatório!")
    private Date nascimento;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotEmpty(message = "O campo nacionalidade é obrigatório!")
    private String nacionalidade;

//    @OneToMany(mappedBy = "autor")
//    @JsonIgnore
//    private List<Livro> livros;

    public Autor() {
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

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }


}
