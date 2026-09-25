package padroescriacao.unificado;

import org.junit.jupiter.api.Test;
import padroescriacao.unificado.singleton.GerenciadorConfiguracoes;
import padroescriacao.unificado.factorymethod.IFerramentaSeguranca;
import padroescriacao.unificado.factorymethod.FerramentaFactory;
import padroescriacao.unificado.abstractfactory.ISuiteSeguranca;
import padroescriacao.unificado.abstractfactory.SuiteSegurancaBasica;
import padroescriacao.unificado.abstractfactory.SuiteSegurancaAvancada;

import static org.junit.jupiter.api.Assertions.*;

class SistemaUnificadoTest {

    // Singleton
    @Test
    void deveRetornarMesmaInstanciaDoSingleton() {
        GerenciadorConfiguracoes config1 = GerenciadorConfiguracoes.getInstancia();
        GerenciadorConfiguracoes config2 = GerenciadorConfiguracoes.getInstancia();
        assertSame(config1, config2);
    }

    @Test
    void deveManterConfiguracoesGlobais() {
        GerenciadorConfiguracoes config = GerenciadorConfiguracoes.getInstancia();
        config.setNivelSeguranca("MAXIMO");
        assertEquals("MAXIMO", config.getNivelSeguranca());
    }

    // Factory Method
    @Test
    void deveCriarFerramentaCriptografia() {
        IFerramentaSeguranca ferramenta = FerramentaFactory.criarFerramenta("CRIPTOGRAFIA");
        assertNotNull(ferramenta);
        assertTrue(ferramenta.executar().contains("Criptografia"));
    }

    @Test
    void deveCriarFerramentaFirewall() {
        IFerramentaSeguranca ferramenta = FerramentaFactory.criarFerramenta("FIREWALL");
        assertNotNull(ferramenta);
        assertTrue(ferramenta.executar().contains("Firewall"));
    }

    @Test
    void deveLancarExcecaoParaFerramentaDesconhecida() {
        assertThrows(IllegalArgumentException.class, () -> {
            FerramentaFactory.criarFerramenta("INVALIDA");
        });
    }

    // Abstract Factory
    @Test
    void deveCriarSuiteBasica() {
        ISuiteSeguranca suite = new SuiteSegurancaBasica();
        assertNotNull(suite.criarFirewall());
        assertNotNull(suite.criarAntivirus());
        assertTrue(suite.criarFirewall().ativar().contains("Básico"));
    }

    @Test
    void deveCriarSuiteAvancada() {
        ISuiteSeguranca suite = new SuiteSegurancaAvancada();
        assertNotNull(suite.criarFirewall());
        assertNotNull(suite.criarAntivirus());
        assertTrue(suite.criarFirewall().ativar().contains("Avançado"));
    }
}