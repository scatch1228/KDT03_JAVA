package Chap6_Sorting;

import java.util.ArrayList;
import java.util.List;

public class IntStack {
	private List<Integer> stk; // 스택용 리스트
	private int capacity; // 스택의 크기
	private int top; // 스택 포인터

//--- 실행시 예외: 스택이 비어있음 ---//
	public class EmptyIntStackException extends RuntimeException {
//추가
		public EmptyIntStackException(String msg) {
			super(msg);
		}
	}

/*
public class RuntimeException extends Exception {
// 생성자 중 하나: 메시지를 받는 생성자
public RuntimeException(String message) {
    // 부모 클래스인 Throwable 클래스의 생성자 호출
    super(message);
}
}
*/
//--- 실행시 예외: 스택이 가득 참 ---//
	public class OverflowIntStackException extends RuntimeException {
//추가
		public OverflowIntStackException(String msg) {
			super(msg);
		}
	}

//--- 생성자(constructor) ---//
	public IntStack(int maxlen) {
//추가
		try {
		//추가
			this.capacity = maxlen;
			this.stk = new ArrayList<Integer>(capacity);
			this.top = 0;
		} catch (OutOfMemoryError e) { // 생성할 수 없음
			capacity=0;
		}
	}

//--- 스택에 x를 푸시 ---//
	public void push(int x) throws OverflowIntStackException {
		if (isFull()) // 스택이 가득 참
			throw new OverflowIntStackException("push: stack overflow");
//추가
		stk.add(top++, x);
	}

//--- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
	public int pop() throws EmptyIntStackException {
		if (isEmpty()) // 스택이 빔
			throw new EmptyIntStackException("pop: stack empty");
//추가
		return stk.remove(--top);
	}

//--- 스택에서 데이터를 피크(peek, 정상에 있는 데이터를 들여다봄) ---//
	public int peek() throws EmptyIntStackException {
		if (isEmpty()) // 스택이 빔
			throw new EmptyIntStackException("peek: stack empty");
//추가
		return stk.getLast();
	}

//--- 스택을 비움 ---//
	public void clear() throws EmptyIntStackException {
		/*
		 * stack을 empty로 만들어야 한다.
		 * stack이 empty일 때 clear()가 호출된 예외 발생해야 한다 
		 * pop()으로 구현하지 않고 대신에 while 문으로 remove()를 반복 실행한다
		 */
		if (isEmpty()) // 스택이 빔
			throw new EmptyIntStackException("peek: stack empty");
//추가
		top=0;
	}

//--- 스택에서 x를 찾아 인덱스(없으면 –1)를 반환 ---//
	public int indexOf(int x) {
//추가	
		if(!stk.contains(x)) return -1;
		else return stk.indexOf(x);
	}

//--- 스택의 크기를 반환 ---//
	public int getCapacity() {
		//추가
		return capacity;
	}

//--- 스택에 쌓여있는 데이터 갯수를 반환 ---//
	public int size() {
	//추가
		return top;
	}

//--- 스택이 비어있는가? ---//
	public boolean isEmpty() {
		//추가
		return top<=0;
	}

//--- 스택이 가득 찼는가? ---//
	public boolean isFull() {
		//추가
		return top>=capacity;
	}
	
//--- 스택 안의 모든 데이터를 바닥 → 정상 순서로 표시 ---//
	public void dump() throws EmptyIntStackException{
		if (isEmpty()) {
			System.out.println("스택이 비어있습니다.");
			throw new EmptyIntStackException("peek: stack empty");
		}
		else {
			//추가할 부분
			for (int i=0; i<top; i++) {
				System.out.println(stk.get(i));
			}
		}
	}
}