package tudelft.ghappy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GHappyTest {
    GHappy gHappy;

    @BeforeEach
    public void intital(){
        gHappy = new GHappy();
    }

    @ParameterizedTest(name = "String = {0} , Result = {1} ")
    @CsvSource({"gxxx,false","ggxx,true","gggx,true"})
    public void gAtTheBegining(String string,boolean expectedResult){
        boolean result = gHappy.gHappy(string);
        Assertions.assertEquals(expectedResult,result);
    }

    @ParameterizedTest(name = "String = {0} , Result = {1} ")
    @CsvSource({"xxxg,false","xxgg,true","xggg,true"})
    public void gAtTheEnd(String string,boolean expectedResult){
        boolean result = gHappy.gHappy(string);
        Assertions.assertEquals(expectedResult,result);
    }

    @Test
    public void oneg(){
        boolean result = gHappy.gHappy("g");
        Assertions.assertEquals(false,result);
    }

    @ParameterizedTest(name = "String = {0} , Result = {1} ")
    @CsvSource({"xxgxx,false","xxggyy,true","xgggyy,true"})
    public void gInTheMiddle(String string,boolean expectedResult){
        boolean result = gHappy.gHappy(string);
        Assertions.assertEquals(expectedResult,result);
    }

    @Test
    public void nog(){
        boolean result = gHappy.gHappy("xxx");
        Assertions.assertEquals(true,result);
    }
}
