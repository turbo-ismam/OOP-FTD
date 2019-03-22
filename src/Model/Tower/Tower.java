package Model.Tower;

import Model.Entity.Entity;
import utilityClasses.Pair;

public interface Tower extends Entity {

	int getCost();
	
	void setCost(int cost);
	
	String getType(); //oppure una enum, per ora stringa
	
	void setType(String type);
	
	int getDamage();
	
	void setDamage(int damage);
	
	float getShootTime(); //non so a cosa serva, ora
	
	void setShootTime();
	
	void shoot(); 		/*	si potrebbe valutare un metodo
						*	"target" opzionale, per cui :
						*	if (target is null) then
						*find target,
						*else shoot();*/
	
	boolean isShooting();
	
	boolean isInRange();
	
	
	
	
}
