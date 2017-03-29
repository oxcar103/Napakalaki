package NapakalakiGame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Sofía Almeida Bruno
 * @author María Victoria Granados Pozo
 */
public class Player {
    static final int MAXLEVEL = 10;
    private String name;
    private int level;
    private boolean dead;
    private boolean canISteal;
    private BadConsequence pendingBadConsequence;
    private ArrayList<Treasure> hiddenTreasures;
    private ArrayList<Treasure> visibleTreasures;
    private Player enemy;
    
    
    /**
     * 
     * Constructor
     * @param name Nombre del jugador
     */
    public Player(String name) {
        this.name = name;
        level = 0;
        dead = true;
        canISteal = true;
        pendingBadConsequence = null;
        hiddenTreasures = new ArrayList();
        visibleTreasures = new ArrayList();
        enemy = null; 
    }
    
     /**
      * 
      * Consultor del nombre
      * @return nombre del jugador
      */
    public String getName() {
        return name;
    }
    
     /**
      * 
      * Da vida al jugador
      */
    private void bringToLife() {
        dead = false;
    }
    
    /**
     * 
     * Consultor del nivel de combate
     * @return nivel de combate
     */
    private int getCombatLevel() {
        int combatLevel = level;
        for(Treasure treasure: visibleTreasures) {
           combatLevel += treasure.getBonus();
        }
        return combatLevel;
    }
    
    /**
     * 
     * Incrementa niveles
     * @param l Número de niveles a incrementar 
     */
    private void incrementLevels(int l) {
        if (l > 0)
            if (level+l <= MAXLEVEL)
                level += l;
            else
                level = MAXLEVEL;
    }
    
    /**
     * 
     * Decrementa niveles
     * @param l Número de niveles a decrementar 
     */
    private void decrementLevels(int l) {
        if (l > 0)
            if (level-l > 0)
                level -= l;
            else
                level = 1;
    }
    
    /**
     * 
     * Asigna el mal rollo pendiente 
     * @param b 
     */
    private void setPendingBadConsequence(BadConsequence b) {
        pendingBadConsequence = b;
    }
    
    /**
     * 
     * Aplica el premio del monstruo
     * @param m monstruo del que aplicar el premio
     */
    private void applyPrize(Monster m) {
        int nLevels = m.getLevelsGained();
        incrementLevels(nLevels);
        int nTreasures = m.getTreasuresGained();
        
        if(nTreasures > 0){
            CardDealer dealer = CardDealer.getInstance();
            for (int i=0; i < nTreasures; i++){
                Treasure treasure = dealer.nextTreasure();
                hiddenTreasures.add(treasure);
            }    
        }
    }
    
    /**
     * 
     * Aplica el mal rollo del monstruo
     * @param m monstruo del que aplicar el mal rollo
     */
    private void applyBadConsequence(Monster m) {
        BadConsequence badConsequence = m.getBadConsequence();
        int nLevels = badConsequence.getLevels();
        decrementLevels(nLevels);
        BadConsequence pendingBad = badConsequence.adjustToFitTreasureLists(visibleTreasures, hiddenTreasures);
        setPendingBadConsequence(pendingBad);
    }
    
    /**
     * 
     * Comprueba si un tesoro puede pasarse a visible
     * @param t tesoro para hacer visible
     * @return true si el tesoro puede ser visible
     *         false en caso contrario
     */
    private boolean canMakeTreasureVisible(Treasure t) {
        if (t.getType() == TreasureKind.ONEHAND)
            if (howManyVisibleTreasures(TreasureKind.ONEHAND) < 2 && howManyVisibleTreasures(TreasureKind.BOTHHANDS) == 0)
                return true;
        else if (t.getType() == TreasureKind.BOTHHANDS)
            if (howManyVisibleTreasures(TreasureKind.ONEHAND) == 0 && howManyVisibleTreasures(TreasureKind.BOTHHANDS) == 0)
                return true;
        else if(howManyVisibleTreasures (t.getType()) == 0)
            return true;
        return false;
    }
    
    /**
     * 
     * Número de tesoros visibles de un determinado tipo
     * @param tKind tipo de tesoro a comparar
     * @return número 
     */
    private int howManyVisibleTreasures(TreasureKind tKind) {
        int contador=0;
        for (Treasure t: visibleTreasures)
            if (t.getType() == tKind)
                ++contador;
        return contador;
        
    }
    
    /**
     * 
     * Cambia el estado a muerto si se pierden todos los tesoros
     */
    private void dieIfNoTreasures() {
        if (hiddenTreasures.isEmpty() && visibleTreasures.isEmpty())
            dead = true;
    }
    
    /**
     * 
     * Consultor de dead
     * @return true si está muerto
     *         false en caso contrario
     */
    public boolean isDead() {
        return dead;
    }
    
    /**
     * 
     * Consultor de los tesoros ocultos
     * @return Array de los tesoros ocultos
     */
    public ArrayList<Treasure> getHiddenTreasures() {
        return hiddenTreasures;
    }
    
     /**
     * 
     * Consultor de los teosoros visibles
     * @return Array de los tesoros visibles
     */
    public ArrayList<Treasure> getVisibleTreasures() {
        return visibleTreasures;
    }
    
    /**
     * 
     * @param m
     * @return 
     */
    public CombatResult combat(Monster m) {
        int myLevel = getCombatLevel();
        int monsterLevel = m.getCombatLevel();
        if (!canISteal){
           Dice dice = Dice.getInstance();
           int number = dice.nextNumber();
           
           if (number < 3){
               int enemyLevel = enemy.getCombatLevel();
               monsterLevel += enemyLevel;
           }
        }
        if (myLevel > monsterLevel){
            applyPrize(m);
            if (level >= MAXLEVEL)
                return CombatResult.WINGAME;
            else
                return CombatResult.WIN;
        }
        else{
            applyBadConsequence(m);
            return CombatResult.LOSE;
        }
    }
    
    /**
     * 
     * @param t 
     */
    public void makeTreasureVisible(Treasure t) {
        boolean canI = canMakeTreasureVisible(t);
        if(canI){
            visibleTreasures.add(t);
            hiddenTreasures.remove(t);
        }            
    }
    
    /**
     * 
     * @param t 
     */
    public void discardVisibleTreasure(Treasure t) {
        visibleTreasures.remove(t);
        if (pendingBadConsequence != null && !pendingBadConsequence.isEmpty()){
            pendingBadConsequence.substractVisibleTreasure (t);
        }
        dieIfNoTreasures();
        
    }
    
    /**
     * 
     * @param t 
     */
    public void discardHiddenTreasure (Treasure t){
        hiddenTreasures.remove(t);
        if (pendingBadConsequence != null && !pendingBadConsequence.isEmpty()){
            pendingBadConsequence.substractHiddenTreasure (t);
        }
        dieIfNoTreasures();
    }
    
    /**
     * 
     * Comprueba si el estado de un jugador es válido
     * @return true si el jugador no tiene ningún mal rollo que cumplir
     *              y no tiene más de cuatro tesoros ocultos
     *         false en caso contrario
     */
    public boolean validState() {
        if (pendingBadConsequence.isEmpty() && hiddenTreasures.size()<= 4)
            return true;
        else 
            return false;
    }
    
    /**
     * 
     */
    public void initTreasures() {
        CardDealer dealer = CardDealer.getInstance();
        Dice dice = Dice.getInstance();
        bringToLife();
        Treasure treasure = dealer.nextTreasure();
        hiddenTreasures.add(treasure);
        int number = dice.nextNumber();
        
        if (number > 1){
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
        if (number == 6){
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
    }
    
    /**
     * 
     * Consultor del nivel
     * @return nivel del jugador
     */
    public int getLevels() {
        return level;
    }
    
    public Treasure stealTreasure() {
        boolean canI = canISteal();
        if (canI){
            boolean canYou = enemy.canYouGiveMeATreasure();
            if (canYou){
                Treasure treasure = enemy.giveMeATreasure();
                hiddenTreasures.add (treasure);
                haveStolen();
                return treasure;
            }
        }
        return null;
    }
    
    /**
     * 
     * 
     * @param enemy 
     */
    public void setEnemy(Player enemy) {
        this.enemy = enemy;
    }
    
    /**
     * 
     * Elige un tesoro al azar entre los tesoros ocultos
     * @return un tesoro oculto
     */
    private Treasure giveMeATreasure() {
        Random rand = new Random();
        int posicion = rand.nextInt(hiddenTreasures.size());
        return hiddenTreasures.get(posicion);
    }
    
    /**
     * 
     * Consultor de canISteal
     * @return true si el jugador puede robar una carta
     *         false en caso contrario
     */
    public boolean canISteal() {
        return canISteal;
    }
    
    /**
     * 
     * Consulta si le pueden robar un tesoro
     * @return true si el jugador tiene tesoros ocultos
     *         false en caso contrario
     */
    private boolean canYouGiveMeATreasure() {
        if (hiddenTreasures.isEmpty())
            return false;
        return true;
    }
    
    /**
     * 
     * Si el jugador roba un tesoro cambia el valor de canISteal
     */
    private void haveStolen() {
        canISteal = false;
    }
    
    /**
     * 
     * 
     */
    public void discardAllTreasures() {
        for(Treasure treasure : visibleTreasures){
            discardVisibleTreasure (treasure);
        }
        for(Treasure treasure : hiddenTreasures){
            discardHiddenTreasure (treasure);
        }
    }
}
