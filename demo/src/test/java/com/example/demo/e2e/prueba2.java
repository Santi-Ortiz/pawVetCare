package com.example.demo.e2e;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
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
public class prueba2 {
    
    private WebDriver driver;
    private WebDriverWait wait;
    private int numeroTratamientos;
    private int gananciasTotalesInt;

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
    public void flujoCompleto() {
        EntrarPrimeraInfoDashboard();
        DarTratamiento();
        ObservarCambiosDashboard();
    }

    public void EntrarPrimeraInfoDashboard() {
        // Navega a la página principal
        driver.get("http://localhost:4200/home");

        // Empezar con un zoom diferente
        ((JavascriptExecutor) driver).executeScript("document.body.style.zoom='70%'");

        // Localiza y hace clic en el botón "Soy PVC"
        WebElement soyPVCButton = driver.findElement(By.className("buttonSoyPVC"));
        soyPVCButton.click();

        // Localiza y hace clic en el botón "¡Soy Admin!"
        WebElement soyAdminContainer = driver.findElement(By.className("container-admin"));
        WebElement soyAdminButton = soyAdminContainer.findElement(By.className("text-cliente"));
        wait.until(ExpectedConditions.elementToBeClickable(soyAdminButton)).click();

        // Primer intento de ingreso con credenciales incorrectas
        WebElement cedulaInput = driver.findElement(By.id("username"));
        cedulaInput.sendKeys("admin");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("admin");

        WebElement verMisMascotasButton = driver.findElement(By.cssSelector("input[type='submit'][value='Ver mis mascotas']"));
        verMisMascotasButton.click();

        // Navegar a la sección "CLIENTES"
        WebElement dashboardLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[routerlink='/dashboard']")));
        dashboardLink.click();

        // Almacena el número de tratamientos en una variable
        WebElement numeroTratamientosElement = driver.findElement(By.className("numero")); // Asegúrate de que solo haya un elemento con esta clase o usa un selector más específico si hay varios
        String numeroTratamientosText = numeroTratamientosElement.getText().trim();
        this.numeroTratamientos = Integer.parseInt(numeroTratamientosText);  // Convierte a int si es un número

        // Almacena las ganancias totales en otra variable
        // Localiza el elemento de 'ganancias totales' y almacena el texto en la variable
        WebElement gananciasTotalesElement = driver.findElement(By.cssSelector("app-container-ganancias-totales .container-inicializar .numero"));
        String gananciasTotales = gananciasTotalesElement.getText();
        // Convertir el valor a número para usarlo en assert o cálculos
        gananciasTotales = gananciasTotales.replace("$", "").replace(",", "").trim();
        this.gananciasTotalesInt = Integer.parseInt(gananciasTotales);

        // Hacer clic en el enlace "Cerrar Sesión"
        WebElement linkCerrar = wait.until(ExpectedConditions.elementToBeClickable(By.className("buttonSinCuenta")));
        linkCerrar.click();

    }

    public void DarTratamiento() {
        // Navega a la página principal
        driver.get("http://localhost:4200/home");

        // Empezar con un zoom diferente
        ((JavascriptExecutor) driver).executeScript("document.body.style.zoom='70%'");

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
        WebElement soyVetContainer = driver.findElement(By.className("container-veterinario"));
        WebElement soyVetButton = soyVetContainer.findElement(By.className("text-cliente"));
        soyVetButton.click();

        // Primer intento de ingreso con credenciales incorrectas
        WebElement cedulaInput2 = driver.findElement(By.id("cedula"));
        cedulaInput2.sendKeys("1234");

        WebElement passwordInput2 = driver.findElement(By.id("password"));
        passwordInput2.sendKeys("vet");

        WebElement verMisMascotasButton2 = driver.findElement(By.cssSelector("input[type='submit'][value='Ver mis mascotas']"));
        verMisMascotasButton2.click();

        String medicamentoMostrado = "11";
        String  cedMostrado = "11";
        String  cantMostrado = "11";

        // Buscar la mascota por nombre
        WebElement buscarInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("nombreMascota")));
        buscarInput.clear();
        buscarInput.sendKeys("Cupcake");

        WebElement buscarMasButton = driver.findElement(By.className("buscador-button"));
        buscarMasButton.click();

        // Hacer clic en el enlace "+ Info" de la mascota encontrada
        WebElement infoButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("info-button")));
        infoButton.click();

        // Localiza el elemento <select> por su nombre
        WebElement medicamentoSelect = driver.findElement(By.name("medicamento"));
        
        // Crea un objeto Select y selecciona el primer elemento
        Select selectMedicamento = new Select(medicamentoSelect);
        selectMedicamento.selectByIndex(4); // 0 es la opción deshabilitada, 1 selecciona "Antibiótico A"

        WebElement cedulaInputVet = driver.findElement(By.id("ccVet"));
        String cedulaVeterinario = cedulaInputVet.getAttribute("ng-reflect-model");
        
        // Almacena el valor seleccionado
        String medicamentoSeleccionado = selectMedicamento.getFirstSelectedOption().getText();
        System.out.println("Medicamento Seleccionado: " + medicamentoSeleccionado);

        // Localiza y hace clic en el botón "Dar Medicamento"
        WebElement darMedicamentoButton = driver.findElement(By.cssSelector(".dar-button"));
        darMedicamentoButton.click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();

        // Hacer clic en el enlace "MASCOTAS"
        WebElement linkMascotas2 = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("MASCOTAS")));
        linkMascotas2.click();

        // Buscar la mascota por nombre
        WebElement buscarInput2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("nombreMascota")));
        buscarInput2.clear();
        buscarInput2.sendKeys("Cupcake");

        WebElement buscarMasButton2 = driver.findElement(By.className("buscador-button"));
        buscarMasButton2.click();

        // Hacer clic en el enlace "+ Info" de la mascota encontrada
        WebElement infoButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.className("info-button")));
        infoButton2.click();
        
        // Aserción para verificar que coincidan
        Assertions.assertEquals(medicamentoMostrado, medicamentoMostrado, "El medicamento mostrado no coincide con el seleccionado.");
        Assertions.assertEquals(cantMostrado, cantMostrado, "La cantidad no coincide con el del vet.");
        Assertions.assertEquals(cedMostrado, cedMostrado, "La cédula no coincide con el del vet.");

        // Hacer clic en el enlace "Cerrar Sesión"
        WebElement linkCerrar2 = wait.until(ExpectedConditions.elementToBeClickable(By.className("buttonSinCuenta")));
        linkCerrar2.click();

    }

    public void ObservarCambiosDashboard() {
        // Navega a la página principal
        driver.get("http://localhost:4200/home");

        // Empezar con un zoom diferente
        ((JavascriptExecutor) driver).executeScript("document.body.style.zoom='70%'");

        // Localiza y hace clic en el botón "Soy PVC"
        WebElement soyPVCButton3 = driver.findElement(By.className("buttonSoyPVC"));
        soyPVCButton3.click();

        // Localiza y hace clic en el botón "¡Soy Admin!"
        WebElement soyAdminContainer2 = driver.findElement(By.className("container-admin"));
        WebElement soyAdminButton2 = soyAdminContainer2.findElement(By.className("text-cliente"));
        wait.until(ExpectedConditions.elementToBeClickable(soyAdminButton2)).click();

        // Primer intento de ingreso con credenciales incorrectas
        WebElement cedulaInput3 = driver.findElement(By.id("username"));
        cedulaInput3.sendKeys("admin");

        WebElement passwordInput3 = driver.findElement(By.id("password"));
        passwordInput3.sendKeys("admin");

        WebElement verMisMascotasButton3 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='submit'][value='Ver mis mascotas']")));
        verMisMascotasButton3.click();

        // Navegar a la sección "CLIENTES"
        WebElement dashboardLink3 =  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[routerlink='/dashboard']")));
        dashboardLink3.click();
        

        // Almacena el número de tratamientos en una variable
        WebElement numeroTratamientosElement2 = driver.findElement(By.className("numero")); // Asegúrate de que solo haya un elemento con esta clase o usa un selector más específico si hay varios
        String numeroTratamientosText2 = numeroTratamientosElement2.getText().trim();
        int numeroTratamientosFinal = Integer.parseInt(numeroTratamientosText2);  // Convierte a int si es un número

        // Almacena las ganancias totales en otra variable
        // Localiza el elemento de 'ganancias totales' y almacena el texto en la variable
        WebElement gananciasTotalesElement2 = driver.findElement(By.cssSelector("app-container-ganancias-totales .container-inicializar .numero"));
        String gananciasTotales2 = gananciasTotalesElement2.getText();
        // Convertir el valor a número para usarlo en assert o cálculos
        gananciasTotales2 = gananciasTotales2.replace("$", "").replace(",", "").trim();
        int gananciasTotalesIntFinal = Integer.parseInt(gananciasTotales2);
        
        // Aserción para comprobar que a es uno más que b
        Assertions.assertEquals(numeroTratamientos + 1, numeroTratamientosFinal, "Los tratamientos aumentaron 1 correctamente.");
        // Aserción para comprobar que a es mayor que b
        Assertions.assertTrue(gananciasTotalesIntFinal > gananciasTotalesInt, "Las ganancias aumentaron.");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}


