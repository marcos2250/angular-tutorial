package marcos2250.exemploweb.dominio.enums;

public enum TipoEmpresa implements EnumPersistente<Integer> {

    MEI(1, "Microempreendedor individual"), //
    MICRO(2, "Microempresa"), //
    PEQUENA(3, "Pequena"), //
    MEDIA(4, "Média"), //
    GRANDE(5, "Grande");

    private Integer codigo;
    private String descricao;
    
    private TipoEmpresa(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
    
    @Override
    public Integer getCodigo() {
        return codigo;
    }
    
    public String getDescricao() {
        return descricao;
    }

}
