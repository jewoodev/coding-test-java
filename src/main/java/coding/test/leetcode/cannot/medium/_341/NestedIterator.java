package coding.test.leetcode.cannot.medium._341;

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
//public class NestedIterator implements Iterator<Integer> {
//
//    private Queue<Integer> dq = new ArrayDeque<>();
//
//    public NestedIterator(List<NestedInteger> nestedList) {
//        this.addInteger(nestedList);
//    }
//
//    private void addInteger(List<NestedInteger> nestedList) {
//        for (NestedInteger ne: nestedList) {
//            if (ne.isInteger()) {
//                dq.offer(ne.getInteger());
//            } else {
//                this.addInteger(ne.getList());
//            }
//        }
//    }
//
//    @Override
//    public Integer next() {
//        return dq.poll();
//    }
//
//    @Override
//    public boolean hasNext() {
//        return !dq.isEmpty();
//    }
//}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */