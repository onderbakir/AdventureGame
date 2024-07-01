import javax.imageio.plugins.tiff.GeoTIFFTagSet;

public class ToolStore extends NormalLoc {

	ToolStore(Player player) {
		super(player, "Magaza");
		
	}
	
	
	public boolean getLocation() {
		
		System.out.println("Para : " + player.getMoney());
		System.out.println("1- Silahlar : ");
		System.out.println("2- Zirhlar : ");
		System.out.println("3- Cikis");
		System.out.print("Seciminiz : ");
		
		int selTool = scan.nextInt();
		int selItemID;
		
		switch (selTool) {
		case 1: 
			selItemID = weeponMenu();
			buyWeepon(selItemID);
			break;
			
		case 2:
			selItemID = armorMenu();
			buyArmor(selItemID);
			break;
			
		default:
			System.out.println("");
			break;
		
		}
		
		return true;
	}
	
	
	
	public int weeponMenu(){
		
		System.out.println("1- Tabanca\t <Para : 25 Hasae : 2>");
		System.out.println("2- Kilic\t <Para : 35 Hasae : 3>");
		System.out.println("3- Tufek\t <Para : 45 Hasae : 7>");
		System.out.println("4- Cikis");
		System.out.print("Seciminiz : ");
		int selWeponID = scan.nextInt();
		
		return selWeponID;
				
	}
	
	public int armorMenu() {
		
		System.out.println("1- Hafif Zirh\t <Para :15 Zirh : 1>");
		System.out.println("2- Orta Zirh\t <Para : 25 Zirh : 3>");
		System.out.println("3- Agir Zirh\t <Para : 40 Zirh : 5>");
		System.out.println("4- Cikis");
		System.out.print("Seciminiz : ");
		int selArmorID = scan.nextInt();
		
		return selArmorID;
		
	}
	
	public void  buyWeepon(int itemID) {
		
		int damage = 0, price = 0;
		String wName = null;
		
		switch (itemID) {
		case 1: 
			damage = 2;
			wName = "Tabanca";
			price = 25;
			break; 
		case 2:
			damage = 3;
			wName = "Kilic";
			price = 35;
			break; 
		case 3:
			damage = 7;
			wName = "Tufek";
			price = 45;
			break; 
		case 4:
			System.out.println("Cikis yapiliyor. ");
			break;
		default:
			System.out.println("Gecersiz islem.");
			break;		
		}
		
		if(price > 0) {
			if(player.getMoney() >= price) {
				player.getInv().setDamage(damage);
				player.getInv().setwName(wName);
				player.setMoney(player.getMoney() - price);
				
				System.out.println(wName+ " satin aldiniz, onceki hasar : " + player.getDamage() 
				+ ", yeni hasar : " + player.getTotalDamage());
				System.out.println("Kalan para : " + (player.getMoney()));
				
			}else {
				System.out.println("Paran yetersiz.");
			}
		}
		
	}
	
	public void buyArmor(int itemID) {
		
		
		int avoid = 0, price = 0;
		String aName = null;
		
		switch (itemID) {
		case 1: 
			avoid = 1;
			aName = "Hafif Zirh";
			price = 15;
			break; 
		case 2:
			avoid = 3;
			aName = "Ortz Zirh";
			price = 25;
			break; 
		case 3:
			avoid = 5;
			aName = "Agir Zirh";
			price = 40;
			break; 
		case 4:
			System.out.println("Cikis yapiliyor. ");
			break;
		default:
			System.out.println("Gecersiz islem.");
			break;		
		}
		
		if(price > 0) {
			if(player.getMoney() >= price) {
				player.getInv().setArmor(avoid);
				player.getInv().setaName(aName);
				player.setMoney(player.getMoney() - price);
				
				System.out.println(aName+ " satin aldiniz, zirhiniz : "+ player.getInv().getArmor());
				
				
				System.out.println("Kalan para : " + (player.getMoney()));
				
			}else {
				System.out.println("Paran yetersiz.");
			}
		}
		
	}
	
}
