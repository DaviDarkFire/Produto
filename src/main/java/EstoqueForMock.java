public interface EstoqueForMock { //TODO: Perguntar se isso foi o menos seboso a se fazer
    int getQuantidadeDeProdutosEmEstoque();
    void daBaixaDeProdutoEmEstoque(Produto produto) throws Exception;
    void adicionaProdutoEmEstoque(Produto produto) throws Exception;
}
 //TODO: pesquisar java checked and unchecked exceptions.
//TODO: coleções/string java. map DTO, produto pode alterar/manipular lista mas objetos externos que dão get não podem.
