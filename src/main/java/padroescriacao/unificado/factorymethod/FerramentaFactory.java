package padroescriacao.unificado.factorymethod;

public class FerramentaFactory {

    public static IFerramentaSeguranca criarFerramenta(String tipo) {
        switch (tipo.toUpperCase()) {
            case "CRIPTOGRAFIA":
                return new FerramentaCriptografia();
            case "FIREWALL":
                return new FerramentaFirewall();
            case "SCANNER":
                return new FerramentaScanner();
            default:
                throw new IllegalArgumentException("Ferramenta desconhecida: " + tipo);
        }
    }
}