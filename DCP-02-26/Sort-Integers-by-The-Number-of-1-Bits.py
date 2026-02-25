1class Solution:
2    def sortByBits(self, arr):
3        arr.sort(key=lambda num: (bin(num).count('1'), num))
4        return arr