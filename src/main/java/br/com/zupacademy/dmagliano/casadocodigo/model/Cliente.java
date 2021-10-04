package br.com.zupacademy.dmagliano.casadocodigo.model;

import br.com.zupacademy.dmagliano.casadocodigo.controller.dto.ClienteForm;
import br.com.zupacademy.dmagliano.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.dmagliano.casadocodigo.repository.PaisRepository;
import org.springframework.util.Assert;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Objects;
import java.util.Optional;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @ManyToOne
    private Pais pais;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;
    @ManyToOne
    private Estado estado;

    @Deprecated
    public Cliente() {
    }

    public Cliente(String email, String nome, String sobrenome, String documento,
                   String endereco, String complemento, String cidade, Pais pais,
                   String telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.telefone = telefone;
        this.cep = cep;
    }

    public static Cliente toEntity(ClienteForm clienteForm, PaisRepository paisRepository, EstadoRepository estadoRepository) {

        Optional<Pais> paisCliente = paisRepository.findById(clienteForm.getPaisId());

        Cliente cliente = new Cliente(
                clienteForm.getEmail(),
                clienteForm.getNome(),
                clienteForm.getSobrenome(),
                clienteForm.getDocumento(),
                clienteForm.getEndereco(),
                clienteForm.getComplemento(),
                clienteForm.getCidade(),
                paisCliente.get(),
                clienteForm.getTelefone(),
                clienteForm.getCep()
        );


        //verifica se o pais encontrado possui estados, e se o campo EstadoId não é nulo.
        if (paisPossuiEstado(paisCliente.get(), estadoRepository)) {
            Assert.isTrue(clienteForm.getEstadoId() != null, "Estado é obrigatório para o pais informado: " + paisCliente.get().getNome());
            Optional<Estado> estadoCliente = estadoRepository.findById(clienteForm.getEstadoId());

            //Caso a pessoa tenha informado o estado, ela verifica se o estado esta cadastrado no banco
            if (!estadoCliente.isPresent()) {
                Assert.state(Objects.nonNull(clienteForm.getEstadoId()), "Estado não encontrado");
            }
            if (!estadoValido(estadoCliente.get(), paisCliente.get())) {
                Assert.state(Objects.isNull(estadoCliente.get()), "Estado não pertence ao pais informado: " + paisCliente.get().getNome());
            }

            //Cria o estado, caso ele seja do mesmo país informado.
            Estado estado = estadoCliente.get();
            cliente.setEstado(estado);
            return cliente;
        } else {
            return cliente;
        }

    }

    private static boolean paisPossuiEstado(Pais pais, EstadoRepository estadoRepository) {
        return (estadoRepository.existsByPaisId(pais.getId()));
    }


    private static Boolean estadoValido(Estado estado, Pais pais) {

        if (!estado.pertencePais(pais)) {
            Assert.state(Objects.nonNull(estado.getName()), "Estado não pertence ao pais informado");
            return false;
        }
        return true;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Long getId() {
        return id;
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

    public Pais getPais() {
        return pais;
    }

    public Estado getEstado() {
        return estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

}
