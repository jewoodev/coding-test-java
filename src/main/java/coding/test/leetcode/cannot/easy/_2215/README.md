# 2215. Find the Difference of Two Arrays

문제 링크: [링크](https://leetcode.com/problems/find-the-difference-of-two-arrays/description/)

nums1와 nums2 각각의 차집합을 구하기 위해 10002로 겹치는 요소를 바꿔치기 하는 방법밖에 떠올리지 못했었다. 이것도 요소는 똑같이 나오는 것 같은데 답이 안돼는 이유를 알아내진 못했다.

| Constructor | Description |
|---|---|
| ArrayList(Collection<? extends E> c) |  Constructs a list containing the elements of the specified collection, in the order they are returned by the collection's iterator. |

ArrayList의 생성자 중에 위의 것도 있음을 기억해두자.

그리고 아래의 메서드가 있음도 기억해두자.

| Modifier and Type  | Method                     | Description                                                                                 |
|--------------------|----------------------------|---------------------------------------------------------------------------------------------|
|         boolean           | removeAll(Collection<?> c) | Removes from this list all of its elements that are contained in the specified collection.  |
