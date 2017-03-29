package VIEW;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import org.jdesktop.layout.GroupLayout;

// Referenced classes of package com.gum.View:
//            About, Login
public class Splash extends JFrame {

    Timer timer;
    int ellapsed;
    private JLabel LBL1;
    private JLabel LBL2;
    private JLabel LBL3;
    private JLabel LBL4;
    private JLabel LBL5;
    private JPanel bg;
    private JLabel bgLabel;
    private JPanel fgPanel;
    private JProgressBar progressBar;

    public Splash() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = getSize().width;
        int h = getSize().height;
        int x = (dim.width - w) / 2;
        int y = (dim.height - h) / 2;
        setLocation(x, y);
        setBackground(new Color(0, 0, 0, 0));
        timer = new Timer();
        ellapsed = 0;
        timer.scheduleAtFixedRate(new TimerTask() {

            //final Splash this$0;
        
            public void run() {
                setFocusable(false);
                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(30L);
                    } catch (InterruptedException ex) {
                    }
                    progressBar.setValue(i);
                    if (i == 5) {
                        LBL1.setBackground(new Color(0, 0, 0, 0));
                        LBL1.setText("Loading all components.");
                    }
                    if (i == 15) {
                        LBL1.setBackground(new Color(0, 0, 0, 0));
                        LBL1.setText("Read usability Core.");
                    }
                    if (i == 25) {
                        LBL1.setBackground(new Color(0, 0, 0, 0));
                        LBL1.setText("Prepare Modules.");
                    }
                    if (i == 35) {
                        LBL1.setBackground(new Color(0, 0, 0, 0));
                        LBL1.setText("Reconstruct the Core Components.");
                    }
                    if (i == 75) {
                        LBL1.setBackground(new Color(0, 0, 0, 0));
                        LBL1.setText("Prepare Graphical User Interfaces.");
                    }
                    if (i == 95) {
                        LBL1.setBackground(new Color(0, 0, 0, 0));
                        LBL1.setText("Done Loading all Program Core Components.");
                        LBL1.setBackground(new Color(0, 0, 0, 0));
                    }
                    ellapsed++;
                }

                timer.cancel();
                Index IDX = new Index();
                IDX.setVisible(true);
                dispose();
            }

            {
                //this$0 = Splash.this;
                //super();
            }
        }, 0L, 1L);
    }

    private void initComponents() {
        bg = new JPanel();
        fgPanel = new JPanel();
        LBL1 = new JLabel();
        LBL2 = new JLabel();
        LBL3 = new JLabel();
        LBL4 = new JLabel();
        LBL5 = new JLabel();
        bgLabel = new JLabel();
        progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        setDefaultCloseOperation(3);
        bg.setMinimumSize(new Dimension(1, 1));
        bg.setLayout(new GridBagLayout());
        fgPanel.setOpaque(false);
        setUndecorated(true);
        LBL1.setText("-");
        LBL2.setHorizontalAlignment(0);
        LBL2.setText("E-Voting System");
        LBL3.setHorizontalAlignment(0);
        LBL3.setText("First Released on :");
        LBL4.setHorizontalAlignment(0);
        LBL4.setText("November 16, 2016");
        LBL5.setHorizontalAlignment(0);
        LBL5.setText("Beta Version. 1.0.0.");
        GroupLayout fgPanelLayout = new GroupLayout(fgPanel);
        fgPanel.setLayout(fgPanelLayout);
        fgPanelLayout.setHorizontalGroup(fgPanelLayout.createParallelGroup(1).add(fgPanelLayout.createSequentialGroup().addContainerGap(314, 32767).add(fgPanelLayout.createParallelGroup(1).add(2, fgPanelLayout.createSequentialGroup().add(LBL4, -1, 134, -1).add(193, 193, 193)).add(2, fgPanelLayout.createSequentialGroup().add(fgPanelLayout.createParallelGroup(1).add(LBL5).add(LBL2)).add(193, 193, 193)).add(2, fgPanelLayout.createSequentialGroup().add(LBL3, -2, 114, -2).add(186, 186, 186)).add(2, fgPanelLayout.createSequentialGroup().add(LBL1, -2, 230, -2).add(50, 50, 50)).add(2, fgPanelLayout.createSequentialGroup().add(progressBar, -2, 280, -2).add(10, 10, 10)))));
        fgPanelLayout.setVerticalGroup(fgPanelLayout.createParallelGroup(1).add(fgPanelLayout.createSequentialGroup().add(167, 167, 167).add(LBL2).add(8, 8, 8).add(LBL5).addPreferredGap(1).add(LBL1).add(10, 10, 10).add(progressBar).add(5,5,5).add(LBL3).addPreferredGap(0).add(LBL4).addContainerGap(46, 32767)));
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = 1;
        gridBagConstraints.weightx = 1.0D;
        gridBagConstraints.weighty = 1.0D;
        bg.add(fgPanel, gridBagConstraints);
        bgLabel.setHorizontalAlignment(0);
        bgLabel.setIcon(new ImageIcon("image/Splash.png"));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = 1;
        gridBagConstraints.weightx = 1.0D;
        gridBagConstraints.weighty = 1.0D;
        bg.add(bgLabel, gridBagConstraints);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(1).add(bg, -1, 600, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(1).add(bg, -1, 300, 32767));
        bg.setBackground(new Color(0, 0, 0, 0));
        fgPanel.setBackground(new Color(0, 0, 0, 0));
        pack();
    }

    public static void main(String args[]) {
        try {
            javax.swing.UIManager.LookAndFeelInfo arr$[] = UIManager.getInstalledLookAndFeels();
            int len$ = arr$.length;
            int i$ = 0;
            do {
                if (i$ >= len$) {
                    break;
                }
                javax.swing.UIManager.LookAndFeelInfo info = arr$[i$];
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
                i$++;
            } while (true);
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(com/gum/View/About.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            //Logger.getLogger(com/gum/View/About.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            //Logger.getLogger(com/gum/View/About.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            //Logger.getLogger(com/gum/View/About.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                (new Splash()).setVisible(true);
            }

        });
    }

}
