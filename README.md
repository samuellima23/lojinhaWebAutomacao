# Lojinha Web Automação
Esse repositório contém automação de alguns testes Web de um software denominado como Lojinha, presente no Programa de testes e qualidade de software. Os sub-tópicos abaixo descrevem algumas decisões tomadas na estruturação do projeto. Além disso possui informações sobre técnica de testes, a técnica utilizada foi a de testes exploratórios baseados em sessão usando a heurística CHIQUE, que será explicada no tópico em questão.

## Tecnologias utilizadas
- Java (https://www.oracle.com/br/java/technologies/downloads/#jdk20-windows)
- JUnit (https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.9.1)
- Maven (https://maven.apache.org/)
- Selenium (https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.8.3)

## Testes Automatizados
Testes para validar as partições de equivalência relacionadas ao valor do produto da Lojinha, a partição de equivalência é uma técnica de teste aplicada a **regras de negócio**, nessa regra não era permitido cadastrar produtos com valores menores na faixa de R$0,01 e R$7000 (um centavo, sete mil reais). Para complementar essa regra também foram automatizados os testes para a técnica de valores limite.

![image](https://user-images.githubusercontent.com/33026663/231018707-b0be091a-681d-4a43-bae4-7a886a2b6a4f.png)

![image](https://user-images.githubusercontent.com/33026663/231018798-b4a33b40-db41-4bd8-9c67-e06d511e6ff6.png)


## Partições de Equivalência e Valores Limite
Ambas as técnicas de partições de equivalência e valores limite são aplicadas a regras de negócio, na partição de equivalência devemos identificar as entradas do usuário na aplicação e dividi-las em faixas de possíveis valores para que um desses seja usado como base para o teste. Já o valor limite somente se aplica a números ou seja, se há uma faixa de valores, assim complementamos as partições de equivalência onde escolhemos os limites de valores que podem ser usados como entrada pelo usuário. Abaixo seguem exemplos de como aplicar essa técnica com as entradas da Lojinha.
- Partição de equivalência:

![image](https://user-images.githubusercontent.com/33026663/231015554-bf6f4e57-0d48-41c5-9c95-f07e7301255b.png)

- Valores Limite:

![image](https://user-images.githubusercontent.com/33026663/231015269-692881ee-feeb-492c-a811-0d50e5dda211.png)

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

![image](https://user-images.githubusercontent.com/33026663/231019547-0f173b41-f0ad-4098-a2f3-c884e71a1233.png)

![image](https://user-images.githubusercontent.com/33026663/231019469-b9cc6ffc-5b9d-411d-b4b0-268979a39244.png)


### Relatório de sessão
#### 1. Charter
Explore a jornada de edição de produtos, com o uso da heurística CHIQUE, para saber se a aplicação é aderente as principais funcionalidades em contexto web.
#### 2. Hora de início:
16:55
#### 3. Testador:
Samuel
#### 4. Divisão da tarefa:
4.1 - Duração 10min; 
4.2 - 75% execução, 22% investigação e 3% configuração; 
4.3 - 70% Charter e 30% Oportunidade
#### 5. Arquivos

![lojinha icone](https://user-images.githubusercontent.com/33026663/231016185-49660597-d3a6-4fd8-96cd-c297a7754652.png)


#### 6. Notas Gerais
- O ícone em anexo no tópico de Arquivos, para mim aparenta ser clicável e que teremos as informações da lojinha a ser exibida em sequência, interessante discutirmos se esse componente da UI não pode ser melhorado.

- É possível salvar o produto sem preencher o campo nome (B1)

- É possível salvar o produto sem preencher o campo cor

- É possível salvar um componente sem preencher o campo nome
#### 7. Bugs
- B1 – Na edição de produtos é possível salvar produto sem nome, o produto salvo sem nome não pode ser acessado para edição pois o link para acesso está posicionado no nome
#### 8. Dúvidas
- O campo cores não deveria ser obrigatório?

- O campo nome nos componentes não deveria ser obrigatório?
