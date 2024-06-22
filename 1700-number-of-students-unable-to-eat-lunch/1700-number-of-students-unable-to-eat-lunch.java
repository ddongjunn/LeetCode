class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int len = students.length;
        ArrayDeque<Integer> studentQueue = new ArrayDeque<>();
        ArrayDeque<Integer> sandwichStack = new ArrayDeque<>();

        for(int i = 0; i < len; i++) {
            sandwichStack.push(sandwiches[len - i - 1]);
            studentQueue.offer(students[i]);
        }

        int lastServed = 0;
        while(studentQueue.size() > 0 && lastServed < studentQueue.size()) {
            if(sandwichStack.peek() == studentQueue.peek()) {
                sandwichStack.pop();
                studentQueue.poll();
                lastServed = 0;
            }
            else {
                studentQueue.offer(studentQueue.poll());
                lastServed++;
            }
        }
        return studentQueue.size();
    }
}