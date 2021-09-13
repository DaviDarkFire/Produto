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

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public QualquerCoisa getQualquerCoisa() {
        return qualquerCoisa;
    }
}
