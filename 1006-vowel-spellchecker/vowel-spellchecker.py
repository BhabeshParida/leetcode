class Solution:
    def spellchecker(self, wordlist: List[str], queries: List[str]) -> List[str]:
        
        vowels = set('aeiou')
        
        def mask(word: str) -> str:
            return ''.join('*' if c in vowels else c for c in word.lower())
        
        exact = set(wordlist)
        case_map = {}
        vowel_map = {}
        
        # Preprocessing
        for word in wordlist:
            lower = word.lower()
            masked = mask(word)
            
            if lower not in case_map:
                case_map[lower] = word
                
            if masked not in vowel_map:
                vowel_map[masked] = word
        
        result = []
        
        # Process queries
        for q in queries:
            # 1. Exact match
            if q in exact:
                result.append(q)
            # 2. Case-insensitive
            elif q.lower() in case_map:
                result.append(case_map[q.lower()])
            # 3. Vowel error
            elif mask(q) in vowel_map:
                result.append(vowel_map[mask(q)])
            # 4. No match
            else:
                result.append("")
        
        return result
