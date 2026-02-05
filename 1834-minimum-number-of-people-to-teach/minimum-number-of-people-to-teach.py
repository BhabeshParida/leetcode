from typing import List

class Solution:
    def minimumTeachings(self, n: int, languages: List[List[int]], friendships: List[List[int]]) -> int:
        # Convert each user's languages to a set for fast lookup
        lang_sets = [set(l) for l in languages]

        # Collect friendships where users cannot communicate
        bad_friends = []
        for u, v in friendships:
            u -= 1  # convert to 0-based index
            v -= 1
            if lang_sets[u].isdisjoint(lang_sets[v]):
                bad_friends.append((u, v))

        # If all friends already communicate
        if not bad_friends:
            return 0

        answer = float('inf')

        # Try teaching each language
        for lang in range(1, n + 1):
            to_teach = set()
            for u, v in bad_friends:
                if lang not in lang_sets[u]:
                    to_teach.add(u)
                if lang not in lang_sets[v]:
                    to_teach.add(v)
            answer = min(answer, len(to_teach))

        return answer
