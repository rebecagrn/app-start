package hello.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by rebeca on 08/02/2019.
 */

@Entity
@Table(name = "telefones_clientes")
public class TelefonesClientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_fone")
    private Integer codigo;

    @ManyToOne
    @JoinColumn(name = "cod_cli", referencedColumnName = "cod_cli")
    private Clientes cliente;

    @Column(name = "ddd_fone")
    @Size(max = 2)
    private Integer ddd;

    @Column(name = "num_fone")
    @Size(max = 9)
    private Integer numero;

    @ManyToOne
    @JoinColumn(name = "cod_tipo", referencedColumnName = "cod_tipo")
    private TiposContato tipo;

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

    public Integer getDdd() {
        return ddd;
    }

    public void setDdd(Integer ddd) {
        this.ddd = ddd;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public TiposContato getTipo() {
        return tipo;
    }

    public void setTipo(TiposContato tipo) {
        this.tipo = tipo;
    }

    public Date getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(Date datacadastro) {
        this.datacadastro = datacadastro;
    }
}
