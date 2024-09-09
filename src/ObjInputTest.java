import java.util.Scanner;

public class ObjInputTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SafeInputObj safeInput = new SafeInputObj(scanner);

        // Demonstrate getNonZeroLenString
        String nonZeroLenString = safeInput.getNonZeroLenString("Enter a non-empty string");
        System.out.println("Entered value: " + nonZeroLenString);

        String minLenString = safeInput.getMinLenString("Enter a non-empty string",10);
        System.out.println("Entered value: " + minLenString);

        int rangedInt = safeInput.getRangedInt("Enter a number",10, 50);
        System.out.println("Entered value: " + rangedInt);

        int getInt = safeInput.getInt("Enter a number");
        System.out.println("Entered value: " + getInt);

        double rangedDouble = safeInput.getRangedDouble("Enter a number",5, 20);
        System.out.println("Entered value: " + rangedDouble);

        double getDouble = safeInput.getDouble("Enter a number");
        System.out.println("Entered value: " + getDouble);

        boolean YNConfirm = safeInput.getYNConfirm("Enter prompt");
        System.out.println("Entered value: " + YNConfirm);

        String regExString = safeInput.getRegExString("Enter prompt","^.+$");
        System.out.println("Entered value: " + regExString);
    }
}
