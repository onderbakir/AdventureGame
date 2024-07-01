import java.util.Scanner;

public class Game {
	
	Player player;
	Location location;
	
	
	
	Scanner scan = new Scanner(System.in);
	
	public void login() {
	Scanner scan = new Scanner(System.in);
		
		System.out.println("Macera Oyununa Hoş Geldiniz!");
		System.out.print("Oyuna başlamadan önce isminizi giriniz : ");
		
		//Kullanıcı ismi alınacak
		//String playerName = scan.nextLine();
		
		player = new Player("a");
		player.selectCha();
		
		
		start();
	}
	
	public void start() {
		while(true) {

			System.out.println();
			System.out.println("--------------------------------------------------------------------------");
			System.out.println();
			System.out.println("Eylem gerceklestirmek icin bir mekan seciniz.");
			System.out.println("1- Guvenli Ev : Burada dusman yok, tamamen guvenli.");
			System.out.println("2- Magara : Burada zombilere rastlanıyor, pek tekin degil.");
			System.out.println("3- Orman : Issız ormanın derinliklerinde tehlike kol geziyor, vampirlere dikkat et.");
			System.out.println("4- Nehir : Ayıların avlandigi bolge, ac ayılar huysuz olabilir.");
			System.out.println("5- Magaza : Ekipman bulabilecegin bir kulube.");
			
			System.out.print("Nereye gitmek istersin ? ");
			
			int selLoc = scan.nextInt();
					
			while(selLoc < 1 || selLoc >5) {
				
				System.out.print("Oyle bir yer yok. Nereye gitmek istersin ? ");
				selLoc = scan.nextInt();
						
			}
			
			switch(selLoc) {
			case 1:
				location = new SafeHouse(player);
				break;
			case 2:
				location = new Cave(player);
				break;
			case 3: 
				location = new Forest(player);
			case 4:
				location = new River(player);
				break;
			case 5:
				location = new ToolStore(player);
				break;
			default :
				location = new SafeHouse(player);
				break;
			}
			
			if(location.getClass().getName().equals("SafeHouse")) {
				
				if(player.getInv().isFirewood() && player.getInv().isFood() && player.getInv().isWater()) {
					
					System.out.println("Tebrikler oyunu kazandiniz ! ");
					break;
				}
				
			}
			
			if(!location.getLocation()) {
				System.out.println("Oyun bitti !");
				break;
			}
			
		}
	
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	
	
	

}
