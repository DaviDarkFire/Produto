public class EstoqueSpy implements Estoque{
    private Integer quantidadeDeProdutos;

    public EstoqueSpy(Integer quantidadeDeProdutos) {
        this.quantidadeDeProdutos = quantidadeDeProdutos;
    }

    @Override
    public int getQuantidadeDeProdutosEmEstoque() {
        return quantidadeDeProdutos;
    }

    @Override
    public void daBaixaDeProdutoEmEstoque(Produto produto) {
        quantidadeDeProdutos--;
    }

    @Override
    public void adicionaProdutoEmEstoque(Produto produto) {
        quantidadeDeProdutos++;

    }
}
