public interface Estoque {
    int getQuantidadeDeProdutosEmEstoque();
    void daBaixaDeProdutoEmEstoque(Produto produto) throws RuntimeException;
    void adicionaProdutoEmEstoque(Produto produto) throws RuntimeException;
}
