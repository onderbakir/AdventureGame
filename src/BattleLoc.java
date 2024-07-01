
public abstract class BattleLoc extends Location {

	protected Obstacle obstacle;
	protected String awarrd;
	
	
	BattleLoc(Player player, String name, Obstacle obstacle, String award) {
		super(player);
		// TODO Auto-generated constructor stub
		this.name = name;
		this.obstacle = obstacle;
		this.awarrd = award;
	}
	
	public boolean getLocation() {
		
		int obsCount = obstacle.count();
		System.out.println("Dikkat burada " + obsCount + " tane " + obstacle.getName() + " ile karsilastin" );
		System.out.print("<S>avas evya <K>ac!");
		
		String selCase = scan.nextLine();
		selCase = selCase.toUpperCase();
		
		if(selCase.equals("S")) {
			 
			if(combat(obsCount)) {
				
				System.out.println(this.name + " bolgesindeki tum dusmanlari temizlediniz !");
				
				if(this.awarrd.equals("Food") && player.getInv().isFood() == false) {
					System.out.println(this.awarrd + " kazandiniz.");
					player.getInv().setFood(true);
				}else if(this.awarrd.equals("Water") && player.getInv().isWater() == false) {
					System.out.println(this.awarrd + " kazandiniz.");
					player.getInv().setWater(true);
				}else if(this.awarrd.equals("Firewood") && player.getInv().isFirewood() == false) {
					System.out.println(this.awarrd + " kazandiniz.");
					player.getInv().setFirewood(true);
				}
				
				return true;
			}
			if (player.getHealthy() <= 0) {
				System.out.println("Oldunuz ! ");
				return false;
			}
			
		}
		
		return true;
		
	}
	
	public boolean combat(int obsCount) {
		
		for(int i=0 ; i < obsCount ; i++) {
			
			int defObsHealth = obstacle.getHealth();
			
			playerStats();
			enemyStats();
			
			while(player.getHealthy() > 0 && obstacle.getHealth() > 0) {
				
				System.out.print("<V>ur veya <K>ac");
				String selCase = scan.nextLine();
				selCase = selCase.toUpperCase();
				
				if(selCase.equals("V")) {
					
					System.out.println("Siz vurdunuz. ");
					obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
					
					afterHit();
					
					if(obstacle.getHealth() > 0) {
						
						System.out.println(obstacle.getName() + " size vurdu !");
						player.setHealthy(player.getHealthy() - (obstacle.getDamage() - player.getInv().getArmor()) );
						
						afterHit();
						
					}
								
				}else {
					
					break;
				}
			}
					
				if(obstacle.getHealth() <  player.getHealthy()) {
					System.out.println("Dusmani yok ettin !");
					player.setMoney(player.getMoney() + obstacle.getAward());
					System.out.println("Paraniz : " + player.getMoney());
					
					obstacle.setHealth(defObsHealth);
				}else {
					return false;
				}
				System.out.println("------------------------------------------");
			}
			
		return true;
		
	}
	
	public void playerStats() {
		
		System.out.println("\n" + "Oyuncu Degerleri : \n-----------------------------------");
		System.out.println("Can : " + player.getHealthy());
		System.out.println("Hasar : " + player.getTotalDamage());
		System.out.println("Para : " + player.getMoney());
		
		if(player.getInv().getDamage() > 0) {
			
			System.out.println("Silah : " + player.getInv().getwName());
			
		}
		if(player.getInv().getArmor() > 0) {
			
			System.out.println("Zirh : " + player.getInv().getaName());
			
		}
		
	}
	
	public void enemyStats() {
		
		System.out.println("\n" + obstacle.getName() + " Degerleri : \n---------------------------------");
		System.out.println("Hasar : " + obstacle.getDamage());
		System.out.println("Can : " + obstacle.getHealth());
		System.out.println("Odul : " + obstacle.getAward());
		
		
	}
	
	public void afterHit() {
		System.out.println("Oyuncu cani : " + player.getHealthy());
		System.out.println(obstacle.getName() + " cani : " + obstacle.getHealth());
		System.out.println();
	}
	
	
}
