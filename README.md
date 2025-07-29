# Teste Automatizado de Login com Appium e JUnit

Este projeto realiza a automação do fluxo de login no aplicativo Sigga Empower, utilizando **Appium**, **JUnit** e **Java**. Ele testa dois cenários principais:

- Login com servidor inválido e validação da mensagem de erro
- Login com servidor válido (`stg`) e e-mail inválido, validando o erro de autenticação

## Estrutura do Projeto

```
src/test/java/
├── config/
│   └── DriverManager.java         # Inicializa o Appium Driver
├── pages/
│   └── LoginPage.java             # Page Object do fluxo de login
└── tests/
    └── LoginTest.java             # Casos de teste JUnit
```

## Requisitos

- Appium Server
- Node.js
- Java 11+
- Maven
- Android SDK configurado
- Emulador ou dispositivo físico com Android 13
- Aplicativo Sigga Empower instalado

## Como Executar

1. Inicie o Appium Server
2. Conecte um dispositivo com o app já instalado
3. Execute os testes com Maven:

```bash
mvn test
```

## Observações

- O projeto utiliza `noReset = true`, então o app **não será desinstalado** entre execuções.
- Os testes são escritos com JUnit 4.
- É possível reiniciar o app com `driver.terminateApp(...)` e `driver.activateApp(...)`

---

Desenvolvido por [fehgamarano](https://github.com/fehgamarano)