import java.util.Scanner;

@SuppressWarnings("serial")
class SiyasiException extends Exception {

	@Override
	public void printStackTrace() {
		System.out.println("Siyasi Yasağınız Bulunuyor");
	}

// Bir class'ın RuntimeException'dan türememesi direkt o class'ı checked exception class yapar.
// Buradada class'ımız Exception sınıfından extends ediyor bu yüzden Checked Exception bir class
	
	
	
}

@SuppressWarnings("serial")
class VizeException extends Exception {

	@Override
	public void printStackTrace() {
		System.out.println("Gideceğiniz Ülkeye Vizeniniz Bulunmamaktadır");
	}
}

@SuppressWarnings("serial")
class HarcException extends Exception {

	@Override
	public void printStackTrace() {
		System.out.println("Lütfen Yurtdışı Harcını Tam Yatırın!");
	}
	
}

public class Yolcu {
	private int harc ; 
	private boolean siyasiYasak;
	private boolean vizeDurumu ; 
	
	public Yolcu() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Yatırdığınız Harç Bedeli : ");
		this.harc =scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("Herhangi bir siyasi yasağınız bulunuyor mu (evet yada hayır) ? : ");
		String cevap = scanner.nextLine();
		
		if (cevap.equals("evet")) {
			this.siyasiYasak = true;
		}
		else {
			this.siyasiYasak = false;
		}
		
		System.out.print("Vizeniz bulunuyor mu ? (evet yada hayır) : ");
		String cevap2 = scanner.nextLine();
		
		if (cevap2.equals("evet")) {
			vizeDurumu = true ;
		}
		else {
			
			vizeDurumu = false;
		}
		
	}

	
	public void yurtDisiHarci() throws HarcException{
		if (this.harc<150) {
			throw new HarcException(); // Runtime Exception'dan türemedi Checked Exception bir sınıf
		}
		else {
			System.out.println("Yurtdışı harcı işlemi tamam");
		}
	}

	
	public void siyasiYasak() throws SiyasiException{
		if (this.siyasiYasak == true) {
			throw new SiyasiException();
		}
		else {
			System.out.println("Siyasi yasağınız bulunmuyor");
		}
	}

	
	public void vizeDurumu() throws VizeException{ // VİzeException objesi fırlatabilir
		if (this.vizeDurumu==true) {
			System.out.println("Vize işlemleri tamam!");
		}
		else {
			throw new VizeException();// VizeException class'ından bir tane exception objesi fırlat
		}
	}

	public int getHarc() {
		return harc;
	}

	public void setHarc(int harc) {
		this.harc = harc;
	}

	public boolean isSiyasiYasak() {
		return siyasiYasak;
	}

	public void setSiyasiYasak(boolean siyasiYasak) {
		this.siyasiYasak = siyasiYasak;
	}

	public boolean isVizeDurumu() {
		return vizeDurumu;
	}

	public void setVizeDurumu(boolean vizeDurumu) {
		this.vizeDurumu = vizeDurumu;
	}
	
	
}
