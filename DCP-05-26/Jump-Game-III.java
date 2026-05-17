1class Solution {
2    public boolean canReach(int[] arr, int start) {
3        int n = arr.length;
4
5        Queue<Integer> q = new LinkedList<>();
6        boolean[] vis = new boolean[n];
7
8        q.offer(start);
9        vis[start] = true;
10
11        while(!q.isEmpty()) {
12
13            int i = q.poll();
14
15            if(arr[i] == 0)
16                return true;
17
18            int forward = i + arr[i];
19            int backward = i - arr[i];
20
21            if(forward < n && !vis[forward]) {
22                vis[forward] = true;
23                q.offer(forward);
24            }
25
26            if(backward >= 0 && !vis[backward]) {
27                vis[backward] = true;
28                q.offer(backward);
29            }
30        }
31
32        return false;   
33    }
34}