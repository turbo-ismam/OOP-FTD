package Model.Tower;

import Model.Enemy.Enemy;
import Model.Entity.Entity;
import utilityClasses.Pair;

public interface Tower extends Entity {

	
	float getShootTime(); //non so a cosa serva, ora
		
	void shoot(); 		/*	si potrebbe valutare un metodo
						*	"target" opzionale, per cui :
						*	if (target is null) then
						*find target,
						*else shoot();*/
	
	boolean isShooting();
	
	boolean isInRange();
	
	Enemy getTarget();


	void setType(TowerType type);


	TowerType getType();
	
	
	
	
}
