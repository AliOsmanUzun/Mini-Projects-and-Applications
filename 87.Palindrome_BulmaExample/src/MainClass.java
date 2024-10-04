import java.util.Scanner;
import java.util.Stack;

public class MainClass {
	public static void main(String[] args) {
		
		
		// Bir cümlenin palindrome olup olmadığını bulma 
		
		// Palindrome baştan okunuşu ile sondan okunuşu aynı olan kelimelere ve cümlelere denir

		// kasaylabalyasak
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Bir cümle girin lütfen : ");
		String cümle = scanner.nextLine();
		
		Stack<Character> stack = new Stack<Character>();
		
		for (int i = 0; i < cümle.length()/2; i++) { // uzunluğunun yarısına kadar döngü devam etsin demiş oldum
				stack.push(cümle.charAt(i));
		}
		
		// Kontrollerini yapalım
		
		if (isPalindrome(cümle, stack)) { // True değer dönerse
			System.out.println(cümle + " cümlesi palindrome bir cümledir");
		}
		else {
			System.out.println(cümle + " cümlesi palindrome bir cümle değildir");
		}
	}
	// Palindrome olup olmadığını kontrol etmek için boolean değer döndüren bir metot yazıyorum
	public static boolean isPalindrome(String cümle , Stack<Character> stack) {

		for (int i = (cümle.length()/2)+1; i < cümle.length(); i++) { // i değerimizi yarısından başlattık cümlenin
			
			if (cümle.charAt(i)!=stack.pop()) {
				return false ;  
			}
		}
		
		
		
		// if koşuluna hiç girmemişse demekki bu polindrom bir cümle o yüzden true değer döndürdüm
		return true ; 
	}
}
