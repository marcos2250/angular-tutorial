package marcos2250.exemploweb.dominio;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

@Entity
@Table(name = "EMP_EMPRESA")
public class Empresa {

    private Long id;

    private String nome;
    private TipoEmpresa tipo;

    private LocalDate dataFundacao;

    private List<Pessoa> empregados;

    @Id
    @GeneratedValue
    @Column(name = "EMP_ID")
    public Long getId() {
        return id;
    }

    @Column(name = "EMP_ST_NOME")
    public String getNome() {
        return nome;
    }

    @Column(name = "EMP_DT_FUNDACAO")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    public LocalDate getDataFundacao() {
        return dataFundacao;
    }

    @ManyToMany
    @JoinTable(name = "EMS_EMPREGADOS", //
    joinColumns = @JoinColumn(name = "EMP_ID"), //
    inverseJoinColumns = @JoinColumn(name = "PES_ID"))
    public List<Pessoa> getEmpregados() {
        return empregados;
    }

    @Column(name = "EMP_CD_TIPO")
    @Enumerated(EnumType.ORDINAL)
    public TipoEmpresa getTipo() {
        return tipo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipo(TipoEmpresa tipo) {
        this.tipo = tipo;
    }

    public void setDataFundacao(LocalDate data) {
        this.dataFundacao = data;
    }

    public void setEmpregados(List<Pessoa> empregados) {
        this.empregados = empregados;
    }

}
