package Methods;

public class Divided extends Thread {
    public static void start(int size, int h) {
        float[] arr = new float[size];
        float[] a1 = new float[h];
        float[] a2 = new float[h];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        System.out.println("Dividing time is: " + (System.currentTimeMillis() - a));
        long b = System.currentTimeMillis();

        new Thread(() -> {
            float[] ar1 = calculate(a1);
            System.arraycopy(ar1, 0, a1, 0, ar1.length);
        }).start();

        new Thread(() -> {
            float[] ar2 = calculate(a2);
            System.arraycopy(ar2, 0, a2, 0, ar2.length);
        }).start();

        System.out.println("Calculating time is: " + (System.currentTimeMillis() - b));
        long c = System.currentTimeMillis();

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.out.println("Merging ends in: " + (System.currentTimeMillis() - c));
        System.out.println("Two threads approximately ends in: " + (System.currentTimeMillis() - a));
    }

    public static float[] calculate(float[] arr) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = (float) (arr[i] * Math.sin(0.2f + arr[i] / 5) * Math.cos(0.2f + arr[i] / 5) * Math.cos(0.4f + arr[i] / 2));
        return arr;
    }
}
