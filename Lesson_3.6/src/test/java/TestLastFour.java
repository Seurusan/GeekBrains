import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.gb.lesson_3_6.LastFour;

public class TestLastFour {
    static LastFour lastFour;

    @BeforeEach
    public void init() {
        lastFour = new LastFour();
    }

    @Test
    public void TestLastFour_1() {
        Assertions.assertArrayEquals(new int[]{1, 7}, LastFour.lastFourMethod(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}));
    }

    @Test
    public void TestLastFour_2() {
        Assertions.assertArrayEquals(new int[]{}, LastFour.lastFourMethod(new int[]{1, 2, 4, 4, 2, 3, 4}));
    }

    @Test
    public void TestLastFour_3() {
        Assertions.assertThrows(RuntimeException.class, () -> LastFour.lastFourMethod(new int[]{1, 2, 44, 2, 34, 1, 2}));
    }

    @Test
    public void TestLastFour_4() {
        Assertions.assertThrows(RuntimeException.class, () -> LastFour.lastFourMethod(new int[]{1, 2, 1, 7}));
    }
}
