package edu.cs3500.spreadsheets.provider.view;

import java.awt.TextField;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.util.HashMap;
//import java.util.Map;

import javax.swing.*;

//import edu.cs3500.spreadsheets.controller.Features;
import edu.cs3500.spreadsheets.controller.FeaturesMain;
import edu.cs3500.spreadsheets.model.Coord;
import edu.cs3500.spreadsheets.model.ViewWorksheet;
//import edu.cs3500.spreadsheets.model.datastructures.values.IVal;

public class EditableView extends JPanel implements WorksheetPane{
  private TextField input;
  private JButton submit;
  private JButton discard;
  private JButton save;
  private JButton load;
  private WorksheetPanel worksheetPanel;
//  private Features f;
//  private Map<Character, Runnable> keyTypes = new HashMap<>();
//  private Map<Integer, Runnable> keyReleases = new HashMap<>();


/* public EditableView(ViewWorksheet model){
    super();
    this.model = model;
    this.values = model.getAllValues();
    this.spreadsheetPanel = new ScrollableWorksheet(this.model);

    this.mainPanel = new JPanel();
    this.mainPanel.setLayout(new BorderLayout());

    this.gridPanel = new JPanel();

    this.editPanel = new JPanel(new FlowLayout());
    this.editPanel.setMinimumSize(new Dimension(500, 200));
    this.input = new TextField(75);
    this.submit = new JButton("submit");
    this.discard = new JButton("discard");
    this.editPanel.add(input);
    this.editPanel.add(submit);
    this.editPanel.add(discard);

    this.gridPanel.add(spreadsheetPanel);

    submit.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String newValue = input.getText();
        System.out.println(newValue);
      }
    });

    discard.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        input.setText("");
        System.out.println("box cleared");
      }
    });

    this.mainPanel.add(editPanel, BorderLayout.PAGE_START);
    this.mainPanel.add(gridPanel, BorderLayout.CENTER);
    this.add(this.mainPanel);

   addMouseListener(this);


    /*this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Editable Visual View");
    this.setVisible(true);
    this.pack();
  }*/

  EditableView(ViewWorksheet model){
    super();

//    Map<Integer, Runnable> keyPresses = new HashMap<>();
//    keyPresses.put(KeyEvent.VK_LEFT, () -> f.moveSelectedLeft());
//    keyPresses.put(KeyEvent.VK_DOWN, () -> f.moveSelectedDown());
//    keyPresses.put(KeyEvent.VK_RIGHT, ()-> f.moveSelectedRight());
//    keyPresses.put(KeyEvent.VK_UP, ()-> f.moveSelectedUp());
//    keyPresses.put(KeyEvent.VK_BACK_SPACE, ()-> f.removeCell());

    //private ViewWorksheet model;
    //private ViewWorksheet model;
    //private ScrollableWorksheet spreadsheetPanel;
    //private JPanel gridPanel;
    JPanel editPanel = new JPanel(new FlowLayout());
    this.input = new TextField(75);
    this.submit = new JButton("√");
    this.submit.setActionCommand("submit");
    this.discard = new JButton("X");
    this.discard.setActionCommand("discard");
    this.save = new JButton("Save");
    this.save.setActionCommand("save");
    this.load = new JButton("Load");
    this.load.setActionCommand("load");
    editPanel.add(input);
    editPanel.add(submit);
    editPanel.add(load);
    editPanel.add(save);
    editPanel.add(discard);

    //this.gridPanel = new JPanel();

    WorksheetPanel.WorksheetPanelBuilder builder = new WorksheetPanel.WorksheetPanelBuilder();
    builder.setModel(model);
    this.worksheetPanel = builder.buildWorksheet();
    //this.values = model.getAllValues();
    //Coord topLeftCoord = new Coord(1, 1);
    JScrollBar vertical = new JScrollBar(JScrollBar.VERTICAL, 1, 100, 1, 600);
    JScrollBar horizontal = new JScrollBar(JScrollBar.HORIZONTAL, 1, 100, 1, 600);
    vertical.addAdjustmentListener(worksheetPanel);
    horizontal.addAdjustmentListener(worksheetPanel);

    GridBagConstraints gbc = new GridBagConstraints();
    setLayout(new GridBagLayout());

    gbc.anchor = GridBagConstraints.PAGE_START;

    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.weightx = .25;
    gbc.weighty = 0;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    add(this.input, gbc);

    gbc.gridx = 1;
    gbc.gridy = 0;
    gbc.weightx = 0;
    gbc.weighty = 0;
    gbc.fill = GridBagConstraints.NONE;
    add(this.submit, gbc);

    gbc.gridx = 2;
    gbc.gridy = 0;
    gbc.weightx = 0;
    gbc.weighty = 0;
    gbc.fill = GridBagConstraints.NONE;
    add(this.discard, gbc);

    gbc.gridx = 3;
    gbc.gridy = 0;
    gbc.weightx = 0;
    gbc.weighty = 0;
    gbc.fill = GridBagConstraints.NONE;
    add(this.save, gbc);

    gbc.gridx = 4;
    gbc.gridy = 0;
    gbc.weightx = 0;
    gbc.weighty = 0;
    gbc.fill = GridBagConstraints.NONE;
    add(this.load, gbc);

    gbc.gridx = 5;
    gbc.gridy = 1;
    gbc.weightx = 0;
    gbc.weighty = 0;
    gbc.gridwidth = 5;
    gbc.fill = GridBagConstraints.VERTICAL;
    add(vertical, gbc);

    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.weightx = 0;
    gbc.weighty = .5;
    gbc.fill = GridBagConstraints.BOTH;
    add(this.worksheetPanel, gbc);

    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.weightx = 1;
    gbc.weighty = 0;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    add(horizontal, gbc);

    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());


//    submit.addActionListener(e -> {
//      String newValue = input.getText();
//      System.out.println(newValue);
//    });
//
//    discard.addActionListener(e -> {
//      input.setText("");
//      System.out.println("box cleared");
//    });

    //addMouseListener(this);

    /*this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Editable Visual View");
    this.setVisible(true);
    this.pack();*/
  }

  @Override
  public Coord getTopLeft() {
    return this.worksheetPanel.getTopLeft();
  }

  @Override
  public void moveX(int x) {
    this.worksheetPanel.moveX(x);
  }

  @Override
  public void moveY(int y) {
    this.worksheetPanel.moveY(y);
  }

  @Override
  public void highlightCell(Coord c) {
    this.worksheetPanel.highlightCell(c);
  }

  @Override
  public void addFeatures(FeaturesMain flocal) {
    this.submit.addActionListener(evt -> flocal.putCell(input.getText()));
    this.discard.addActionListener(evt -> flocal.discard());
    this.save.addActionListener(evt -> flocal.save());
    this.load.addActionListener(evt -> flocal.load());
//    this.f = flocal;
//    this.submit.addActionListener(evt -> flocal.putCell(this.submit.getText()));
//    this.discard.addActionListener(evt -> flocal.discard());
//    this.save.addActionListener(evt -> flocal.save());
//    this.load.addActionListener(evt -> flocal.load());
//    this.addKeyListener(new KeyListener() {
//      @Override
//      public void keyTyped(KeyEvent keyEvent) {
//        if(keyTypes.containsKey(keyEvent.getKeyChar())) {
//          System.out.println("hello");
//          keyTypes.get(keyEvent.getKeyChar()).run();
//        }
//      }
//
//      @Override
//      public void keyPressed(KeyEvent keyEvent) {
//        if(keyPresses.containsKey(keyEvent.getKeyCode())) {
//          keyPresses.get(keyEvent.getKeyCode()).run();
//        }
//      }
//
//      @Override
//      public void keyReleased(KeyEvent keyEvent) {
//        if(keyReleases.containsKey(keyEvent.getKeyCode())) {
//          keyReleases.get(keyEvent.getKeyCode()).run();
//        }
//      }
//    });
//
//    this.addMouseListener(new MouseAdapter() {
//      @Override
//      public void mouseClicked(MouseEvent e) {
//        Coord c = worksheetPanel.selectCell(e.getX(), e.getY());
//        flocal.selectCell(c);
//      }
//
//      @Override
//      public void mouseDragged(MouseEvent e) {
//        //super.mouseDragged(e);
//      }
//    });
  }

  @Override
  public Coord selectCell(int x, int y) {
    return this.worksheetPanel.selectCell(x,y);
  }

//  @Override
//  public void addActionListener(ActionListener actionListener) {
//    this.discard.addActionListener(actionListener);
//    this.submit.addActionListener(actionListener);
//    this.save.addActionListener(actionListener);
//    this.load.addActionListener(actionListener);
//  }

  @Override
  public void setModel(ViewWorksheet model) {
    this.worksheetPanel.setModel(model);
  }

  @Override
  public void addKeyListener(KeyListener kl) {
    this.worksheetPanel.addKeyListener(kl);
  }

  /*public void render() throws IOException {
    JFrame frame = new JFrame();
    frame.add(this);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Editable Visual View");
    frame.setVisible(true);
    frame.pack();
  }*/
/*

  @Override
  public void mousePressed(MouseEvent e) {
    System.out.println(e.getX());
    System.out.println(e.getY());
    this.input.setText(this.values.get(new Coord(3,2)).toString());
    // use x & y position to get that cells in the map and pass set it as the textfield contents
    // show some visual indication that that is the cell that was clicked
  }

  public void mouseClicked(MouseEvent e) {

  }

  public void mouseReleased(MouseEvent e) {

  }

  public void mouseEntered(MouseEvent e) {

  }

  public void mouseExited(MouseEvent e) {

  }*/

//  public String getInput() {
//    return this.input.getText();
//  }

  void setText(String s) {
    this.input.setText(s);
  }


}
