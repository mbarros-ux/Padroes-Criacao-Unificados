package padroescriacao.unificado.abstractfactory;

// Fábrica Abstrata
public interface ISuiteSeguranca {
    IFirewall criarFirewall();
    IAntivirus criarAntivirus();
}