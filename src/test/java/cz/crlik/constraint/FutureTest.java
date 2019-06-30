package cz.crlik.constraint;

import org.junit.Test;

import javax.validation.constraints.Future;
import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.ChronoUnit;

public class FutureTest extends AbstractTest {
    @Test
    public void testDateInTheFuture() {
        Object testedObject = new Object() {
            @Future
            public LocalDate date = LocalDate.now().plus(1, ChronoUnit.DAYS);
        };

        shouldPass(testedObject);
    }

    @Test
    public void testDateInThePast() {
        Object testedObject = new Object() {
            @Future
            public LocalDate date = LocalDate.now().minus(1, ChronoUnit.DAYS);
        };

        shouldFail(testedObject);
    }

    @Test
    public void testYearInTheFuture() {
        Object testedObject = new Object() {
            @Future
            public Year year = Year.now().plus(5, ChronoUnit.YEARS);
        };

        shouldPass(testedObject);
    }

    @Test
    public void testYearInThePast() {
        Object testedObject = new Object() {
            @Future
            public Year year = Year.now().minus(5, ChronoUnit.YEARS);
        };

        shouldFail(testedObject);
    }

    @Test
    public void testCurrentYear() {
        Object testedObject = new Object() {
            @Future
            public Year year = Year.now();
        };

        shouldFail(testedObject);
    }

    @Test
    public void testNull() {
        Object testedObject = new Object() {
            @Future
            public LocalDate date = null;
        };

        shouldPass(testedObject);
    }
}
