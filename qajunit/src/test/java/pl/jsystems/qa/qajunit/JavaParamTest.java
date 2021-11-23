package pl.jsystems.qa.qajunit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tags({@Tag("junit"), @Tag("smoke"), @Tag("param")})
@DisplayName("Param test")
public class JavaParamTest {

    @BeforeAll
    public static void setUpBeforeAll() {
        System.out.println("========== BeforeAll =========");
    }
    @BeforeEach
    public void setUp(TestInfo testInfo) {
        System.out.println("========== BeforeEach =========");
        System.out.println("DisplayName: " + testInfo.getDisplayName());
        System.out.println("----------- Test Name class name: " + testInfo.getTestClass().getClass().getSimpleName()
                + " \ntest name: " + testInfo.getTestMethod() );
    }
    @AfterEach
    public void tearDown(TestInfo testInfo) {
        System.out.println("========== AfterEach =========");
        System.out.println("DisplayName: " + testInfo.getDisplayName());
        System.out.println("---------- Test Name class name: " + testInfo.getTestClass()
                + " \ntest name: " + testInfo.getTestMethod() );
    }
    @AfterAll
    public static void tearDownAfterAll() {
        System.out.println("========== AfterAll =========");
    }

    @DisplayName("Parameter test with value int tape")
    @ParameterizedTest(name = "Parameter test with value {0}")
    @ValueSource(ints = {5, 15, 25})
    public void firstParamTest(int number){
        assertEquals(number%5, 0);
    }

    @DisplayName("Parameter test for string say hello")
    @ParameterizedTest(name = "Parameter test: {0}")
    @ValueSource(strings = {"Hello", "Hello junit", "Hello students"})
    public void stringParamTest(String param){
        assertThat(param).contains("Hello");
    }

    @DisplayName("Parameter test with multi param.")
    @ParameterizedTest(name = "Parameter test: {0}")
    @CsvSource(value = {"Hello; 5", "Hello junit; 15", "Hello students; 25"}, delimiter = ';')
   // @CsvSource(value = {"Hello, 5", "'Hello, junit', 15", "Hello students, 25"})
    public void multiParamTest(String param, int number){
        assertThat(param).contains("Hello");
        assertEquals(number%5, 0);
    }

    @DisplayName("Parameter test with multi param.")
    @ParameterizedTest(name = "Parameter test: {0}")
    @CsvFileSource(resources = "/plik.csv", delimiter = ';')// delimeter - co rozdziela dane
    public void multiCsvParamTest(String param, int number){
        assertThat(param).contains("Hello");
        assertEquals(number%5, 0);
    }

    @DisplayName("Parameter ENUM test")
    @ParameterizedTest(name = "ENUM test: {0}")
    @EnumSource(value = ParamEnum.class)
    public void stringEnumTest(ParamEnum param){
        assertThat(param.toString()).contains("ENUM");
    }
    enum ParamEnum{
        ENUM_ONE,
        ENUM_TWO
    }
}
