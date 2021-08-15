import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

class ServicoDeCriacaoDeProdutoTest {

    private QualquerCoisa qualquerCoisa;
    private ProdutoRepository produtoRepository;
    private Produto produto;

    @Before
    public void setUp(){
        qualquerCoisa = Mockito.mock(QualquerCoisa.class); //dummie
        produtoRepository = Mockito.mock(ProdutoRepository.class);
        produto = new Produto("Monange", 10.0, "Creme hidratante", qualquerCoisa);
    }

    @Test
    public void deveAdicionarProduto(){
        String mensagemEsperada = "Produto adicionado com sucesso!";
        Mockito.when(produtoRepository.adicionarProduto(produto)).thenReturn(mensagemEsperada); //Mock

        ServicoDeCriacaoDeProduto servico = new ServicoDeCriacaoDeProduto(produtoRepository);
        String resposta = servico.cadastrarProduto(produto);

        Assertions.assertThat(resposta).isEqualTo(mensagemEsperada);

    }

}