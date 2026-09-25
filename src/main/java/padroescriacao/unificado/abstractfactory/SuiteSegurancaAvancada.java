package padroescriacao.unificado.abstractfactory;

public class SuiteSegurancaAvancada implements ISuiteSeguranca {

    @Override
    public IFirewall criarFirewall() {
        return new FirewallAvancado();
    }

    @Override
    public IAntivirus criarAntivirus() {
        return new AntivirusAvancado();
    }
}