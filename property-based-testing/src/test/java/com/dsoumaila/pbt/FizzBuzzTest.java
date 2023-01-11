package com.dsoumaila.pbt;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JUnitQuickcheck.class)
public class FizzBuzzTest {

    @Property(shrink = false)
    public void should_display_number_as_string(@InRange(minInt = 1, maxInt = 100) int value) {
        // GIVEN
        assumeTrue(value % 3 != 0);
        assumeTrue(value % 5 != 0);
        FizzBuzz fizzBuzz = new FizzBuzz();

        // WHEN
        String result = fizzBuzz.display(value);

        // THEN
        assertEquals(result, String.valueOf(value));
    }

    @Property(shrink = false)
    public void should_display_fizz_when_value_is_3_multiple(@InRange(minInt = 1, maxInt = 100) int value) {
        // GIVEN
        FizzBuzz fizzBuzz = new FizzBuzz();
        assumeTrue(value % 3 == 0);
        assumeTrue(value % 5 != 0);

        // WHEN
        String result = fizzBuzz.display(value);

        // THEN
        assertEquals(result, "fizz");
    }

    @Property(shrink = false)
    public void should_display_buzz_when_value_is_5_multiple(@InRange(minInt = 1, maxInt = 100) int value) {
        // GIVEN
        FizzBuzz fizzBuzz = new FizzBuzz();
        assumeTrue(value % 5 == 0);
        assumeTrue(value % 3 != 0);

        // WHEN
        String result = fizzBuzz.display(value);

        // THEN
        assertEquals(result, "buzz");
    }

    @Property(shrink = false)
    public void should_display_fizzbuzz_when_value_is_5_and_3_multiple(@InRange(minInt = 1, maxInt = 100) int value) {
        // GIVEN
        FizzBuzz fizzBuzz = new FizzBuzz();
        assumeTrue(value % 5 == 0);
        assumeTrue(value % 3 == 0);

        // WHEN
        String result = fizzBuzz.display(value);

        // THEN
        assertEquals(result, "fizzbuzz");
    }
}
