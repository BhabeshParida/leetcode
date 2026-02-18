class Solution:
    def fractionToDecimal(self, numerator: int, denominator: int) -> str:
        
        # If numerator is 0
        if numerator == 0:
            return "0"
        
        result = []
        
        # Handle sign
        if (numerator < 0) ^ (denominator < 0):
            result.append("-")
        
        # Convert to positive
        numerator = abs(numerator)
        denominator = abs(denominator)
        
        # Integer part
        result.append(str(numerator // denominator))
        remainder = numerator % denominator
        
        # If no remainder, return integer result
        if remainder == 0:
            return "".join(result)
        
        result.append(".")
        
        # Dictionary to store remainder and its index
        remainder_map = {}
        
        while remainder:
            
            # If remainder already seen → repeating cycle
            if remainder in remainder_map:
                index = remainder_map[remainder]
                result.insert(index, "(")
                result.append(")")
                break
            
            remainder_map[remainder] = len(result)
            
            remainder *= 10
            result.append(str(remainder // denominator))
            remainder %= denominator
        
        return "".join(result)
