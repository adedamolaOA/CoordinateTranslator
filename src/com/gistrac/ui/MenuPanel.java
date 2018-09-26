/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gistrac.ui;

import com.gistrac.utils.Archiver;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.DefaultMapController;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;
import org.openstreetmap.gui.jmapviewer.tilesources.BingAerialTileSource;
import org.openstreetmap.gui.jmapviewer.tilesources.OsmTileSource;

/**
 *
 * @author SecureUser
 */
public class MenuPanel extends javax.swing.JPanel {

    /**
     * Creates new form MenuPanel
     */
    JMapViewer map;
    MainUI mainUI;
    HashMap<String, String> stateCoordinates = new HashMap<>();

    public MenuPanel(MainUI mainUI) {
        initComponents();
        map = new JMapViewer();
        this.mainUI = mainUI;
        //jButton4.setVisible(false);
        //map.addMapMarker(new MapMarkerDot(9.0579,7.4806));
        //map.addMapMarker(new MapMarkerDot(9.0579,8.4806));
        map.setMapRectanglesVisible(true);
        map.setTileSource(new OsmTileSource.CycleMap());
        //map.setZoom(100);
        map.setDisplayPositionByLatLon(9.0579, 7.4806, 6);
        //map.setMapMarkerVisible(false);
        mapPanel.add(map);
        mapProgressLoad.setStringPainted(true);

        //Abia,Adamawa,Akwa Ibom,Anambra,Bauchi,Bayelsa,Benue,Borno,Cross River,Delta,Ebonyi,Edo,Ekiti,Enugu,Federal Capital Territory,
//Gombe,Imo,Jigawa,Kaduna,Kano,Katsina,Kebbi,Kogi,Kwara,Lagos,Nasarawa,Niger,Ogun,Ondo,Osun,Oyo,Plateau,Rivers,Sokoto,
//Taraba,Yobe,Zamfara
        stateCoordinates.put("Abia", "5.4150331, 7.5569161");
        stateCoordinates.put("Adamawa", "9.19809, 12.542714");//9.286464684304082, 12.447509765625
        stateCoordinates.put("Akwa Ibom", "5.036226914872196, 7.9156494140625");
        stateCoordinates.put("Anambra", "6.227933930268673, 7.064208984375");
        stateCoordinates.put("Bauchi", "10.336536087082974, 9.832763671875");
        stateCoordinates.put("Bayelsa", "4.948669740022713, 6.26220703125");
        stateCoordinates.put("Benue", "7.743651345263343, 8.525390625");
        stateCoordinates.put("Borno", "11.856599189585982, 13.150634765625");
        stateCoordinates.put("Cross River", "5.00339434502215, 8.32763671875");

        stateCoordinates.put("Edo", "6.328947931902761, 5.62225341796875");

        stateCoordinates.put("Federal Capital Territory", "9.080400104155316, 7.481689453125");
        stateCoordinates.put("Gombe", "10.304110328329449, 11.162109375");
        stateCoordinates.put("Imo", "5.5066396743548855, 7.03125");
        stateCoordinates.put("Jigawa", "11.767881354755533, 9.3328857421875");
        stateCoordinates.put("Kaduna", "10.531020008464989, 7.4267578125");
        stateCoordinates.put("Kano", "12.007084584179248, 8.525390625");
        stateCoordinates.put("Katsina", "12.996529200993775, 7.61077880859375");

        stateCoordinates.put("Kwara", "8.51583556120223, 4.5263671875");
        stateCoordinates.put("Lagos", "6.4899833326706515, 3.3837890625");
        stateCoordinates.put("Nasarawa", "8.51583556120223, 8.514404296875");
        stateCoordinates.put("Niger", "9.644076964907923, 6.52587890625");
        stateCoordinates.put("Ogun", "7.188100871179019, 3.31787109375");
        stateCoordinates.put("Ondo", "7.264394325339793, 5.185546875");
        stateCoordinates.put("Osun", "7.798078531355303, 4.54833984375");
        stateCoordinates.put("Oyo", "7.406047717076271, 3.88916015625");
        stateCoordinates.put("Plateau", "9.947208977327033, 8.887939453125");
        stateCoordinates.put("Rivers", "4.784468966579362, 7.00927734375");
        stateCoordinates.put("Sokoto", "13.07947827722643, 5.2294921875");
        stateCoordinates.put("Taraba", "8.917633696396082, 11.348876953125");

        stateCoordinates.put("Delta", "5.7745858, 5.8826956");
        stateCoordinates.put("Ebonyi", "6.322123280148472, 8.106536865234375");
        stateCoordinates.put("Ekiti", "7.623886853120049, 5.2239990234375");
        stateCoordinates.put("Enugu", "6.4382095, 7.5384664");
        stateCoordinates.put("Kebbi", "11.6628506, 4.7614985");
        stateCoordinates.put("Kogi", "7.8035607, 6.7338896");
        stateCoordinates.put("Yobe", "11.75174775769061, 11.964111328125");
        stateCoordinates.put("Zamfara", "12.17896495790654, 6.668701171875");
        new DefaultMapController(map) {

            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    //http://maps.google.com/maps?&z=10&q=36.26577+-92.54324&ll=36.26577+-92.54324
//                    Coordinate cc = map.getPosition(e.getPoint());
//                    String ccUrl = "http://maps.google.com/maps?&z=11&t=k&q=" + cc.getLat() + "+" + cc.getLon() + "&ll=" + cc.getLat() + "+" + cc.getLon() + "";
//                    openWebpage(new URL(ccUrl));
                    Coordinate cc = map.getPosition(e.getPoint());
                    JOptionPane.showMessageDialog(null, "Latitude: " + cc.getLat() + "\n Longitude: " + cc.getLon(), "Ontrac Location Application", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println(map.getPosition(e.getPoint()));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };
        File ll = new File("DataSource");
        if (!ll.exists()) {
            ll.mkdir();
        }
//        Thread t = new Thread(new Runnable() {
//            SearchFrame dialog;
//
//            @Override
//            public void run() {
//                dialog = new SearchFrame();
//
//                dialog.setVisible(true);
//                mainUI.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowIconified(java.awt.event.WindowEvent evt) {
//                        dialog.setExtendedState(JFrame.ICONIFIED);
//                    }
//
//                    @Override
//                    public void windowDeiconified(java.awt.event.WindowEvent evt) {
//                        dialog.setExtendedState(JFrame.NORMAL);
//                    }
//                });
//            }
//
//        });
//        t.start();

    }

    public static void openWebpage(URI uri) {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uri);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void openWebpage(URL url) {
        try {
            openWebpage(url.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
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

        jPanel2 = new javax.swing.JPanel();
        mapPanel = new javax.swing.JPanel();
        mapProgressLoad = new javax.swing.JProgressBar();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        butEntry1 = new javax.swing.JButton();
        butEntry2 = new javax.swing.JButton();
        butEntry3 = new javax.swing.JButton();
        butEntry4 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cmbState = new javax.swing.JComboBox();
        butEntry5 = new javax.swing.JButton();
        butEntry6 = new javax.swing.JButton();
        butEntry7 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        lblDataSetName = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblSuccess = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblAbsent = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lblInternalFailure = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lblTempFailure = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lblSystemFailure = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lblSystemFailure1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 51, 51));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        mapPanel.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mapPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mapPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        butEntry1.setBackground(new java.awt.Color(224, 79, 95));
        butEntry1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        butEntry1.setForeground(new java.awt.Color(255, 255, 255));
        butEntry1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gistrac/ui/resources/1427519828_map.png"))); // NOI18N
        butEntry1.setText(" Data Set #1");
        butEntry1.setToolTipText("Data Set #1 is part of 4 entry points for Location, BTS, GPRS and CDR Data ");
        butEntry1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        butEntry1.setContentAreaFilled(false);
        butEntry1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butEntry1.setFocusPainted(false);
        butEntry1.setOpaque(true);
        butEntry1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butEntry1ActionPerformed(evt);
            }
        });

        butEntry2.setBackground(new java.awt.Color(224, 79, 95));
        butEntry2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        butEntry2.setForeground(new java.awt.Color(255, 255, 255));
        butEntry2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gistrac/ui/resources/1427519828_map.png"))); // NOI18N
        butEntry2.setText("Data Set #2");
        butEntry2.setToolTipText("Data Set #2 is part of 4 entry points for Location, BTS, GPRS and CDR Data ");
        butEntry2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        butEntry2.setContentAreaFilled(false);
        butEntry2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butEntry2.setFocusPainted(false);
        butEntry2.setOpaque(true);
        butEntry2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butEntry2ActionPerformed(evt);
            }
        });

        butEntry3.setBackground(new java.awt.Color(224, 79, 95));
        butEntry3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        butEntry3.setForeground(new java.awt.Color(255, 255, 255));
        butEntry3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gistrac/ui/resources/1427519828_map.png"))); // NOI18N
        butEntry3.setText("Data Set #3");
        butEntry3.setToolTipText("Data Set #3 is part of 4 entry points for Location, BTS, GPRS and CDR Data ");
        butEntry3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        butEntry3.setContentAreaFilled(false);
        butEntry3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butEntry3.setFocusPainted(false);
        butEntry3.setOpaque(true);
        butEntry3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butEntry3ActionPerformed(evt);
            }
        });

        butEntry4.setBackground(new java.awt.Color(224, 79, 95));
        butEntry4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        butEntry4.setForeground(new java.awt.Color(255, 255, 255));
        butEntry4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gistrac/ui/resources/1427519828_map.png"))); // NOI18N
        butEntry4.setText("Data Set #4");
        butEntry4.setToolTipText("Data Set #4 is part of 4 entry points for Location, BTS, GPRS and CDR Data ");
        butEntry4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        butEntry4.setContentAreaFilled(false);
        butEntry4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butEntry4.setFocusPainted(false);
        butEntry4.setOpaque(true);
        butEntry4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butEntry4ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(224, 79, 95));
        jButton4.setToolTipText("View All Archived Data Set");
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setFocusPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(224, 79, 95));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gistrac/ui/resources/clear.png"))); // NOI18N
        jButton2.setToolTipText("This Tool clears all markers on the map and reset all data sets");
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setFocusPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(224, 79, 95));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gistrac/ui/resources/refresh_map.png"))); // NOI18N
        jButton3.setToolTipText("This tool resets the map");
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setFocusPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(224, 79, 95));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gistrac/ui/resources/downloadAsImage.png"))); // NOI18N
        jButton1.setToolTipText("This Tool allows users to print screenshots of maps creating map images.");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Map View:");

        cmbState.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Abia", "Adamawa", "Akwa Ibom", "Anambra", "Bauchi", "Bayelsa", "Benue", "Borno", "Cross River", "Delta", "Ebonyi", "Edo", "Ekiti", "Enugu", "Federal Capital Territory", "Gombe", "Imo", "Jigawa", "Kaduna", "Kano", "Katsina", "Kebbi", "Kogi", "Kwara", "Lagos", "Nasarawa", "Niger", "Ogun", "Ondo", "Osun", "Oyo", "Plateau", "Rivers", "Sokoto", "Taraba", "Yobe", "Zamfara" }));
        cmbState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStateActionPerformed(evt);
            }
        });

        butEntry5.setBackground(new java.awt.Color(224, 79, 95));
        butEntry5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        butEntry5.setForeground(new java.awt.Color(255, 255, 255));
        butEntry5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gistrac/ui/resources/1427519828_map.png"))); // NOI18N
        butEntry5.setText("Data Set #5");
        butEntry5.setToolTipText("Data Set #4 is part of 4 entry points for Location, BTS, GPRS and CDR Data ");
        butEntry5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        butEntry5.setContentAreaFilled(false);
        butEntry5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butEntry5.setFocusPainted(false);
        butEntry5.setOpaque(true);
        butEntry5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butEntry5ActionPerformed(evt);
            }
        });

        butEntry6.setBackground(new java.awt.Color(224, 79, 95));
        butEntry6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        butEntry6.setForeground(new java.awt.Color(255, 255, 255));
        butEntry6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gistrac/ui/resources/1427519828_map.png"))); // NOI18N
        butEntry6.setText("Data Set #6");
        butEntry6.setToolTipText("Data Set #4 is part of 4 entry points for Location, BTS, GPRS and CDR Data ");
        butEntry6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        butEntry6.setContentAreaFilled(false);
        butEntry6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butEntry6.setFocusPainted(false);
        butEntry6.setOpaque(true);
        butEntry6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butEntry6ActionPerformed(evt);
            }
        });

        butEntry7.setBackground(new java.awt.Color(224, 79, 95));
        butEntry7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        butEntry7.setForeground(new java.awt.Color(255, 255, 255));
        butEntry7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gistrac/ui/resources/1427519828_map.png"))); // NOI18N
        butEntry7.setText("Data Set #7");
        butEntry7.setToolTipText("Data Set #4 is part of 4 entry points for Location, BTS, GPRS and CDR Data ");
        butEntry7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        butEntry7.setContentAreaFilled(false);
        butEntry7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butEntry7.setFocusPainted(false);
        butEntry7.setOpaque(true);
        butEntry7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butEntry7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbState, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(butEntry1, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butEntry2, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butEntry3, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butEntry4, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butEntry5, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butEntry6, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butEntry7, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                .addGap(193, 193, 193)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(butEntry1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbState, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(butEntry2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butEntry3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butEntry4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butEntry5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butEntry6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butEntry7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.setOpaque(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Data Set:");

        lblDataSetName.setForeground(new java.awt.Color(255, 255, 255));
        lblDataSetName.setText("Unknown");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 255, 0));
        jLabel16.setText("Successes:");

        lblSuccess.setForeground(new java.awt.Color(0, 255, 0));
        lblSuccess.setText("0");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 204, 255));
        jLabel18.setText("Absent Subscriber:");

        lblAbsent.setForeground(new java.awt.Color(102, 204, 255));
        lblAbsent.setText("0");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 51));
        jLabel20.setText("Internal Failure In Mobile Network: ");

        lblInternalFailure.setForeground(new java.awt.Color(255, 255, 51));
        lblInternalFailure.setText("0");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 153, 153));
        jLabel22.setText("Temporary Failure: ");

        lblTempFailure.setForeground(new java.awt.Color(255, 153, 153));
        lblTempFailure.setText("0");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 51, 51));
        jLabel24.setText("System Failure: ");

        lblSystemFailure.setForeground(new java.awt.Color(255, 51, 51));
        lblSystemFailure.setText("0");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 0, 255));
        jLabel25.setText("MAX CLIENT EXCEEDED:");

        lblSystemFailure1.setForeground(new java.awt.Color(255, 0, 204));
        lblSystemFailure1.setText("0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDataSetName, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSuccess, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAbsent, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInternalFailure, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTempFailure, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSystemFailure, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25)
                .addGap(18, 18, 18)
                .addComponent(lblSystemFailure1, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                .addGap(119, 119, 119))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblDataSetName))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(lblSuccess)
                        .addComponent(jLabel18)
                        .addComponent(lblAbsent)
                        .addComponent(jLabel20)
                        .addComponent(lblInternalFailure)
                        .addComponent(jLabel22)
                        .addComponent(lblTempFailure)
                        .addComponent(jLabel24)
                        .addComponent(lblSystemFailure)
                        .addComponent(lblSystemFailure1)
                        .addComponent(jLabel25)))
                .addGap(9, 9, 9))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(mapProgressLoad, javax.swing.GroupLayout.DEFAULT_SIZE, 1406, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mapProgressLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public double longtitude(String lng) {
        double result = 0.0000000;
        String[] lngStrings = lng.split(" ");
        String NSEW = lngStrings[3];
        double min = Double.parseDouble(lngStrings[1]);
        double sec = Double.parseDouble(lngStrings[2]);
        int degrees = Integer.parseInt(lngStrings[0]);

        double minSec = (min * 60) + sec;
        double time = minSec / 3600;

        double subResult = degrees + time;
        if (NSEW.equalsIgnoreCase("E")) {
            result = subResult;
        } else {
            result = subResult * -1;
        }
        return result;
    }

    public double latitude(String lng) {
        double result = 0.0000000;
        String[] lngStrings = lng.split(" ");
        String NSEW = lngStrings[3];
        double min = Double.parseDouble(lngStrings[1]);
        double sec = Double.parseDouble(lngStrings[2]);
        int degrees = Integer.parseInt(lngStrings[0]);

        double minSec = (min * 60) + sec;
        double time = minSec / 3600;

        double subResult = degrees + time;

        if (NSEW.equalsIgnoreCase("N")) {
            result = subResult;
        } else {
            result = subResult * -1;
        }
        return result;
    }
    String index;
    String data;
    private void butEntry1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butEntry1ActionPerformed
        Archiver a = new Archiver();
        JFileChooser fc = new JFileChooser(new File("DataSource"));
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int returnVal = fc.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            LoadingDialog dialog = new LoadingDialog(new javax.swing.JFrame(), true);
            dialog.setVisible(true);
            if (dialog.save()) {

                butEntry1.setText(dialog.getDataName());
                butEntry1.setBackground(dialog.getColor());
                butEntry1.setForeground(dialog.getDataSetColor());
                if (lblDataSetName.getText().equalsIgnoreCase("Unknown")) {
                    lblDataSetName.setText(dialog.getDataName());
                } else {
                    lblDataSetName.setText(lblDataSetName.getText() + " : " + dialog.getDataName());
                }
                if (!dialog.getAdditionalData()) {
                    if (dialog.getDataType().equalsIgnoreCase("Location Data")) {
                        plotMapLocationData(dialog.getColor(), fc.getSelectedFile());
                        ds1.put("success", success2 + "");
                        ds1.put("absent", absent2 + "");
                        ds1.put("sysFail", sysFail2 + "");
                        ds1.put("tempFail", tempFail2 + "");
                        ds1.put("internalFail", internalFail2 + "");
                        dataSetNames.put("ds1", dialog.getDataName());
                        System.out.println(success2 + "???????????????????" + ds1.get("success"));
                    } else if (dialog.getDataType().equalsIgnoreCase("BTS")) {
                        plotMapBTS(dialog.getColor(), fc.getSelectedFile());
                    } else if (dialog.getDataType().equalsIgnoreCase("GPRS Data")) {
                        plotMapGPRS(dialog.getColor(), fc.getSelectedFile());
                    }
                    //String showInputDialog = JOptionPane.showInputDialog("Please Provide a name for this entry");
                } else {
                    // plotMapLocationDataDiff(dialog.getColor(), fc.getSelectedFile(), dialog.getAdditionalColor(), dialog.getAdditionalDataSet());
                }

            }
        }
    }//GEN-LAST:event_butEntry1ActionPerformed

    HashMap<String, String> ds1 = new HashMap<>();
    HashMap<String, String> ds2 = new HashMap<>();
    HashMap<String, String> ds3 = new HashMap<>();
    HashMap<String, String> ds4 = new HashMap<>();
    HashMap<String, String> ds5 = new HashMap<>();
    HashMap<String, String> ds6 = new HashMap<>();
    HashMap<String, String> ds7 = new HashMap<>();
    HashMap<String, String> dataSetNames = new HashMap<>();
    int success = 0;
    int absent = 0;
    int sysFail = 0;
    int tempFail = 0;
    int internalFail = 0;

    int success2 = 0;
    int absent2 = 0;
    int sysFail2 = 0;
    int tempFail2 = 0;
    int internalFail2 = 0;

    public void plotMapLocationData(Color color, File dataFile) {
        Thread t;
        t = new Thread(() -> {
            FileReader r = null;
            try {
                // TODO add your handling code here:
                int fileCounter = 1;
                for (final File fileEntry : dataFile.listFiles()) {

                    if (fileEntry.isDirectory()) {
                        //plotMapLocationData(color, fileEntry);
                    } else {
                        mapProgressLoad.setString("Map Processing for Batch #" + fileCounter);
                        File f = fileEntry;
                        r = new FileReader(f);
                        BufferedReader bf = new BufferedReader(r);
                        StringBuilder s = new StringBuilder();
                        String tempBuffer;
                        try {
                            while ((tempBuffer = bf.readLine()) != null) {
                                //System.out.println(tempBuffer);
                                s.append(tempBuffer).append("\n");
                            }
                            //17 14
                            String[] data1 = s.toString().split("\n");
                            int dataSizes = data1.length / 100;
                            int count = 1;
                            for (int i = 1; i < data1.length; i++) {
                                System.out.println(data1[i]);
                                String[] dataSplit = data1[i].split(",");
                                System.out.println(dataSplit[12] + " ----- " + dataSplit[16]);
                                if (dataSplit[12].equalsIgnoreCase("SUCCESS")) {
                                    String[] splited = dataSplit[16].split(";");
                                    String[] lat1 = splited[0].split(": ");
                                    String lat = lat1[1];
                                    String[] lng1 = splited[1].split(": ");
                                    String lng = lng1[1];

                                    System.out.println(longtitude(lng));
                                    System.out.println(latitude(lat));

                                    map.addMapMarker(new MapMarkerDot(color, latitude(lat), longtitude(lng)));

                                    mapProgressLoad.setValue(count);
                                    count++;
                                    if (count >= 100) {
                                        count = 0;
                                    }
                                    //dataSizes = dataSizes+dataSizes;

                                    success++;
                                    lblSuccess.setText("" + success);
                                } else if (dataSplit[12].equalsIgnoreCase("SYSTEM FAILURE")) {
                                    sysFail++;
                                    lblSystemFailure.setText("" + sysFail);
                                } else if (dataSplit[12].equalsIgnoreCase("TEMPORARY FAILURE")) {
                                    tempFail++;
                                    lblTempFailure.setText("" + tempFail);
                                } else if (dataSplit[12].equalsIgnoreCase("INTERNAL FAILURE IN MOBILE NETWORK")) {
                                    internalFail++;
                                    lblInternalFailure.setText("" + internalFail);
                                } else if (dataSplit[12].equalsIgnoreCase("ABSENT SUBSCRIBER")) {
                                    absent++;
                                    lblAbsent.setText(absent + "");
                                }
                            }
                            dataSizes = 0;
                            count = 1;
                            mapProgressLoad.setValue(0);
                        } catch (IOException ex) {
                            Logger.getLogger(MenuPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        System.out.println(fileEntry.getName());
                    }
                    fileCounter++;
                    success2 = success;
                    sysFail2 = sysFail;
                    internalFail2 = internalFail;
                    tempFail2 = tempFail;
                    absent2 = absent;
                    System.out.println(success2 + "???????????????????");
                }
                JOptionPane.showMessageDialog(this, "Map points Successfully Plotted", "Ontrac Location Monitoring System", WIDTH);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MenuPanel.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    r.close();
                } catch (IOException ex) {
                    Logger.getLogger(MenuPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        t.start();
    }

    public void plotMapGPRS(Color color, File gprs) {
        Thread t;
        t = new Thread(() -> {
            File f = gprs;
            FileReader r = null;
            try {
                r = new FileReader(f);
                BufferedReader bf = new BufferedReader(r);
                String tempBuffer;
                try {
                    int count = 0;
                    while ((tempBuffer = bf.readLine()) != null) {
                        //System.out.println(tempBuffer);                       
                        StringTokenizer st = new StringTokenizer(tempBuffer, "|");
                        int i = 0;
                        String[] datas = new String[st.countTokens()];
                        while (st.hasMoreTokens()) {

                            datas[i] = st.nextToken();
                            i++;
                        }
                        if (count != 0 && datas.length > 8) {
                            System.out.println(datas[7] + " ------ " + datas[8]);
                           
                            map.addMapMarker(new MapMarkerDot(color, Double.parseDouble(datas[7]), Double.parseDouble(datas[8])));
                            mapProgressLoad.setValue(count);

                        }

                        count++;
                        if (count >= 100) {
                            count = 0;
                        }
                    }
                    mapProgressLoad.setValue(100);
                   
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MenuPanel.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        t.start();
    }

    public void plotMapBTS(Color color, File dataFile) {
        FileReader r = null;

        try {

            // TODO add your handling code here:
            int fileCounter = 1;
            for (final File fileEntry : dataFile.listFiles()) {

                if (fileEntry.isDirectory()) {
                    //plotMapLocationData(color, fileEntry);
                } else {
                    File f = fileEntry;
                    r = new FileReader(f);
                    BufferedReader bf = new BufferedReader(r);
                    StringBuilder s = new StringBuilder();
                    String tempBuffer = "";
                    try {

                        while ((tempBuffer = bf.readLine()) != null) {
                            //System.out.println(tempBuffer);
                            s.append(tempBuffer + "\n");
                        }
                        //17 14
                        String[] data = s.toString().split("\n");
                        int count = 1;
                        for (int i = 1; i < data.length; i++) {
                            System.out.println(data[i]);
                            String[] dataSplit = data[i].split(",");
                            //System.out.println(dataSplit[13]+" ----- "+dataSplit[16]);
                            if (true) {

                                map.addMapMarker(new MapMarkerDot(color, Double.parseDouble(dataSplit[2]), Double.parseDouble(dataSplit[3])));
                                mapProgressLoad.setValue(count);
                                count++;
                                if (count >= 100) {
                                    count = 0;
                                }
                            }
                        }

                    } catch (IOException ex) {
                        Logger.getLogger(MenuPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println(fileEntry.getName());
                }
                fileCounter++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MenuPanel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                r.close();
            } catch (IOException ex) {
                Logger.getLogger(MenuPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    int counter = 0;

    public void plotMapLocationDataDiff(Color color, File dataFile, Color additionalColor, File additionalDataFile) {
        Thread t;
        t = new Thread(() -> {
            FileReader r = null;
            try {

                // TODO add your handling code here:
                int fileCounter = 1;
                for (int j = 0; j < dataFile.listFiles().length; j++) {
                    File fileEntry = dataFile.listFiles()[j];
                    File fileEntry2 = additionalDataFile.listFiles()[j];
                    if (fileEntry.isDirectory()) {
                        //plotMapLocationData(color, fileEntry);
                    } else {
                        File f = fileEntry;
                        r = new FileReader(f);
                        BufferedReader bf = new BufferedReader(r);
                        StringBuilder s = new StringBuilder();
                        StringBuilder s2 = new StringBuilder();
                        String tempBuffer;
                        String tempBuffer2;
                        try {

                            while ((tempBuffer = bf.readLine()) != null) {
                                //System.out.println(tempBuffer);
                                s.append(tempBuffer + "\n");
                            }
                            mapProgressLoad.setString("Map Processing for Batch #" + fileCounter);
                            File f2 = fileEntry2;
                            FileReader rr = new FileReader(f2);
                            BufferedReader bf2 = new BufferedReader(rr);
                            while ((tempBuffer2 = bf2.readLine()) != null) {
                                //System.out.println(tempBuffer);
                                s2.append(tempBuffer2 + "\n");
                            }
                            //17 14
                            String[] data = s.toString().split("\n");
                            String[] data2 = s2.toString().split("\n");
                            int count = 1;
                            for (int i = 1; i < data.length; i++) {
                                System.out.println(data[i]);
                                String[] dataSplit = data[i].split(",");
                                String[] dataSplit2 = data2[i].split(",");
                                System.out.println(dataSplit[13] + " ----- " + dataSplit[16]);
                                System.out.println(dataSplit2[13] + " ----- " + dataSplit2[16]);
                                if (dataSplit[13].equalsIgnoreCase("SUCCESS") && dataSplit2[13].equalsIgnoreCase("SUCCESS")) {
                                    String[] splited = dataSplit[16].split(";");
                                    String[] lat1 = splited[0].split(": ");
                                    String lat = lat1[1];
                                    String[] lng1 = splited[1].split(": ");
                                    String lng = lng1[1];

                                    String[] splited2 = dataSplit[16].split(";");
                                    String[] lat11 = splited2[0].split(": ");
                                    String lat0 = lat11[1];
                                    String[] lng11 = splited2[1].split(": ");
                                    String lng0 = lng11[1];

                                    System.out.println(longtitude(lng) + " ---- " + longtitude(lng0));
                                    System.out.println(latitude(lat) + " ---- " + longtitude(lat0));
                                    if (longtitude(lng) != longtitude(lng0) || latitude(lat) != latitude(lat0)) {
                                        map.addMapMarker(new MapMarkerDot(color, latitude(lat), longtitude(lng)));
                                        map.addMapMarker(new MapMarkerDot(additionalColor, latitude(lat0), longtitude(lng0)));
                                        counter++;
                                        mapProgressLoad.setValue(count);
                                        count++;
                                        if (count >= 100) {
                                            count = 0;
                                        }
                                    } else {

                                    }

                                    //map.setDisplayToFitMapMarkers();      
                                    //map.setMapMarkerVisible(true);
                                }
                            }

                            if (counter == 0) {
                                JOptionPane.showMessageDialog(null, "No Diiference in Data", "Ontrac Location Monitoring System", JOptionPane.INFORMATION_MESSAGE);
                            }

                        } catch (IOException ex) {
                            Logger.getLogger(MenuPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        System.out.println(fileEntry.getName());
                    }
                    fileCounter++;
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MenuPanel.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    r.close();
                } catch (IOException ex) {
                    Logger.getLogger(MenuPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        t.start();
    }
    private void butEntry2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butEntry2ActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser(new File("DataSource"));
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = fc.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            LoadingDialog dialog = new LoadingDialog(new javax.swing.JFrame(), true);
            dialog.setVisible(true);
            if (dialog.save()) {
                butEntry2.setText(dialog.getDataName());
                butEntry2.setBackground(dialog.getColor());
                butEntry2.setForeground(dialog.getDataSetColor());
                if (lblDataSetName.getText().equalsIgnoreCase("Unknown")) {
                    lblDataSetName.setText(dialog.getDataName());
                } else {
                    lblDataSetName.setText(lblDataSetName.getText() + " : " + dialog.getDataName());
                }
                if (!dialog.getAdditionalData()) {
                    if (dialog.getDataType().equalsIgnoreCase("Location Data")) {
                        plotMapLocationData(dialog.getColor(), fc.getSelectedFile());
                    } else if (dialog.getDataType().equalsIgnoreCase("BTS")) {
                        plotMapBTS(dialog.getColor(), fc.getSelectedFile());
                    } else if (dialog.getDataType().equalsIgnoreCase("GPRS Data")) {
                        plotMapGPRS(dialog.getColor(), fc.getSelectedFile());
                    }
                    //String showInputDialog = JOptionPane.showInputDialog("Please Provide a name for this entry");
                } else {
                    //plotMapLocationDataDiff(dialog.getColor(), fc.getSelectedFile(), dialog.getAdditionalColor(), dialog.getAdditionalDataSet());
                }
            }
            //String showInputDialog = JOptionPane.showInputDialog("Please Provide a name for this entry");
            ds2.put("success", success2 + "");
            ds2.put("absent", absent2 + "");
            ds2.put("sysFail", sysFail2 + "");
            ds2.put("tempFail", tempFail2 + "");
            ds2.put("internalFail", internalFail2 + "");
            dataSetNames.put("ds2", dialog.getDataName());
        }
//           FileReader r = null;
//        JFileChooser fc = new JFileChooser();
//        int returnVal = fc.showOpenDialog(null);
//        if(returnVal == JFileChooser.APPROVE_OPTION){
//            String showInputDialog = JOptionPane.showInputDialog("Please Provide a name for this entry");
//        try {
//            butEntry2.setText(showInputDialog);
//            
//            // TODO add your handling code here:
//            File f = fc.getSelectedFile();
//            r = new FileReader(f);
//            BufferedReader bf = new BufferedReader(r);
//            StringBuilder s = new StringBuilder();
//            String tempBuffer = "";
//            try {
//                butEntry2.setBackground(Color.BLUE);
//                while((tempBuffer = bf.readLine())!=null){
//                    //System.out.println(tempBuffer);
//                    s.append(tempBuffer+"\n");
//                }
//                //17 14
//                String[] data = s.toString().split("\n");
//                for(int i=1;i<data.length;i++){
//                System.out.println(data[i]);
//                String[] dataSplit = data[i].split(",");
//                //System.out.println(dataSplit[13]+" ----- "+dataSplit[16]);
//                if(true){
////                    String[] splited = dataSplit[16].split(";");
////                    String[] lat1 = splited[0].split(": ");
////                    String lat = lat1[1];
////                    String[] lng1 = splited[1].split(": ");
////                    String lng = lng1[1];
////                    
////                    System.out.println(longtitude(lng));
////                    System.out.println(latitude(lat));
//                    
//                    map.addMapMarker(new MapMarkerDot(Color.BLUE,Double.parseDouble(dataSplit[2]),Double.parseDouble(dataSplit[3])));
//                    
//                    //map.setDisplayToFitMapMarkers();      
//                    //map.setMapMarkerVisible(true);
//                }
//                }
//                
//            } catch (IOException ex) {
//                Logger.getLogger(MenuPanel.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(MenuPanel.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                r.close();
//            } catch (IOException ex) {
//                Logger.getLogger(MenuPanel.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        }
    }//GEN-LAST:event_butEntry2ActionPerformed

    private void butEntry3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butEntry3ActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser(new File("DataSource"));
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = fc.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            LoadingDialog dialog = new LoadingDialog(new javax.swing.JFrame(), true);
            dialog.setVisible(true);
            if (dialog.save()) {
                butEntry3.setText(dialog.getDataName());
                butEntry3.setBackground(dialog.getColor());
                butEntry3.setForeground(dialog.getDataSetColor());
                if (lblDataSetName.getText().equalsIgnoreCase("Unknown")) {
                    lblDataSetName.setText(dialog.getDataName());
                } else {
                    lblDataSetName.setText(lblDataSetName.getText() + " : " + dialog.getDataName());
                }

                if (!dialog.getAdditionalData()) {
                    if (dialog.getDataType().equalsIgnoreCase("Location Data")) {
                        plotMapLocationData(dialog.getColor(), fc.getSelectedFile());
                    } else if (dialog.getDataType().equalsIgnoreCase("BTS")) {
                        plotMapBTS(dialog.getColor(), fc.getSelectedFile());
                    } else if (dialog.getDataType().equalsIgnoreCase("GPRS Data")) {
                        plotMapGPRS(dialog.getColor(), fc.getSelectedFile());
                    }
                    //String showInputDialog = JOptionPane.showInputDialog("Please Provide a name for this entry");
                } else {
                    //plotMapLocationDataDiff(dialog.getColor(), fc.getSelectedFile(), dialog.getAdditionalColor(), dialog.getAdditionalDataSet());
                }
            }
            //String showInputDialog = JOptionPane.showInputDialog("Please Provide a name for this entry");
            ds4.put("success", success2 + "");
            ds4.put("absent", absent2 + "");
            ds4.put("sysFail", sysFail2 + "");
            ds4.put("tempFail", tempFail2 + "");
            ds4.put("internalFail", internalFail2 + "");
            dataSetNames.put("ds4", dialog.getDataName());
        }
    }//GEN-LAST:event_butEntry3ActionPerformed

    private void butEntry4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butEntry4ActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser(new File("DataSource"));
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = fc.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            LoadingDialog dialog = new LoadingDialog(new javax.swing.JFrame(), true);
            dialog.setVisible(true);
            if (dialog.save()) {
                butEntry4.setText(dialog.getDataName());
                butEntry4.setBackground(dialog.getColor());
                butEntry4.setForeground(dialog.getDataSetColor());
                if (lblDataSetName.getText().equalsIgnoreCase("Unknown")) {
                    lblDataSetName.setText(dialog.getDataName());
                } else {
                    lblDataSetName.setText(lblDataSetName.getText() + " : " + dialog.getDataName());
                }
                if (!dialog.getAdditionalData()) {
                    if (dialog.getDataType().equalsIgnoreCase("Location Data")) {
                        plotMapLocationData(dialog.getColor(), fc.getSelectedFile());
                    } else if (dialog.getDataType().equalsIgnoreCase("BTS")) {
                        plotMapBTS(dialog.getColor(), fc.getSelectedFile());
                    } else if (dialog.getDataType().equalsIgnoreCase("GPRS Data")) {
                        plotMapGPRS(dialog.getColor(), fc.getSelectedFile());
                    }
                    //String showInputDialog = JOptionPane.showInputDialog("Please Provide a name for this entry");
                } else {
                    //plotMapLocationDataDiff(dialog.getColor(), fc.getSelectedFile(), dialog.getAdditionalColor(), dialog.getAdditionalDataSet());
                }
            }
            //String showInputDialog = JOptionPane.showInputDialog("Please Provide a name for this entry");

            ds4.put("success", success2 + "");
            ds4.put("absent", absent2 + "");
            ds4.put("sysFail", sysFail2 + "");
            ds4.put("tempFail", tempFail2 + "");
            ds4.put("internalFail", internalFail2 + "");
        }
    }//GEN-LAST:event_butEntry4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        File f = new File("Map\\Images");
        if (!f.exists()) {
            f.mkdirs();
        }
        String showInputDialog = JOptionPane.showInputDialog(this, "Please Enter the name of the Map Image", "Ontrac Location Monitoring System", JOptionPane.INFORMATION_MESSAGE);
        if (!showInputDialog.isEmpty()) {
            boolean state = save(showInputDialog + "_" + new Archiver().fileName() + ".png");
            if (state) {
                JOptionPane.showMessageDialog(this, "Map Image: " + showInputDialog + " saved successfully", "Ontrac Location Monitoring System", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "An Error Occured while saving Map Image", "Ontrac Location Monitoring System", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No Name Entered for Map Image", "Ontrac Location Monitoring System", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        butEntry1.setBackground(new java.awt.Color(224, 79, 95));
        butEntry2.setBackground(new java.awt.Color(224, 79, 95));
        butEntry3.setBackground(new java.awt.Color(224, 79, 95));
        butEntry4.setBackground(new java.awt.Color(224, 79, 95));
        butEntry1.setText(" Data Set #1");
        butEntry2.setText(" Data Set #2");
        butEntry3.setText(" Data Set #3");
        butEntry4.setText(" Data Set #4");
        List<MapMarker> marker = map.getMapMarkerList();//removeMapMarker(null);
        marker.stream().forEach((marker1) -> {
            map.removeMapMarker(marker1);
        });

        JOptionPane.showMessageDialog(this, "Marker all cleared from Map", "Ontrac Location Monitoring System", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        map = new JMapViewer();
        //map.addMapMarker(new MapMarkerDot(9.0579,7.4806));
        //map.addMapMarker(new MapMarkerDot(9.0579,8.4806));
        map.setMapRectanglesVisible(true);
        map.setTileSource(new OsmTileSource.CycleMap());
        //map.setZoom(100);
        map.setDisplayPositionByLatLon(9.0579, 7.4806, 6);
        //map.setMapMarkerVisible(false);
        mapPanel.removeAll();
        mapPanel.revalidate();
        mapPanel.add(map);
        mapPanel.revalidate();
        mapPanel.repaint();
        mapPanel.revalidate();
        butEntry1.setText(" Data Set #1");
        butEntry2.setText(" Data Set #2");
        butEntry3.setText(" Data Set #3");
        butEntry4.setText(" Data Set #4");
        butEntry1.setBackground(new java.awt.Color(224, 79, 95));
        butEntry2.setBackground(new java.awt.Color(224, 79, 95));
        butEntry3.setBackground(new java.awt.Color(224, 79, 95));
        butEntry4.setBackground(new java.awt.Color(224, 79, 95));
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cmbStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStateActionPerformed
        // TODO add your handling code here:
        String[] states = {"Abia", "Adamawa", "Akwa Ibom",
            "Anambra", "Bauchi", "Bayelsa", "Benue", "Borno", "Cross River", "Delta", "Ebonyi", "Edo", "Ekiti", "Enugu", "Federal Capital Territory",
            "Gombe", "Imo", "Jigawa", "Kaduna", "Kano", "Katsina", "Kebbi", "Kogi", "Kwara", "Lagos", "Nasarawa", "Niger", "Ogun", "Ondo", "Osun", "Oyo", "Plateau", "Rivers", "Sokoto",
            "Taraba", "Yobe", "Zamfara"};
        for (String state : states) {
            if (cmbState.getSelectedItem().toString().equalsIgnoreCase(state)) {
                String[] split = stateCoordinates.get(state).split(", ");
                double lat = Double.parseDouble(split[0]);
                double lng = Double.parseDouble(split[1]);
                map.setDisplayPositionByLatLon(lat, lng, 9);
            }
        }
    }//GEN-LAST:event_cmbStateActionPerformed

    private void butEntry5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butEntry5ActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser(new File("DataSource"));
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = fc.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            LoadingDialog dialog = new LoadingDialog(new javax.swing.JFrame(), true);
            dialog.setVisible(true);
            if (dialog.save()) {
                butEntry5.setText(dialog.getDataName());
                butEntry5.setBackground(dialog.getColor());
                butEntry5.setForeground(dialog.getDataSetColor());
                if (lblDataSetName.getText().equalsIgnoreCase("Unknown")) {
                    lblDataSetName.setText(dialog.getDataName());
                } else {
                    lblDataSetName.setText(lblDataSetName.getText() + " : " + dialog.getDataName());
                }
                if (!dialog.getAdditionalData()) {
                    if (dialog.getDataType().equalsIgnoreCase("Location Data")) {
                        plotMapLocationData(dialog.getColor(), fc.getSelectedFile());
                    } else if (dialog.getDataType().equalsIgnoreCase("BTS")) {
                        plotMapBTS(dialog.getColor(), fc.getSelectedFile());
                    } else if (dialog.getDataType().equalsIgnoreCase("GPRS Data")) {
                        plotMapGPRS(dialog.getColor(), fc.getSelectedFile());
                    }
                    //String showInputDialog = JOptionPane.showInputDialog("Please Provide a name for this entry");
                } else {
//                    plotMapLocationDataDiff(dialog.getColor(), fc.getSelectedFile(), dialog.getAdditionalColor(), dialog.getAdditionalDataSet());
                }
            }
            //String showInputDialog = JOptionPane.showInputDialog("Please Provide a name for this entry");
            ds5.put("success", success2 + "");
            ds5.put("absent", absent2 + "");
            ds5.put("sysFail", sysFail2 + "");
            ds5.put("tempFail", tempFail2 + "");
            ds5.put("internalFail", internalFail2 + "");
            dataSetNames.put("ds5", dialog.getDataName());
        }
    }//GEN-LAST:event_butEntry5ActionPerformed

    private void butEntry6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butEntry6ActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser(new File("DataSource"));
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = fc.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            LoadingDialog dialog = new LoadingDialog(new javax.swing.JFrame(), true);
            dialog.setVisible(true);
            if (dialog.save()) {
                butEntry6.setText(dialog.getDataName());
                butEntry6.setBackground(dialog.getColor());
                butEntry6.setForeground(dialog.getDataSetColor());
                if (lblDataSetName.getText().equalsIgnoreCase("Unknown")) {
                    lblDataSetName.setText(dialog.getDataName());
                } else {
                    lblDataSetName.setText(lblDataSetName.getText() + " : " + dialog.getDataName());
                }
                if (!dialog.getAdditionalData()) {
                    if (dialog.getDataType().equalsIgnoreCase("Location Data")) {
                        plotMapLocationData(dialog.getColor(), fc.getSelectedFile());
                    } else if (dialog.getDataType().equalsIgnoreCase("BTS")) {
                        plotMapBTS(dialog.getColor(), fc.getSelectedFile());
                    } else if (dialog.getDataType().equalsIgnoreCase("GPRS Data")) {
                        plotMapGPRS(dialog.getColor(), fc.getSelectedFile());
                    }
                    //String showInputDialog = JOptionPane.showInputDialog("Please Provide a name for this entry");
                } else {
                    //plotMapLocationDataDiff(dialog.getColor(), fc.getSelectedFile(), dialog.getAdditionalColor(), dialog.getAdditionalDataSet());
                }
            }
            //String showInputDialog = JOptionPane.showInputDialog("Please Provide a name for this entry");
            ds6.put("success", success2 + "");
            ds6.put("absent", absent2 + "");
            ds6.put("sysFail", sysFail2 + "");
            ds6.put("tempFail", tempFail2 + "");
            ds6.put("internalFail", internalFail2 + "");
            dataSetNames.put("ds6", dialog.getDataName());
        }
    }//GEN-LAST:event_butEntry6ActionPerformed

    private void butEntry7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butEntry7ActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser(new File("DataSource"));
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = fc.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            LoadingDialog dialog = new LoadingDialog(new javax.swing.JFrame(), true);
            dialog.setVisible(true);
            if (dialog.save()) {
                butEntry7.setText(dialog.getDataName());
                butEntry7.setBackground(dialog.getColor());
                butEntry7.setForeground(dialog.getDataSetColor());
                if (lblDataSetName.getText().equalsIgnoreCase("Unknown")) {
                    lblDataSetName.setText(dialog.getDataName());
                } else {
                    lblDataSetName.setText(lblDataSetName.getText() + " : " + dialog.getDataName());
                }
                if (!dialog.getAdditionalData()) {
                    if (dialog.getDataType().equalsIgnoreCase("Location Data")) {
                        plotMapLocationData(dialog.getColor(), fc.getSelectedFile());
                    } else if (dialog.getDataType().equalsIgnoreCase("BTS")) {
                        plotMapBTS(dialog.getColor(), fc.getSelectedFile());
                    } else if (dialog.getDataType().equalsIgnoreCase("GPRS Data")) {
                        plotMapGPRS(dialog.getColor(), fc.getSelectedFile());
                    }
                    //String showInputDialog = JOptionPane.showInputDialog("Please Provide a name for this entry");
                } else {
                    //plotMapLocationDataDiff(dialog.getColor(), fc.getSelectedFile(), dialog.getAdditionalColor(), dialog.getAdditionalDataSet());
                }
            }
            ds7.put("success", success2 + "");
            ds7.put("absent", absent2 + "");
            ds7.put("sysFail", sysFail2 + "");
            ds7.put("tempFail", tempFail2 + "");
            ds7.put("internalFail", internalFail2 + "");
            dataSetNames.put("ds7", dialog.getDataName());
            //String showInputDialog = JOptionPane.showInputDialog("Please Provide a name for this entry");

        }
    }//GEN-LAST:event_butEntry7ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        //        ArchiveDialog dialog = new ArchiveDialog(new javax.swing.JFrame(), true);
        //        dialog.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    public boolean save(String imageFile) {
        boolean state = true;
        Rectangle r = mapPanel.getBounds();

        try {
            BufferedImage i = new BufferedImage(r.width, r.height,
                    BufferedImage.TYPE_INT_RGB);
            Graphics g = i.getGraphics();
            paint(g);
            ImageIO.write(i, "png", new File("Map\\Images\\" + imageFile));
        } catch (IOException e) {
            e.printStackTrace();
            state = false;
        }

        return state;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butEntry1;
    private javax.swing.JButton butEntry2;
    private javax.swing.JButton butEntry3;
    private javax.swing.JButton butEntry4;
    private javax.swing.JButton butEntry5;
    private javax.swing.JButton butEntry6;
    private javax.swing.JButton butEntry7;
    private javax.swing.JComboBox cmbState;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblAbsent;
    private javax.swing.JLabel lblDataSetName;
    private javax.swing.JLabel lblInternalFailure;
    private javax.swing.JLabel lblSuccess;
    private javax.swing.JLabel lblSystemFailure;
    private javax.swing.JLabel lblSystemFailure1;
    private javax.swing.JLabel lblTempFailure;
    private javax.swing.JPanel mapPanel;
    private javax.swing.JProgressBar mapProgressLoad;
    // End of variables declaration//GEN-END:variables
}
