package Test;
import static org.junit.Assert.*;
import java.util.*;

import Model.Enemy.Enemy;
import Model.Enemy.SimpleEnemyModel;

public class Test {
	
	private Enemy monster = new SimpleEnemyModel();
	
	// verifica base di fromRange()
	@org.junit.Test
    public void testRange() {
		// in un range da 0 a 3 si producono 0,1,2,3, e poi pi� niente
		final SplitIterator<Integer> si = sif.fromRange(0, 3); 
		assertEquals(si.next(),Optional.of(0));
		assertEquals(si.next(),Optional.of(1));
		assertEquals(si.next(),Optional.of(2));
		assertEquals(si.next(),Optional.of(3));
		assertEquals(si.next(),Optional.empty());
		assertEquals(si.next(),Optional.empty()); // empty anche insistendo a produrre
    }
	
	// verifica dello split in fromRange()
	@org.junit.Test
    public void testRangeAndSplit() {
		final SplitIterator<Integer> si = sif.fromRange(0, 5); 
		assertEquals(si.next(),Optional.of(0));
		// rimangono da produrre 1,2,3,4,5.. ma si splitta
		final SplitIterator<Integer> siNew = si.split(); 
		// siNew itera la prima met� (escluso l'intermedio se c'�), ossia 1,2
		assertEquals(siNew.next(),Optional.of(1));
		assertEquals(siNew.next(),Optional.of(2));
		assertEquals(siNew.next(),Optional.empty());
		// si itera la seconda met�, ossia 3,4,5
		assertEquals(si.next(),Optional.of(3));
		assertEquals(si.next(),Optional.of(4));
		assertEquals(si.next(),Optional.of(5));
		assertEquals(si.next(),Optional.empty());
    }
	
	// verifica avanzata dello split in fromRange()
	@org.junit.Test
    public void testRangeAndSplitInterleaved() {
		// come il test di cui sopra, ma siNew e si lavorano anche in "interleaving" senza cambiamenti
		final SplitIterator<Integer> si = sif.fromRange(0, 5); 
		assertEquals(si.next(),Optional.of(0));
		final SplitIterator<Integer> siNew = si.split(); 
		assertEquals(siNew.next(),Optional.of(1));
		assertEquals(si.next(),Optional.of(3));
		assertEquals(si.next(),Optional.of(4));
		assertEquals(siNew.next(),Optional.of(2));
		assertEquals(siNew.next(),Optional.empty());
		assertEquals(si.next(),Optional.of(5));
		assertEquals(si.next(),Optional.empty());
    }
	
	// verifica dell'eccezione allo split in fromRangeNoSplit()
	@org.junit.Test(expected = UnsupportedOperationException.class)
	public void testRangeNoSplit() {
		final SplitIterator<Integer> si = sif.fromRangeNoSplit(0, 3); 
		assertEquals(si.next(),Optional.of(0));
		assertEquals(si.next(),Optional.of(1));
		assertEquals(si.next(),Optional.of(2));
		si.split(); // deve lanciare l'eccezione
    }
	
	// verifica base del metodo map(), che usa fromRange()
	@org.junit.Test
    public void optionalTestMap() {
		final SplitIterator<String> si = sif.map(sif.fromRange(0, 3),i -> "s"+i);
		// sif produce s0,s1,s2,s3, per mapping da 0,1,2,3
		assertEquals(si.next(),Optional.of("s0"));
		assertEquals(si.next(),Optional.of("s1"));
		assertEquals(si.next(),Optional.of("s2"));
		assertEquals(si.next(),Optional.of("s3"));
		assertEquals(si.next(),Optional.empty());
    }
	
	// verifica avanzata del metodo map(), che usa fromRange()
	@org.junit.Test
    public void optionalTestMapAndSplit() {
		// controlla che lo SpliIterator creato da map() supporti lo splitting
		final SplitIterator<String> si = sif.map(sif.fromRange(0, 5),i -> "s"+i);
		assertEquals(si.next(),Optional.of("s0"));
		final SplitIterator<String> siNew = si.split(); 
		assertEquals(siNew.next(),Optional.of("s1"));
		assertEquals(siNew.next(),Optional.of("s2"));
		assertEquals(siNew.next(),Optional.empty());
		assertEquals(si.next(),Optional.of("s3"));
		assertEquals(si.next(),Optional.of("s4"));
		assertEquals(si.next(),Optional.of("s5"));
		assertEquals(si.next(),Optional.empty());
    }
	
	// verifica base di fromList()
	@org.junit.Test
    public void testList() {
		final SplitIterator<Integer> si = sif.fromList(Arrays.asList(0,10,20,30,40)); 
		// su questa lista, l'iterazione produce 0,10,20,30,40, e poi pi� niente
		assertEquals(si.next(),Optional.of(0));
		assertEquals(si.next(),Optional.of(10));
		assertEquals(si.next(),Optional.of(20));
		assertEquals(si.next(),Optional.of(30));
		assertEquals(si.next(),Optional.of(40));
		assertEquals(si.next(),Optional.empty());
    }
	
	// verifica splitting in fromList()
	@org.junit.Test
    public void testListAndSplit() {
		// nota che il tutto va come nel caso del range..
		final SplitIterator<Integer> si = sif.fromList(Arrays.asList(0,10,20,30,40,50)); 
		assertEquals(si.next(),Optional.of(0));
		final SplitIterator<Integer> siNew = si.split(); 
		assertEquals(siNew.next(),Optional.of(10));
		assertEquals(si.next(),Optional.of(30));
		assertEquals(si.next(),Optional.of(40));
		assertEquals(siNew.next(),Optional.of(20));
		assertEquals(siNew.next(),Optional.empty());
		assertEquals(si.next(),Optional.of(50));
		assertEquals(si.next(),Optional.empty());
    }
	
	// verifica dell'eccezione allo split in fromListNoSplit()
	@org.junit.Test(expected = UnsupportedOperationException.class)
	public void testListNoSplit() {
		final SplitIterator<Integer> si = sif.fromListNoSplit(Arrays.asList(10,20,30)); 
		assertEquals(si.next(),Optional.of(10));
		assertEquals(si.next(),Optional.of(20));
		si.split();
    }
	
	// verifica base di excludedFirst()
	@org.junit.Test
	public void testExcludeFirst() {
		final SplitIterator<Integer> si = sif.fromList(Arrays.asList(10,20,30));
		// si itererebbe su 10,20,30
		final SplitIterator<Integer> si2 = sif.excludeFirst(si);
		// si2 itera su 20,30, perch� esclude il primo di si
		assertFalse(si == si2); // si2 � un nuovo iteratore!
		assertEquals(si2.next(),Optional.of(20));
		assertEquals(si2.next(),Optional.of(30));
		assertEquals(si2.next(),Optional.empty());
    }
	
	
}
