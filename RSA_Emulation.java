import java.util.Scanner;

public class RSA_Emulation {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);

        //Get prime number inputs from user
        System.out.print("Enter prime number p: \n");
        int p = sc.nextInt();
        System.out.print("Enter prime number q: \n");
        int q = sc.nextInt();

        //find product of prime numbers and Φ of these numbers
        int n = p * q;
        int phi_of_n = (p-1)*(q-1);

        //find an integer e that is less  than Φ of n and co-prime to Φ of n
        int e = 0;
        for (int i = 2; i < phi_of_n; i++) {
            if (greatestCommonFactor(i,phi_of_n) == 1) {
                e = i;
                break;
            }
        }

        //find an integer d such that ed mod(Φ of n) is 1
        int d = 0;
        for (int i = 1; i < n; i++) {
            if ((i*e)%phi_of_n == 1) {
                d = i;
                break;
            }
        }

        System.out.println("\nCalculating RSA values ...");

        System.out.println("\nPublic RSA key is ("+e+", "+n+ ")");

        System.out.println("Private RSA key is ("+d+", "+n+ ")");


        System.out.print("\nEnter the plaintext message m (an integer): ");
        double message = sc.nextInt();

        System.out.println("\n Encrypting m...");
        double ciphertext = (Math.pow(message,e))%n;
        System.out.print(("The ciphertext c is  "+ (int) ciphertext)+"\n");

        /**
         * Applying the fast exponential modular arithmetic technique to work
         * out the decryption formula.
         **/
        long binaryForm = Long.parseLong(Integer.toBinaryString(d));

        int val = 1;
        for(int i = 0; i < String.valueOf(binaryForm).length(); i++) {
            if (String.valueOf(binaryForm).charAt(i) == '0') {
                val = (int) Math.pow(val,2);
                if ( val > n) {
                    val = val % n;
                }
            }
            else if (String.valueOf(binaryForm).charAt(i) == '1') {
                val = (int) Math.pow(val,2);
                if ( val > n) {
                    val = val % n;
                }
                val = (int) (val * ciphertext);
                if ( val > n) {
                    val = val % n;
                }
            }
        }

        int plaintext = val;
        System.out.println("\n Decrypting c...");
        System.out.print(("The plaintext m is  "+ plaintext+"\n"));

    }
    /**
     * Implementing a function to find the GCD that helps find the of value 'e'
      **/
    public static int greatestCommonFactor(int x, int y) {
        if (y==0) {
            return x;
        }
        else
            return greatestCommonFactor(y,x%y);
    }
}
