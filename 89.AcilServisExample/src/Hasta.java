
public class Hasta implements Comparable<Hasta> {
	
	private String isim;
	
	private String hastalik;
	
	private int öncelik; // Hastalığın önceliği 
	
	public Hasta(String isim, String hastalik) {
		this.isim = isim;
		this.hastalik = hastalik; // equals ile string değerlerin içeriğinin olup olmadığını kontrol ediyoruz.
		if (this.hastalik.equals("Apandisit")) {
			this.öncelik = 3; 
		}
		else if (this.hastalik.equals("Yanık")) {
			this.öncelik = 2;
		}
		else if (this.hastalik.equals("Baş Ağrısı")){
			this.öncelik = 1;
		}
		else {
			this.öncelik=0;
		}
	}
	
	

	@Override
	public String toString() {
		String bilgiler = "Öncelik Sırası : " + öncelik +
						  "\nHasta Adı : " + isim + 
						  "\nHastalık : " + hastalik +"\n";
		return  bilgiler;
	}



	@Override
	public int compareTo(Hasta hasta) {
			if (this.öncelik > hasta.öncelik) {
				return -1 ;
			}
			else if (this.öncelik < hasta.öncelik)  {
				return 1;
			} 
			else {
				return 0; 
				
			}
			// Böylece büyükten küçüğe doğru sıralama yapmış oldum. 
		}
	}
	

	
	
	


