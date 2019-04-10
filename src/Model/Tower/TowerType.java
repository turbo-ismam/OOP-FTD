package Model.Tower;

public enum TowerType {
	
		BASIC(50, true),
		
		RANGED(100, false);
	
	private int cost;
    private boolean canAttack;
    
    TowerType(final int towerCost, final boolean canAttack){
    	 this.cost = towerCost;
         this.canAttack = canAttack;
    }
    
    public int getCost() {
        return this.cost;
    }

    public boolean canAttack() {
        return this.canAttack;
    }
    
   
}
