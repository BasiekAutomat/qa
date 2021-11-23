package pl.jsystems.qa.qajunit;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Tags({@Tag("junit"), @Tag("firstTest"), @Tag("zadania1")})
@DisplayName("Junit testy")
public class JunitTest {

    @BeforeAll
    public static void beforeAll(){
        System.out.println("---beforeAll----");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("---afterAll----");
    }

  /*  @BeforeEach
    public static void beforeEach(){
        System.out.println("---beforeEach----");
    }
    @AfterEach
    public static void afterEach(){
        System.out.println("---afterEach----");
    }*/

    private static final String STRING_TESTOWY = "StringTestowy";

    @RepeatedTest(3)
    @Tag("firstTest")
    @DisplayName("First Test")
    @Test
    public void firstTest(){

        final String STRING_TESTOWY = "StringTestowy";

        assertEquals(2+3,5);
        assertNotEquals(2+2,5);
        assertTrue(STRING_TESTOWY.contains("wy"));
        assertTrue(STRING_TESTOWY.endsWith("wy"));

    }
    @Tag("JunitTest")
    @DisplayName("Junit Test")
    @Test

    public void junitTest(){
        System.out.println(0.2*0.2);

     //   assertEquals(0.2*0.2, 0.04);
      //  double result = new BigDecimal("0.2").multiply()
    }
    @Tag("string")
    @DisplayName("String test")
    @Test
    public void stringTest(){
        String simpleString = "simpleString";
        String simple = "simpleString";

        String simpleString_2 = new String("simpleString");
        String simpleString_3 = new String("simpleString");

        assertSame("simpleString", simpleString);
        assertSame(simple, simpleString);
        //assertSame(simpleString_2, simpleString_3);
        assertNotSame(simpleString_2, simple);

        assertTrue(simpleString == simple);
        //assertTrue(simpleString == simpleString_3);


        assertEquals(simple, simpleString);
        assertEquals(simpleString, simpleString_2);
        assertEquals(simpleString_3, simpleString_2);
    }
    @Tag("googleTruthTest")
    @DisplayName("Google truth Test")
    @Test
    public void googleTruthTest(){
        assertThat(STRING_TESTOWY).contains("ingT");
    }
    @Tag("zadania")
    @DisplayName("Zadanie 1")
    @Test

    public void zad1(){
        String resultString = "Wordpress powers 99% of the internet";
        String expectedString = "Wordpress powers [number]% of the internet";

        assertThat(resultString).startsWith("Wordpress powers ");
        assertThat(resultString).endsWith("% of the internet");
        assertThat(resultString).matches("Wordpress powers \\d+% of the internet");

        String result = resultString.replace("Wordpress powers ", "").replace("% of the internet", "");

        assertThat(result).matches("^\\d+$");

        int intResult = new Integer(result);
        assertThat(intResult>=0);
        assertThat(intResult).isLessThan(100);
        //assertThat(intResult<=100);

    }

    @Tags({@Tag("junit"), @Tag("nested")})
    @DisplayName("Nested")
    @Nested
    public class NestedTest{
        @DisplayName("List test")
        @Test
        public void listTest(){
            List<Integer> result = Arrays.asList(1,2,3,4,5);
            List<Integer> expectesd = Arrays.asList(3,4,5);

            assertThat(result).containsAnyIn(expectesd);
            assertTrue(result.containsAll(expectesd));
            assertThat(result).hasSize(5);
            assertThat(result).containsAnyOf(1,2);
        }
    @DisplayName("Exception test")
        @Test
        public void exceprionTest(){
            final GamePlay gamePlay = new GamePlay();
            Assertions.assertThrows(IllegalArgumentException.class, ()->gamePlay.play(0));
    }

    }
}
