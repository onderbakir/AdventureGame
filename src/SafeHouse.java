
public class SafeHouse extends NormalLoc {
	
	

	SafeHouse(Player player) {
		super(player, "Guvenli Ev");
		// TODO Auto-generated constructor stub
	}
	
	public boolean getLocation() {
		
		player.setHealthy(player.getrHealthy());
		System.out.println("Caniniz yenilendi.");
		System.out.println("Suan guvenli evdesiniz.");
		
		return true;
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
