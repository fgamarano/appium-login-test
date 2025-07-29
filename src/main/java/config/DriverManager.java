package config;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class DriverManager {

    public static AndroidDriver driver;

    public static void initializeDriver() {
        try {
            UiAutomator2Options options = new UiAutomator2Options()
                    .setPlatformName("Android")
                    .setPlatformVersion("13.0")
                    .setDeviceName("0075444986")
                    .setAutomationName("UIAutomator2")
                    .setAppPackage("com.sigga.platform.empower.pr")
                    .setAppActivity("crc6442cd7d981b8a9420.MainActivity")
                    .setNoReset(true)
                    .setNewCommandTimeout(Duration.ofSeconds(300));

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Erro ao iniciar o Appium Driver", e);
        }
    }

    public static void stopDriver() {
        if (driver != null) {
            // driver.quit(); // omitido por compatibilidade
        }
    }
}
