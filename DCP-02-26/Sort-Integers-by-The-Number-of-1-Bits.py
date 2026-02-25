1class Solution:
2    def sortByBits(self, arr: List[int]) -> List[int]:
3        arr.sort(key = lambda num: (num.bit_count(), num))
4        return arr