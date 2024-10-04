import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class MainClass {

	public static void main(String[] args) throws InterruptedException {

		
		// Ramazan Pidesi Uygulaması
		
		// Fırından 1 (dahil) ile 10(dahil) arası pide çıkacak. Kuyruktakiler Pideyi almaya çalışacak
		
		System.out.println("********** RAMAZAN PİDESİ UYGULAMASINA HOŞ GELDİNİZ **********");
		Queue<String> pide_kuyrugu = new LinkedList<String>();
		
		pide_kuyrugu.offer("Murat");
		pide_kuyrugu.offer("Hasan");
		pide_kuyrugu.offer("Okan");
		pide_kuyrugu.offer("Ayşe");
		pide_kuyrugu.offer("Merve");
		pide_kuyrugu.offer("Ezgi");
		pide_kuyrugu.offer("Gizem");
		pide_kuyrugu.offer("Mehmet");
		pide_kuyrugu.offer("Oğuz");
		pide_kuyrugu.offer("Burak");
		
	// Rastegele değerler üretmek için random sınıfını ve metotlarını kullanıyoruz.
		
		Random random = new Random();
		
		int pide_sayisi = 1 + random.nextInt(10); // next int metodu ile int tipte rastegele değerler üretebiliyoruz
		// Bu şekilde kullandığımız zaman random nesnesi ve metodunu 0 ile 10 arası değer üretmiş oluyoruz.
		// + 1 şeklinde bir kullanım yapmamın nedeni şuan 0 ve 10 arası değer üretiyor 0 burada dahilken 10 dahil
		// değil bende bu yüzden +1 ekleyerek bu durumun olmamasını sağladım
		// 9 ürettiğinde aslında 10 , 0 ürettiğinde aslında 1 üretmiş olacak
		 
		 
		 System.out.println("\nPideler Çıkıyor...\n");
		 
		 System.out.println("\nÇıkan Pide Sayısı : " + pide_sayisi + "\n");
		 
		 // Main.Java'mızın  3 saniye beklemesini istiyorum çalışma esnasında
		 
		 Thread.sleep(3000);
		 
		 while (pide_sayisi!=0) {
			 
			System.out.println(pide_kuyrugu.poll() + " pideyi aldı....");
			pide_sayisi--;
			Thread.sleep(1000);;
		}
		 
		 System.out.println("\nPide Kalmadı...");
		 
		 
		 
		 
		 
	}
}
