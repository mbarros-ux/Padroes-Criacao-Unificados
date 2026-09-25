package padroescriacao.unificado.abstractfactory;

public class SuiteSegurancaBasica implements ISuiteSeguranca {

    @Override
    public IFirewall criarFirewall() {
        return new FirewallBasico();
    }

    @Override
    public IAntivirus criarAntivirus() {
        return new AntivirusBasico();
    }
}