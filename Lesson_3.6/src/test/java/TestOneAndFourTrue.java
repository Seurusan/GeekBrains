import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.gb.lesson_3_6.OneAndFourTrue;

class TestOneAndForTrue {
    static OneAndFourTrue task;

    @BeforeEach
    public void init() {
        task = new OneAndFourTrue();
    }

    @Test
    public void TestOneAndForTrue_1() {
        Assertions.assertTrue(OneAndFourTrue.check(new int[]{1, 1, 1, 4, 4, 4, 1, 4,}));
    }

    @Test
    public void TestOneAndForTrue_2() {
        Assertions.assertFalse(OneAndFourTrue.check(new int[]{1, 1, 1, 1, 1, 1}));
    }

    @Test
    public void TestOneAndForTrue_3() {
        Assertions.assertFalse(OneAndFourTrue.check(new int[]{4, 4, 4, 4,}));
    }

    @Test
    public void TestOneAndForTrue_4() {
        Assertions.assertFalse(OneAndFourTrue.check(new int[]{1, 4, 4, 1, 1, 4, 3}));
    }

}
