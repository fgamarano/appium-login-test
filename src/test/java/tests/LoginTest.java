package tests;

import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import config.DriverManager;
import pages.LoginPage;

public class LoginTest {

    private static LoginPage loginPage;

    @BeforeClass
    public static void setUp() {
        DriverManager.initializeDriver();
        loginPage = new LoginPage(DriverManager.driver);
    }

    @Before
    public void reiniciarAplicativo() {
        DriverManager.driver.terminateApp("com.sigga.platform.empower.pr");
        DriverManager.driver.activateApp("com.sigga.platform.empower.pr");
    }

    @Test
    public void deveExibirMensagemErroComServidorInvalido() {
        System.out.println("Botão visível? " + loginPage.botaoSelecionarServidorVisivel());
        loginPage.selecionarServidorCustom();
        loginPage.preencherServidor("servidor-invalido");
        String mensagem = loginPage.obterMensagemErro();
        System.out.println("Mensagem de erro: " + mensagem);
        assertEquals("Não foi possível recuperar o certificado do servidor. Tente mais tarde.", mensagem);
    }

    @Test
    public void deveExibirMensagemErroComEmailInvalido() {
        loginPage.selecionarServidorCustom();
        loginPage.preencherServidor("stg");
        loginPage.preencherEmail("candidato@processoseletivo.com");
        String mensagem = loginPage.obterMensagemErro();
        System.out.println("Mensagem de erro: " + mensagem);
        assertEquals("Usuário Inválido!", mensagem);
    }

    @AfterClass
    public static void tearDown() {
        DriverManager.stopDriver();
    }
}