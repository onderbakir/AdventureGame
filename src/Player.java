import java.util.Scanner;

public class Player {
	
	private int damage, healthy, money, rHealthy;
	private String name, cName;
	private Inventory inv;
	
	Scanner scan = new Scanner(System.in);
	
	
	public Player(String name) {
		
		this.name = name;
		this.inv = new Inventory();
				
		
	}
	
	
	
	public void selectCha() {
		
		switch(chaMenu()){
			
		case 1:
			
			initPlayer("Samuray", 5, 21, 15);
			break;
		
		case 2:
			
			initPlayer("Okcu", 7, 10, 20);
			break;
		case 3:
			
			initPlayer("Sovalye", 8, 24, 5);
			break;
			
		default :
			
			initPlayer("Samuray", 5, 21, 15);			
			break;
			
		}
		
		System.out.println("Karakter : " + getcName() + "\nHasar : " + getDamage() + "\t Saglik : " + getHealthy() + "\t Para : " + getMoney());
		
	}
	
	
	public int getTotalDamage() {
		
		return this.getDamage() + this.getInv().getDamage();
		
	}
	
	
	public void initPlayer(String cName, int dmg, int hlthy, int mny) {
		
		//set metotları;
		setcName(cName);
		setDamage(dmg);
		setHealthy(hlthy);
		setMoney(mny);
		setrHealthy(hlthy);
		
	}
	
	
	public int chaMenu() {
		
		System.out.println("\nLütfen karakterinizi seciniz.");
		System.out.println("1- Samuray -\t  Hasar : 5, Saglik : 21, Para : 15");
		System.out.println("2- Okcu -\t  Hasar : 7, Saglik : 18, Para : 20");
		System.out.println("3- Soavlye -\t  Hasar : 8, Saglik : 24, Para : 5");
		System.out.print("\nSeciminiz : ");
		
		int chaID = scan.nextInt();
		
		while(chaID < 1 || chaID > 3) {
			
			System.out.println("\nLutfen gecerli bir secim yapiniz. ");
			System.out.print("Seciminiz : ");
			chaID = scan.nextInt();
			
			
		}
		
		System.out.println("Secilen sinif : " + chaID);
		
		return chaID;
		
	}



	public int getDamage() {
		return damage;
	}



	public void setDamage(int damage) {
		this.damage = damage;
	}



	public int getHealthy() {
		return healthy;
	}



	public void setHealthy(int healthy) {
		this.healthy = healthy;
	}



	public int getMoney() {
		return money;
	}



	public void setMoney(int money) {
		this.money = money;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getcName() {
		return cName;
	}



	public void setcName(String cName) {
		this.cName = cName;
	}



	public Inventory getInv() {
		return inv;
	}



	public void setInv(Inventory inv) {
		this.inv = inv;
	}



	public int getrHealthy() {
		return rHealthy;
	}



	public void setrHealthy(int rHealthy) {
		this.rHealthy = rHealthy;
	}
	
	
	
	
	
}
