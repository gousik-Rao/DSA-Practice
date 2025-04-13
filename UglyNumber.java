package pack.Searching.BinarySearch;

public class UglyNumber {

	public int nthUglyNumber(int n, int a, int b, int c) {
        int low = 1, high = Math.min(Math.min(a, b), c) * n;

        return n == 1 ? 1 : binarySearch(low, high, n, a, b, c);
    }

    private int binarySearch(int low, int high, long n, long a, long b, long c){
        if(high == low){
            return high;
        }

        int mid = low + (high - low) / 2;
        // Inclusion-Exclusion principle
        long count = (mid / a + mid / b + mid / c) - (mid / lcm(a, b) + mid / lcm(b, c) + mid / lcm(a, c))
                    + (mid / lcm(lcm(a, b), c));

        return count < n ? binarySearch(mid + 1, high, n, a, b, c) : binarySearch(low, mid, n, a, b, c);
    }
    private long gcd(long a, long b){
        return b == 0 ? a : gcd(b, a % b);
    }

    private long lcm(long a, long b){
        return (a * b) / gcd(a, b);
    }
}
