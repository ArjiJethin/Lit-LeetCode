1class Solution{
2    public ListNode rotateRight(ListNode head,int k){
3        if(head==null||head.next==null||k==0) return head; // edge
4
5        int len=1;
6        ListNode tail=head;
7        while(tail.next!=null){ tail=tail.next; len++; } 
8
9        k%=len;
10        if(k==0) return head; 
11
12        tail.next=head; // circular
13
14        int steps=len-k;
15        ListNode newtail=head;
16        for(int i=1;i<steps;i++) newtail=newtail.next; 
17
18        ListNode newhead=newtail.next; // head
19        newtail.next=null;
20
21        return newhead;
22    }
23}