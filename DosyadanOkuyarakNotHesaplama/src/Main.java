import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	public static String harfnotuHesapla(String isim , int vize1 , int vize2, int finalnot) {
	String cikti = "";
	
	double toplamNot = (vize1 * 0.3)+ (vize2*0.3)+ (finalnot*0.4); // vize1 ve vize %30 , finalnot %40 etki edecek
	
	if (toplamNot >= 90) {
		
		cikti = isim + " bu dersten AA aldı...";
	}
	else if (toplamNot >= 85) {
		
		cikti = isim + " bu dersten BA aldı...";
	}
	else if (toplamNot >= 80) {
		
		cikti = isim + " bu dersten BB aldı...";
	}
	else if (toplamNot >= 75) {
		
		cikti = isim + " bu dersten CB aldı...";
	}
	else if (toplamNot >= 70) {
		
		cikti = isim + " bu dersten CC aldı...";
	}
	else if (toplamNot >= 65) {
		
		cikti = isim + " bu dersten DC aldı...";
	}
	else if (toplamNot >= 60) {
		
		cikti = isim + " bu dersten DD aldı...";
	}
	else if (toplamNot >= 55) {
		
		cikti = isim + " bu dersten FD aldı...";
	}
	else {
		cikti = isim + " bu dersten FF aldı...";
	}
	return cikti;
	
	}
	public static void main(String[] args) {
		
		// Okuma yapacaksam dosya içerisinde scanner sınıfı ile yapıyorum
		
		try(Scanner scanner = new Scanner(new BufferedReader(new FileReader("dosya.txt")));
			BufferedWriter writer = new BufferedWriter(new FileWriter("harfnotlari.txt")))
		{
		while (scanner.hasNextLine()) {
			
			String ogrenciBilgileri = scanner.nextLine();
			
			String [] array = ogrenciBilgileri.split(","); // okuduğu satırdaki tüm virgülleri kaldıracak ve ona göre ayıracak
			int vize1 = Integer.valueOf(array[1]);
			int vize2 = Integer.valueOf(array[2]);
			int finalnot = Integer.valueOf(array[3]);
			String sonuc = harfnotuHesapla(array[0], vize1, vize2, finalnot); 
			// bu metodumuz string bir değer dönecek
			writer.write(sonuc  + "\n");
		}
			
			
		}
		catch (FileNotFoundException ex) {
		System.out.println("Dosya bulunamadı!");
		ex.printStackTrace();
		}
		catch (IOException ex) {
		System.out.println("Dosya açılırken hata meydana geldi!");
		ex.printStackTrace();
		}
		
		
		
	}
}
