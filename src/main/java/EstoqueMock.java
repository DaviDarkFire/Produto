public class EstoqueMock implements EstoqueForMock{

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
    public void daBaixaDeProdutoEmEstoque(Produto produto) throws Exception{
        ultimoProdutoManuseado = produto;
        quantasVezesHouveExclusaoDeProduto++;
        lancaExcecaoCasoQuantidadeDeExclusoesMaiorQueCinco();
        quantidadeDeProdutos--;
    }

    @Override
    public void adicionaProdutoEmEstoque(Produto produto) throws Exception {
        ultimoProdutoManuseado = produto;
        quantasVezesHouveAdicaoDeProduto++;
        lancaExcecaoCasoQuantidadeDeAdicoesMaiorQueCinco();
        quantidadeDeProdutos++;
    }

    private void lancaExcecaoCasoQuantidadeDeExclusoesMaiorQueCinco() throws Exception {
        if(quantasVezesHouveExclusaoDeProduto > 5) {
            throw new Exception("Cuidado! Mais que 5 exclusões.");
        }
    }

    private void lancaExcecaoCasoQuantidadeDeAdicoesMaiorQueCinco() throws Exception {
        if(quantasVezesHouveAdicaoDeProduto > 5) {
            throw new Exception("Cuidado! Mais que 5 adições.");
        }
    }
}
