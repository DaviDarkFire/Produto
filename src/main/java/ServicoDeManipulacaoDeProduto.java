public class ServicoDeManipulacaoDeProduto {

    private ProdutoRepository produtoRepository;

    public ServicoDeManipulacaoDeProduto(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public String cadastrarProduto(Estoque estoque, Produto produto) {
        estoque.adicionaProdutoEmEstoque(produto);
        return produtoRepository.adicionarProduto(produto);
    }

    public String atualizarProduto(Produto produto) {
        return produtoRepository.atualizarProduto(produto);
    }

    public boolean deletarProduto(Estoque estoque ,Produto produto) {
        estoque.daBaixaDeProdutoEmEstoque(produto);
        return produtoRepository.removerProduto(produto);
    }
}
