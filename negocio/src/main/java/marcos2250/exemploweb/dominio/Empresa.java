package marcos2250.exemploweb.dominio;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import marcos2250.exemploweb.dominio.enums.TipoEmpresa;
import marcos2250.exemploweb.util.LocalDateDeserializer;
import marcos2250.exemploweb.util.LocalDateSerializer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "EMP_EMPRESA")
@AttributeOverride(name = ObjetoPersistente.ID, column = @Column(name = "EMP_ID"))
public class Empresa extends ObjetoPersistente {

    private String nome;
    private TipoEmpresa tipo;

    private LocalDate dataFundacao;

    private List<Pessoa> empregados;

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
    public TipoEmpresa getTipo() {
        return tipo;
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

    @Override
    public String toString() {
        return "Empresa: " + nome;
    };

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Empresa.class.isInstance(obj)) {
            Empresa cast = Empresa.class.cast(obj);
            return cast.getId() == this.getId();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (int) (nome.hashCode() + this.getId());
    }

}
