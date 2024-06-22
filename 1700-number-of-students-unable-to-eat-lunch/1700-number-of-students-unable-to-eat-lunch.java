class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> student = new ArrayDeque();
        for(int i : students) {
            student.offer(i);
        }
        
        Queue<Integer> sandwich = new ArrayDeque();
        for(int i : sandwiches) {
            sandwich.offer(i);
        }
        
        int lastServed = 0;
        while(!student.isEmpty() && lastServed < student.size()) {
            if(student.peek() == sandwich.peek()) {
                student.poll();
                sandwich.poll();
                lastServed = 0;
            } else {
                student.offer(student.poll());
                lastServed++;
            }  
        }
        return student.size();
    }
}