import javax.swing.JFrame;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class MyFrame extends JFrame implements KeyListener{

	Draw drawing;

	public MyFrame(){
		this.drawing = new Draw();
	}

	public void keyPressed(KeyEvent e){
		
		if(e.getKeyCode() == KeyEvent.VK_UP){
			drawing.spaceShip.moveUp();
			System.out.println("pos: " + drawing.spaceShip.x + "," + drawing.spaceShip.y);
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			drawing.spaceShip.moveDown();
			System.out.println("pos: " + drawing.spaceShip.x + "," + drawing.spaceShip.y);
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			drawing.spaceShip.moveRight();
			System.out.println("pos: " + drawing.spaceShip.x + "," + drawing.spaceShip.y);
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			drawing.spaceShip.moveLeft();
			System.out.println("pos: " + drawing.spaceShip.x + "," + drawing.spaceShip.y);
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE){
			drawing.spaceShip.attack();
			System.out.println("pos: " + drawing.spaceShip.x + "," + drawing.spaceShip.y);
		}
			
		else if(e.getKeyCode() == KeyEvent.VK_P){
			drawing.spawnEnemy();
		}
	}
	public void keyReleased(KeyEvent e){

	}
	public void keyTyped(KeyEvent e){

	}


    public static void main(String args []){
    MyFrame gameFrame = new MyFrame();
    
    gameFrame.setSize(1067,600);
    gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    gameFrame.setVisible(true);
    gameFrame.setResizable(false);
    gameFrame.getContentPane().add(gameFrame.drawing);
    gameFrame.addKeyListener(gameFrame);
    System.out.println("pratical prog");

    
        
    }
}