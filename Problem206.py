from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class SolutionIterative:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        pre, p = None, head
        while p:
            q = p.next
            p.next = pre
            pre = p
            p = q
        return pre


class SolutionRecursive(object): # recursive
  def reverseList(self, root):
    if not root or not root.next:
      return root

    ret = self.reverseList(root.next)
    root.next.next = root # root.next is end of the newly reversed list ret
    root.next = None
    return ret


class SolutionDummyHead:
    def reverseList(self, head: ListNode) -> Optional[ListNode]:
        dummy = ListNode()
        curr = head
        while curr:
            next = curr.next
            curr.next = dummy.next
            dummy.next = curr
            curr = next
        return dummy.next