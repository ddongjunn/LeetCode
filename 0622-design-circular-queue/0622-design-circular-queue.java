class MyCircularQueue {
    public int front = 0;
    public int rear = -1;
    public int len = 0;
    public int[] q;
    
    public MyCircularQueue(int k) {
        this.q = new int[k];
    }
    
    public boolean enQueue(int value) {
        if(!isFull()){
            this.rear = (this.rear + 1) % this.q.length;
            this.q[rear] = value;
            this.len++;
            return true;
        }
        return false;
    }
    
    public boolean deQueue() {
        if(!isEmpty()){
            this.front = (this.front + 1) % this.q.length;
            this.len--;
            return true;
        }
        return false;
    }
    
    public int Front() {
        return this.isEmpty() ? -1 : this.q[front];
    }
    
    public int Rear() {
        return this.isEmpty() ? -1 : this.q[rear];
    }
    
    public boolean isEmpty() {
        return this.len == 0;
    }
    
    public boolean isFull() {
        return this.len == this.q.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */