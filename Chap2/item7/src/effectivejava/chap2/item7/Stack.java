package effectivejava.chap2.item7;

import java.util.*;

public class Stack {
 private Object[] elements;
 private int size = 0;
 private static final int DEFAULT_INITIAL_CAPACITY = 16;

 public Stack() {
     elements = new Object[DEFAULT_INITIAL_CAPACITY];
 }

 public void push(Object e) {
     ensureCapacity();
     elements[size++] = e;
 }
//메모리 누수가 발생하는 pop 메서드
 /*
 public Object pop() {
     if (size == 0)
         throw new EmptyStackException();
     return elements[--size];//size보다 큰 원소들의 다쓴 참조(obsolete reference)는 가비지 컬렉터가 안쓰는지 알 수 없으므로 회수되지 않는다.
 }
 */
 public Object pop() {
     if (size == 0)
         throw new EmptyStackException();
     Object result = elements[--size];
     elements[size] = null; //사용하지 않을 다쓴 참조를 null 처리하여 가비지 컬렉터가 회수할 수 있도록 한다.
     return result;
 }

 public Object[] getElements() {
	 return this.elements;
 }
 
 private void ensureCapacity() {
     if (elements.length == size)
         elements = Arrays.copyOf(elements, 2 * size + 1);
 }
}