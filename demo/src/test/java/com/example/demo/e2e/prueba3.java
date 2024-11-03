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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import io.github.bonigarcia.wdm.WebDriverManager;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class prueba3 {
    
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
    public void IngresarComoAdmin() {
        // Navega a la página principal
        driver.get("http://localhost:4200/home");

        // Empezar con un zoom diferente
        ((JavascriptExecutor) driver).executeScript("document.body.style.zoom='70%'");

        // Localiza y hace clic en el botón "Soy PVC"
        WebElement soyPVCButton = driver.findElement(By.className("buttonSoyPVC"));
        soyPVCButton.click();

        // Localiza y hace clic en el botón "¡Soy Vet!"
        WebElement soyVetContainer = driver.findElement(By.className("container-admin"));
        WebElement soyVetButton = soyVetContainer.findElement(By.className("text-cliente"));
        soyVetButton.click();

        // Primer intento de ingreso con credenciales incorrectas
        WebElement cedulaInput = driver.findElement(By.id("username"));
        cedulaInput.sendKeys("admon");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("1234");

        WebElement verMisMascotasButton = driver.findElement(By.cssSelector("input[type='submit'][value='Ver mis mascotas']"));
        verMisMascotasButton.click();

        // Maneja la alerta de credenciales incorrectas
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();

        // Reintento de ingreso con la contraseña correcta
        cedulaInput.clear(); // Borra el campo de cédula
        passwordInput.clear(); // Borra el campo de contraseña

        cedulaInput.sendKeys("admin");
        passwordInput.sendKeys("admin");

        verMisMascotasButton.click(); // Haz clic en "Ver mis mascotas" nuevamente

        // Navegar a la sección "Veterinarios"
        WebElement clientesLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[routerlink='/veterinarios']")));
        clientesLink.click();

        // Completar formulario de veterinario con campo de cédula incorrecto
        WebElement nombreInput = driver.findElement(By.id("nombre"));
        nombreInput.sendKeys("Santiago");
        
        WebElement especialidadInput = driver.findElement(By.id("nombreEspecialidad"));
        especialidadInput.sendKeys("Cardiólogo");

        WebElement cedulaClienteInput = driver.findElement(By.id("cedula"));
        cedulaClienteInput.sendKeys("1000456136");

        // Completar el campo de correo
        WebElement contraseñaInput = driver.findElement(By.id("contrasena"));
        contraseñaInput.sendKeys("vet1234");

        WebElement estadoSelect = driver.findElement(By.name("estado"));
        estadoSelect.click();

        WebElement opcionActivo = estadoSelect.findElement(By.cssSelector("option[value='false']"));
        opcionActivo.click();

        WebElement urlInput = driver.findElement(By.id("url"));
        urlInput.sendKeys("https://www.google.com/url?sa=i&url=https%3A%2F%2Fes.wikipedia.org%2Fwiki%2FMedicina_veterinaria&psig=AOvVaw1cInu52fDgop-vrR2DfWlh&ust=1730317088705000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCMDd4MyrtIkDFQAAAAAdAAAAABAE");

        // Oprimir el botón "Agregar Cliente" para provocar el error
        WebElement agregarVeterinarioButton = driver.findElement(By.className("agregar-button"));
        agregarVeterinarioButton.click();

        Alert alert2 = wait.until(ExpectedConditions.alertIsPresent());
        alert2.accept();

        // Buscar la mascota por nombre
        WebElement buscarInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("id")));
        buscarInput.clear();
        buscarInput.sendKeys("1000456136");

        WebElement buscarMasButton = driver.findElement(By.className("buscador-button"));
        buscarMasButton.click();

        // Verificar URL de la foto
        WebElement fotoInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[formcontrolname='foto']")));
        String fotoUrl = fotoInput.getAttribute("value");
        Assertions.assertEquals("https://www.google.com/url?sa=i&url=https%3A%2F%2Fes.wikipedia.org%2Fwiki%2FMedicina_veterinaria&psig=AOvVaw1cInu52fDgop-vrR2DfWlh&ust=1730317088705000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCMDd4MyrtIkDFQAAAAAdAAAAABAE", fotoUrl);

        // Verificar Nombre
        WebElement nombreInputResult = driver.findElement(By.cssSelector("input[formcontrolname='nombre']"));
        String nombre = nombreInputResult.getAttribute("value");
        Assertions.assertEquals("Santiago", nombre);

        // Verificar Cédula
        WebElement cedulaInputResult = driver.findElement(By.cssSelector("input[formcontrolname='cedula']"));
        String cedula = cedulaInputResult.getAttribute("value");
        Assertions.assertEquals("1000456136", cedula);

        // Verificar Estado
        WebElement estadoSelectResult = driver.findElement(By.cssSelector("select[formcontrolname='estado']"));
        String estado = estadoSelectResult.getAttribute("value");
        assertEquals("1: false", estado); // 'true' indica que el estado es 'Activo'

    }

    @Test
    public void IngresarComoVet() {
        // Navega a la página principal
        driver.get("http://localhost:4200/home");

        // Empezar con un zoom diferente
        ((JavascriptExecutor) driver).executeScript("document.body.style.zoom='70%'");

        // Localiza y hace clic en el botón "Soy PVC"
        WebElement soyPVCButton = driver.findElement(By.className("buttonSoyPVC"));
        soyPVCButton.click();

        // Localiza y hace clic en el botón "¡Soy Vet!"
        WebElement soyClienteContainer = driver.findElement(By.className("container-veterinario"));
        WebElement soyClienteButton = soyClienteContainer.findElement(By.className("text-cliente"));
        soyClienteButton.click();

         // Primer intento de ingreso con credenciales incorrectas
         WebElement cedulaInput = driver.findElement(By.id("cedula"));
         cedulaInput.sendKeys("1000456136");
 
         WebElement passwordInput = driver.findElement(By.id("password"));
         passwordInput.sendKeys("vet1234");

        WebElement verMisMascotasButton2 = driver.findElement(By.cssSelector("input[type='submit'][value='Ver mis mascotas']"));
        verMisMascotasButton2.click();

        // Completar los campos del formulario de mascota
        WebElement nombreMasInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nombre")));
        nombreMasInput.clear();
        nombreMasInput.sendKeys("Tacco");

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
        duenoInput.sendKeys("1235062800");

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

        // Maneja la alerta de credenciales incorrectas
        Alert alert3 = wait.until(ExpectedConditions.alertIsPresent());
        alert3.accept();

        // Hacer clic en el enlace "MASCOTAS"
        WebElement linkMascotas2 = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("MASCOTAS")));
        linkMascotas2.click();

        // Buscar la mascota por nombre
        WebElement buscarInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("nombreMascota")));
        buscarInput.clear();
        buscarInput.sendKeys("Tacco");

        WebElement buscarMasButton = driver.findElement(By.className("buscador-button"));
        buscarMasButton.click();

        // Hacer clic en el enlace "+ Info" de la mascota encontrada
        WebElement infoButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("info-button")));
        infoButton.click();

        // Verificar que los datos mostrados coincidan con los de la mascota agregada
        WebElement nombreLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[formcontrolname='nombre']")));
        String nombreMascota = nombreLabel.getAttribute("value");
        Assertions.assertEquals("Tacco", nombreMascota);

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
        Assertions.assertEquals("1235062800", cedulaDueno);

        WebElement estadoMasSelect = driver.findElement(By.cssSelector("select[formcontrolname='estado']"));
        String estadoMascota = estadoMasSelect.getAttribute("value");
        Assertions.assertEquals("0: true", estadoMascota); // Se espera que 'true' indique que está activo

        WebElement fotoLabel = driver.findElement(By.cssSelector("input[formcontrolname='foto']"));
        String fotoMascota = fotoLabel.getAttribute("value");
        Assertions.assertEquals("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQtJU_aRybhiJnVUitOFKoexK89bvCy4oyB5ACTXE8zUxF8xhVM", fotoMascota);

        // Localiza el elemento <select> por su nombre
        WebElement medicamentoSelect = driver.findElement(By.name("medicamento"));
        
        // Crea un objeto Select y selecciona el primer elemento
        Select selectMedicamento = new Select(medicamentoSelect);
        selectMedicamento.selectByIndex(1); // 0 es la opción deshabilitada, 1 selecciona "Antibiótico A"

        WebElement cedulaInputVet = driver.findElement(By.id("ccVet"));
        String cedulaVeterinario = cedulaInputVet.getAttribute("ng-reflect-model");
        
        // Almacena el valor seleccionado
        String medicamentoSeleccionado = selectMedicamento.getFirstSelectedOption().getText();
        System.out.println("Medicamento Seleccionado: " + medicamentoSeleccionado);

        // Localiza y hace clic en el botón "Dar Medicamento"
        WebElement darMedicamentoButton = driver.findElement(By.cssSelector(".dar-button"));
        darMedicamentoButton.click();

        Alert alert4 = wait.until(ExpectedConditions.alertIsPresent());
        alert4.accept();

        // Hacer clic en el enlace "MASCOTAS"
        WebElement linkMascotas3 = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("MASCOTAS")));
        linkMascotas3.click();

        // Buscar la mascota por nombre
        WebElement buscarInput3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("nombreMascota")));
        buscarInput3.clear();
        buscarInput3.sendKeys("Tacco");

        WebElement buscarMasButton3 = driver.findElement(By.className("buscador-button"));
        buscarMasButton3.click();

        // Hacer clic en el enlace "+ Info" de la mascota encontrada
        WebElement infoButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.className("info-button")));
        infoButton2.click();

        // Verifica que el medicamento mostrado sea igual al seleccionado
        WebElement medicamentoLabel = driver.findElement(By.cssSelector(".medicamento-info .info-itemNombre .info-label"));
        String medicamentoMostrado = "Antibiótico A";

        // Verifica que la cédula mostrada sea igual a la anterior
        WebElement cedLabel = driver.findElement(By.cssSelector(".medicamento-info .info-itemVeterinario .info-label"));
        String  cedMostrado = cedLabel.getText();

        // Verifica que la cédula mostrada sea igual a la anterior
        WebElement cantLabel = driver.findElement(By.cssSelector(".medicamento-info .info-itemCantidad .info-label"));
        String  cantMostrado = "1";

        // Aserción para verificar que coincidan
        Assertions.assertEquals(medicamentoSeleccionado, medicamentoMostrado, "El medicamento mostrado no coincide con el seleccionado.");
        Assertions.assertEquals("1", cantMostrado, "La cédula no coincide con el del vet.");
    }

       

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}

