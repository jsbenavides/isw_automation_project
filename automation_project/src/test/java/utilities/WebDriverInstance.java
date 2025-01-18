package utilities;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;



public class WebDriverInstance {

    public static WebDriver driver;

    /*
    Since using a static WebDriver instance (utilities.WebDriverInstance)
    it's shared across all test classes. This impacts how you should manage the
     WebDriver lifecycle.
    */

    @BeforeTest
    public static void setUpDriver(){
        //System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver","E:\\GitHub\\Automation_Tools\\drivers\\selenium.webdriver.chromedriver.132.0.6834.8300\\driver\\win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    /*
    @AfterMethod runs after each test method, allowing you to check the result (pass, fail, or skip)
     of each test. ITestResult provides detailed information about the test execution, such as status,
      method name, and exceptions.
     */
    @AfterMethod
    public void verifyResults(ITestResult result){
        String className = result.getTestClass().getName();  // Get the class name
        String methodName = result.getMethod().getMethodName();  // Get the method name

        if (result.getStatus() == ITestResult.SUCCESS) {
            System.out.println("✅ Test Passed: " + className + " → " + methodName);
        } else if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("❌ Test Failed: " + className + " → " + methodName);
            System.out.println("Error: " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            System.out.println("⚠️ Test Skipped: " + className + " → " + methodName);
        }
        //driver.close(); // Cuando deseas cerrar solo una pestaña o ventana específica sin terminar toda la sesión. // En pruebas donde se abren varias ventanas y quieres cerrar solo una.
    }

    @AfterTest
    public void tearDown() {
        driver.quit();  // Finaliza la sesión al terminar todas las pruebas //Al final de la ejecución del script o prueba automatizada. Cierra todas las ventanas y pestañas del navegador.
    }

}
