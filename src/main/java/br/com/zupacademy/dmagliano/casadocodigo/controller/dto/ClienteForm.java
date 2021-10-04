package br.com.zupacademy.dmagliano.casadocodigo.controller.dto;

import br.com.zupacademy.dmagliano.casadocodigo.controller.validator.ExistsId;
import br.com.zupacademy.dmagliano.casadocodigo.controller.validator.UniqueValue;
import br.com.zupacademy.dmagliano.casadocodigo.controller.validator.CPForCNPJ;
import br.com.zupacademy.dmagliano.casadocodigo.model.Cliente;
import br.com.zupacademy.dmagliano.casadocodigo.model.Pais;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


public class ClienteForm {

    @Email
    @NotBlank
    @UniqueValue(domainClass = Cliente.class, fieldName = "email")
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    @UniqueValue(domainClass = Cliente.class, fieldName = "documento")
    @CPForCNPJ
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;

    @ExistsId(domainClass = Pais.class, fieldName = "id")
    private Long paisId;

    private Long estadoId;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;

    @Deprecated
    public ClienteForm() {
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Long getPaisId() {
        return paisId;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }
}
