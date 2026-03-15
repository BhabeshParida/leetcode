import java.util.*;

class Fancy {

    static final long MOD = 1000000007;

    ArrayList<Long> list;
    long mul, add;

    public Fancy() {
        list = new ArrayList<>();
        mul = 1;
        add = 0;
    }
    
    public void append(int val) {
        long inv = modInverse(mul);
        long stored = ((val - add + MOD) % MOD * inv) % MOD;
        list.add(stored);
    }
    
    public void addAll(int inc) {
        add = (add + inc) % MOD;
    }
    
    public void multAll(int m) {
        mul = (mul * m) % MOD;
        add = (add * m) % MOD;
    }
    
    public int getIndex(int idx) {
        if(idx >= list.size())
            return -1;

        long stored = list.get(idx);
        long result = (stored * mul % MOD + add) % MOD;
        return (int) result;
    }

    private long modInverse(long x) {
        return power(x, MOD - 2);
    }

    private long power(long a, long b) {
        long res = 1;
        a %= MOD;

        while(b > 0) {
            if((b & 1) == 1)
                res = (res * a) % MOD;

            a = (a * a) % MOD;
            b >>= 1;
        }

        return res;
    }
}