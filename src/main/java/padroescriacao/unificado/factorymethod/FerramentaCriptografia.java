package padroescriacao.unificado.factorymethod;

public class FerramentaCriptografia implements IFerramentaSeguranca {

    @Override
    public String executar() {
        return "Criptografia ativada";
    }

    @Override
    public String cancelar() {
        return "Criptografia desativada";
    }
}