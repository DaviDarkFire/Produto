import java.math.BigDecimal;

public class Produto {
    private String nome;
    private Double preco;
    private String descricao;
    private QualquerCoisa qualquerCoisa;

    public Produto(String nome, Double preco, String descricao, QualquerCoisa qualquerCoisa) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.qualquerCoisa = qualquerCoisa;
    }
}
