public class JavaIsPassByValue {
	public static void main(String str[]){
		int i = 10;
		String s = "sri";
		Test t = new Test(i,s);
			
		modInt(i);
		modStr(s);
		modObj(t);
		
		System.out.println(i);
		System.out.println(s);
		System.out.println(t.i1+" and "+t.str);
	}
	
	static void modInt(int i1){
		i1=20;
	}
	static void modStr(String st){
		st="kanth";
	}
	static void modObj(Test t1){
		//Test t2 = new Test(20,"kanth");
		//t1=t2;
		t1.i1=20;
		t1.str="kanth";
	}
}

class Test{
	int i1;
	String str;
	
	Test(int i,String s){
		i1=i;
		str=s;
	}
}
