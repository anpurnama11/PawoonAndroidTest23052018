import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class SingleNumber {

	public static boolean isContainMoreThanOne(int num,int[]arr) {
		int count = 0;
		for(int i=0;i<arr.length;i++) {
			if(num==arr[i]) {
				count++;
			}
		}
		if(count>1) return true;
		else return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		String numbers=input.nextLine();
        int[] digits = new int[numbers.length()];
		for(int i=0;i<numbers.length();i++)
		{
			digits[i] = numbers.charAt(i) - '0';
		}
		input.close();
		List<Integer> results = new ArrayList<>();
		for(int i = 0;i<digits.length;i++) {
			if(isContainMoreThanOne(digits[i],digits)) {
				results.add(digits[i]);
			}
		}
		for(int i = 0;i<results.size();i++) {
			System.out.println(results.get(i));
		}
	}
}
