import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicoDeManipulacaoDeProdutoTest {

    private QualquerCoisa qualquerCoisa;
    private ProdutoRepository produtoRepository;
    private Produto produto;
    private AutorizacaoStubSpy autorizacaoStubSpy;

    @Before
    public void setUp() {
        qualquerCoisa = Mockito.mock(QualquerCoisa.class); //dummie
        produtoRepository = Mockito.mock(ProdutoRepository.class);
        produto = new Produto("Monange", 10.0, "Creme hidratante", qualquerCoisa);
        autorizacaoStubSpy = new AutorizacaoStubSpy(); //Stub
    }

    @Test
    public void deveAdicionarProduto() {
        String mensagemEsperada = "Produto adicionado com sucesso!";
        Mockito.when(produtoRepository.adicionarProduto(produto)).thenReturn(mensagemEsperada); //Mock
        ServicoDeManipulacaoDeProduto servico = new ServicoDeManipulacaoDeProduto(produtoRepository);

        String resposta = servico.cadastrarProduto(produto);

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

        boolean resposta = servico.deletarProduto(autorizacaoStubSpy, produto);

        Assertions.assertThat(resposta).isTrue();
    }
}