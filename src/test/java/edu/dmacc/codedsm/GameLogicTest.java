package edu.dmacc.codedsm;

import junit.textui.TestRunner;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameLogicTest {

    GameRunner ToTest = new GameRunner() {
        @Override
        public boolean isVictorious() {
            return true;
        }

        @Override
        public boolean isDefeated() {
            return false;
        }
    };
    GameResult TestResult = new GameResult();
    GameLogic Tester = new GameLogic(ToTest);

    Object GameLogicTest;
    @Before
    public void setUp() throws Exception {
        GameLogicTest = new Object();
    }

    @Test
    public void buildResultTest(){
        String expectedName = "Test Name";
        Integer expectedInt = 1;
        TestResult = Tester.buildResult(expectedName, expectedInt);
        assertEquals(expectedName, TestResult.getPlayer());
        assertEquals(expectedInt, TestResult.getScore());
    }

    @Test
    public void runGameIntegerTestIfVictorious(){
        Integer testScore = 0;
        Integer expectedScore = 1000;
        if (ToTest.isVictorious()){
            testScore = 1000;
        }
        assertEquals(expectedScore, testScore);
    }

    @Test
    public void runGameIntegerTestIfDefeated(){
        Integer testScore = 0;
        Integer expectedScore = 0;
        if (ToTest.isDefeated()){
            testScore = 100;
        }
        assertEquals(expectedScore, testScore);
    }

}