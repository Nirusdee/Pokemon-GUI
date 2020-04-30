import javax.swing.*;
import java.io.File;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.*;
import java.awt.event.*;

public class NewPokemon extends JFrame{
    
    private Trainer trainer;
   
    public NewPokemon(Trainer trainer){
        super("New Pokemon");
        this.trainer = trainer;
        JTextField name = new JTextField(20);

        JRadioButton ivysaur = new JRadioButton("ivysaur"); 
        JRadioButton Hooh = new JRadioButton("Hooh");
        JRadioButton Pachirisu = new JRadioButton("Pachirisu");

        JLabel img1 = new JLabel();
        JLabel img2 = new JLabel();
        JLabel img3 = new JLabel();

        JButton okButton = new JButton("New"); 
        JButton closeButton = new JButton("Back");
          
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        
        File[] file = new File[3];
        file[0] = new File("ivysaur.jpg");
        file[1] = new File("Hooh.jpg");
        file[2] = new File("Pachirisu.jpg");
        BufferedImage[] img =new BufferedImage[3];
        
        for(int i=0; i<3; i++){
            try{
                img[i] = ImageIO.read(file[i]);
            } 
            catch (IOException ex) {
                ex.printStackTrace();
            }   
        }
        img1.setIcon(new ImageIcon(img[0]));
        img2.setIcon(new ImageIcon(img[1]));
        img3.setIcon(new ImageIcon(img[2]));

        Box box1 = Box.createVerticalBox();
        box1.add(img1);
        box1.add(Box.createVerticalStrut(20));
        box1.add(ivysaur);
        Box box2 = Box.createVerticalBox();
        box2.add(img2);
        box2.add(Box.createVerticalStrut(20));
        box2.add(Hooh);
        Box box3 = Box.createVerticalBox();
        box3.add(img3);
        box3.add(Box.createVerticalStrut(20));
        box3.add(Pachirisu);
      
        addItem(panel1, box1, 0, 0, 1, 1, GridBagConstraints.SOUTH);
        addItem(panel1, box2, 1, 0, 1, 1, GridBagConstraints.SOUTH);
        addItem(panel1, box3, 2, 0, 1, 1, GridBagConstraints.SOUTH);
        ButtonGroup group = new ButtonGroup();
        group.add(ivysaur);
        group.add(Hooh);
        group.add(Pachirisu);


        addItem(panel1, new JLabel("Name:"), 0, 3, 1, 1, GridBagConstraints.EAST);
        addItem(panel1, name, 1, 3, 2, 1, GridBagConstraints.WEST);
              
        
        Box buttonBox = Box.createHorizontalBox();
        buttonBox.add(okButton);
        buttonBox.add(Box.createHorizontalStrut(20));
        buttonBox.add(closeButton);
        addItem(panel1, buttonBox, 2, 4, 1, 1, GridBagConstraints.CENTER);
        
        okButton.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                if (name.getText().length() == 0||((ivysaur.isSelected() == false ) && (Hooh.isSelected() == false) && (Pachirisu.isSelected() == false))){
                }
                else{
                if(trainer.slot().size() == 1){
                

                }
                else if(name.getText() != "" && ivysaur.isSelected()){
                    trainer.addP();
                    trainer.slot().get(0).Name(name.getText());
                    trainer.slot().get(0).poke(0,1);
                   
                }
                else if(name.getText() != "" && Hooh.isSelected()){
                    trainer.addP();
                    trainer.slot().get(0).Name(name.getText());
                    trainer.slot().get(0).poke(1,1);
                   
                }
                else if(name.getText() != "" && Pachirisu.isSelected()){
                    trainer.addP();
                    trainer.slot().get(0).Name(name.getText());
                    trainer.slot().get(0).poke(2,1);
                }
                
                setVisible(false);
                MainGame maingame = new MainGame(trainer);
                maingame.setVisible(true);
            }
            }});

        closeButton.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                
                MainGame maingame = new MainGame(trainer);
                maingame.setVisible(true);
                setVisible(false);
            }});

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel1);
        pack();
        setSize(1000, 600);
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
        setVisible(true);
    }

    
    private void addItem(JPanel p, JComponent c, int x, int y, int width, int height, int align) {
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = x;
        gc.gridy = y;
        gc.gridwidth = width;
        gc.gridheight = height;
        gc.weightx = 100.0;
        gc.weighty = 100.0;
        gc.insets = new Insets(5, 5, 5, 5);
        gc.anchor = align;
        gc.fill = GridBagConstraints.NONE;
        p.add(c, gc);
    }
}