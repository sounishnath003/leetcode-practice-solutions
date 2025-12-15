class MyQueue:
    def __init__(self):
        self.stack1=[]
        self.stack2=[]
        
    def push(self, val:int):
        self.stack1.append(val)
        
    def peek(self) -> int:
        if not self.stack2:
            while self.stack1: self.stack2.append(self.stack1.pop())
        return -1 if not self.stack2 else self.stack2[-1]
        
    def pop(self) -> int:
        if not self.stack2:
            while self.stack1:
                self.stack2.append(self.stack1.pop())
        return self.stack2.pop() if self.stack2 else -1

    def empty(self):
        return not self.stack1 and not self.stack2
         


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()