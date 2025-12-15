class MyStack:
    def __init__(self):
        self.q1=deque()
        self.q2=deque()
        
    def push(self, val:int):
        self.q1.append(val)
        
    def pop(self) -> int:
        while len(self.q1) > 1:
            self.q2.append(self.q1.popleft())
        top=self.q1.popleft()
        self.q1=self.q2
        self.q2=deque()
        return top
        
    def top(self) -> int:
        while len(self.q1) > 1:
            self.q2.append(self.q1.popleft())
        top=self.q1.popleft()
        self.q2.append(top)
        self.q1=self.q2
        self.q2=deque()
        
        return top
        
    def empty(self) -> bool:
        return not self.q1
        


# Your MyStack object will be instantiated and called as such:
# obj = MyStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.empty()