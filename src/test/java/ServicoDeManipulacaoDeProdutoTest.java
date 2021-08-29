import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicoDeManipulacaoDeProdutoTest {

    private QualquerCoisa qualquerCoisa;
    private ProdutoRepository produtoRepository;
    private Produto produto;
    private EstoqueSpy estoqueSpy;
    private EstoqueMock estoqueMock;

    @Before
    public void setUp() {
        qualquerCoisa = Mockito.mock(QualquerCoisa.class); //dummie
        produtoRepository = Mockito.mock(ProdutoRepository.class);
        produto = new Produto("Monange", 10.0, "Creme hidratante", qualquerCoisa);
        estoqueSpy = new EstoqueSpy(0);
    }

    @Test
    public void deveAdicionarProduto() {
        String mensagemEsperada = "Produto adicionado com sucesso!";
        Mockito.when(produtoRepository.adicionarProduto(produto)).thenReturn(mensagemEsperada); //stub
        ServicoDeManipulacaoDeProduto servico = new ServicoDeManipulacaoDeProduto(produtoRepository);

        String resposta = servico.cadastrarProduto(estoqueSpy, produto);

        Assertions.assertThat(resposta).isEqualTo(mensagemEsperada);
    }

    @Test
    public void deveAtualizarProduto() {
        String mensagemEsperada = "Produto atualizado com sucesso!";
        Mockito.when(produtoRepository.atualizarProduto(produto)).thenReturn(mensagemEsperada);
        ServicoDeManipulacaoDeProduto servico = new ServicoDeManipulacaoDeProduto(produtoRepository);

        String resposta = servico.atualizarProduto(produto);

        Assertions.assertThat(resposta).isEqualTo(mensagemEsperada);
    }

    @Test
    public void deveExcluirProduto() {
        Mockito.when(produtoRepository.removerProduto(produto)).thenReturn(true);
        ServicoDeManipulacaoDeProduto servico = new ServicoDeManipulacaoDeProduto(produtoRepository);

        boolean resposta = servico.deletarProduto(estoqueSpy, produto);

        Assertions.assertThat(resposta).isTrue();
    }

    @Test
    public void deveSomarNoEstoqueAoCadastrarProdutoNovo() {
        estoqueSpy = new EstoqueSpy(0);
        Integer quantidadeDeProdutosDoEstoqueAposCadastro = 1;

        Mockito.when(produtoRepository.adicionarProduto(produto)).thenReturn("mensagem qualquer");
        ServicoDeManipulacaoDeProduto servico = new ServicoDeManipulacaoDeProduto(produtoRepository);

        servico.cadastrarProduto(estoqueSpy, produto);

        Assertions.assertThat(estoqueSpy.getQuantidadeDeProdutosEmEstoque()).isEqualTo(quantidadeDeProdutosDoEstoqueAposCadastro);
    }

    @Test
    public void deveSubtrairDoEstoqueAoExcluirProduto() {
        estoqueSpy = new EstoqueSpy(5);
        Integer quantidadeDeProdutosDoEstoqueAposCadastro = 4;

        Mockito.when(produtoRepository.removerProduto(produto)).thenReturn(true);
        ServicoDeManipulacaoDeProduto servico = new ServicoDeManipulacaoDeProduto(produtoRepository);

        servico.deletarProduto(estoqueSpy, produto);

        Assertions.assertThat(estoqueSpy.getQuantidadeDeProdutosEmEstoque()).isEqualTo(quantidadeDeProdutosDoEstoqueAposCadastro);
    }

    @Test
    public void deveFazer2AdicoesDeProdutoEmEstoque() {
        estoqueSpy = new EstoqueSpy(0);
        Integer quantidadeDeAdicoesDeProdutoEmEstoque = 2;

        Mockito.when(produtoRepository.adicionarProduto(produto)).thenReturn("mensagem qualquer");
        ServicoDeManipulacaoDeProduto servico = new ServicoDeManipulacaoDeProduto(produtoRepository);

        servico.cadastrarProduto(estoqueSpy, produto);
        servico.cadastrarProduto(estoqueSpy, produto);

        Assertions.assertThat(estoqueSpy.quantasVezesHouveAdicaoDeProduto).isEqualTo(quantidadeDeAdicoesDeProdutoEmEstoque);
    }

    @Test
    public void deveFazer2ExclusoesDeProdutoEmEstoque() {
        estoqueSpy = new EstoqueSpy(3);
        Integer quantidadeDeExclusoesDeProdutoEmEstoque = 2;

        Mockito.when(produtoRepository.adicionarProduto(produto)).thenReturn("mensagem qualquer");
        ServicoDeManipulacaoDeProduto servico = new ServicoDeManipulacaoDeProduto(produtoRepository);

        servico.deletarProduto(estoqueSpy, produto);
        servico.deletarProduto(estoqueSpy, produto);

        Assertions.assertThat(estoqueSpy.quantasVezesHouveExclusaoDeProduto).isEqualTo(quantidadeDeExclusoesDeProdutoEmEstoque);
    }

    @Test
    public void deveConterProdutoEspecificadoComoUltimoProdutoManuseadoAposExclusao() {
        estoqueSpy = new EstoqueSpy(3);

        Mockito.when(produtoRepository.adicionarProduto(produto)).thenReturn("mensagem qualquer");
        ServicoDeManipulacaoDeProduto servico = new ServicoDeManipulacaoDeProduto(produtoRepository);

        servico.deletarProduto(estoqueSpy, produto);

        Assertions.assertThat(estoqueSpy.ultimoProdutoManuseado).isEqualTo(produto);
    }

    @Test
    public void deveLancarExcecaoCasoHajaMaisQue5Adicoes() {
        estoqueMock = new EstoqueMock(4);

        Mockito.when(produtoRepository.adicionarProduto(produto)).thenReturn("mensagem qualquer");
        ServicoDeManipulacaoDeProduto servico = new ServicoDeManipulacaoDeProduto(produtoRepository);

        try {
            for (int i = 0; i < 6; i++) {
                servico.cadastrarProduto(estoqueMock, produto);
            }
        } catch (Exception e) {
            String mensagem = e.getMessage();
            Assertions.assertThat(mensagem).isEqualTo("Cuidado! Mais que 5 adições.");
        }
    }

    @Test
    public void deveLancarExcecaoCasoHajaMaisQue5Exclusoes() {
        estoqueMock = new EstoqueMock(4);

        Mockito.when(produtoRepository.adicionarProduto(produto)).thenReturn("mensagem qualquer");
        ServicoDeManipulacaoDeProduto servico = new ServicoDeManipulacaoDeProduto(produtoRepository);

        try {
            for (int i = 0; i < 6; i++) {
                servico.deletarProduto(estoqueMock, produto);
            }
        } catch (Exception e) {
            String mensagem = e.getMessage();
            Assertions.assertThat(mensagem).isEqualTo("Cuidado! Mais que 5 exclusões.");
        }
    }
}