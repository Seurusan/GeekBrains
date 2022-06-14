package Methods;

public class Straight {
    public static void start(int size, int h) {
        float[] arr = new float[size];
        //Fill array with 1's
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        //Runtime start point
        long a = System.currentTimeMillis();
        //Redefining the array
        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        //Runtime check and out
        System.out.println("One thread ends in: " + (System.currentTimeMillis() - a));
    }
}
