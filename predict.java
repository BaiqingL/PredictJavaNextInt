import java.util.Random;
import java.util.Scanner;

/**
 * References:
 * https://stackoverflow.com/questions/14616163/how-to-obtain-the-nth-random-nextint-value
 * https://www.codemagi.com/blog/post/247
 * https://docs.oracle.com/javase/7/docs/api/java/util/Random.html#Random()
 */

public class predict {
    private static int calculated(long seed) {
        //32 bit MIN MAX value
        int bits = 32;
        long seed2 = (seed * 25214903917L + 11) & 281474976710655L;
        return (int)(seed2 >>> (48 - bits));
    }

    public static void main(String[] args) {
        
        long seed =0;
        Scanner z = new Scanner(System.in);
        System.out.println("Enter a randomly generated number (random.nexInt() method) by java:");
        long target1 = z.nextLong();
        System.out.println("Enter the SECOND randomly generated number:");
        long target2 = z.nextLong();
        //Brute forcing begins
        for (int i = 0; i < 65536; i++) {
            seed = target1 * 65536 + i;
            if (calculated(seed) == target2) {
                System.out.println("Seed found: " + seed);
                break;
            }
        }

        //Setting the exact seed to replicate the original run of generating numbers
        Random random = new Random((seed ^ 25214903917L) & 281474976710655L);
        int result2 = random.nextInt();
        int result3 = random.nextInt();
        System.out.println("\n" + "Numbers after that can be " + result2 +" and "+ result3 + "\n" + "The seed calculated is: " + seed);
    }
}
