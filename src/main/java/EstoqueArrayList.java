import java.util.ArrayList;
import java.util.List;

public class EstoqueArrayList implements Estoque {
    private List<Produto> produtosEmEstoque;

    public EstoqueArrayList(List<Produto> produtosEmEstoque) {
        this.produtosEmEstoque = produtosEmEstoque;
    }

    public EstoqueArrayList() {
        produtosEmEstoque = new ArrayList<>();
    }

    @Override
    public int getQuantidadeDeProdutosEmEstoque() {
        return produtosEmEstoque.size();
    }

    @Override
    public void daBaixaDeProdutoEmEstoque(Produto produto) throws RuntimeException {
        produtosEmEstoque.remove(produto);
    }

    @Override
    public void adicionaProdutoEmEstoque(Produto produto) throws RuntimeException {
        produtosEmEstoque.add(produto);
    }

    public int buscarProduto(Produto produto) {
        return produtosEmEstoque.indexOf(produto);
    }
}
