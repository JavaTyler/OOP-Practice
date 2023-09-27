package PerfectNumbers;

import java.util.ArrayList;

public class PerfectNumber implements PerfectNumberInterface {

    @Override
    public boolean isPerfect(long n) {

        ArrayList<Long> divisors = new ArrayList<>(1);
        long sum = 0;

        for(long i = 1; i < n - 1; i++) {

            if (n % i == 0) {
                divisors.add(i);
            }

        }

        for (int j = 0; j < divisors.size(); j++) {
            sum+= divisors.get(j);
        }

        if (sum == n) {
            return true;
        }
        else {
            return false;
        }

        //〖perfect(p)= 2〗^(p-1)×〖(2〗^p-1)
    }

    @Override
    public long getPerfect(long p) {
        long perfect = (long) ((Math.pow(2,(p-1))) * (Math.pow(2, p) - 1));
        return perfect;
    }

    public static void main (String[] args)
    {
        PerfectNumberInterface pf = new PerfectNumber();
        for (int p = 1; p < 20; ++p) {
            long perfect = pf.getPerfect(p);
            System.out.println("From main: " + p + " " + perfect + " " +
                    pf.isPerfect(perfect));
        }
    }

}
