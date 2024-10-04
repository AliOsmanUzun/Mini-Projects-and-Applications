import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MainClass {
	public static void main(String[] args) {
		
		// Harf Frekansı Bulma Uygulaması
		// TreeMap kullanarak bir stringin içindeki harflerin frekansını bulma 
		
		// Yani bir harf kaç defa geçiyor
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Cümleyi Giriniz : ");
		String cumle = scanner.nextLine();
		// Bu cümle içindeki her bir karakter üzerinde gezinicez ve bir karakter kaç defa kullanılmış onu bulacağız
		
		Map<Character, Integer> frekans = new TreeMap<Character,Integer>();
		
		
		for(int i = 0; i<cumle.length(); i++) {
			
			char c  = cumle.charAt(i); // charAt metodu belirtilen index'deki değeri geri döner 
			
	// containsKey metodu, bir Java Map (örneğin, HashMap, TreeMap, LinkedHashMap) nesnesinde belirli bir anahtarın 
	// (key) olup olmadığını kontrol etmek için kullanılır.
	// Bu metod, kontrol edilen anahtarın map içinde bulunup bulunmadığını belirler 
	// ve buna göre true veya false değeri döner.
		
	// Bizde burada anahtarı ( key ) characterler olarak belirlediğimiz için onu kontrol edicez
			
	if (frekans.containsKey(c)) {
		// Key değerinde c değişkenin tuttuğu değer var ise true değer dönecek
		
	// Replace metodu ise Map nesnesi içerisinde mevcut olarak bulunan bir key için yeni bir value ile 
// eski  value'i değiştirmek için kullanılır. Belirtilen anahtar zaten map içerisinde mevcutsa bu işlemi gerçekleştirir.
// Eğer bu metodu 2 parametreli şekilde  yani ( Key ve new Value ) şeklinde kullanırsam bu işlemi yapar ve eski value'yi return eder.
// Eğer bu metodu 3 parametreli şekilde yani ( Key , eski Value , yeni Value ) şeklinde kullanırsam değerler doğruysa işlemi yapar
// Ve true değer döner , eğer böyle bir anahtar değeri  ve value yoksa false değer döner
		
		frekans.replace(c, frekans.get(c)+1);
		// Sen c key'nin sahip olduğu value'ya o anki key değerinin sahip olduğu value'yi getir ve 1 arttır.
		
	}
	else {
		// Eğer bu karakter ( key olarak ) bu treemap nesnesi içerisinde yoksa
		frekans.put(c,1);
		// Eğer bu key değeri bir daha geçerse buradak bulunan value değeri 1 artacak
	}
		}
		
	for(Map.Entry<Character,Integer> entry : frekans.entrySet()) {
		System.out.println("Karakter : " + entry.getKey() + " Değer : " + entry.getValue());
	}	
	
	scanner.close();
	}
}
