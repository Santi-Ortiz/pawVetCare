package com.example.demo.e2e;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import io.github.bonigarcia.wdm.WebDriverManager;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class prueba1 {
    
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void init() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-extensions");
        this.driver = new ChromeDriver(chromeOptions);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void IngresarComoVeterinario() {
        // Navega a la página principal
        driver.get("http://localhost:4200/home");

        // Empezar con un zoom diferente
        ((JavascriptExecutor) driver).executeScript("document.body.style.zoom='70%'");

        // Localiza y hace clic en el botón "Soy PVC"
        WebElement soyPVCButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("buttonSoyPVC")));
        soyPVCButton.click();

        WebElement soyVetContainer = driver.findElement(By.className("container-veterinario"));
        WebElement soyVetButton = soyVetContainer.findElement(By.className("text-cliente"));
        wait.until(ExpectedConditions.elementToBeClickable(soyVetButton)).click();

        // Primer intento de ingreso con credenciales incorrectas
        WebElement cedulaInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cedula")));
        cedulaInput.sendKeys("1234");

        WebElement passwordInput =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        passwordInput.sendKeys("1234");

        WebElement verMisMascotasButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='submit'][value='Ver mis mascotas']")));
        verMisMascotasButton.click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();

        // Reintento de ingreso con la contraseña correcta
        cedulaInput.clear();
        passwordInput.clear();

        cedulaInput.sendKeys("1234");
        passwordInput.sendKeys("vet");
        verMisMascotasButton.click();

        // Navegar a la sección "CLIENTES"
        WebElement clientesLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[routerlink='/clientes']")));
        clientesLink.click();

        // Completar formulario de cliente con campo de cédula incorrecto
        WebElement nombreInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nombre")));
        nombreInput.sendKeys("Juan");
        
        WebElement cedulaClienteInput = driver.findElement(By.id("cedula"));
        cedulaClienteInput.sendKeys("1235062800");

        WebElement correoInput = driver.findElement(By.id("correo"));
        correoInput.sendKeys("juan.anga@correo.com");

        WebElement celularInput = driver.findElement(By.id("celular"));
        celularInput.sendKeys("3175591382");

        WebElement agregarClienteButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("agregar-button")));
        agregarClienteButton.click();

        Alert alert2 = wait.until(ExpectedConditions.alertIsPresent());
        alert2.accept(); // Aceptar alerta

        // Completar el campo de cédula otra vez
        cedulaClienteInput.clear();
        cedulaClienteInput.sendKeys("1033096545");
        agregarClienteButton.click();

        Alert alert3 = wait.until(ExpectedConditions.alertIsPresent());
        alert3.accept(); // Aceptar alerta

        // Buscar al cliente por cédula
        WebElement buscadorInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("id")));
        buscadorInput.sendKeys("1033096545");

        WebElement buscarButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("buscador-button")));
        buscarButton.click();

        // Validar los datos del cliente
        WebElement nombreDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[formcontrolname='nombre']")));
        WebElement cedulaDisplayed = driver.findElement(By.cssSelector("input[formcontrolname='cedula']"));
        WebElement correoDisplayed = driver.findElement(By.cssSelector("input[formcontrolname='correo']"));
        WebElement celularDisplayed = driver.findElement(By.cssSelector("input[formcontrolname='celular']"));

        Assertions.assertEquals("Juan", nombreDisplayed.getAttribute("value"), "El nombre no coincide.");
        Assertions.assertEquals("1033096545", cedulaDisplayed.getAttribute("value"), "La cédula no coincide.");
        Assertions.assertEquals("juan.anga@correo.com", correoDisplayed.getAttribute("value"), "El correo no coincide.");
        Assertions.assertEquals("3175591382", celularDisplayed.getAttribute("value"), "El celular no coincide.");

        // Hacer clic en el enlace "MASCOTAS"
        WebElement linkMascotas = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("MASCOTAS")));
        linkMascotas.click();

        // Completar los campos del formulario de mascota
        WebElement nombreMasInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nombre")));
        nombreMasInput.clear();
        nombreMasInput.sendKeys("Pacco");

        WebElement razaInput = driver.findElement(By.id("raza"));
        razaInput.clear();
        razaInput.sendKeys("Golden Retriever");

        WebElement pesoInput = driver.findElement(By.id("peso"));
        pesoInput.clear();
        pesoInput.sendKeys("20");

        WebElement edadInput = driver.findElement(By.id("edad"));
        edadInput.clear();
        edadInput.sendKeys("3");

        WebElement enfermedadInput = driver.findElement(By.id("enfermedad"));
        enfermedadInput.clear();
        enfermedadInput.sendKeys("Gastritis");

        WebElement duenoInput = driver.findElement(By.id("dueno"));
        duenoInput.clear();
        duenoInput.sendKeys("1033096545");

        WebElement estadoSelect = driver.findElement(By.name("estado"));
        estadoSelect.click();
        WebElement opcionActivo = estadoSelect.findElement(By.cssSelector("option[value='true']"));
        opcionActivo.click();

        WebElement fotoInput = driver.findElement(By.id("url"));
        fotoInput.clear();
        fotoInput.sendKeys("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQtJU_aRybhiJnVUitOFKoexK89bvCy4oyB5ACTXE8zUxF8xhVM");

        WebElement agregarMascotaButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("agregar-button")));
        agregarMascotaButton.click();

        Alert alert4 = wait.until(ExpectedConditions.alertIsPresent());
        alert4.accept(); // Aceptar alerta

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("buscador-input")));

        // Hacer clic en el enlace "MASCOTAS"
        WebElement linkMascotas2 = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("MASCOTAS")));
        linkMascotas2.click();

        // Buscar la mascota por nombre
        WebElement buscarInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("nombreMascota")));
        buscarInput.clear();
        buscarInput.sendKeys("Pacco");

        WebElement buscarMascotaButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("buscador-button")));
        buscarMascotaButton.click();

        // Hacer clic en el enlace "+ Info" de la mascota encontrada
        WebElement infoButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("info-button")));
        infoButton.click();

        // Verificar que los datos mostrados coincidan con los de la mascota agregada
        WebElement nombreLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[formcontrolname='nombre']")));
        Assertions.assertEquals("Pacco", nombreLabel.getAttribute("value"));

        WebElement razaLabel = driver.findElement(By.cssSelector("input[formcontrolname='raza']"));
        Assertions.assertEquals("Golden Retriever", razaLabel.getAttribute("value"));
    }

        @Test
    public void IngresarComoCliente() {
        // Navega a la página principal
        driver.get("http://localhost:4200/home");

        // Empezar con un zoom diferente
        ((JavascriptExecutor) driver).executeScript("document.body.style.zoom='70%'");

        // Localiza y hace clic en el botón "Soy PVC"
        WebElement soyPVCButton = driver.findElement(By.className("buttonSoyPVC"));
        soyPVCButton.click();

        // Localiza y hace clic en el botón "¡Soy Vet!"
        WebElement soyClienteContainer = driver.findElement(By.className("container-cliente"));
        WebElement soyClienteButton = soyClienteContainer.findElement(By.className("text-cliente"));
        soyClienteButton.click();

        // Primer intento de ingreso con credenciales incorrectas
        WebElement cedulaClientInput = driver.findElement(By.id("cedula"));
        cedulaClientInput.sendKeys("1033096545");

        WebElement verMisMascotasButton2 = driver.findElement(By.cssSelector("input[type='submit'][value='Ver mis mascotas']"));
        verMisMascotasButton2.click();

        // Hacer clic en el enlace "+ Info" de la mascota encontrada
        WebElement infoButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.className("info-button")));
        infoButton2.click();

        // Verificar que los datos mostrados coincidan con los de la mascota agregada
        WebElement nombreLabel2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[formcontrolname='nombre']")));
        String nombreMascota2 = nombreLabel2.getAttribute("value");
        Assertions.assertEquals("Pacco", nombreMascota2);

        WebElement razaLabel2 = driver.findElement(By.cssSelector("input[formcontrolname='raza']"));
        String razaMascota2 = razaLabel2.getAttribute("value");
        Assertions.assertEquals("Golden Retriever", razaMascota2);

        WebElement edadLabel2 = driver.findElement(By.cssSelector("input[formcontrolname='edad']"));
        String edadMascota2 = edadLabel2.getAttribute("value");
        Assertions.assertEquals("3", edadMascota2);

        WebElement pesoLabel2 = driver.findElement(By.cssSelector("input[formcontrolname='peso']"));
        String pesoMascota2 = pesoLabel2.getAttribute("value");
        Assertions.assertEquals("20", pesoMascota2);

        WebElement enfermedadLabel2 = driver.findElement(By.cssSelector("input[formcontrolname='enfermedad']"));
        String enfermedadMascota2 = enfermedadLabel2.getAttribute("value");
        Assertions.assertEquals("Gastritis", enfermedadMascota2);

        WebElement duenoLabel2 = driver.findElement(By.cssSelector("input[formcontrolname='cliente']"));
        String cedulaDueno2 = duenoLabel2.getAttribute("value");
        Assertions.assertEquals("1033096545", cedulaDueno2);

        WebElement estadoMasSelect2 = driver.findElement(By.cssSelector("select[formcontrolname='estado']"));
        String estadoMascota2 = estadoMasSelect2.getAttribute("value");
        Assertions.assertEquals("0: true", estadoMascota2); // Se espera que 'true' indique que está activo

        WebElement fotoLabel2 = driver.findElement(By.cssSelector("input[formcontrolname='foto']"));
        String fotoMascota2 = fotoLabel2.getAttribute("value");
        Assertions.assertEquals("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQtJU_aRybhiJnVUitOFKoexK89bvCy4oyB5ACTXE8zUxF8xhVM", fotoMascota2);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}

