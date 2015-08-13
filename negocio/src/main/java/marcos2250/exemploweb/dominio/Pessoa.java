package marcos2250.exemploweb.dominio;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

@Entity
@Table(name = "PES_PESSOA")
public class Pessoa {

    private Long id;

    private String nome;

    private String sobrenome;

    private LocalDate dataNascimento;

    private String telefone;

    private List<Empresa> empresas;

    @Id
    @GeneratedValue
    @Column(name = "PER_ID")
    public Long getId() {
        return id;
    }

    @Column(name = "PER_ST_NOME")
    public String getNome() {
        return nome;
    }

    @Column(name = "PER_ST_SOBRENOME")
    public String getSobrenome() {
        return sobrenome;
    }

    @Column(name = "PER_DT_NASCIMENTO")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    @Column(name = "PER_NM_TELEFONE")
    public String getTelefone() {
        return telefone;
    }

    @ManyToMany(mappedBy = "empregados", fetch = FetchType.EAGER)
    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setDataNascimento(LocalDate data) {
        this.dataNascimento = data;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }

}
