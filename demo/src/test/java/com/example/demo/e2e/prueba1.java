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

import io.github.bonigarcia.wdm.WebDriverManager;

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
    public void VeterinarioClienteMascota() {
        // Navega a la página principal
        driver.get("http://localhost:4200/home");

        // Empezar con un zoom diferente
        ((JavascriptExecutor) driver).executeScript("document.body.style.zoom='70%'");

        // Espera para que cargue la página
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Localiza y hace clic en el botón "Soy PVC"
        WebElement soyPVCButton = driver.findElement(By.className("buttonSoyPVC"));
        soyPVCButton.click();

        // Espera para que cargue la siguiente página
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Localiza y hace clic en el botón "¡Soy Vet!"
        WebElement soyVetContainer = driver.findElement(By.className("container-veterinario"));
        WebElement soyVetButton = soyVetContainer.findElement(By.className("text-cliente"));
        soyVetButton.click();

        // Espera para que cargue la página de inicio de sesión
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Primer intento de ingreso con credenciales incorrectas
        WebElement cedulaInput = driver.findElement(By.id("cedula"));
        cedulaInput.sendKeys("1234");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("1234");

        WebElement verMisMascotasButton = driver.findElement(By.cssSelector("input[type='submit'][value='Ver mis mascotas']"));
        verMisMascotasButton.click();

        // Espera para que aparezca la alerta de "Credenciales incorrectas"
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Maneja la alerta de credenciales incorrectas
        Alert alert = driver.switchTo().alert();
        alert.accept(); // Haz clic en "Aceptar" en la alerta

        // Espera para reescribir
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Reintento de ingreso con la contraseña correcta
        cedulaInput.clear(); // Borra el campo de cédula
        passwordInput.clear(); // Borra el campo de contraseña

        cedulaInput.sendKeys("1234");
        passwordInput.sendKeys("vet");

        verMisMascotasButton.click(); // Haz clic en "Ver mis mascotas" nuevamente

        // Espera a la carga de la página
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Navegar a la sección "CLIENTES"
        WebElement clientesLink = driver.findElement(By.cssSelector("a[routerlink='/clientes']"));
        clientesLink.click();

        // Espera a la carga de la página
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Completar formulario de cliente con campo de cédula incorrecto
        WebElement nombreInput = driver.findElement(By.id("nombre"));
        nombreInput.sendKeys("Juan");
        
        WebElement cedulaClienteInput = driver.findElement(By.id("cedula"));
        cedulaClienteInput.sendKeys("1235062800");

        // Completar el campo de correo
        WebElement correoInput = driver.findElement(By.id("correo"));
        correoInput.sendKeys("juan.anga@correo.com");

        WebElement celularInput = driver.findElement(By.id("celular"));
        celularInput.sendKeys("3175591382");

        // Oprimir el botón "Agregar Cliente" para provocar el error
        WebElement agregarClienteButton = driver.findElement(By.className("agregar-button"));
        agregarClienteButton.click();

        // Espera a que la página cargue
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        alert.accept(); // Haz clic en "Aceptar" en la alerta
        
        // Completar el campo de cédula otra vez
        cedulaClienteInput.clear();
        cedulaClienteInput.sendKeys("1033096545");
        
        // Oprimir el botón de agregar cliente
        agregarClienteButton.click();

        // Espera a que la página cargue
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        alert.accept(); // Haz clic en "Aceptar" en la alerta

        // Espera a que la página cargue
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Buscar al cliente por cédula
        WebElement buscadorInput = driver.findElement(By.name("id"));
        buscadorInput.sendKeys("1033096545"); // Ingresar la cédula del cliente
        WebElement buscarButton = driver.findElement(By.className("buscador-button"));
        // Usar WebDriverWait para esperar a que el botón sea clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(buscarButton)).click();

        // Espera a que la página cargue
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Validar los datos del cliente
        WebElement nombreDisplayed = driver.findElement(By.cssSelector("input[formcontrolname='nombre']"));
        WebElement cedulaDisplayed = driver.findElement(By.cssSelector("input[formcontrolname='cedula']"));
        WebElement correoDisplayed = driver.findElement(By.cssSelector("input[formcontrolname='correo']"));
        WebElement celularDisplayed = driver.findElement(By.cssSelector("input[formcontrolname='celular']"));

        // Assertions para validar que los datos son correctos
        Assertions.assertEquals("Juan", nombreDisplayed.getAttribute("value"), "El nombre no coincide.");
        Assertions.assertEquals("1033096545", cedulaDisplayed.getAttribute("value"), "La cédula no coincide.");
        Assertions.assertEquals("juan.anga@correo.com", correoDisplayed.getAttribute("value"), "El correo no coincide.");
        Assertions.assertEquals("3175591382", celularDisplayed.getAttribute("value"), "El celular no coincide.");

        // Hacer clic en el enlace "MASCOTAS"
        WebElement linkMascotas = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("MASCOTAS")));
        linkMascotas.click();

        // Espera a que la página cargue
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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

        // Seleccionar "Activo" en el dropdown de estado
        WebElement estadoSelect = driver.findElement(By.name("estado"));
        estadoSelect.click();
        WebElement opcionActivo = estadoSelect.findElement(By.cssSelector("option[value='true']"));
        opcionActivo.click();

        // Ingresar la URL de la foto
        WebElement fotoInput = driver.findElement(By.id("url"));
        fotoInput.clear();
        fotoInput.sendKeys("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQtJU_aRybhiJnVUitOFKoexK89bvCy4oyB5ACTXE8zUxF8xhVM");

        // Hacer clic en el botón "Agregar Mascota"
        WebElement agregarButton = driver.findElement(By.className("agregar-button"));
        agregarButton.click();

        // Espera a que la página cargue
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        alert.accept(); // Haz clic en "Aceptar" en la alerta

        // Hacer clic en el enlace "MASCOTAS"
        WebElement linkMascotas2 = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("MASCOTAS")));
        linkMascotas2.click();

        // Espera a que la página cargue
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Buscar la mascota por nombre
        WebElement buscarInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("nombreMascota")));
        buscarInput.clear();
        buscarInput.sendKeys("Pacco");

        WebElement buscarMasButton = driver.findElement(By.className("buscador-button"));
        buscarMasButton.click();

        // Espera a que la página cargue
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Hacer clic en el enlace "+ Info" de la mascota encontrada
        WebElement infoButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("info-button")));
        infoButton.click();

        // Espera a que la página cargue
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verificar que los datos mostrados coincidan con los de la mascota agregada
        WebElement nombreLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[formcontrolname='nombre']")));
        String nombreMascota = nombreLabel.getAttribute("value");
        Assertions.assertEquals("Pacco", nombreMascota);

        WebElement razaLabel = driver.findElement(By.cssSelector("input[formcontrolname='raza']"));
        String razaMascota = razaLabel.getAttribute("value");
        Assertions.assertEquals("Golden Retriever", razaMascota);

        WebElement edadLabel = driver.findElement(By.cssSelector("input[formcontrolname='edad']"));
        String edadMascota = edadLabel.getAttribute("value");
        Assertions.assertEquals("3", edadMascota);

        WebElement pesoLabel = driver.findElement(By.cssSelector("input[formcontrolname='peso']"));
        String pesoMascota = pesoLabel.getAttribute("value");
        Assertions.assertEquals("20", pesoMascota);

        WebElement enfermedadLabel = driver.findElement(By.cssSelector("input[formcontrolname='enfermedad']"));
        String enfermedadMascota = enfermedadLabel.getAttribute("value");
        Assertions.assertEquals("Gastritis", enfermedadMascota);

        WebElement duenoLabel = driver.findElement(By.cssSelector("input[formcontrolname='cliente']"));
        String cedulaDueno = duenoLabel.getAttribute("value");
        Assertions.assertEquals("1033096545", cedulaDueno);

        WebElement estadoMasSelect = driver.findElement(By.cssSelector("select[formcontrolname='estado']"));
        String estadoMascota = estadoMasSelect.getAttribute("value");
        Assertions.assertEquals("0: true", estadoMascota); // Se espera que 'true' indique que está activo

        WebElement fotoLabel = driver.findElement(By.cssSelector("input[formcontrolname='foto']"));
        String fotoMascota = fotoLabel.getAttribute("value");
        Assertions.assertEquals("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQtJU_aRybhiJnVUitOFKoexK89bvCy4oyB5ACTXE8zUxF8xhVM", fotoMascota);

        // Hacer clic en el enlace "Cerrar Sesión"
        WebElement linkCerrar = wait.until(ExpectedConditions.elementToBeClickable(By.className("buttonSinCuenta")));
        linkCerrar.click();

        // Espera a que la página cargue
         try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Localiza y hace clic en el botón "Soy PVC"
        WebElement soyPVCButton2 = driver.findElement(By.className("buttonSoyPVC"));
        soyPVCButton2.click();

        // Espera para que cargue la siguiente página
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Localiza y hace clic en el botón "¡Soy Vet!"
        WebElement soyClienteContainer = driver.findElement(By.className("container-cliente"));
        WebElement soyClienteButton = soyClienteContainer.findElement(By.className("text-cliente"));
        soyClienteButton.click();

        // Espera para que cargue la página de inicio de sesión
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Primer intento de ingreso con credenciales incorrectas
        WebElement cedulaClientInput = driver.findElement(By.id("cedula"));
        cedulaClientInput.sendKeys("1033096545");

        WebElement verMisMascotasButton2 = driver.findElement(By.cssSelector("input[type='submit'][value='Ver mis mascotas']"));
        verMisMascotasButton2.click();

        // Espera a que la página cargue
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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

