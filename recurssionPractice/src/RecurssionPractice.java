public class RecurssionPractice {
    public static void main(String[] args) {

        sayHi(10);
    }

    public static void sayHi (int count) {
        if (count == 0) {
            System.out.println("Done");
        } else {
            System.out.println("Hello");
            count--;
            sayHi(count);
        }

    }
}
