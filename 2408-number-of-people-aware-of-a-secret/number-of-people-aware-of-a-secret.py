class Solution:
    def peopleAwareOfSecret(self, n: int, delay: int, forget: int) -> int:
        MOD = 10**9 + 7
        
        dp = [0] * (n + 1)
        dp[1] = 1
        
        share = 0  # number of people who can share on current day
        
        for day in range(2, n + 1):
            # People who start sharing today
            if day - delay >= 1:
                share = (share + dp[day - delay]) % MOD
            
            # People who forget today (stop sharing)
            if day - forget >= 1:
                share = (share - dp[day - forget]) % MOD
            
            dp[day] = share
        
        # People who still remember the secret on day n
        return sum(dp[max(1, n - forget + 1): n + 1]) % MOD
