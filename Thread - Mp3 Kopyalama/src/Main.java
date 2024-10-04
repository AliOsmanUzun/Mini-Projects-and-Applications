import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	

// Bu mp3 dosyasının tüm içeriğini almak için bir ArrayList kullanacağız.
// Dosyadaki bütün içereği işlem sonunda oluşturduğumuz arraylist'e atmış olacağız
 private static ArrayList<Integer> icerik = new ArrayList<Integer>();
 
 // Dosya okuma işini tek bir metod ile yapalım
 
 public static void fileRead() {
	 // Okuma yapacağımız için 
	 try(FileInputStream input = new FileInputStream("şarkı.mp3");) {
	  // okuma yapacağım dosyamın adını constructor'a girdim
	 
	 int oku;
	 
	 while((oku = input.read()) != -1) {
		 
		 // ArrayList'imize okunan değerleri aktaralım
		icerik.add(oku);
	 }
	 
	 }
	 catch (FileNotFoundException ex) {
	 System.out.println("Dosya bulunamadı!!!");
	 ex.printStackTrace();
	 }
	 catch (IOException ex) {
	 System.out.println("Dosya okunurken hata meydana geldi");
	 ex.printStackTrace();
	 }
 }
 
 // Dosya okuma işlemini önceki metotda yapmış olduk 
 // Şimdi okuduğumuz bu dosyayı başka bir dosyaya kopyalama işlemini yapalım metodumuzda
 
 public static void kopyala(String dosyaIsmi) {
	 try {
	 FileOutputStream output = new FileOutputStream(dosyaIsmi);
	 // Dosyamı okuduğum arraylist üzerinde gezinmem gerekiyor
	 for (int deger : icerik) {
		try {
			output.write(deger); // Dosyamızı artık kopyalamış oluyoruz.
		} catch (IOException ex) {
			System.out.println("Yazma işlemi gerçekleşirken bir hata meydana geldi");
			ex.printStackTrace();
		}
		
		
	}
	 }
	 catch(FileNotFoundException ex) {
		 
	 }
 }
	public static void main(String[] args) {
	// Threadler ile bu dosya kopyalama işleminin süresini nasıl kısaltabiliriz
		
	 fileRead();
	 
	 Thread thread1 = new Thread(new Runnable() {
		
		@Override
		public void run() {
		kopyala("şarkı2.mp3");
		}
	});
	 
	 Thread thread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
			kopyala("şarkı3.mp3");
			}
		});
	 
	 Thread thread3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
			kopyala("şarkı4.mp3");
			}
		});
	 long baslangic = System.currentTimeMillis() ;
	 thread1.start();
	 thread2.start();
	 thread3.start();
	 
	 try {
		thread1.join();
		thread2.join();
		thread3.join();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	 // Main threadimiz bu kopyalama işlemlerini teker teker yapıyor işlem bu yüzden uzuyor 
	 // Ama bu sefer bu kopyalama işlemlerini farklı threadler ile yaparak kopyalanma süresini azaltacağız
	 long bitis = System.currentTimeMillis();
	 
	 System.out.println("3 dosyanın kopyalanması şu kadar sürdü : " + (bitis - baslangic) / 1000 + " saniye");
	System.out.println("Merhaba");
	}
}
