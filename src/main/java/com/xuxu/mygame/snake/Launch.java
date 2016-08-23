package com.xuxu.mygame.snake;

import javax.swing.*;

class Launch {
	public static void main(String[] args){
		JFrame frame = new SnakeFrame();
		frame.setTitle("Snake Game");
		frame.setSize(Config.FrameWidth,Config.FrameHight);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
	}
}
