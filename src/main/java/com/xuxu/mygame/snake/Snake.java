package com.xuxu.mygame.snake;

import java.util.LinkedList;

class Snake{
	public static final int Right = 0;
	public static final int Down = 1;
	public static final int Left = 2;
	public static final int Up = 3;
	
	LinkedList<SPoint> positions;
	int direction;
	double speed;
	int length;

	Food food = new Food();
	boolean foodEaten = false;

	boolean eat = false;

	boolean dead = false;

	public Snake(){
		positions = new LinkedList<SPoint>();
		direction = Right;
		speed = Config.InitSpeed;
		initSnake();
	}

	private void initSnake(){
		positions.add(new SPoint(Config.HorNum/2, Config.VerNum/2));
		positions.add(new SPoint(Config.HorNum/2-1, Config.VerNum/2));
		positions.add(new SPoint(Config.HorNum/2-2, Config.VerNum/2)); 
		length = 3;
	}

	public boolean isdead(SPoint p){
		return p.x < 1 || p.x > Config.HorNum || p.y < 1 || p.y > Config.VerNum;
	}

	public void nextStep() throws Exception{
		SPoint head = positions.peek();
		if(isdead(head)){
			dead = true;
			return;
		}
		SPoint nextPoint;
		switch(direction){
			case Right:
				nextPoint = new SPoint(head.x+1, head.y);
				break;
			case Down:
				nextPoint = new SPoint(head.x, head.y+1);
				break;
			case Left:
                                nextPoint = new SPoint(head.x-1, head.y);
                                break;
			case Up:
                                nextPoint = new SPoint(head.x, head.y-1);
                                break;
			default:
				throw new Exception("Unknown direction! "+direction);
		}
		positions.addFirst(nextPoint);
		if(nextPoint.x == food.x && nextPoint.y == food.y){
                        eat = true;
                        food.getNewFood();
			foodEaten = true;
                }
		//System.out.println("offered point: "+nextPoint);
		if(!eat){
			positions.removeLast();
		}
		eat = false;
	}

	public int length(){
		return positions.size();
	}

	public void printPositions(){
		for(SPoint sp : positions){
			System.out.print(sp+" ");
		}
		System.out.println();
	}

	class SPoint{
		int x;
		int y;

		public SPoint(int x, int y){
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString(){
			return "("+x+","+y+")";
		}
	}
}
