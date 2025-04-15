package pack.Searching.BinarySearch;

public class PowerOfXN {

	public double myPow(double x, int n) {
        long power = n;

        if(n < 0){
            power = -power;
        }
        double result = power(x, power);

        return n < 0 ? 1 / result : result;
    }

    double power(double x, long n){
        if(n == 0){
            return 1;
        }
        double half = power(x, n / 2);
        if(n % 2 == 0){
            return half * half;
        }
        return x * half * half;
    }
}
