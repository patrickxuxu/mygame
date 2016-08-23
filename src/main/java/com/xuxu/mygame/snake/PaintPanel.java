package com.xuxu.mygame.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class PaintPanel extends JPanel implements KeyListener{

	Snake snake = new Snake();
	private static int PX = Config.PX;

	boolean finish = false;

	protected void paintComponent(Graphics g){
		if(snake.dead){
			finish = true;
			g.setFont(new Font(null, 0, 20));
			double x = Config.LeftSide + (Config.RightSide - Config.LeftSide)*0.3;
			double y = Config.TopSide + (Config.ButtomSide - Config.TopSide)*0.4;
			g.drawString("Game Over", (int)x, (int)y);
			System.out.println("game finished in panel");
		}
		super.paintComponent(g); 
		drawSides(g);
		drawSnake(g);
		if(!snake.foodEaten){
			g.fillRect(snake.food.x*PX, snake.food.y*PX, PX, PX);
		}
		snake.foodEaten = false;
	}

	@Override
	public void keyTyped(KeyEvent e){
		System.out.println("type "+e.getKeyChar());
		boolean valid = false;
		if(e.getKeyChar() == 's'){
			if(snake.direction != Snake.Up){
				snake.direction = Snake.Down;
				valid = true;
			}	
		}else if(e.getKeyChar() == 'w'){
			if(snake.direction != Snake.Down){
                                snake.direction = Snake.Up;
                                valid = true;
                        }
		}else if(e.getKeyChar() == 'd'){
			if(snake.direction != snake.Left){
                                snake.direction = Snake.Right;
                                valid = true;
                        }
		}else if(e.getKeyChar() == 'a'){
			if(snake.direction != Snake.Right){
                                snake.direction = Snake.Left;
                                valid = true;
                        }
		}else if(e.getKeyChar() == 'u'){
			snake.speed *= 1.5;
		}else if(e.getKeyChar() == 'i'){
                        snake.speed /= 1.5;
		}else{

		}
		if(valid){
			goNext();
			this.repaint();
		}
	}

	@Override
	public void keyPressed(KeyEvent e){

	}

	@Override
	public void keyReleased(KeyEvent e){

	}

	private void drawSides(Graphics g){
		g.drawLine(Config.LeftSide, Config.TopSide, Config.RightSide, Config.TopSide);
		g.drawLine(Config.RightSide, Config.TopSide, Config.RightSide, Config.ButtomSide);
		g.drawLine(Config.RightSide, Config.ButtomSide, Config.LeftSide, Config.ButtomSide);
		g.drawLine(Config.LeftSide, Config.ButtomSide, Config.LeftSide, Config.TopSide);
	}

	private void drawSnake(Graphics g){
		for(int i = 0; i < snake.length(); i++){
			Snake.SPoint p = snake.positions.get(i);
			g.fillRect(p.x*PX, p.y*PX, PX, PX);
		}
	}

	public void goNext(){
		try{
			snake.nextStep();
		}catch(Exception e){
			e.printStackTrace();
		}
		//snake.printPositions();
	}

	public long sleeptime(){
		double time =  1000/snake.speed;
		return (long) time;
	}

}
