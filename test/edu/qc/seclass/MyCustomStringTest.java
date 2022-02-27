package edu.qc.seclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MyCustomStringTest {

    private MyCustomStringInterface mycustomstring;

    @Before
    public void setUp() {
        mycustomstring = new MyCustomString();
    }

    @After
    public void tearDown() {
        mycustomstring = null;
    }

    @Test
    public void testCountNumbers1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals(7, mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers2() {
    	//enter some random numbers mix with character
        mycustomstring.setString("asdon12saodn3 ininosdan23qwoiej123 ijion32");
        assertEquals(5, mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers3() {
    	//no digits at all
    	mycustomstring.setString("Only characters no digits");
        assertEquals(0, mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers4() {
    	//only have one number
    	mycustomstring.setString("12321461616321");
        assertEquals(1, mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers5() {
    	mycustomstring.setString("1a 2b 3c 4d 5e 6f");
        assertEquals(6, mycustomstring.countNumbers());
    }

    @Test(expected = NullPointerException.class)        // this test throws an new NullPointerException because the current string is null
    public void testCountNumbers6() {
        mycustomstring.countNumbers();
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("d33p md1  i51,it", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd2() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("'bt t0 6snh r6rh", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true));
    }

    @Test(expected = IllegalArgumentException.class)          //this test throws an new IllegalArgumentException because n is less than or equals to 0
    public void testGetEveryNthCharacterFromBeginningOrEnd3() {
    	mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
    	mycustomstring.getEveryNthCharacterFromBeginningOrEnd(0, true);         
    }

    @Test(expected = NullPointerException.class)              // this test throws an new NullPointerException because the current string is null
    public void testGetEveryNthCharacterFromBeginningOrEnd4() {
    	mycustomstring.getEveryNthCharacterFromBeginningOrEnd(5, true);
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd5() {
    	mycustomstring.setString("abcdefghijklmno");
    	assertEquals("ejo", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(5, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd6() {
    	mycustomstring.setString("abcdefghijklmno");
    	assertEquals("afk", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(5, true));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd7() {
    	mycustomstring.setString("testing case 7");
    	assertEquals("etn ae7", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd8() {
    	mycustomstring.setString("testing case 7");
    	assertEquals("tsigcs ", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, true));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd9() {
    	mycustomstring.setString("haveingfunwiththiscase");
    	assertEquals("efiha", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(4, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd10() {
    	mycustomstring.setString("haveingfunwiththiscase");
    	assertEquals("vgwtc", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(4, true));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd11() {
    	mycustomstring.setString("haveingfunwiththiscase");
    	assertEquals("nis", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(6, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd12() {
    	mycustomstring.setString("haveingfunwiththiscase");
    	assertEquals("iwi", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(6, true));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd13() {
    	mycustomstring.setString("last couple casesss");
    	assertEquals("scp ss", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd14() {
    	mycustomstring.setString("last couple casesss");
    	assertEquals("a ueas", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true));
    }

    @Test
    public void testConvertDigitsToNamesInSubstring1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(17, 23);
        assertEquals("I'd b3tt3r put sZerome dOneSix1ts in this 5tr1n6, right?", mycustomstring.getString());
    }

    @Test(expected = IllegalArgumentException.class)                  // this test throw an new IllegalArgumentException because the startposition is > endposition
    public void testConvertDigitsToNamesInSubstring2() {
    	mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");        
    	mycustomstring.convertDigitsToNamesInSubstring(24, 23);
    }

    @Test(expected = MyIndexOutOfBoundsException.class)              // this test throw an new IndexOutOfBoundsException because the startposition is <= 0
    public void testConvertDigitsToNamesInSubstring3() {
    	mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
    	mycustomstring.convertDigitsToNamesInSubstring(-1, 23);
    }
 
    @Test(expected = NullPointerException.class)                     // this test throw an new NullPointerException because the current string is null
    public void testConvertDigitsToNamesInSubstring4() {
    	mycustomstring.convertDigitsToNamesInSubstring(14, 23);
    }

    @Test(expected = MyIndexOutOfBoundsException.class)              // this test throw an new IndexOutOfBoundsException because the endposition is > current string's length
    public void testConvertDigitsToNamesInSubstring5() {
    	mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
    	mycustomstring.convertDigitsToNamesInSubstring(10, 70);
    }

    @Test
    public void testConvertDigitsToNamesInSubstring6() {
    	mycustomstring.setString("I have 6 apples");
        mycustomstring.convertDigitsToNamesInSubstring(5, 10);
        assertEquals("I have Six apples", mycustomstring.getString());
    }

    @Test
    public void testConvertDigitsToNamesInSubstring7() {
    	mycustomstring.setString("1 2 3 4 5 ");
        mycustomstring.convertDigitsToNamesInSubstring(1, 10);
        assertEquals("One Two Three Four Five ", mycustomstring.getString());
    }

    @Test
    public void testConvertDigitsToNamesInSubstring8() {
    	mycustomstring.setString("last 1 for this");
        mycustomstring.convertDigitsToNamesInSubstring(1, 6);
        assertEquals("last One for this", mycustomstring.getString());
    }

}
