package com.xuxu.mygame.snake;

class Config{
	public static final int FrameWidth = 800;
	public static final int FrameHight = 600;
	public static final int LeftSide = 10;
	public static final int RightSide = FrameWidth - LeftSide;
	public static final int TopSide = 10;
	public static final int ButtomSide = 490;
	public static final int PX = 10;
	public static final int HorNum = (RightSide - LeftSide)/PX;
	public static final int VerNum = (ButtomSide - TopSide)/PX;
	public static final int InitSpeed = 1;
}
