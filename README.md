# Padrões de Criação Unificados - Sistema de Segurança Corporativa

Implementação unificada dos padrões de projeto **Singleton**, **Factory Method** e **Abstract Factory** em Java, aplicados a um domínio de Cibersegurança.

## Descrição

Este projeto demonstra como três padrões de criação distintos podem coexistir e resolver problemas diferentes dentro de um mesmo sistema. O foco é mostrar a arquitetura de um **Sistema de Segurança Corporativa** onde:

1.  **Singleton** gerencia o estado global (configurações).
2.  **Factory Method** instancia ferramentas pontuais sob demanda.
3.  **Abstract Factory** provisiona famílias completas de produtos compatíveis (suites).

## Estrutura do Projeto
```bash
src/
├── main/
│ └── padroescriacao/unificado/
│ ├── singleton/
│ │ └── GerenciadorConfiguracoes.java
│ ├── factorymethod/
│ │ ├── IFerramentaSeguranca.java
│ │ ├── FerramentaFactory.java
│ │ └── (Implementações Concretas)
│ ├── abstractfactory/
│ │ ├── ISuiteSeguranca.java
│ │ ├── (Interfaces de Produtos)
│ │ └── (Fábricas e Produtos Concretos)
│ └── SistemaSegurancaCorporativa.java
│
└── test/
└── padroescriacao/unificado/
└── SistemaUnificadoTest.java
```


##  Padrões Implementados

### 1. Singleton: GerenciadorConfiguracoes
**Fato:** Garante que uma classe tenha apenas uma instância e fornece um ponto de acesso global a ela.
**Aplicação:** O `GerenciadorConfiguracoes` armazena o `nivelSeguranca` e o `modoProducao`. Como essas configurações afetam todo o sistema, é crucial que não existam múltiplas instâncias com valores conflitantes.

### 2. Factory Method: FerramentaFactory
**Fato:** Define uma interface para criar um objeto, mas deixa as subclasses (ou a própria lógica da factory) decidirem qual classe instanciar.
**Aplicação:** A `FerramentaFactory` recebe um parâmetro (ex: "CRIPTOGRAFIA") e retorna a instância concreta correspondente. O cliente (`SistemaSegurancaCorporativa`) não precisa saber como a ferramenta é construída, apenas que ela implementa `IFerramentaSeguranca`.

### 3. Abstract Factory: SuiteSeguranca
**Fato:** Fornece uma interface para criar famílias de objetos relacionados ou dependentes sem especificar suas classes concretas.
**Aplicação:** As fábricas `SuiteSegurancaBasica` e `SuiteSegurancaAvancada` garantem que, ao solicitar uma suite, o sistema receba um Firewall e um Antivírus do mesmo nível (ambos básicos ou ambos avançados), evitando incompatibilidades.

##  Diagrama de Classes

O diagrama abaixo ilustra a arquitetura unificada. Ele está dividido em três zonas lógicas que representam a responsabilidade de cada padrão.

### Análise da Estrutura Visual

1.  **Zona Superior Esquerda (Singleton):**
    A classe `GerenciadorConfiguracoes` possui um estereótipo `<<singleton>>`. A seta de dependência que sai e retorna para a própria classe representa o atributo estático `instancia`, que armazena a única referência válida do objeto.

2.  **Zona Inferior Esquerda (Factory Method):**
    A `FerramentaFactory` possui uma relação de dependência (seta tracejada com rótulo "cria") apontando para a interface `IFerramentaSeguranca`. As classes concretas (`FerramentaCriptografia`, `Firewall`, `Scanner`) implementam essa interface (seta tracejada com triângulo vazio). Isso permite que a factory retorne qualquer uma dessas ferramentas de forma polimórfica.

3.  **Zona Direita (Abstract Factory):**
    Esta é a estrutura mais complexa. A interface `ISuiteSeguranca` atua como a fábrica abstrata.
    *   **Relação de Criação:** Ela possui setas "cria" apontando para as interfaces de produtos `IFirewall` e `IAntivirus`.
    *   **Relação de Implementação:** As classes `SuiteSegurancaBasica` e `SuiteSegurancaAvancada` implementam a fábrica.
    *   **Produtos Concretos:** As classes `FirewallBasico`, `FirewallAvancado`, etc., implementam as interfaces de produtos. Note que não há setas diretas entre as Suites e os Produtos Concretos no diagrama de alto nível, pois a fábrica conhece apenas as interfaces, mantendo o desacoplamento.

## 🔑 Diferenças entre os Padrões de Criação

| Padrão | Categoria | Escopo | Quando Usar | Exemplo no Projeto |
| :--- | :--- | :--- | :--- | :--- |
| **Singleton** | Criacional | Instância única | Quando precisa de exatamente uma instância global compartilhada | `GerenciadorConfiguracoes` — configurações globais do sistema |
| **Factory Method** | Criacional | Um objeto por vez | Quando quer delegar a criação de um objeto específico sem expor a lógica | `FerramentaFactory` — cria ferramentas individuais (Criptografia, Firewall, Scanner) |
| **Abstract Factory** | Criacional | Família de objetos | Quando precisa criar grupos de objetos relacionados que devem ser compatíveis entre si | `SuiteSegurancaBasica/Avancada` — cria suites completas (Firewall + Antivírus do mesmo nível) |

## Testes
- O projeto contém 7 testes unitários que validam:
- A unicidade da instância do Singleton.
- A criação correta de ferramentas via Factory Method.
- O tratamento de exceções para entradas inválidas.
- A consistência das famílias de produtos criadas pelo Abstract Factory.

## Tecnologias
- Java 21
- JUnit 5 (JUnit Jupiter)
- IntelliJ IDEA
- Maven (gerenciamento de dependências)
- Draw.io (diagrama UML)

##  Conceitos Aplicados

- **Padrão Criacional Singleton**: Controle de instância única com acesso global
- **Padrão Criacional Factory Method**: Delegação de criação de objetos para método factory
- **Padrão Criacional Abstract Factory**: Criação de famílias de objetos relacionados
- **Composição de Padrões**: Integração de múltiplos padrões em uma arquitetura coesa
