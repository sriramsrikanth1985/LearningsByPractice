public class nestedTry
{
    public static void main(String args[])
    {
        try {
            int num = args.length;
            try {
                int numValue = Integer.parseInt(args[0]);
                System.out.println("The square is " + numValue * numValue);
            } catch(Exception e){
	            System.out.println("Not a number! ");
	            throw e;
	        }
            System.out.println("Hello after first try exception");
        } catch(Exception e){
            System.out.println("No arguments given! ");
        }
    }
}
