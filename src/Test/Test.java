package Test;
import static org.junit.Assert.*;
import java.util.*;

import Model.Enemy.Enemy;
import Model.Enemy.SimpleEnemyModel;
import Model.Enemy.WaveSpawner;
import Model.Map.MapModel;
import Model.Map.SimpleMapModel;

public class Test {
	
	private Enemy monster = new SimpleEnemyModel();
	
	// verifica base di fromRange()
	@org.junit.Test
    public void testRange() {
		// in un range da 0 a 3 si producono 0,1,2,3, e poi pi� niente
		monster.setDamage(25);
		assertEquals(monster.getHP(),75);
    }
	
	// verifica dello split in fromRange()
	@org.junit.Test
    public void testRangeAndSplit() {
		MapModel mappa = new SimpleMapModel();
		monster.walk();
		assertEquals(monster.getLocation().getY().intValue(),10);
		assertEquals(monster.getLocation().getX().intValue(),1);
		monster.walk();
		monster.walk();
		monster.walk();
		monster.walk();
		assertEquals(monster.getLocation().getY().intValue(),10);
		assertEquals(monster.getLocation().getX().intValue(),5);
    }
	
	@org.junit.Test
    public void spawn() {
		WaveSpawner spawner = new WaveSpawner();
		spawner.getSpawn().add(monster);
    }
	
}





