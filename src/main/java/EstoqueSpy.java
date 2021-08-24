public class EstoqueSpy implements Estoque{ //adicionar atributos que espionem o que foi feito
    //com o mock adicionar exceções caso os atributos espiões não estejam de acordo com o que eu definir
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

    public Integer quantasVezesHouveExclusaoDeProduto(){
        return quantasVezesHouveExclusaoDeProduto;
    }

    public Produto ultimoProdutoManuseado(){
        return ultimoProdutoManuseado;
    }

    public Integer quantasVezesHouveAdicaoDeProduto(){
        return quantasVezesHouveAdicaoDeProduto;
    }
}
