/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frmsentimentanalysiscabiles;

import com.aliasi.classify.Classification; // Label (example: positive)
import com.aliasi.classify.Classified; // Text + label (example: "I love this" = positive)
import com.aliasi.classify.DynamicLMClassifier; // Classifies text using N-Gram

import java.awt.Cursor;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Amazing
 */
public class FrmSentimentAnalysisAmazing extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmSentimentAnalysisAmazing.class.getName());

    /**
     * Creates new form FrmSentimentAnalysisAmazing
     */
    public FrmSentimentAnalysisAmazing() {
        tablesetup();
        initComponents();
    }
    
    private void tablesetup() {
        UIManager.put("TableHeader.background", Color.RED);
        UIManager.put("TableHeader.foreground", Color.WHITE);
        UIManager.put("TableHeader.font", new Font("Segoe UI", Font.BOLD, 12));
    }
    
    // Training helper
    static void train(DynamicLMClassifier classifier_Cabiles, String text_Cabiles, String category_Cabiles) {
        Classification c_Cabiles = new Classification(category_Cabiles); // Create category label
        Classified<String> classified_Cabiles = new Classified<>(text_Cabiles, c_Cabiles); // Combine tetx and label
        classifier_Cabiles.handle(classified_Cabiles); // Train the classifier
    }
    
    // Classification helper
    static String classify(DynamicLMClassifier classifier_Cabiles, String text_Cabiles) {
        Classification result_Cabiles = classifier_Cabiles.classify(text_Cabiles);
        return result_Cabiles.bestCategory();
    }
    
    private void text_classi(JTextArea txt) {
        String[] categories_Cabiles = {"positive", "negative"};
        // It learns patterns of 8-character sequences from the training text
        DynamicLMClassifier classifier_Cabiles = DynamicLMClassifier.createNGramProcess(categories_Cabiles, 8);
        
        // POSITIVE
        train(classifier_Cabiles, "I love this product", "positive");
        train(classifier_Cabiles, "This is amazing and works well", "positive");
        train(classifier_Cabiles, "Very good quality I am happy", "positive");
        train(classifier_Cabiles, "Excellent experience highly recommended", "positive");
        train(classifier_Cabiles, "I like this very much", "positive");
        
        train(classifier_Cabiles, "This exceeded all my expectations", "positive");
        train(classifier_Cabiles, "Best product I have ever used", "positive");
        train(classifier_Cabiles, "Works perfectly and looks great", "positive");
        train(classifier_Cabiles, "Outstanding quality and great value", "positive");
        train(classifier_Cabiles, "I will definitely buy this again", "positive");
        train(classifier_Cabiles, "Very satisfied with the results", "positive");
        train(classifier_Cabiles, "Super easy to use and very effective", "positive");
        train(classifier_Cabiles, "Excellent customer service and fast delivery", "positive");
        train(classifier_Cabiles, "This product is worth every cent", "positive");
        train(classifier_Cabiles, "I feel great using this every day", "positive");
        train(classifier_Cabiles, "Impressive performance and solid build", "positive");
        train(classifier_Cabiles, "Completely blown away by the quality", "positive");
        train(classifier_Cabiles, "Five stars without any hesitation", "positive");
        train(classifier_Cabiles, "So glad I made this decision", "positive");
        train(classifier_Cabiles, "Everything works as described and more", "positive");
        train(classifier_Cabiles, "Truly one of the best things I bought", "positive");
        train(classifier_Cabiles, "This made my day so much better", "positive");
        train(classifier_Cabiles, "Highly recommend this to everyone", "positive");
        train(classifier_Cabiles, "I am so happy with this purchase", "positive");
        train(classifier_Cabiles, "Fantastic experience from start to finish", "positive");
        train(classifier_Cabiles, "Absolutely love the design and functionality", "positive");
        train(classifier_Cabiles, "Shipping was fast and packaging was perfect", "positive");
        train(classifier_Cabiles, "Great value for the price I paid", "positive");
        
        // NEGATIVE
        train(classifier_Cabiles, "I hate this product", "negative");
        train(classifier_Cabiles, "This is very bad and useless", "negative");
        train(classifier_Cabiles, "Terrible experience I regret it", "negative");
        train(classifier_Cabiles, "Not good at all poor quality", "negative");
        train(classifier_Cabiles, "This does not work properly", "negative");
        
        train(classifier_Cabiles, "Worst purchase I have ever made", "negative");
        train(classifier_Cabiles, "I am so disappointed with this", "negative");
        train(classifier_Cabiles, "Complete waste of money", "negative");
        train(classifier_Cabiles, "This broke after just one day", "negative");
        train(classifier_Cabiles, "Nothing works as advertised at all", "negative");
        train(classifier_Cabiles, "I want a full refund immediately", "negative");
        train(classifier_Cabiles, "Terrible quality and awful customer support", "negative");
        train(classifier_Cabiles, "This is the worst experience ever", "negative");
        train(classifier_Cabiles, "Do not buy this under any circumstances", "negative");
        train(classifier_Cabiles, "I regret spending money on this garbage", "negative");
        train(classifier_Cabiles, "Completely useless and very overpriced", "negative");
        train(classifier_Cabiles, "Horrible smell and disgusting texture", "negative");
        train(classifier_Cabiles, "Stopped working after the very first use", "negative");
        train(classifier_Cabiles, "Very poorly made and falls apart easily", "negative");
        train(classifier_Cabiles, "The packaging was damaged and item was missing", "negative");
        train(classifier_Cabiles, "Extremely frustrating and hard to use", "negative");
        train(classifier_Cabiles, "I am deeply unsatisfied with this item", "negative");
        train(classifier_Cabiles, "Would not recommend this to anyone", "negative");
        train(classifier_Cabiles, "Zero stars if I could give them", "negative");
        train(classifier_Cabiles, "This caused more problems than it solved", "negative");
        train(classifier_Cabiles, "Absolutely disgusting and a total disappointment", "negative");
        train(classifier_Cabiles, "Broke on arrival and support ignored me", "negative");
        train(classifier_Cabiles, "Smells awful and feels very cheap", "negative");
        
        txtresult_Cabiles.setText("");
        
        String txt_Cabiles = txt.getText();
        String[] sentences_Cabiles = txt_Cabiles.split("[.!?]");
        
        for(String sentence_Cabiles : sentences_Cabiles)
        {
            sentence_Cabiles = sentence_Cabiles.trim();
            // Skip empty sentences
            if(!sentence_Cabiles.isEmpty())
            {
                String result_Cabiles = classify(classifier_Cabiles, sentence_Cabiles);
                txtresult_Cabiles.append(sentence_Cabiles + " => " + result_Cabiles + "\n");
            }
        }
        
        DefaultTableModel model_Cabiles = new DefaultTableModel();
        model_Cabiles.addColumn("Sentence");
        model_Cabiles.addColumn("Sentiment");
        tbl_result_Cabiles.setModel(model_Cabiles);

        for(String sentence_Cabiles : sentences_Cabiles)
        {
            sentence_Cabiles = sentence_Cabiles.trim();
            // Skip empty sentences
            if(!sentence_Cabiles.isEmpty())
            {
                String result_Cabiles = classify(classifier_Cabiles, sentence_Cabiles);
                model_Cabiles.addRow(new Object[] {sentence_Cabiles, result_Cabiles});
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtinput_Cabiles = new javax.swing.JTextArea();
        btnsubmit_Cabiles = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtresult_Cabiles = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_result_Cabiles = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Input Text");

        txtinput_Cabiles.setBackground(new java.awt.Color(255, 255, 255));
        txtinput_Cabiles.setColumns(20);
        txtinput_Cabiles.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        txtinput_Cabiles.setForeground(new java.awt.Color(0, 0, 0));
        txtinput_Cabiles.setRows(5);
        jScrollPane1.setViewportView(txtinput_Cabiles);

        btnsubmit_Cabiles.setBackground(new java.awt.Color(204, 204, 204));
        btnsubmit_Cabiles.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnsubmit_Cabiles.setForeground(new java.awt.Color(0, 0, 0));
        btnsubmit_Cabiles.setText("Submit");
        btnsubmit_Cabiles.addActionListener(this::btnsubmit_CabilesActionPerformed);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Results");

        txtresult_Cabiles.setBackground(new java.awt.Color(255, 204, 255));
        txtresult_Cabiles.setColumns(20);
        txtresult_Cabiles.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        txtresult_Cabiles.setForeground(new java.awt.Color(0, 0, 0));
        txtresult_Cabiles.setRows(5);
        jScrollPane2.setViewportView(txtresult_Cabiles);

        tbl_result_Cabiles.setBackground(new java.awt.Color(255, 255, 255));
        tbl_result_Cabiles.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        tbl_result_Cabiles.setForeground(new java.awt.Color(0, 0, 0));
        tbl_result_Cabiles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tbl_result_Cabiles);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnsubmit_Cabiles)
                .addGap(381, 381, 381))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnsubmit_Cabiles)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Sentiment Analysis - CABILES");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(255, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(233, 233, 233))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 884, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsubmit_CabilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsubmit_CabilesActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        text_classi(txtinput_Cabiles);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnsubmit_CabilesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FrmSentimentAnalysisAmazing().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsubmit_Cabiles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbl_result_Cabiles;
    private javax.swing.JTextArea txtinput_Cabiles;
    private javax.swing.JTextArea txtresult_Cabiles;
    // End of variables declaration//GEN-END:variables
}
