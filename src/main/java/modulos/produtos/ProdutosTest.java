package modulos.produtos;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.LoginPage;
import java.time.Duration;


@DisplayName("Testes web do modulo de produtos")
public class ProdutosTest {

    private WebDriver navegador;
    @BeforeEach
    public void beforeEach(){
        //Abrir o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver_win32\\chromedriver.exe");
        this.navegador = new ChromeDriver();

        //Maximizar a tela
        this.navegador.manage().window().maximize();

        //Definindo um tempo de espera de 05 segundos
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Navegar para a lojinha Web
        this.navegador.get("http://165.227.93.41/lojinha-web/v2/");

    }
    @Test
    @DisplayName("Não é permitido registrar um produto com valor igual a zero")
    public void testNaoEPermitidoRegistrarComValorIgualAZero() {
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarOFormularioDeAdicaoDeNovoProduto()
                .informarNomeDoProduto("Notebook")
                .informarValorDoProduto("0.00")
                .informarCorDoProduto("preto, branco")
                .submeterOFormularioComErro()
                .capturarMensagemApresentada();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00",mensagemApresentada);

    }
    @Test
    @DisplayName("Não é permitido registrar um produto com valor igual a sete mil e um centavo")
    public void testNaoEPermitidoRegistrarComValorIgualSeteMilEUmCentavo() {
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarOFormularioDeAdicaoDeNovoProduto()
                .informarNomeDoProduto("Notebook")
                .informarValorDoProduto("700001")
                .informarCorDoProduto("preto, branco")
                .submeterOFormularioComErro()
                .capturarMensagemApresentada();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00",mensagemApresentada);

    }
    @Test
    @DisplayName("Posso Adicionar produtos que possuam o valor de 7.000,00")
    public void testPossoAdicionarProdutosComValorDeSeteMilReais(){
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarOFormularioDeAdicaoDeNovoProduto()
                .informarNomeDoProduto("Notebook")
                .informarValorDoProduto("7000")
                .informarCorDoProduto("preto, branco")
                .submeterOFormularioCorretamente()
                .capturarMensagemApresentada();


        //Vou validar que a mensagem de sucesso foi apresentada
        Assertions.assertEquals("Produto adicionado com sucesso",mensagemApresentada);
    }
    @Test
    @DisplayName("Posso Adicionar produtos que possuam o valor de 0.01")
    public void testPossoAdicionarProdutosComValorDeUmCentavo(){
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarOFormularioDeAdicaoDeNovoProduto()
                .informarNomeDoProduto("Notebook")
                .informarValorDoProduto("001")
                .informarCorDoProduto("preto, branco")
                .submeterOFormularioCorretamente()
                .capturarMensagemApresentada();


        //Vou validar que a mensagem de sucesso foi apresentada
        Assertions.assertEquals("Produto adicionado com sucesso",mensagemApresentada);
    }
    @Test
    @DisplayName("Não é permitido registrar um produto com valor maior que sete mil")
    public void testNaoEPermitidoRegistrarComValorMaiorQueSeteMil() {
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarOFormularioDeAdicaoDeNovoProduto()
                .informarNomeDoProduto("Notebook")
                .informarValorDoProduto("750001")
                .informarCorDoProduto("preto, branco")
                .submeterOFormularioComErro()
                .capturarMensagemApresentada();


        //Vou validar que a mensagem de erro foi apresentada

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00",mensagemApresentada);
    }
    @Test
    @DisplayName("Posso Adicionar produtos que estejam na faixa de 0,01 a 7.000,00")
    public void testPossoAdicionarProdutosComValoresMaioresQueZeroEMenoresQueSeteMilEUmCentavo(){
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarOFormularioDeAdicaoDeNovoProduto()
                .informarNomeDoProduto("Notebook")
                .informarValorDoProduto("5000")
                .informarCorDoProduto("preto, branco")
                .submeterOFormularioCorretamente()
                .capturarMensagemApresentada();


        //Vou validar que a mensagem de sucesso foi apresentada
        Assertions.assertEquals("Produto adicionado com sucesso",mensagemApresentada);
    }


    @AfterEach
    public void afterEach(){
        //Fechar o navegador
        navegador.quit();
    }
}
