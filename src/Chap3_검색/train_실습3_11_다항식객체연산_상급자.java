package Chap3_검색;

import java.util.*;
import java.io.*;

class Term implements Comparable<Term>{
    int coef; // 계수
    int exp;  // 지수
    //생성자
    Term(int c, int e) { this.coef = c; this.exp = e; }
    //getter
	public int getCoef() {
		return coef;
	}
	public int getExp() {
		return exp;
	}
	//setter
	public void setCoef(int coef) {
		this.coef = coef;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	
	@Override
	public int compareTo(Term o) {
		Integer e1 = exp;
		Integer e2 = o.exp;
		return e1.compareTo(e2);
	}
	@Override
	public String toString() {
		return "Term [coef=" + coef + ", exp=" + exp + "]";
	}
}

class Polynomial implements Cloneable{
	List<Term> terms; //static?
	static int capacity;
	static int free;
	int start;
	int finish;
	
	Polynomial() {
		capacity = 128;
		terms = new ArrayList<Term>(capacity);
	} 
	
    @Override
    public String toString() {
        if (terms==null) return "0\n";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < terms.size(); i++) {
            Term t = terms.get(i);
            sb.append(t.coef).append("x^").append(t.exp);
            if (i != terms.size() - 1) sb.append(" + ");
        }
        sb.append('\n');
        return sb.toString();
    }
    
    List<Term> getTerms() {
    	return terms;
    }
    
    void removeZero() {
    	//remove 0 terms
    	List<Term> zero = new ArrayList<>(30);
    	for(Term x : terms) {
    		if (x.getCoef()==0) {
    			zero.add(x);
    		}
    	}//지울거 따로 모아야 comodifier error가 안나옴
    	for(Term x : zero) {
    		terms.remove(x);
    	}
    }
    
    void sort() {
    	removeZero();
    	Collections.sort(terms);
    	Collections.reverse(terms);
    }
    
    void addTerm(int c, int e) {	
    	boolean hasTerm = false;
    	Term term = new Term(c,e);
    	for (Term x : terms) {
    		if (x.getExp() == e) {
    			x.setCoef(c+x.coef);
    			hasTerm = true;
    			break;
        	}
    	}//for
    	if(!hasTerm) terms.add(term);
    	//System.out.println(term);
    	sort();
	}
    
    void newTerm(int c, int e) {
        addTerm(c, e);
    }


	void getData(int numTerms, Random rand) {
        terms.clear();
        if (numTerms <= 0) return;

        int degree = 2 * numTerms; // C++ 코드 동일
        int expo = degree;

        for (int i = degree; i > 0; i--) {
            int coef;
            do { coef = rand.nextInt(numTerms); } while (coef == 0);//ㅁㅁㅁ계수 <= 0은 없음.

            int newExpo;
            do { newExpo = rand.nextInt(degree); } while (newExpo >= expo); 
            //ㅁㅁㅁ차수 내림차순으로 생성.
            //지수가 랜덤으로 생성되기 때문에 건너뛰는 지수가 거의 반드시 생김.
            expo = newExpo;

            newTerm(coef, expo);
            if (expo == 0) break; //ㅁㅁㅁ상수항이 반드시 생김
        }
    }

	
	Polynomial add(Polynomial p) {
		try {
			Polynomial addPoly = (Polynomial) this.clone();
			for (Term x : p.terms) {
				addPoly.newTerm(x.getCoef(), x.getExp());
			}
			return addPoly;
		}

		catch (CloneNotSupportedException e) {

		}
		return null;
	}
	
	Polynomial subtract(Polynomial p) {
		Polynomial subPoly = this;
		
		for (Term x : p.terms) {
			subPoly.newTerm((x.getCoef())*(-1), x.getExp());
		}
		return subPoly;
	}
	
	Polynomial multiply(Polynomial p) {
		Polynomial mulPoly = new Polynomial();
		
		for (Term x : p.terms) {
			for (Term y : this.terms) {
				int coef = x.getCoef() * y.getCoef();
				int exp = x.getExp() + y.getExp();
				mulPoly.newTerm(coef, exp);
			}
		}
		return mulPoly;
	}
	
	int eval(int n) {
		int eval = 0;
		for (Term x : this.terms) {
			eval += x.getCoef() * Math.pow(n, x.getExp()) ;
		}
		return eval;
	}


}
public class train_실습3_11_다항식객체연산_상급자 {
    private static final Random RAND = new Random(49);

    private static void printMenu() {
        System.out.println("1.INPUT");
        System.out.println("2.ADD");
        System.out.println("3.SUBTRACT");
        System.out.println("4.MULTIPLY");
        System.out.println("5.EVAL");
        System.out.println("6.ADDTERM");
        System.out.println("7.EXIT");
        System.out.print("선택> ");
    }

    public static void main(String[] args) throws Exception {
    	
        Scanner sc = new Scanner(System.in);
        Polynomial P1 = new Polynomial();
        Polynomial P2 = new Polynomial();
        Polynomial P3 = new Polynomial();
        Polynomial P4 = new Polynomial();
        Polynomial P5 = new Polynomial();
        

        while (true) {
            printMenu();
            if (!sc.hasNextInt()) break;
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1: // INPUT
                    P1.getData(5, RAND);
                    P2.getData(9, RAND);
                    System.out.print(P1);
                    System.out.print(P2);
                    break;

                case 2: // ADD
                    P3 = P1.add(P2);
                    System.out.print(P3);
                    break;

                case 3: // SUBTRACT
                    P4 = P1.subtract(P2);
                    System.out.print(P4);
                    break;

                case 4: // MULTIPLY
                    P5 = P1.multiply(P2);
                    System.out.print(P5);
                    break;

                case 5: // EVAL
                    int result = P5.eval(3);
                    System.out.println(result);
                    break;

                case 6: // ADDTERM
                    P1.addTerm(9, 9);
                    System.out.print(P1);
                    break;

                case 7: // EXIT
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    return;

                default:
                    System.out.println("잘못된 선택입니다.");
            }
        }
		
        System.out.println("프로그램을 종료합니다.");
        sc.close();
    }
}
