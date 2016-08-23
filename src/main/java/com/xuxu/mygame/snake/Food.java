package com.xuxu.mygame.snake;

import java.util.Random;

class Food{
	public int x;
	public int y;

	public Food(int x, int y){
		this.x = x;
		this.y = y;
	}

	public Food(){
		getNewFood();
	}

	public void getNewFood(){
		int tmp_x = x, tmp_y = y;
		Random r = new Random();
		while(tmp_x == x && tmp_y == y){
			tmp_x = Math.abs(r.nextInt())%Config.HorNum+1;
                	tmp_y = Math.abs(r.nextInt())%Config.VerNum+1;
		}
		x = tmp_x;
		y = tmp_y;
	}
}
