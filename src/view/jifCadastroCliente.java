/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 *
 * @author EDUARDE
 */
public class jifCadastroCliente extends javax.swing.JInternalFrame {


    /**
     * Creates new form cliente
     */
    public jifCadastroCliente() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel1 = new javax.swing.JLabel();
        jClienteNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jClienteDataNasc = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jClienteCpf = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jClienteEndereco = new javax.swing.JTextField();
        jCadClienteSalvar = new javax.swing.JButton();
        jCadClienteExcluir = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jClienteTelefone = new javax.swing.JFormattedTextField();
        jClienteCelular = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jClienteObservacao = new javax.swing.JTextArea();
        jClienteRg = new javax.swing.JFormattedTextField();

        setClosable(true);
        setForeground(java.awt.Color.lightGray);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Cadastro de Clientes");
        setToolTipText("");

        jLabel1.setText("*Nome:");

        jClienteNome.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jClienteNomeActionPerformed(evt);
            }
        });

        jLabel2.setText("Data Nascimento:");

        try
        {
            jClienteDataNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex)
        {
            ex.printStackTrace();
        }
        jClienteDataNasc.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel3.setText("*CPF:");

        try
        {
            jClienteCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex)
        {
            ex.printStackTrace();
        }

        jLabel4.setText("*RG:");

        jLabel5.setText("Endereço:");

        jCadClienteSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Salvar.png"))); // NOI18N
        jCadClienteSalvar.setText("Salvar");
        jCadClienteSalvar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jCadClienteSalvarActionPerformed(evt);
            }
        });

        jCadClienteExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/CAncelar.png"))); // NOI18N
        jCadClienteExcluir.setText("Sair");
        jCadClienteExcluir.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jCadClienteExcluirActionPerformed(evt);
            }
        });

        jLabel6.setText("Celular:");

        jLabel7.setText("Telefone:");

        try
        {
            jClienteTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex)
        {
            ex.printStackTrace();
        }

        try
        {
            jClienteCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) 9 ####-####")));
        } catch (java.text.ParseException ex)
        {
            ex.printStackTrace();
        }

        jLabel8.setText("Observação");

        jClienteObservacao.setColumns(20);
        jClienteObservacao.setRows(5);
        jScrollPane1.setViewportView(jClienteObservacao);

        try
        {
            jClienteRg.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("############")));
        } catch (java.text.ParseException ex)
        {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jClienteCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jClienteTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jClienteNome, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jClienteCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jClienteRg, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jClienteDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jClienteEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCadClienteSalvar)
                        .addGap(28, 28, 28)
                        .addComponent(jCadClienteExcluir))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jClienteNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jClienteDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jClienteCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jClienteRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jClienteEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jClienteTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jClienteCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCadClienteSalvar)
                    .addComponent(jCadClienteExcluir))
                .addGap(74, 74, 74))
        );

        setBounds(0, 0, 721, 439);
    }// </editor-fold>//GEN-END:initComponents

    private void jClienteNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jClienteNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jClienteNomeActionPerformed

    private void jCadClienteSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCadClienteSalvarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCadClienteSalvarActionPerformed

    private void jCadClienteExcluirActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jCadClienteExcluirActionPerformed
    {//GEN-HEADEREND:event_jCadClienteExcluirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jCadClienteExcluirActionPerformed

    
    public void adicionaOuvinteJCadClienteSalvar(ActionListener ouvinte)
    {
        this.jCadClienteSalvar.addActionListener(ouvinte);
    }
    
    
    // GETTERS
    
    public JButton getClienteSalvar()
    {
        return this.jCadClienteSalvar;
    }
        
    
    public String getjClienteCelular()
    {
        if (this.jClienteCelular.getText().charAt(1) == ' ') return null;
        return this.jClienteCelular.getText();
    }

    public String getjClienteCpf()
    {
        if (this.jClienteCpf.getText().charAt(0) == ' ') return null;
        return this.jClienteCpf.getText();        
    }

    public LocalDate getjClienteDataNasc()
    {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        try                     { return LocalDate.parse(this.jClienteDataNasc.getText(), format); }
        catch (Exception e)     { return null; }
    }

    public String getjClienteObservacao()
    {
        if (this.jClienteObservacao.getText().equals("")) return null;
        return this.jClienteObservacao.getText();
    }

    public String getjClienteEndereco()
    {
        if (this.jClienteEndereco.getText().equals("")) return null;
        return this.jClienteEndereco.getText();
    }

    public String getjClienteRg()
    {
        if (this.jClienteRg.getText().equals("") || this.jClienteRg.getText().charAt(0) == ' ')
            return null;
        return this.jClienteRg.getText();
    }

    public String getjClienteTelefone()
    {
        if (this.jClienteTelefone.getText().charAt(1) == ' ') return null;
        return this.jClienteTelefone.getText();
    }
    
    public String getjClienteNome()
    {
        if (this.jClienteNome.getText().equals("")) return null;
        return this.jClienteNome.getText();
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jCadClienteExcluir;
    private javax.swing.JButton jCadClienteSalvar;
    private javax.swing.JFormattedTextField jClienteCelular;
    private javax.swing.JFormattedTextField jClienteCpf;
    private javax.swing.JFormattedTextField jClienteDataNasc;
    private javax.swing.JTextField jClienteEndereco;
    private javax.swing.JTextField jClienteNome;
    private javax.swing.JTextArea jClienteObservacao;
    private javax.swing.JFormattedTextField jClienteRg;
    private javax.swing.JFormattedTextField jClienteTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
