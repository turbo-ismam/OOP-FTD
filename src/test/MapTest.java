package test;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertNotSame;

import utilityclasses.Pair;
import model.map.AbstractMapModel;
import model.map.HardMap;
import model.map.MapTile;
import model.map.MapTileImpl;
import model.map.NormalMap;
import model.map.SimpleMap;
import model.map.Status;
/**
 * Test the Map model.
 */
public class MapTest {

    @org.junit.Test
    public void mapCreation() {

        //Nella mappa è stato generata un path orizzontale
        final AbstractMapModel sa = new HardMap();
        final Pair<Integer, Integer> a = new Pair<>(10, 10);
        boolean b = true;
        System.out.println("test");
        assertSame("",sa.getTileList().get(0).getStatus(),Status.EMPTY);
        assertSame("",sa.getTileList().get(154).getStatus(),Status.EMPTY);
        assertSame("",sa.getTileList().get(190).getStatus(),Status.PATH);
        for (int i = 0; i < sa.getGridSize() * sa.getGridSize(); i++) {
            if (sa.getTileList().get(i).getStatus() == Status.PATH) {
                b = false;
                final Pair<Integer, Integer> q = new Pair<>(sa.getTileList().get(i).getPosition().getX(),sa.getTileList().get(i).getPosition().getY());
                System.out.println(q.getX().toString() + " " + q.getY().toString());
            }
        } ;
        assertSame("",b,false);
        assertSame("",sa.getTileList().get(10).getStatus(),Status.PATH);
        final int test = sa.fromPairToInt(a);
        System.out.println(test);
        assertSame("",sa.getTileList().get(test).getStatus(),Status.PATH);
        assertSame("",sa.getPathList().get(0),sa.getTileList().get(10));

        //Creo un nuovo tile da inserire nella mappa 
        final MapTile tile = new MapTileImpl(0, 0);
        tile.setStatus(Status.WITHTOWER);
        sa.setTile(tile);
        assertSame("",sa.getTileList().get(0).getStatus(),Status.WITHTOWER);

        System.out.print(sa.fromPairToInt(a) + "\n");
        System.out.println(sa.fromIntToPair(399).toString());

    }

    @org.junit.Test
    public void simpleMapCheck() {

        //path lungo
        final AbstractMapModel s = new SimpleMap();
        final Pair<Integer, Integer> a = new Pair<>(5, 10);
        final Pair<Integer, Integer> b = new Pair<>(10, 10);
        final Pair<Integer, Integer> c = new Pair<>(10, 5);
        final Pair<Integer, Integer> d = new Pair<>(15, 5);
        final Pair<Integer, Integer> e = new Pair<>(2, 15);

        assertSame("",s.getTileList().get(s.fromPairToInt(a)).getStatus(),Status.PATH);
        System.out.print("5,10 ok\n");
        assertSame("",s.getTileList().get(s.fromPairToInt(b)).getStatus(),Status.PATH);
        System.out.print("10,10 ok\n");
        assertSame("",s.getTileList().get(s.fromPairToInt(c)).getStatus(),Status.PATH);
        System.out.print("10,5 ok\n");
        assertSame("",s.getTileList().get(s.fromPairToInt(d)).getStatus(),Status.PATH);
        System.out.print("15,5 ok\n");
        assertSame("",s.getTileList().get(s.fromPairToInt(e)).getStatus(),Status.PATH);
        System.out.print("Simple path complete");
    }

    @org.junit.Test
    public void normalMapCheck() {

        //path medio
        final AbstractMapModel s = new NormalMap();
        final Pair<Integer, Integer> a = new Pair<>(5, 0);
        final Pair<Integer, Integer> b = new Pair<>(5, 10);
        final Pair<Integer, Integer> c = new Pair<>(15, 10);
        final Pair<Integer, Integer> d = new Pair<>(15, 15);
        final Pair<Integer, Integer> e = new Pair<>(2, 15);

        assertSame("",s.getTileList().get(s.fromPairToInt(a)).getStatus(),Status.PATH);
        System.out.print("5,10 ok\n");
        assertSame("",s.getTileList().get(s.fromPairToInt(b)).getStatus(),Status.PATH);
        System.out.print("10,10 ok\n");
        assertSame("",s.getTileList().get(s.fromPairToInt(c)).getStatus(),Status.PATH);
        System.out.print("10,5 ok\n");
        assertSame("",s.getTileList().get(s.fromPairToInt(d)).getStatus(),Status.PATH);
        System.out.print("15,5 ok\n");
        assertNotSame("",s.getTileList().get(s.fromPairToInt(e)).getStatus(),Status.PATH);
        System.out.print("Normal path complete");
    }
	
    public void hardMapCheck() {

        //linea dritta
        final AbstractMapModel s = new NormalMap();
        final Pair<Integer, Integer> a = new Pair<>(5, 0);
        final Pair<Integer, Integer> b = new Pair<>(5, 10);
        final Pair<Integer, Integer> c = new Pair<>(15, 10);
        final Pair<Integer, Integer> d = new Pair<>(15, 10);
        final Pair<Integer, Integer> e = new Pair<>(2, 15);
        
        assertSame("",s.getTileList().get(s.fromPairToInt(a)).getStatus(),Status.PATH);
        System.out.print("5,10 ok\n");
        assertSame("",s.getTileList().get(s.fromPairToInt(b)).getStatus(),Status.PATH);
        System.out.print("10,10 ok\n");
        assertSame("",s.getTileList().get(s.fromPairToInt(c)).getStatus(),Status.PATH);
        System.out.print("10,5 ok\n");
        assertSame("",s.getTileList().get(s.fromPairToInt(d)).getStatus(),Status.PATH);
        System.out.print("15,5 ok\n");
        assertNotSame("",s.getTileList().get(s.fromPairToInt(e)).getStatus(),Status.PATH);
        System.out.print("Normal path complete");
    }
}

