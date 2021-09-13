import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.api.Assertions;

public class EstoqueArrayListTest {

    private List<Produto> produtos;

    @Before
    public void setUp() {
        produtos = new ArrayList<>();
        for(int i = 0; i < 1000; i++){
            produtos.add(ProdutoBuilder.criar());
        }
    }

    @Test
    public void deveRetornarQuantidadeDeElementosDoEstoque() {
        Estoque estoque = new EstoqueArrayList(Arrays.asList(ProdutoBuilder.criar()));

        int quantidadeDeProdutosEmEstoque = estoque.getQuantidadeDeProdutosEmEstoque();

        Assertions.assertThat(quantidadeDeProdutosEmEstoque).isEqualTo(1);
    }

    @Test
    public void testStreams() {
        List<Produto> filtrados = produtos.stream()
                .filter(produto -> produto.getPreco() >= 7)
                .sorted(Comparator.comparing(Produto::getPreco).reversed())
                .collect(Collectors.toList());
        System.out.println(filtrados);
    }
}