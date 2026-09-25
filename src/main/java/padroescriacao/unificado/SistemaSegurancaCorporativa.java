package padroescriacao.unificado;

import padroescriacao.unificado.singleton.GerenciadorConfiguracoes;
import padroescriacao.unificado.factorymethod.IFerramentaSeguranca;
import padroescriacao.unificado.factorymethod.FerramentaFactory;
import padroescriacao.unificado.abstractfactory.ISuiteSeguranca;
import padroescriacao.unificado.abstractfactory.SuiteSegurancaBasica;
import padroescriacao.unificado.abstractfactory.SuiteSegurancaAvancada;

public class SistemaSegurancaCorporativa {

    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE SEGURANÇA CORPORATIVA ===\n");

        // Usando SINGLETON
        System.out.println("1. Singleton:");
        GerenciadorConfiguracoes config = GerenciadorConfiguracoes.getInstancia();
        config.setNivelSeguranca("AVANCADO");
        config.setModoProducao(true);
        System.out.println(config.exibirConfiguracoes());
        System.out.println();

        // Usando FACTORY METHOD
        System.out.println("2. Factory Method:");
        IFerramentaSeguranca criptografia = FerramentaFactory.criarFerramenta("CRIPTOGRAFIA");
        IFerramentaSeguranca firewall = FerramentaFactory.criarFerramenta("FIREWALL");
        IFerramentaSeguranca scanner = FerramentaFactory.criarFerramenta("SCANNER");

        System.out.println("- " + criptografia.executar());
        System.out.println("- " + firewall.executar());
        System.out.println("- " + scanner.executar());
        System.out.println();

        // Usando ABSTRACT FACTORY
        System.out.println("3. Abstract Factory");

        // Suite Básica
        ISuiteSeguranca suiteBasica = new SuiteSegurancaBasica();
        System.out.println("Suite Básica:");
        System.out.println("  - " + suiteBasica.criarFirewall().ativar());
        System.out.println("  - " + suiteBasica.criarAntivirus().ativar());

        // Suite Avançada
        ISuiteSeguranca suiteAvancada = new SuiteSegurancaAvancada();
        System.out.println("Suite Avançada:");
        System.out.println("  - " + suiteAvancada.criarFirewall().ativar());
        System.out.println("  - " + suiteAvancada.criarAntivirus().ativar());
        System.out.println();

        // Demonstrando que Singleton é único
        System.out.println("4. VALIDAÇÃO DO SINGLETON:");
        GerenciadorConfiguracoes config2 = GerenciadorConfiguracoes.getInstancia();
        System.out.println("Mesma instância? " + (config == config2));
        System.out.println("Config2: " + config2.exibirConfiguracoes());
    }
}