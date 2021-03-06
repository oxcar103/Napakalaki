package GUI;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author Sofía Almeida Bruno
 * @author María Victoria Granados Pozo
 */
public class PlayerNamesCapture extends javax.swing.JDialog {
    public ArrayList<String> names = new ArrayList();
    /**
     * Creates new form PlayerNamesCapture
     */
    public PlayerNamesCapture(JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.addWindowListener (new WindowAdapter() {
        @Override
        //Si el usuario cierra la ventana el juego se acaba
        public void windowClosing(WindowEvent e){
            System.exit(0);
        }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Player1 = new javax.swing.JLabel();
        Player2 = new javax.swing.JLabel();
        Player3 = new javax.swing.JLabel();
        name1 = new javax.swing.JTextField();
        name2 = new javax.swing.JTextField();
        name3 = new javax.swing.JTextField();
        BPlay = new javax.swing.JButton();
        BCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Khmer OS", 0, 12)); // NOI18N

        Player1.setText("Player 1");

        Player2.setText("Player 2");

        Player3.setText("Player 3");

        name1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                name1ActionPerformed(evt);
            }
        });

        name3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                name3ActionPerformed(evt);
            }
        });

        BPlay.setText("Play");
        BPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BPlayActionPerformed(evt);
            }
        });

        BCancel.setText("Cancel");
        BCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BPlay)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                        .addComponent(BCancel))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Player3)
                            .addComponent(Player2)
                            .addComponent(Player1))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(name1, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                            .addComponent(name2)
                            .addComponent(name3))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Player1)
                    .addComponent(name1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Player2)
                    .addComponent(name2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Player3)
                    .addComponent(name3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BCancel)
                    .addComponent(BPlay))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void name3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_name3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_name3ActionPerformed

    private void name1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_name1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_name1ActionPerformed

    private void BPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BPlayActionPerformed
        names.add (name1.getText());
        names.add (name2.getText());
        names.add (name3.getText());
        this.dispose();
    }//GEN-LAST:event_BPlayActionPerformed

    /**
     * 
     * Botón cancel
     * @param evt 
     */
    private void BCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCancelActionPerformed
        System.exit(0);
    }//GEN-LAST:event_BCancelActionPerformed

    /**
     * 
     * Método que interactua con los usuarios
     */
    public ArrayList<String> getNames() {
        this.setVisible(true);
        return names;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BCancel;
    private javax.swing.JButton BPlay;
    private javax.swing.JLabel Player1;
    private javax.swing.JLabel Player2;
    private javax.swing.JLabel Player3;
    private javax.swing.JTextField name1;
    private javax.swing.JTextField name2;
    private javax.swing.JTextField name3;
    // End of variables declaration//GEN-END:variables
}
