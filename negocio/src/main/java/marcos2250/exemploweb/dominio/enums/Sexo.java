package marcos2250.exemploweb.dominio.enums;

public enum Sexo implements EnumPersistente<String> {
    
    MASCULINO("M", "Masculino"),
    FEMININO("F", "Feminino");

    private String codigo;
    private String descricao;

    private Sexo(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    @Override
    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }
    
}