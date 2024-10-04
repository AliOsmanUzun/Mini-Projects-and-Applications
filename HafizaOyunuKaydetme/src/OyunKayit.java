import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class OyunKayit {

	public static void oyunKaydet(Kart[][] array) { // Kartlar arrayini buraya gönderdik
		
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("kayit.dat"))){
			System.out.println("Oyununuz kaydediliyor....");
			out.writeObject(array); // Bu Kart sınıfı tipli 2 boyutlu array içindeki objeleri yazacak dosyaya
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Kart[][] kayitAc(){
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("kayit.dat"))) {
			
			Kart[][] cikti = (Kart[][]) in.readObject(); 
			return cikti ;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// Herhangi bir exception fırlatılırsa null değer fırlat demiş oldum
		return null ;
	}
}
