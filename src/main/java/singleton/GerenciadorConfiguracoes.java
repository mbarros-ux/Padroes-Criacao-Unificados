package padroescriacao.unificado.singleton;

public class GerenciadorConfiguracoes {

    private static GerenciadorConfiguracoes instancia;
    private String nivelSeguranca;
    private boolean modoProducao;

    private GerenciadorConfiguracoes() {
        this.nivelSeguranca = "PADRAO";
        this.modoProducao = false;
    }

    public static GerenciadorConfiguracoes getInstancia() {
        if (instancia == null) {
            instancia = new GerenciadorConfiguracoes();
        }
        return instancia;
    }

    public String getNivelSeguranca() {
        return nivelSeguranca;
    }

    public void setNivelSeguranca(String nivelSeguranca) {
        this.nivelSeguranca = nivelSeguranca;
    }

    public boolean isModoProducao() {
        return modoProducao;
    }

    public void setModoProducao(boolean modoProducao) {
        this.modoProducao = modoProducao;
    }

    public String exibirConfiguracoes() {
        return "Configurações: Nivel=" + nivelSeguranca + ", Producao=" + modoProducao;
    }
}