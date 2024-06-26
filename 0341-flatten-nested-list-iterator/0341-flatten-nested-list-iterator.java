/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    int idx;
    List<Integer> flatList;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.idx = 0;
        this.flatList = new ArrayList();
        flattenList(nestedList);
    }
    
    private void flattenList(List<NestedInteger> nestedList) {
        for(NestedInteger el : nestedList) {
            if(el.isInteger()) {
                flatList.add(el.getInteger());
            } else {
                flattenList(el.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return flatList.get(idx++);
    }

    @Override
    public boolean hasNext() {
        return flatList.size() > idx;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */