
public class MainClass {
		public static void main(String[] args) throws InterruptedException {
			
	
		System.out.println("Sabiha Gökçen Havalimanına Hoşgeldiniz...");
		
		String sartlar ="Yurtdışı Çıkış Kuralları\n"
				      + "Herhangi bir siyasi yasağınızın bulunmaması gerekiyor\n"
				      + "150 TL harç bedelinizi tam olarak yatırmanız gerekiyor\n"
				      + "Gideceğiniz ülkeye vizenizin bulunması gerekiyor\n";
		String message = "Yurt dışı şartlarından hepsini sağlamanız gerekiyor";
		
		while(true) {
			System.out.println("***********************************\n");
			System.out.println(message);
			System.out.println("\n***********************************\n");
			System.out.println(sartlar);
			
			Yolcu yolcu = new Yolcu();
			
			System.out.println("Harç bedeliniz kontrol ediliyor....");
			Thread.sleep(3000);
			try {
			yolcu.yurtDisiHarci();
			}
			catch(HarcException e){
				e.printStackTrace();
				continue;
			}
			
			System.out.println("Siyasi yasak kontrol ediliyor...");
			Thread.sleep(3000);
			try {
			yolcu.siyasiYasak();
			}
			catch(SiyasiException e ) {
				e.printStackTrace();
				continue;
			}
			System.out.println("Vize Durumu Kontrol Ediliyor....");
			Thread.sleep(3000);
			
			try {
				yolcu.vizeDurumu();
			}
			catch(VizeException e) {
				e.printStackTrace();
				continue;
			}
			
			System.out.println("İşlemleriniz Tamam ! Yurtdışına Çıkabilirsiniz....");
			break;
			
			
		}
				      
		}
}
