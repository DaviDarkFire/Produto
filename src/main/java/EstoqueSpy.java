public class EstoqueSpy implements Estoque{
    private Integer quantidadeDeProdutos;
    public Integer quantasVezesHouveExclusaoDeProduto;
    public Produto ultimoProdutoManuseado;
    public Integer quantasVezesHouveAdicaoDeProduto;

    public EstoqueSpy(Integer quantidadeDeProdutos) {
        this.quantidadeDeProdutos = quantidadeDeProdutos;
        this.quantasVezesHouveAdicaoDeProduto = 0;
        this.quantasVezesHouveExclusaoDeProduto = 0;
    }

    @Override
    public int getQuantidadeDeProdutosEmEstoque() {
        return quantidadeDeProdutos;
    }

    @Override
    public void daBaixaDeProdutoEmEstoque(Produto produto) {
        ultimoProdutoManuseado = produto;
        quantasVezesHouveExclusaoDeProduto++;
        quantidadeDeProdutos--;
    }

    @Override
    public void adicionaProdutoEmEstoque(Produto produto) {
        ultimoProdutoManuseado = produto;
        quantasVezesHouveAdicaoDeProduto++;
        quantidadeDeProdutos++;
    }
}
