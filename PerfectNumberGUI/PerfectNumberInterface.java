package PerfectNumbers;

public interface PerfectNumberInterface {

    // -- return true if n is perfect, false otherwise
    //    implements the "guess and verify" technique where
    //    n is the "guess"
    public boolean isPerfect(long n);

    // -- return a perfect number using the formula perfect(p)
    public long getPerfect(long p);

}