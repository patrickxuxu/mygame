package com.xuxu.mygame.snake;

import javax.swing.*;
import java.awt.*;

class SnakeFrame extends JFrame implements Runnable{
	public JLabel scoreLabel;
	public PaintPanel paintCanvas;

	public SnakeFrame(){
		Container ctn = getContentPane();
		scoreLabel = new JLabel("Score:");
		ctn.add(scoreLabel, BorderLayout.NORTH);

		paintCanvas = new PaintPanel();
		ctn.add(paintCanvas, BorderLayout.CENTER);

		this.addKeyListener(paintCanvas);

		JPanel buttomPanel = new JPanel();
		buttomPanel.setLayout(new BorderLayout());
		JLabel helpLabel;
		helpLabel = new JLabel("U, I for speed", JLabel.CENTER);
		buttomPanel.add(helpLabel, BorderLayout.EAST);
		helpLabel = new JLabel("ENTER or R or S for start", JLabel.CENTER);
		buttomPanel.add(helpLabel, BorderLayout.CENTER);
		helpLabel = new JLabel("SPACE or P for pause", JLabel.CENTER);
		buttomPanel.add(helpLabel, BorderLayout.WEST);
		ctn.add(buttomPanel, BorderLayout.SOUTH);

		Thread t = new Thread(this);
		t.start();
	}

	public void run(){
		while(true){
			try{
				long time = paintCanvas.sleeptime();
				Thread.sleep(time);
			}catch(Exception e){
				e.printStackTrace();
			}
			paintCanvas.goNext();
			paintCanvas.repaint();
			if(paintCanvas.finish){
                                break;
                        }
		}
	}
}
