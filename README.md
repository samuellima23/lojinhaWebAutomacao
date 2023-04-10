# Lojinha Web Automação
Esse repositório contém automação de alguns testes Web de um software denominado como Lojinha, presente no Programa de testes e qualidade de software. Os sub-tópicos abaixo descrevem algumas decisões tomadas na estruturação do projeto. Além disso possui informações sobre técnica de testes, a técnica utilizada foi a de testes exploratórios baseados em sessão usando a heurística CHIQUE, que será explicada no tópico em questão.

## Tecnologias utilizadas
- Java (https://www.oracle.com/br/java/technologies/downloads/#jdk20-windows)
- JUnit (https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.9.1)
- Maven (https://maven.apache.org/)
- Selenium (https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.8.3)

## Testes Automatizados
Testes para validar as partições de equivalência relacionadas ao valor do produto da Lojinha, a partição de equivalência é uma técnica de teste aplicada a **regras de negócio**, nessa regra não era permitido cadastrar produtos com valores menores na faixa de R$0,01 e R$7000 (um centavo, sete mil reais). Para complementar essa regra também foram automatizados os testes para a técnica de valores limite.

## Partições de Equivalência e Valores Limite
Ambas as técnicas de partições de equivalência e valores limite são aplicadas a regras de negócio, na partição de equivalência devemos identificar as entradas do usuário na aplicação e dividi-las em faixas de possíveis valores para que um desses seja usado como base para o teste. Já o valor limite somente se aplica a números ou seja, se há uma faixa de valores, assim complementamos as partições de equivalência onde escolhemos os limites de valores que podem ser usados como entrada pelo usuário. Abaixo seguem exemplos de como aplicar essa técnica com as entradas da Lojinha:

## Notas Gerais
- Usamos o design pattern conhecido como Page Object para aprimorar a manutenção do teste e reduzir a duplicação de código.

## Testes exploratórios baseados em sessão
Método criado em 2000 por Jon e James Bach, voltado a trazer mais prestação de contas a atividade de testes exploratórios. Nessa técnica possuímos um relatório de sessão com alguns pontos a serem preenchidos:

1. Charter
2. Hora de inicio
3. Testador
4. Divisão da tarefa: 4.1 - Duração; 4.2 - %execução, %investigação e % configuração; 4.3 - %Charter e % Oportunidade
5. Arquivos
6. Notas Gerais
7. Bugs
8. Dúvidas

## Execução de testes exploratórios baseados em sessão usando a heurística CHIQUE
CHIQUE:
- **C**ampos obrigatórios
- **H**abilitar/Desabilitar formulários
- **I**nterrupção da ação
- **Q**uebra de fluxos
- **U**sabilidade dos menus
- **E**stouro de campos
### Relatório de sessão
#### Charter
Explore a jornada de edição de produtos, com o uso da heurística CHIQUE, para saber se a aplicação é aderente as principais funcionalidades em contexto web.
#### Hora de início:
16:55
#### Testador:
Samuel
#### Divisão da tarefa:
4.1 - Duração 10min; 4.2 - 75%execução, 22%investigação e 3% configuração; 4.3 - 70%Charter e 30% Oportunidade
#### Arquivos

#### Notas Gerais
- O ícone em anexo no tópico de Arquivos, para mim aparenta ser clicável e que teremos as informações da lojinha a ser exibida em sequência, interessante discutirmos se esse componente da UI não pode ser melhorado.

- É possível salvar o produto sem preencher o campo nome (B1)

- É possível salvar o produto sem preencher o campo cor

- É possível salvar um componente sem preencher o campo nome
#### Bugs
- B1 – Na edição de produtos é possível salvar produto sem nome, o produto salvo sem nome não pode ser acessado para edição pois o link para acesso está posicionado no nome
#### Dúvidas
- O campo cores não deveria ser obrigatório?

- O campo nome nos componentes não deveria ser obrigatório?
