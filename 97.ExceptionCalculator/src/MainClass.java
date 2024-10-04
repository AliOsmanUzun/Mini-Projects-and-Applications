import java.util.InputMismatchException;
import java.util.Scanner;
// Birde kendi exception sınıfımızı yazalım
@SuppressWarnings("serial")
class CarpmaException extends Exception {
	

	
	@Override
	public void printStackTrace() {
		System.out.println("İki sayı da çok büyük , Lütfen daha küçük sayılar girin");
	}
	
	
	
}
public class MainClass {

	public static void main(String[] args) {
		
		String merhaba = "merhbaababaa";
		System.out.println(merhaba.charAt(55));
			
		Scanner scanner = new Scanner(System.in);
		System.out.println("***********************************");
		
		String islemler = "1.Toplama İşlemi\n"
					    + "2.Çıkarma İşlemi\n"
					    + "3.Çarpma İşlemi\n"
					    + "4.Bölme İşlemi";
		
		System.out.println(islemler);
		
		System.out.println("***********************************\n");
		
		System.out.print("Lütfen menüden bir seçim yapınız : ");
		
		String islem = scanner.nextLine();
		int a ;
		int b ;
		try {
		switch (islem) {
		case "1":
				System.out.print("Birinci Sayı : ");
				 a = scanner.nextInt();
				System.out.print("İkinci Sayı : ");
				 b = scanner.nextInt();
				System.out.println("Toplam : "  + (a + b));
			break;

		case "2" :
				System.out.print("Birinci Sayı : ");
				a = scanner.nextInt();
				System.out.print("İkinci Sayı : ");
				b = scanner.nextInt();
				System.out.println("Çıkarma : "  + (a - b));
		break;
		
		case "3":
			   System.out.print("Birinci Sayı : ");
			   a = scanner.nextInt();
			System.out.print("İkinci Sayı : ");
			   b = scanner.nextInt();
			  if (a>10000 && b>10000)  { // a ve b sayıları 10.000'den büyükse 
				throw new CarpmaException();
			}
			System.out.println("Çarpım : "  + (a * b));
			break;
			
		case "4":
			System.out.print("Birinci Sayı : ");
			 a = scanner.nextInt();
			System.out.print("İkinci Sayı : ");
			 b = scanner.nextInt();
			System.out.println("Bölüm : "  + (a / b));
			break;
		default : // Buradaki değerlerden farklı bir değer girilirse default bloğum çalışacak
			System.out.println("Menüden bir seçim yapınız");
			break;
		}
		
		}
		// Birden fazla catch bloğu olabilir ama bunlarda dikkat edilmesi gereken
		// Özelden en spesifikten genele doğru gidilmesi Exception fırlatmaların göz önünde bulundurarak
		catch (ArithmeticException e) {
			System.out.println("Bir sayı 0'a bölünemez");
		}
		catch (InputMismatchException e) {
			System.out.println("Lütfen Inputları doğru formatta girin");
		} catch (CarpmaException e) {
			e.printStackTrace();
		}
		// Checked Exception eğer bir METOT içerisinde fırlatılıyorsa
		// Metot imzasında belirtmemiz gerekiyor 
		// Ama normal bir şeklide metot olmadan fırlatılıyorsa
		// Exception Handling yapmamız yeterli olacaktır.
		scanner.close();
			
		}
}
