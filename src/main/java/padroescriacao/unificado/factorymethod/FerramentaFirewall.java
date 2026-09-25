package padroescriacao.unificado.factorymethod;

public class FerramentaFirewall implements IFerramentaSeguranca {

    @Override
    public String executar() {
        return "Firewall com regras de filtragem ativado";
    }

    @Override
    public String cancelar() {
        return "Firewall desativado";
    }
}