public interface Estoque {
    int getQuantidadeDeProdutosEmEstoque();
    void daBaixaDeProdutoEmEstoque(Produto produto);
    void adicionaProdutoEmEstoque(Produto produto);
}
