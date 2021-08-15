public class AutorizacaoStubSpy implements Autorizacao{

    public boolean autorizarExclusaoFoiChamado;

    @Override
    public boolean autorizarExclusao(Produto produto) {
        autorizarExclusaoFoiChamado = true;
        return true;
    }
}
