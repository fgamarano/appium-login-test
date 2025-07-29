package pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {
    private AppiumDriver driver;

    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Selecione um Servidor']")
    private WebElement btnSelecionarServidor;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Custom']")
    private WebElement opcaoCustom;

    @AndroidFindBy(className = "android.widget.EditText")
    private WebElement campoServidor;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Continue']")
    private WebElement btnContinuar;

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text, '@')]")
    private WebElement campoEmail;

    @AndroidFindBy(id = "android:id/message")
    private WebElement mensagemErro;

    public void selecionarServidorCustom() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(btnSelecionarServidor));
        btnSelecionarServidor.click();
        opcaoCustom.click();
    }

    public void preencherServidor(String valor) {
        campoServidor.sendKeys(valor);
        btnContinuar.click();
    }

    public void preencherEmail(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(campoEmail));
        campoEmail.clear();
        campoEmail.sendKeys(email);
        btnContinuar.click();
    }

    public String obterMensagemErro() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(mensagemErro));
        return mensagemErro.getText();
    }

    public boolean botaoSelecionarServidorVisivel() {
        return btnSelecionarServidor.isDisplayed();
    }
}