public interface EstoqueForMock { //TODO: Perguntar se isso foi o menos seboso a se fazer
    int getQuantidadeDeProdutosEmEstoque();
    void daBaixaDeProdutoEmEstoque(Produto produto) throws Exception;
    void adicionaProdutoEmEstoque(Produto produto) throws Exception;
}
