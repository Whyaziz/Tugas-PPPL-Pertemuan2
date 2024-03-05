import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalculatorTest {
    public int result = 0;

    @BeforeAll
    public void initialize() {
        System.out.println("Before All is Called");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("Before Each is Called");
    }

    @AfterEach
    public void methodCleanUp() {
        System.out.println("After Each is Called");
    }

    @AfterAll
    public void classCleanUp() {
        System.out.println("After All is Called");
    }

    @Test
    @Order(1)
    public void testTambah() {
        int angka = 10;
        Calculator calculator = new Calculator(result, angka);
        result = calculator.tambah();
        Assertions.assertEquals(10, result);
    }
    @Test
    @Order(2)
    public void testKali(){
        int kali = 10;
        Calculator calculator = new Calculator(result, kali);
        result = calculator.kali();
        Assertions.assertEquals(100, result);
    }


}
