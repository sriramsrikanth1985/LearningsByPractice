class staticClass{
	static void print(){
		System.out.println("staticClass static method print");
	}
}

public class NullWithStaticMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		staticClass sc = null;
		sc.print();
	}

}
