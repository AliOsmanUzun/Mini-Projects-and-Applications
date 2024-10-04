import java.util.PriorityQueue;
import java.util.Queue;


public class MainClass {

	public static void main(String[] args) {

		// Acil Servis Uygulaması
		
		/*
		 Hastalar Acil Serviste şikayetlerine göre Kuyrukta en önlere geçerek (Priority Queue).
		 
		 Apandisit ---> En yüksek öncelik
		 Yanık ---> Orta Öncelik
		 Baş Ağrısı ---> En düşük öncelik
		 
		 
		
		 
		 */
		
		Queue<Hasta> hastalar = new PriorityQueue<Hasta>();
		
		hastalar.offer(new Hasta("Murat Bey","Yanık"));
		hastalar.offer(new Hasta("Okan Bey","Baş Ağrısı"));
		hastalar.offer(new Hasta("Elif Hanım","Apandisit"));
		hastalar.offer(new Hasta("Oğuz Bey","Yanık"));
		hastalar.offer(new Hasta("Merve Hanım","Yanık"));
		hastalar.offer(new Hasta("Gizem Hanım","Apandisit"));
		hastalar.offer(new Hasta("Alper Bey","Baş Ağrısı"));
		
		int i = 1;
		
		while (hastalar.isEmpty() != true) {
			System.out.println("****************************");
			System.out.println(i + " . sırada");
			System.out.println(hastalar.poll());
			System.out.println("****************************");
			i++;
		}
		
	}

}
