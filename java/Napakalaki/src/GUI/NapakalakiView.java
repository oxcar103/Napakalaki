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

        meetMonster.setText("Meet the Monster");
        meetMonster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meetMonsterActionPerformed(evt);
            }
        });

        combat.setText("Combat");

        nextTurn.setText("Next Turn");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(currentPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(currentMonster, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(meetMonster)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(combat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nextTurn)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(currentPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(currentMonster, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(meetMonster)
                            .addComponent(combat)
                            .addComponent(nextTurn))
                        .addGap(42, 42, 42))))
        );

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
