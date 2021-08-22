public class ServicoDeManipulacaoDeProduto {

    private ProdutoRepository produtoRepository;

    public ServicoDeManipulacaoDeProduto(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public String cadastrarProduto(Produto produto) {
        return produtoRepository.adicionarProduto(produto);
    }

    public String atualizarProduto(Produto produto) {
        return produtoRepository.atualizarProduto(produto);
    }

    public boolean deletarProduto(Autorizacao autorizacaoStubSpy, Produto produto) {
        return autorizacaoStubSpy.autorizarExclusao(produto) && produtoRepository.removerProduto(produto);
    }
}
