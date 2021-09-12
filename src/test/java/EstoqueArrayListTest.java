import org.junit.Test;

import java.util.Arrays;

import org.assertj.core.api.Assertions;

public class EstoqueArrayListTest {

    @Test
    public void deveRetornarQuantidadeDeElementosDoEstoque() {
        Estoque estoque = new EstoqueArrayList(Arrays.asList(ProdutoBuilder.criar()));

        int quantidadeDeProdutosEmEstoque = estoque.getQuantidadeDeProdutosEmEstoque();

        Assertions.assertThat(quantidadeDeProdutosEmEstoque).isEqualTo(1);
    }
}