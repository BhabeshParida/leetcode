from typing import List
import heapq
from collections import defaultdict

class FoodRatings:

    def __init__(self, foods: List[str], cuisines: List[str], ratings: List[int]):
        # food -> (rating, cuisine)
        self.food_info = {}

        # cuisine -> max heap (-rating, food)
        self.cuisine_heap = defaultdict(list)

        for food, cuisine, rating in zip(foods, cuisines, ratings):
            self.food_info[food] = (rating, cuisine)
            heapq.heappush(self.cuisine_heap[cuisine], (-rating, food))

    def changeRating(self, food: str, newRating: int) -> None:
        oldRating, cuisine = self.food_info[food]

        # update rating
        self.food_info[food] = (newRating, cuisine)

        # push new value (lazy deletion)
        heapq.heappush(self.cuisine_heap[cuisine], (-newRating, food))

    def highestRated(self, cuisine: str) -> str:
        heap = self.cuisine_heap[cuisine]

        while True:
            rating, food = heap[0]
            currentRating, _ = self.food_info[food]

            # check if heap top is still valid
            if -rating == currentRating:
                return food

            # outdated entry
            heapq.heappop(heap)
