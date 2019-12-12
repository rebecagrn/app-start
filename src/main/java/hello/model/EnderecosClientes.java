package hello.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by rebeca on 08/02/2019.
 */

@Entity
@Table(name = "enderecos_clientes")
public class EnderecosClientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_ende")
    private Integer codigo;

    @ManyToOne
    @JoinColumn(name = "cod_cli", referencedColumnName = "cod_cli")
    private Clientes cliente;

    @ManyToOne
    @JoinColumn(name = "cod_tipo", referencedColumnName = "cod_tipo")
    private TiposContato tipo;

    @Size(max = 80)
    private String logradouro;

    @Size(max = 80)
    private String bairro;

    @Size(max = 80)
    private String complemento;

    @Size(max = 80)
    private String cidade;

    @Size(max = 8)
    private String cep;

    @Column(name = "data_cad")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date datacadastro;


    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public TiposContato getTipo() {
        return tipo;
    }

    public void setTipo(TiposContato tipo) {
        this.tipo = tipo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Date getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(Date datacadastro) {
        this.datacadastro = datacadastro;
    }
}
