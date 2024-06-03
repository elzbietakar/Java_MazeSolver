/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mazesolver;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.Dimension;


/**
 *
 * @author karas
 */

public class BackgroundFrame extends javax.swing.JFrame {

    /**
     * Creates new form BackgroundFrame
     */
    private MazeReaderObserver observer;
    private MazeData mazeData;
    private MazePanel mazePanel;
    private LinkedList<MazeElement> pathList;
    private PathFinder pathFinder;
   
    public BackgroundFrame(MazeReaderObserver observer, MazeData mazeData, LinkedList<MazeElement> pathList, PathFinder pathFinder) {
        this.pathList = pathList;
        this.pathFinder = pathFinder;
        this.observer = observer;
        this.mazeData = mazeData;
        mazePanel = new MazePanel();
        
        initComponents();
        Color col=new Color(234,112,44);
        attachFileButton.setBackground(col);
        chooseEndButton.setBackground(col);
        chooseStartButton.setBackground(col);
        Restart.setBackground(col);
        Save.setBackground(col);
        findPathButton1.setBackground(col);
        col=new Color(255,238,228);
        menuPanel.setBackground(col);
        toolbarPanel.setBackground(col);
        getContentPane().setBackground(Color.white);
        toolbarPanel.setVisible(false);
        mazeVizualizationPanel.setVisible(false);
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setVisible(false);
        jLabel2.setVisible(false);
        jLabel3.setVisible(false);
        jLabel4.setVisible(false);
        Restart.setVisible(false);
        Save.setVisible(false);
        jScrollPane1.setVisible(false);

        new Thread(new TerminalInputListener(this)).start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        menuPanel = new javax.swing.JPanel();
        descriptionLabel = new javax.swing.JLabel();
        attachFileButton = new javax.swing.JButton();
        toolbarPanel = new javax.swing.JPanel();
        chooseStartButton = new javax.swing.JButton();
        chooseEndButton = new javax.swing.JButton();
        Restart = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        findPathButton1 = new javax.swing.JButton();
        Save = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mazeVizualizationPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        descriptionLabel.setText("Znajdź ścieżkę w labiryncie z użyciem algorytmu Dijkstry.");

        attachFileButton.setText("Załącz plik");
        attachFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attachFileButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(descriptionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 289, Short.MAX_VALUE)
                .addComponent(attachFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(attachFileButton, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(descriptionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );

        toolbarPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        chooseStartButton.setText("Wybierz START");
        chooseStartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseStartButtonActionPerformed(evt);
            }
        });

        chooseEndButton.setText("Wybierz KONIEC");
        chooseEndButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseEndButtonActionPerformed(evt);
            }
        });

        Restart.setText("        Powrót         ");
        Restart.setActionCommand("         Powrót        ");
        Restart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RestartActionPerformed(evt);
            }
        });

        jLabel1.setText("Przebyta drogra:");

        jLabel2.setText("Pokonane zakręty:");

        jLabel3.setText("0");

        jLabel4.setText("0");

        findPathButton1.setText("Znajdź ścieżkę");
        findPathButton1.setMaximumSize(new java.awt.Dimension(122, 23));
        findPathButton1.setMinimumSize(new java.awt.Dimension(122, 23));
        findPathButton1.setPreferredSize(new java.awt.Dimension(122, 23));
        findPathButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findPathButton1ActionPerformed(evt);
            }
        });

        Save.setText("        Zapisz         ");
        Save.setActionCommand("         Zapisz        ");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout toolbarPanelLayout = new javax.swing.GroupLayout(toolbarPanel);
        toolbarPanel.setLayout(toolbarPanelLayout);
        toolbarPanelLayout.setHorizontalGroup(
            toolbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toolbarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(toolbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chooseStartButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chooseEndButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(findPathButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Restart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        toolbarPanelLayout.setVerticalGroup(
            toolbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toolbarPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(chooseStartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chooseEndButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                .addComponent(Save, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Restart, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(findPathButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setMaximumSize(new java.awt.Dimension(327670, 327670));

        mazeVizualizationPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        mazeVizualizationPanel.setPreferredSize(new java.awt.Dimension(4100, 4100));

        javax.swing.GroupLayout mazeVizualizationPanelLayout = new javax.swing.GroupLayout(mazeVizualizationPanel);
        mazeVizualizationPanel.setLayout(mazeVizualizationPanelLayout);
        mazeVizualizationPanelLayout.setHorizontalGroup(
            mazeVizualizationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4098, Short.MAX_VALUE)
        );
        mazeVizualizationPanelLayout.setVerticalGroup(
            mazeVizualizationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4098, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(mazeVizualizationPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(toolbarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(toolbarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void attachFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attachFileButtonActionPerformed
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File inputFile = fileChooser.getSelectedFile();
            String filePath = inputFile.getAbsolutePath();
            System.out.println("GUI: Wybrano plik " + filePath);
            observer.updateFilePath(filePath);
            mazePanel.redraw(mazeData);
            drawMazeVisualizationPanel(mazePanel);
        } else {
        System.out.println("Nie wybrano pliku.");
        }
    }//GEN-LAST:event_attachFileButtonActionPerformed

    private void chooseStartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseStartButtonActionPerformed
        System.out.println("Choose START");
     
        mazePanel.setChooseStartMode(true);
        mazePanel.redraw(mazeData);
        drawMazeVisualizationPanel(mazePanel);
        
    }//GEN-LAST:event_chooseStartButtonActionPerformed

    private void chooseEndButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseEndButtonActionPerformed
        System.out.println("Choose END");
        
        mazePanel.setChooseEndMode(true);
        mazePanel.redraw(mazeData);
        drawMazeVisualizationPanel(mazePanel);
    }//GEN-LAST:event_chooseEndButtonActionPerformed

    private void findPathButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findPathButton1ActionPerformed
        jLabel1.setVisible(true);
        jLabel2.setVisible(true);
        jLabel3.setVisible(true);
        jLabel4.setVisible(true);
        chooseStartButton.setVisible(false);
        chooseEndButton.setVisible(false);
        findPathButton1.setVisible(false);
        Restart.setVisible(true);
        Save.setVisible(true);
        //attachFileButton.setVisible(false);
        
        System.out.println("Find path");
        
        pathFinder.findPath(mazeData, pathList);
        System.out.println("Path was found");
        
        mazePanel.redraw(mazeData);
        drawMazeVisualizationPanel(mazePanel);
        
        
    }//GEN-LAST:event_findPathButton1ActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        MazeSaver mazeSaver = new MazeSaver();
        mazeSaver.saveToFile(pathList);
    }//GEN-LAST:event_SaveActionPerformed

    private void RestartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RestartActionPerformed
        jLabel1.setVisible(false);
        jLabel2.setVisible(false);
        jLabel3.setVisible(false);
        jLabel4.setVisible(false);
        chooseStartButton.setVisible(true);
        chooseEndButton.setVisible(true);
        findPathButton1.setVisible(true);
        Restart.setVisible(false);
        Save.setVisible(false);

        mazeData.forgetFoundPath();
        pathList.clear();
        mazePanel.redraw(mazeData);
        drawMazeVisualizationPanel(mazePanel);
        System.out.println("Restart");
    }//GEN-LAST:event_RestartActionPerformed

public void drawMazeVisualizationPanel(MazePanel mazePanel) {
    mazeVizualizationPanel.setLayout(new java.awt.BorderLayout());
    mazeVizualizationPanel.removeAll();
    mazeVizualizationPanel.add(mazePanel);
    mazeVizualizationPanel.revalidate();
    mazeVizualizationPanel.setBackground(Color.white);
    toolbarPanel.setVisible(true);
    mazeVizualizationPanel.setVisible(true);
    jScrollPane1.setVisible(true);

}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Restart;
    private javax.swing.JButton Save;
    private javax.swing.JButton attachFileButton;
    private javax.swing.JButton chooseEndButton;
    private javax.swing.JButton chooseStartButton;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JButton findPathButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mazeVizualizationPanel;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JPanel toolbarPanel;
    // End of variables declaration//GEN-END:variables
    
}
    
