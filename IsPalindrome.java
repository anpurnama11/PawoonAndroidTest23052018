import java.util.Scanner;

public class IsPalindrome {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		String sentence=input.nextLine();
		input.close();
        if(sentence.equals(new StringBuilder(sentence).reverse().toString())) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
	}
}
