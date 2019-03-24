import javax.swing.JComponent;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.awt.Rectangle;


public class SpaceShip{

	public BufferedImage image;
	public URL resource = getClass().getResource("spaceship/f0.png");

	// circle s positon
	public int x = -10;
	public int y = 470;
	public int height = 0;
	public int width = 0;

	// animation states
	public boolean isAttacking = false;
	public int state = 0;

	Draw draw;

	public SpaceShip(Draw draw){

		this.draw = draw;

		try{
			image = ImageIO.read(resource);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public SpaceShip(int x, int y, Draw draw){

		this.x = x;
		this.y = y;

		this.draw = draw;

		try{
			image = ImageIO.read(resource);
		}
		catch(IOException e){
			e.printStackTrace();
		}

		height = image.getHeight();
		width = image.getWidth() + 5;
	}

	public Rectangle spaceShipBounds(){
		return(new Rectangle (x, y, width, height));

	}
	public void reloadImage(){
		state++;

        if (state == 0){
            resource = getClass().getResource("spaceship/f0.png");
        }

        else if (state == 1){
            resource = getClass().getResource("spaceship/f0.png");
        }

        else if (state == 2){
            resource = getClass().getResource("spaceship/f0.png");
        }

        else if (state == 3){
            resource = getClass().getResource("spaceship/f0.png");
        }
        
        else if (state == 4){
            resource = getClass().getResource("spaceship/f0.png");
        }

        else if (state == 5){
            resource = getClass().getResource("spaceship/f0.png");
            state = 0;
        }

        try {
            image = ImageIO.read(resource);
        }
        catch(IOException e){
            e.printStackTrace();
        }
	}

	public void beamAttackAnimation(){
		Thread beam1 = new Thread(new Runnable(){
			public void run(){
				isAttacking = true;
				for(int ctr = 0; ctr < 5; ctr++){
					try {
						if(ctr==4){
							resource = getClass().getResource("spaceship/f0.png");
						}
						else{
							resource = getClass().getResource("attack/fattack"+ctr+".png");
						}
						
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
				        draw.repaint();
				        Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				draw.checkCollision();
				isAttacking = false;
			}
		});
		beam1.start();
	}


	public void attack(){
		beamAttackAnimation();
	}
	public void moveUp(){
		y=y - 5;
		reloadImage();
		draw.repaint();
		draw.checkCollision();
	}
	public void moveDown(){
		if(y > 470){
			y = 470;
		}
		y=y + 5;
		reloadImage();
		draw.repaint();
		draw.checkCollision();
		
	}
	public void moveLeft(){
		x=x - 5;
		reloadImage();
		draw.repaint();
		draw.checkCollision();
		
	}
	public void moveRight(){
		x=x + 5;
		reloadImage();
		draw.repaint();
		draw.checkCollision();
	}
	
}