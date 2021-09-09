public class EstoqueMock implements Estoque{

    private Integer quantidadeDeProdutos;
    public Integer quantasVezesHouveExclusaoDeProduto;
    public Produto ultimoProdutoManuseado;
    public Integer quantasVezesHouveAdicaoDeProduto;

    public EstoqueMock(Integer quantidadeDeProdutos) {
        this.quantidadeDeProdutos = quantidadeDeProdutos;
        this.quantasVezesHouveExclusaoDeProduto = 0;
        this.quantasVezesHouveAdicaoDeProduto = 0;
    }

    @Override
    public int getQuantidadeDeProdutosEmEstoque() {
        return quantidadeDeProdutos;
    }

    @Override
    public void daBaixaDeProdutoEmEstoque(Produto produto) throws RuntimeException{
        ultimoProdutoManuseado = produto;
        quantasVezesHouveExclusaoDeProduto++;
        lancaExcecaoCasoQuantidadeDeExclusoesMaiorQueCinco();
        quantidadeDeProdutos--;
    }

    @Override
    public void adicionaProdutoEmEstoque(Produto produto) throws RuntimeException {
        ultimoProdutoManuseado = produto;
        quantasVezesHouveAdicaoDeProduto++;
        lancaExcecaoCasoQuantidadeDeAdicoesMaiorQueCinco();
        quantidadeDeProdutos++;
    }

    private void lancaExcecaoCasoQuantidadeDeExclusoesMaiorQueCinco() throws RuntimeException {
        if(quantasVezesHouveExclusaoDeProduto > 5) {
            throw new IllegalArgumentException("Cuidado! Mais que 5 exclusões.");
        }
    }

    private void lancaExcecaoCasoQuantidadeDeAdicoesMaiorQueCinco() throws RuntimeException {
        if(quantasVezesHouveAdicaoDeProduto > 5) {
            throw new RuntimeException("Cuidado! Mais que 5 adições.");
        }
    }
}
