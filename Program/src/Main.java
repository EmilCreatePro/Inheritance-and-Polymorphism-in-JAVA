
import java.io.*;

abstract class Vagon
{
	
	public abstract int getPasageri();

	public abstract int getColete();
	
	
}

class CalatoriA extends VagonCalatori
{
	public int getPasageri()
	{
		return 40;
	}
	
	public int getColete()
	{
		return 300;
	}
	
	public String toString()
	{
		return "Vagon CalatorA";
	}
}

class CalatoriB extends VagonCalatori
{
	
	public int getPasageri()
	{
		return 50;
	}
	
	public int getColete()
	{
		return 400;
	}
	
	public String toString()
	{
		return "Vagon CalatorB";
	}
	
	public void blocareGeamuri()
	{	
		System.out.println("Geamurile s-au blocat\n");
	}
}

class Marfa extends Vagon
{
	
	public int getPasageri()
	{
		return 0;
	}
	
	public int getColete()
	{
		return 400;
	}
	
	public String toString()
	{
		return "Vagon Marfa";
	}
	
}

class Tren
{
	private Vagon[] vagoane = new Vagon[15];
	private int nrVagoane = 0;
	public int nrTotalColete = 0;
	
	public Tren(int n)
	{
		if(n < 15)
		{
			int opt;
			try
			{
				BufferedReader input = new BufferedReader
						(new InputStreamReader(System.in));
				
				for(int i = 0; i < n; i++)
				{
					System.out.print("Ce vagon sa avem?\n1->CalatoriA\n2->CalaltoriB\n3->Marfa\n\nRapsuns: ");
					opt = Integer.parseInt(input.readLine());
					
					if(opt == 1)
					{
						vagoane[nrVagoane++] = new CalatoriA();
					}
					else if(opt == 2)
					{
						vagoane[nrVagoane++] = new CalatoriB();
					}
					else if(opt == 3)
					{
						vagoane[nrVagoane++] = new Marfa();
					}
					else System.out.println("Eroare la citirea din tastatura!");
				
					nrTotalColete += vagoane[nrVagoane-1].getColete();
				}
				
				//input.close();
			}catch(IOException e)
			{
				System.out.println("Eroare la citirea din tastatura!");
				System.exit(1);
			}
		}
		else
			System.out.println("Un tren poate contine maxim 15 vagoane!");
	}
	
	public boolean equals(Object ob)
	{
		if(ob instanceof Tren)
		{
			Tren tren = (Tren)ob;
			return tren.nrTotalColete == nrTotalColete;
		}
		else return false;
	}
	
	public void afisDateTren(Vagon x)
	{

			System.out.println("Pasageri: "  + x.getPasageri() + " Colete: " + x.getColete());
				
	}
	
	public void apelDate()
	{
		for(int i = 0; i < nrVagoane; i++)
		{
			afisDateTren(vagoane[i]);
		}
	}
	
	public int getNrTotalColete()
	{
		return nrTotalColete;
	}
	
	public void afisVagon()
	{
		for(int i = 0; i < nrVagoane; i++)
			System.out.println(vagoane[i].toString());
	}
}

abstract class VagonCalatori extends Vagon
{
	public void inchideUsi()
	{
		System.out.println("Usile s-au inchis\n");
	}
	
	public void deschideUsi()
	{
		System.out.println("Usile s-au deschis\n");
	}
	
	
}

public class Main {

	public static void main(String[] args) 
	{
		int nrVagoane;
		Tren tren1, tren2;
		
		try
		{
			BufferedReader input = new BufferedReader
					(new InputStreamReader(System.in));
			
			System.out.print("Cate vagoane sa aibe trenul?\nRaspuns: ");
			nrVagoane = Integer.parseInt(input.readLine());
			tren1 = new Tren(nrVagoane);
			
			input = new BufferedReader
					(new InputStreamReader(System.in));
			
			System.out.print("Cate vagoane sa aibe trenul?\nRaspuns: ");
			nrVagoane = Integer.parseInt(input.readLine());
			tren2 = new Tren(nrVagoane);
			
			tren1.apelDate();
			System.out.println("Tren1: Avem " + tren1.getNrTotalColete() + " capacitate de colete pt acest tren.");
			tren2.apelDate();
			System.out.println("Tren2 :Avem " + tren2.getNrTotalColete() + " capacitate de colete pt acest tren.");
			
			tren1.afisVagon();
			
			if(tren1.equals(tren2))
			{
				System.out.println("\nTrenurile sunt egale");
			}
			else System.out.println("\nTrenurile NU sunt egale");
			
			input.close();
		}catch(IOException e)
		{
			System.out.println("Eroare la citirea din tastatura2!");
			e.printStackTrace();
			System.exit(1);
		}
		
	}

}
