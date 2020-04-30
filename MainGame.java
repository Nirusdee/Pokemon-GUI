import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MainGame extends JFrame
{
        private Trainer trainer;
        
        public MainGame(Trainer trainer){
        super("Pokemon Close Beta");
        this.trainer = trainer;
        
        JPanel panel1 = new JPanel();
        JButton jb1 = new JButton("New Pokemon");
        JButton jb2 = new JButton("Bag");
        JButton jb3 = new JButton("Quit");
        JButton jb4 = new JButton("Forest");
        JButton jb5 = new JButton("Shop");
        

        panel1.setLayout(new GridBagLayout());

        Box buttonBox = Box.createVerticalBox();
        
        buttonBox.add(jb1);
        buttonBox.add(Box.createVerticalStrut(20));
        buttonBox.add(jb4);
        buttonBox.add(Box.createVerticalStrut(20));
        buttonBox.add(jb2);
        buttonBox.add(Box.createVerticalStrut(20));
        buttonBox.add(jb5);
        buttonBox.add(Box.createVerticalStrut(20));
        buttonBox.add(jb3);
        jb1.setAlignmentX(JButton.CENTER_ALIGNMENT);
        jb2.setAlignmentX(JButton.CENTER_ALIGNMENT);
        jb3.setAlignmentX(JButton.CENTER_ALIGNMENT);
        jb4.setAlignmentX(JButton.CENTER_ALIGNMENT);
        jb5.setAlignmentX(JButton.CENTER_ALIGNMENT);
        // System.out.println(trainer.slot().size());
        addItem(panel1, buttonBox, 3, 4, 1, 1, GridBagConstraints.CENTER);
        
        jb1.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                if(trainer.slot().size() == 0){
                NewPokemon Newpokemon = new NewPokemon(trainer);
                Newpokemon.setVisible(true);
                setVisible(false);
                }
        }});
        
        jb2.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                PokemonStatus Status = new PokemonStatus(trainer);
                Status.setVisible(true);
                setVisible(false);
        }});

        jb3.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                System.exit(0);
        }});
        
        jb4.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                Forest forest = new Forest(trainer);
                forest.setVisible(true);
                setVisible(false);
        }});
        jb5.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                Shop shop = new Shop(trainer);
                shop.setVisible(true);
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
        gc.fill = GridBagConstraints.CENTER;
        p.add(c, gc);
    }
} 