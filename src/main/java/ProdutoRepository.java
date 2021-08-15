public interface ProdutoRepository {
    String adicionarProduto(Produto produto);
    String atualizarProduto(Produto produto);
    boolean removerProduto(Produto produto);
    String buscarProdutoPorId(Integer id);
}
