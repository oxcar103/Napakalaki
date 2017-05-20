package GUI;
import NapakalakiGame.Napakalaki;
/**
 *
 * @author Sofía Almeida Bruno
 * @author María Victoria Granados Pozo
 */
public class NapakalakiView extends javax.swing.JFrame {
    private Napakalaki napakalakiModel;
    /**
     * Creates new form NapakalakiView
     */
    public NapakalakiView() {
        initComponents();
    }

    public void setNapakalaki(Napakalaki napakalaki){
        napakalakiModel = napakalaki;
        currentPlayer.setNapakalaki(napakalakiModel);
        currentPlayer.setPlayer(napakalakiModel.getCurrentPlayer());
        currentMonster.setMonster(napakalakiModel.getCurrentMonster());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        currentMonster = new GUI.MonsterView();
        currentPlayer = new GUI.PlayerView();
        meetMonster = new javax.swing.JButton();
        combat = new javax.swing.JButton();
        nextTurn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(currentMonster);
        currentMonster.setBounds(614, 12, 301, 155);
        getContentPane().add(currentPlayer);
        currentPlayer.setBounds(12, 12, 554, 397);

        meetMonster.setText("Meet the Monster");
        meetMonster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meetMonsterActionPerformed(evt);
            }
        });
        getContentPane().add(meetMonster);
        meetMonster.setBounds(631, 360, 131, 27);

        combat.setText("Combat");
        getContentPane().add(combat);
        combat.setBounds(774, 360, 64, 27);

        nextTurn.setText("Next Turn");
        getContentPane().add(nextTurn);
        nextTurn.setBounds(844, 360, 79, 27);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void meetMonsterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meetMonsterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_meetMonsterActionPerformed

    /**
     * @param args the command line arguments
     */
    public void showView(){
        this.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton combat;
    private GUI.MonsterView currentMonster;
    private GUI.PlayerView currentPlayer;
    private javax.swing.JButton meetMonster;
    private javax.swing.JButton nextTurn;
    // End of variables declaration//GEN-END:variables
}
