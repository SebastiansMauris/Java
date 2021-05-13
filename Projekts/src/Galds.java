import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import dambretes.kaulini.Kaulins;
import dambretes.laukums.Gajiens;
import dambretes.laukums.Laucins;
import dambretes.laukums.Laukums;
import dambretes.laukums.LaukumsPielikums;
import dambretes.speletajs.GajienaPareja;

public class Galds {

	
	final Color gaisaLaucinuKrasa = Color.decode("#FFFFFF");
	final Color tumsaLaucinuKrasa = Color.decode("#A9A9A9");
	final JFrame spelesFrame;
	final LaukumaPanelis laukumaPanelis;
	
	private Laucins sakumaLaucins;
	private Laucins galamerkaLaucins;
	private Kaulins speletajaKustinatsKaulins;	
	
	
	
    public Laukums dambretesLaukums;
   
	
	private static String kaulinaImagePath = "kaulinuIkonas/";
	
	static final Dimension AREJA_RAMJA_IZMERI = new Dimension(600, 600);
	static final Dimension LAUKUMA_PANELU_IZMERI = new Dimension(400, 350);
	static final Dimension LAUCINA_PANELU_IZMERI = new Dimension(10,10);
	
	
	
    public Galds() {
    	this.spelesFrame = new JFrame("Dambrete");
    	spelesFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("kaulinuIkonas/dambrete.jpg"));
    	this.spelesFrame.setLayout(new BorderLayout());
    	this.spelesFrame.setSize(AREJA_RAMJA_IZMERI);
    	this.spelesFrame.setVisible(true);
    	this.dambretesLaukums = Laukums.uztaisitParastuSpelesLaukumu();
        this.laukumaPanelis = new LaukumaPanelis();        
        this.spelesFrame.add(this.laukumaPanelis);
        
        
       
    	}
   
 
    
    public class LaukumaPanelis extends JPanel {
    	
    	
    	
		final List<LaucinuPanelis> laukumaLaucini;
    	
    	LaukumaPanelis() {
    	
    		super(new GridLayout(8, 8));
    		
    		
    		
    		
    		
    		
    		System.out.println(dambretesLaukums);
    		
    		
    		
    		
    		
    		
    		this.laukumaLaucini = new ArrayList<>();
    		System.out.println("laukuma panelis1");
    		for(int i = 0; i < LaukumsPielikums.LAUCINU_SKAITS; i++) {
    			System.out.println("laukuma panelis2");
    			final LaucinuPanelis laucinuPanelis = new LaucinuPanelis(this, i);
    			System.out.println("laukuma panelis3");
    			this.laukumaLaucini.add(laucinuPanelis);
    			System.out.println("laukuma panelis4");
    			add(laucinuPanelis);
    		}
    		
    		setPreferredSize(LAUKUMA_PANELU_IZMERI);
    		validate();
    		
    	}

		public void uzzimetLaukumu(Laukums laukums) {
			removeAll();
			for(LaucinuPanelis laucinuPanelis : laukumaLaucini) {
				laucinuPanelis.uzzimetLaucinu(laukums);
				add(laucinuPanelis);
			}
			validate();
			repaint();
		}
    	
    	
    }
    private class LaucinuPanelis extends JPanel {
    
    
		final int laucinaID;
    	
    	LaucinuPanelis(final LaukumaPanelis laukumaPanelis, 
    			final int laucinaID){
    		super(new GridBagLayout());
    		System.out.println("laucina panelis1");
    		this.laucinaID = laucinaID;
    		System.out.println("laucina panelis2");
    		setPreferredSize(LAUCINA_PANELU_IZMERI);
    		
    		pieskirtLaucinaKrasu();
    
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		pieskirtLaucinamKaulinu(dambretesLaukums);
    		System.out.println("laucina panelis5");
    		
    		addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(SwingUtilities.isRightMouseButton(arg0)) {
						sakumaLaucins = null;
						galamerkaLaucins = null;
						speletajaKustinatsKaulins = null;
						}else if(SwingUtilities.isLeftMouseButton(arg0)) {
						   if(sakumaLaucins == null) {
							   sakumaLaucins = dambretesLaukums.getLaucins(laucinaID);
							   speletajaKustinatsKaulins = sakumaLaucins.getKaulins();
							   if(speletajaKustinatsKaulins == null) {
								   sakumaLaucins = null;
							   }
						   }
						   else {
							   galamerkaLaucins = dambretesLaukums.getLaucins(laucinaID);
							   Gajiens gajiens = Gajiens.gajienuGeneracija.uztaisitGajienu(dambretesLaukums, sakumaLaucins.getLaucinaKoordinate(), galamerkaLaucins.getLaucinaKoordinate());//ja nestrada skatities te TODO
							   final GajienaPareja pareja = dambretesLaukums.pasreizejaisSpeletajs().izpilditGajienu(gajiens);
							   if(pareja.getGajienaStavoklis().irIzpildits()) {
								   dambretesLaukums = pareja.getParejasLaukums();
							   }
							   sakumaLaucins = null;
							   galamerkaLaucins = null;
							   speletajaKustinatsKaulins = null;
							   
						   }
						   SwingUtilities.invokeLater(new Runnable(){
							   @Override
							   public void run() {
								   laukumaPanelis.uzzimetLaukumu(dambretesLaukums);
							   }
						   });
						}
					
				
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					
					
				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					
					
				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					
					
				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					
					
				}
    		});
    			
    		
    		
    		
    		
    		
    		validate();
			
    		
    		
    		
    		
    	}
    	public void uzzimetLaucinu(Laukums laukums) {
    		pieskirtLaucinaKrasu();
    		pieskirtLaucinamKaulinu(laukums);
    		validate();
    		repaint();
    	}
    	//laukums.getLaucins(this.laucinaID).vaiLaucinsIrAiznemts()
    	
    	private void pieskirtLaucinamKaulinu(final Laukums laukums) {
    		this.removeAll();
    		System.out.println("ripax1");
    		
    		
    		
    		
    		
    		System.out.println(laukums);
    		
    		
    		
    		
    		
    		if(laukums.getLaucins(this.laucinaID).vaiLaucinsIrAiznemts()) {
    			System.out.println("ripax2");
				try {
					
					//Image image = new ImageIcon(this.getClass().getResource("baltaisKaulins.gif")).getImage();
					//(laukums.getLaucins(this.laucinaID).getKaulins().getKaulinaKrasa().toString().substring(0, 1);
					//+ laukums.getLaucins(this.laucinaID).getKaulins().toString() + ".gif");
					        
					final BufferedImage image =
					ImageIO.read(new File(kaulinaImagePath + laukums.getLaucins(this.laucinaID).getKaulins().getKaulinaKrasa().toString().substring(0, 1) + 
					laukums.getLaucins(this.laucinaID).getKaulins().toString() + ".gif"));
					System.out.println("ripax3");
					this.add(new JLabel(new ImageIcon(image)));
					System.out.println("ripax4");
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("ripaxException");
					
				}
    		}
    		
    		
    	}

    	private void pieskirtLaucinaKrasu() {
            boolean irGaiss = ((laucinaID + laucinaID / 8) % 2 == 0);
            setBackground(irGaiss ? gaisaLaucinuKrasa : tumsaLaucinuKrasa);
            }
         }
				
			
		
    	
    	
    }
    

