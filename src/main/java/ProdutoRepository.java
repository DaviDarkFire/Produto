public interface ProdutoRepository {
    String adicionarProduto(Produto produto);
    String atualizarProduto(Produto produto);
    String removerProduto(Produto produto);
    String buscarProdutoPorId(Integer id);
}
