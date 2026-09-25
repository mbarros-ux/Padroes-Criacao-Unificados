package padroescriacao.unificado.factorymethod;

public class FerramentaScanner implements IFerramentaSeguranca {

    @Override
    public String executar() {
        return "Scanner de vulnerabilidades em execução";
    }

    @Override
    public String cancelar() {
        return "Scanner parado";
    }
}