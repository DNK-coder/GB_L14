package Test_GBL14;

import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

public class GBL14 {
    MainClassL14 mainClassL14 = new MainClassL14();

    // выполнение дискретных тестов для методлв класса mainClassL14
    @Test
    public void containsOneOrFourTest() {
        Assert.assertTrue(mainClassL14.containsOneOrFour(new int[]{1, 1, 4, 4, 1, 1}));
    }

    @Test
    public void containsOneOrFourTest1() {
        Assert.assertFalse(mainClassL14.containsOneOrFour(new int[]{1, 1, 4, 3, 1, 1}));
    }

    @Test
    public void containsOneOrFourTest2() {
        Assert.assertFalse(mainClassL14.containsOneOrFour(new int[]{1, 0, 1, 1, 1, 1}));
    }

    @Test
    public void containsOneOrFourTest3() {
        Assert.assertFalse(mainClassL14.containsOneOrFour(new int[]{1, 1, 1, 1, 1, 1}));
    }

    @Test
    public void containsOneOrFourTest4() {
        Assert.assertFalse(mainClassL14.containsOneOrFour(new int[]{4, 4, 4, 4, 4, 4}));
    }

    @Test(expected = RuntimeException.class)
    public void containsOneOrFourTest5() {
        Assert.assertFalse(mainClassL14.containsOneOrFour(new int[]{}));
    }

    @Test
    public void cutForTest() {
        Assert.assertArrayEquals(new int[]{5, 6}, mainClassL14.cutFor(new int[]{1, 2, 3, 4, 5, 6}));
    }

    @Test
    public void cutForTest1() {
        Assert.assertArrayEquals(new int[]{5, 6, 7}, mainClassL14.cutFor(new int[]{1, 2, 4, 4, 5, 6, 7}));
    }

    @Test
    public void cutForTest2() {
        Assert.assertArrayEquals(new int[]{}, mainClassL14.cutFor(new int[]{1, 2, 3, 4}));
    }

    @Test(expected = RuntimeException.class)
    public void cutForTest4() {
        Assert.assertArrayEquals(new int[]{}, mainClassL14.cutFor(new int[]{1, 2, 3, 10, 5, 3}));
    }

    @Test(expected = RuntimeException.class)
    public void cutForTest5() {
        Assert.assertArrayEquals(new int[]{}, mainClassL14.cutFor(new int[]{}));
    }

    //Использование параметризации

    @RunWith(Parameterized.class)
    public static class Parametrizedtest {
        @Parameterized.Parameters
        public static Collection<Object> params() {
            return Arrays.asList(new Object[][]{
                    {new int[]{1, 2, 3, 4, 5, 6}, new int[]{5, 6}},
                    {new int[]{1, 2, 3, 4, 7, 8, 9}, new int[]{7, 8, 9}},
                    {new int[]{1, 2, 3, 4, 5}, new int[]{5}},
                    {new int[]{1, 2, 3, 4}, new int[]{}},
            });
        }
        private int[] in1, res;
        private MainClassL14 mainClassL14 = new MainClassL14();

        public Parametrizedtest(int[] in1, int[] res) {
            this.in1 = in1;
            this.res = res;
        }

        @Test
        public void cutForTest1() {
            Assert.assertArrayEquals(res, mainClassL14.cutFor(in1));
        }
    }
}
