package PerfectNumbers;

import java.util.ArrayList;

public class PrimeNumber implements PrimeNumberInterface {

    @Override
    public long[] primeFactors(long p) {

        ArrayList<Long> primeFactorsTemp = new ArrayList<>(1);
        if (p == 1) {
            primeFactorsTemp.add(0, 1L);
            long[] primeFactorsP = new long[1];
            primeFactorsP[0] = 1L;
            return primeFactorsP;
        }
        //primeFactorsTemp.add(0, 1L);
        //primeFactorsTemp.add(index, temp);
        int index = 0;
        for (long temp = 2; p > 1; temp++) {
            while (p % temp == 0) {
               primeFactorsTemp.add(temp);
                p = p/temp;
            }
        }

        long[] primeFactorsP = new long[primeFactorsTemp.size()];
        for (int i = 0; i < primeFactorsP.length; i++) {
            primeFactorsP[i] = primeFactorsTemp.get(i);
        }

        return primeFactorsP;
    }

    @Override
    public boolean isPrime(long p) {

        if (p <= 1) {
            return false;
        }
        if (p <= 3) {
            return true;
        }

        for (long i = 2; i < p; i++) {
            if (p % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public long nextPrime(long p) {

        long i = p;
        while(true) {
            if (isPrime(i)) {
                if (i%2 != 0) {
                    i++;
                }
                else {
                    i+=2;
                }
                break;
            }
        }
        return i;
    }

    public static void main (String[] args) {
        PrimeNumberInterface pr = new PrimeNumber();
        for (int i = 1; i < 20; ++i) {
            if (pr.isPrime(i)) {
                System.out.println(i + " is Prime");
            }
            else {
                long factors[] = pr.primeFactors(i);
                System.out.print(i + " = ");
                for (int f = 0; f < factors.length - 1; ++f) {
                    System.out.print(factors[f] + " * ");
                }
                System.out.println(factors[factors.length- 1]);
            }
        }
    }

}
