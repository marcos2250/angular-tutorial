package marcos2250.exemploweb.dominio;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import marcos2250.exemploweb.dominio.enums.Sexo;
import marcos2250.exemploweb.util.LocalDateDeserializer;
import marcos2250.exemploweb.util.LocalDateSerializer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "PES_PESSOA")
@AttributeOverride(name = ObjetoPersistente.ID, column = @Column(name = "PES_ID"))
public class Pessoa extends ObjetoPersistente {

    private String nome;
    private String sobrenome;
    private LocalDate dataNascimento;
    private Sexo sexo;
    private String telefone;
    private String email;

    private List<Empresa> empresas;

    @Column(name = "PES_ST_NOME")
    public String getNome() {
        return nome;
    }

    @Column(name = "PES_ST_SOBRENOME")
    public String getSobrenome() {
        return sobrenome;
    }

    @Column(name = "PES_DT_NASCIMENTO")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    @Column(name = "PES_NM_TELEFONE")
    public String getTelefone() {
        return telefone;
    }

    @Column(name = "PES_ST_EMAIL")
    public String getEmail() {
        return email;
    }

    @Column(name = "PES_CD_SEXO")
    public Sexo getSexo() {
        return sexo;
    }

    @ManyToMany(mappedBy = "empregados")
    @JsonIgnore
    public List<Empresa> getEmpresas() {
        return empresas;
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

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pessoa: " + nome + " " + sobrenome;
    };

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Pessoa.class.isInstance(obj)) {
            Pessoa cast = Pessoa.class.cast(obj);
            return cast.getId() == this.getId();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (int) (nome.hashCode() + sobrenome.hashCode() + this.getId());
    }
}
