package com.ruby.java.ch10.컬렉션;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//ㅁㅁㅁ제가 작성한 주석은 ㅁㅁㅁ이 달려있습니다.

//Book 클래스
class Book implements Comparable<Book>{
	private String title;
	private String author;
	private int publicationYear;
	private String isbn;

	public Book() {
	}

	public Book(String title, String author, int publicationYear, String isbn) {
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
		this.isbn = isbn;
	}
	
	public String getTitle() {
		return title;
	}
	public String getIsbn() {
		return isbn;
	}
	
	@Override
	public String toString() {
	    return String.format("도서명:\t%s\t저자:\t%s\t출판연도:\t%d\tISBN:\t%s",
	            title, author, publicationYear, isbn);
	}

	@Override //title로 정렬
	public int compareTo(Book o) {
		// 구현
		return title.compareTo(o.title) ;
	}
}

class Library {
	static final int CAPACITY = 5; // 기본 용량을 5로 설정
	private ArrayList<Book> books = new ArrayList<>();;
	
	public Library() {
		books = new ArrayList<>(CAPACITY);
	}
	
	// 책 추가 (용량 초과 시 에러메시지 출력)
	public void addBook(Book book) {
		// 구현
		try {
			books.add(book);
		} catch (Exception e) {
			e.printStackTrace();//수정
		}
		
	}

	// 책 삭제 (빈 목록에서 삭제 시 에러메시지 출력)
	public Book removeBook() {
		// 구현
		try {
			return books.removeLast();
		} catch (Exception e) {
			e.printStackTrace();//수정
		}
		return null;
	}

	// 메시지와 함께 library에 저장된 도서 출력
	public void printBooks(String msg) {
		// 구현
		System.out.println(msg);
		for (Book book : books ) {
			System.out.println(book.toString());
		}
		
		System.out.println("-".repeat(60));
	}

	// 제목으로 정렬
	public void sortBooksByTitle() {
		// 구현
		Collections.sort(books);
		/*ㅁㅁㅁArrayList 클래스 sort 메서드 사용법 모름. 소괄호 안에 compareTo를 어떻게 넣어야하는지?*/
	}

	// ISBN으로 정렬
	public void sortBooksByISBN() {
		// 구현
		/*ㅁㅁㅁ
		 * 
		 *Book class에 compareTo 메서드 오버라이드는 한 번 밖에 못함. 
		 *
		 *해결1.
		 *현 메소드에서 Comparable을 implement하는 익명 클래스 생성해서 
		*이 메소드에서 잠깐 사용할 compareTo를 정의하려고함. 익명 클래스 사용법을 모름.
		*
		*해결2.
		*compareTo 대신에 compare(a,b) 메소드를 정의해서 사용? 이 경우 Comparator 익명 클래스를 만들어야할 듯. 
		*/
		books.sort(new Comparator<Book>() {
		    @Override
		    public int compare(Book b1, Book b2) {
		    	Integer x = Integer.parseInt(b1.getIsbn());
		    	Integer y = Integer.parseInt(b2.getIsbn());
		        return x.compareTo(y) ;
		    }
		});

		
	}

	// books에서 title을 검색해서 리턴, 없으면 null 리턴
	public Book searchBookByTitle(String title) {
		// 구현
		for (Book book : books) {
			if(title.equals(book.getTitle()) ) {
				return book;
			}
		}
		return null;
	}
}
public class 실습_10_4_도서관리 {
	public static void main(String[] args) {

		Library library = new Library();

		// 5개의 Book 객체 초기화
		Book book1 = new Book("자바", "강감찬", 1995, "12");
		Book book2 = new Book("파이썬", "이순신", 2008, "9");
		Book book3 = new Book("C#", "을지문덕", 2008, "8");
		Book book4 = new Book("자료구조", "연개소문", 1994, "45");
		Book book5 = new Book("리액트", "김춘추", 1999, "7");

		library.addBook(book1);
		library.addBook(book2);
		library.addBook(book3);
		library.addBook(book4);
		library.addBook(book5);

		// 도서 목록 출력
		library.printBooks("현재 도서 목록:");

		library.sortBooksByTitle(); // 제목으로 도서 목록 정렬
		library.printBooks("TITLE 정렬후 최종 도서 목록:");
		
		library.sortBooksByISBN(); // ISBN으로 도서 목록 정렬
		library.printBooks("ISBN 정렬후 최종 도서 목록:");

		// 특정 제목으로 도서 검색 후 출력
		String searchTitle = "자바";
		Book foundBook = library.searchBookByTitle(searchTitle);
		if (foundBook != null)
			System.out.println(searchTitle + " 검색결과\n[" + foundBook + "]");
		else
			System.out.println(searchTitle + " 검색결과가 없습니다.");
		System.out.println("-".repeat(60));

		library.removeBook(); // 정상 삭제
		library.removeBook(); // 정상 삭제
		library.removeBook(); // 정상 삭제
		library.removeBook(); // 정상 삭제/
		library.removeBook(); // 정상 삭제

		// 도서 목록 출력
		library.printBooks("현재 도서 목록:");
		
//		library.removeBook();
	}
}