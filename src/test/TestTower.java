//package Test;
//
//import static org.junit.Assert.*;
//import java.util.ArrayList;
//import Model.Tower.*;
//import Model.Enemy.Enemy;
//import Model.Map.MapTile;
//import Model.Map.MapTileImpl;
//import Model.Projectile.*;
//import utilityClasses.Pair;
//
//public class TestTower {
//	
//	private Tower t = new BasicTower(new Pair<>(1, 2), TowerType.BASIC);
//	private ArrayList<Pair<Integer, Integer>> shootingZone;
//	private int range = 2;
//	MapTile m = new MapTileImpl(1, 2);
//	private Enemy target; 
//	Projectile p = new Projectile(null, target, range);
//	
//	@org.junit.Test
//	public void testLocation(){
//		
//		//check the tower position
//		assertEquals(m.getPosition(), t.getLocation());
//		Pair<Integer,Integer> b = new Pair<>(1,3);
//		
//		//check the tower range
//		for(int i = t.getLocation().getX() - range; i <= t.getLocation().getX() + range; i++) {
//			for(int j = t.getLocation().getY() - range; j <= t.getLocation().getY() + range; j++) {	
//					shootingZone.add(new Pair<>(i,j));
//					if(shootingZone.contains(b)) {
//						System.out.println("ok");
//				}
//			}
//		}	
//	}
//	
//	public void testShoot() {
//		t.update();
//		
//	}
//	
//}
