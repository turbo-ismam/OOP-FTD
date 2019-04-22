package Test;
import static org.junit.Assert.*;

import java.util.*;

import utilityClasses.Pair;
import Model.Map.AbstractMapModel;
import Model.Map.HardMap;
import Model.Map.MapTile;
import Model.Map.MapTile.Status;
import Model.Map.MapTileImpl;
import Model.Map.NormalMap;
import Model.Map.SimpleMap;

public class MapTest {
	
	/*
	 * 
	 * 
	 * 
	 * 
	 */
	
	@org.junit.Test
	public void mapCreation() {
		
		//Nella mappa è stato generata un path verticale
		final AbstractMapModel sa = new HardMap();
		Pair<Integer,Integer> a = new Pair<>(10,10);
		boolean b=true;
		System.out.println("test");
		assertTrue(sa.tileList().get(0).getStatus()==Status.EMPTY);
		assertTrue(sa.tileList().get(154).getStatus()==Status.EMPTY);
		assertTrue(sa.tileList().get(190).getStatus()==Status.PATH);
		//assertTrue(sa.tileList().get(sa.fromPairToInt(a)).getStatus()==Status.PATH);
		for (int i=0;i<sa.getGridSize()*sa.getGridSize();i++) {
			if (sa.tileList().get(i).getStatus()==Status.PATH) {
				b=false;
				Pair<Integer,Integer> q = new Pair<>(sa.tileList().get(i).getPosition().getX(),sa.tileList().get(i).getPosition().getY());
				System.out.println(q.getX().toString() + " " + q.getY().toString());		
			}
		};
		assertTrue(b==false);
		assertTrue(sa.tileList().get(10).getStatus()==Status.PATH);
		int test = sa.fromPairToInt(a);
		System.out.println(test);
		assertTrue(sa.tileList().get(test).getStatus()==Status.PATH);
		assertTrue(sa.pathList().get(0)== sa.tileList().get(10));
		
		//Creo un nuovo tile da inserire nella mappa 
		MapTile tile = new MapTileImpl(0,0);
		tile.setStatus(Status.WITHTOWER);
		sa.setTile(tile);
		assertTrue(sa.tileList().get(0).getStatus()==Status.WITHTOWER);
		
		assertFalse(sa.positionable(sa.fromPairToInt(a)));
		assertTrue(sa.positionable(1));
		System.out.print(sa.fromPairToInt(a) + "\n");
		System.out.println(sa.fromIntToPair(399).toString());
		
	}
	
	@org.junit.Test
	public void SimpleMapCheck() {
		
		//path lungo
		final AbstractMapModel s = new SimpleMap();
		Pair<Integer,Integer> a = new Pair<>(5,10);
		Pair<Integer,Integer> b = new Pair<>(10,10);
		Pair<Integer,Integer> c = new Pair<>(10,5);
		Pair<Integer,Integer> d = new Pair<>(15,5);
		Pair<Integer,Integer> e = new Pair<>(2,15);
		
		assertTrue(s.tileList().get(s.fromPairToInt(a)).getStatus()==Status.PATH);
		System.out.print("5,10 ok\n");
		assertTrue(s.tileList().get(s.fromPairToInt(b)).getStatus()==Status.PATH);
		System.out.print("10,10 ok\n");
		assertTrue(s.tileList().get(s.fromPairToInt(c)).getStatus()==Status.PATH);
		System.out.print("10,5 ok\n");
		assertTrue(s.tileList().get(s.fromPairToInt(d)).getStatus()==Status.PATH);
		System.out.print("15,5 ok\n");
		assertTrue(s.tileList().get(s.fromPairToInt(e)).getStatus()==Status.PATH);
		System.out.print("Simple path complete");
	}
	
	@org.junit.Test
	public void NormalMapCheck() {
		
		//path medio
		final AbstractMapModel s = new NormalMap();
		Pair<Integer,Integer> a = new Pair<>(5,0);
		Pair<Integer,Integer> b = new Pair<>(5,10);
		Pair<Integer,Integer> c = new Pair<>(15,10);
		Pair<Integer,Integer> d = new Pair<>(15,15);
		Pair<Integer,Integer> e = new Pair<>(2,15);
		
		assertTrue(s.tileList().get(s.fromPairToInt(a)).getStatus()==Status.PATH);
		System.out.print("5,10 ok\n");
		assertTrue(s.tileList().get(s.fromPairToInt(b)).getStatus()==Status.PATH);
		System.out.print("10,10 ok\n");
		assertTrue(s.tileList().get(s.fromPairToInt(c)).getStatus()==Status.PATH);
		System.out.print("10,5 ok\n");
		assertTrue(s.tileList().get(s.fromPairToInt(d)).getStatus()==Status.PATH);
		System.out.print("15,5 ok\n");
		assertFalse(s.tileList().get(s.fromPairToInt(e)).getStatus()==Status.PATH);
		System.out.print("Normal path complete");
	}
	
	public void HardMapCheck() {
		
		//linea dritta
		final AbstractMapModel s = new NormalMap();
		Pair<Integer,Integer> a = new Pair<>(5,0);
		Pair<Integer,Integer> b = new Pair<>(5,10);
		Pair<Integer,Integer> c = new Pair<>(15,10);
		Pair<Integer,Integer> d = new Pair<>(15,10);
		Pair<Integer,Integer> e = new Pair<>(2,15);
		
		assertTrue(s.tileList().get(s.fromPairToInt(a)).getStatus()==Status.PATH);
		System.out.print("5,10 ok\n");
		assertTrue(s.tileList().get(s.fromPairToInt(b)).getStatus()==Status.PATH);
		System.out.print("10,10 ok\n");
		assertTrue(s.tileList().get(s.fromPairToInt(c)).getStatus()==Status.PATH);
		System.out.print("10,5 ok\n");
		assertTrue(s.tileList().get(s.fromPairToInt(d)).getStatus()==Status.PATH);
		System.out.print("15,5 ok\n");
		assertFalse(s.tileList().get(s.fromPairToInt(e)).getStatus()==Status.PATH);
		System.out.print("Normal path complete");
	}

}

