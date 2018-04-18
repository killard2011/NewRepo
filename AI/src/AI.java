import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javax.swing.*;
import java.util.*;
import java.util.Timer;
import java.math.*;

public class AI extends JPanel {
	int[] locX = {0,123,300};
	int[] locY = {0, 572, 89};
	int[] ObjX = {300,500, 65};
	int[] ObjY = {60, 90, 400};
	public boolean hasPiece = false;
	public boolean goForGoal = false;
	public int score = 0;
	public long startTime = 0;
	public long endTime = 0;
//	long time;
	public static void main(String[] args) throws IOException {
		new AI();
										   					  }

	public AI() throws IOException{
//		startTime =  System.currentTimeMillis();
		
		//figure out how to get it to read and write a.k.a. "memorizing"
//		try{
//			readFileX();
//			readFileY();
//		} catch ( IOException e){
//			e.printStackTrace();
//		}
//		try {
//			writeFileX(locX[0]);
//			writeFileY(locY[0]);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		makeForm();
		System.out.println(locX[1] + " " + locY[1] );
		boolean atTheGoal = false;

		while(atTheGoal == false){
		if(locX[0] == ObjX[1] && locY[0] == ObjY[1]){
			hasPiece = true;
			System.out.println("I have the piece");

		}
		if(hasPiece == true && locX[0] == ObjX[2] && locY[0] == ObjY[2]){
			score++;
			hasPiece = false;
			System.out.println("score: " + score + " droped off my piece!");

		}
		startTime = System.nanoTime();
		move(makeDecision(locX[0], locY[0], goalImportanceX(), goalImportanceY()));
		while(startTime + (1000000000 / 164) > System.nanoTime()){
			super.repaint();	
		}
		
			
			if(locX[0] == ObjX[0] && locY[0] == ObjY[0]){
				atTheGoal = true;
				endTime = System.nanoTime();
				System.out.println("winner!! Score: " + score);
//				System.out.println(endTime - startTime);
			}
		  }
		}

			
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	//						Figure out how to use this stuff to "learn" from past saved info 			   //
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
//	public int readFileX() throws IOException{
//			BufferedReader readerX = new BufferedReader(new FileReader("D:\\LocX.txt"));
//			locX[1] = Integer.parseInt(readerX.readLine());
//			readerX.close();
//			return locX[1];
//		}	
//	public int readFileY() throws IOException{
//		BufferedReader readerY = new BufferedReader(new FileReader("D:\\LocY.txt"));
//		locY[1] = Integer.parseInt(readerY.readLine());
//		readerY.close();
//		return locY[1];
//	}
//	public void writeFileX(int s) throws IOException{
//				BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\LocX.txt"));
//				writer.write(new Integer(s).toString());
//				writer.close();
//		}
//	public void writeFileY(int s) throws IOException{
//			BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\LocY.txt"));
//			writer.write(new Integer(s).toString());
//			writer.close();
//		}
		///////////////////////////////////////////////////////////////////////////////////////////////////
	
		public void makeForm(){
		JFrame myFrame = new JFrame("Artificil Intelligents");
		JPanel myPanel = new JPanel();
		myFrame.setDefaultCloseOperation(3);
		myFrame.setSize(800, 500);
		myFrame.add(this);
		myFrame.setVisible(true);
						  }
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D myGraphics = (Graphics2D) g;
		myGraphics.setPaint(Color.DARK_GRAY);
		myGraphics.fillRect(ObjX[0], ObjY[0], 40, 40);
		myGraphics.setPaint(Color.CYAN);
		myGraphics.fillRect(ObjX[1], ObjY[1], 40, 40);
		myGraphics.setPaint(Color.GREEN);
		myGraphics.fillRect(ObjX[2], ObjY[2], 40, 40);
		myGraphics.setPaint(Color.ORANGE);
		myGraphics.fillRect(locX[0], locY[0], 30, 30);
		
	}
	public int goalImportanceY(){
		if(score < 10 && hasPiece == false){
			return ObjY[1];
		}
		else if(score < 10 && hasPiece == true){
			return ObjY[2];
		}
		else if(score == 10){
			goForGoal = true;
			return ObjY[0];
		}
		else
		{
			System.out.println("ERROR goalImportanceY() NOT WORKING");
			return 0;			
		}
	}
	public int goalImportanceX(){
		if(score < 10 && hasPiece == false)
		{
		return ObjX[1];	
		} 
		else if(score < 10 && hasPiece == true){
			return ObjX[2];
		}
		else if(score == 10){
			return ObjX[0];
		}
		else
		//gray is least important
		//Cyan is most important
		//Black is second most important
		
		System.out.println("ERROR goalImportanceX() NOT WORKING");
		return 0;
	}
	
	public int makeDecision(int locX,int locY, int GoalX, int GoalY){
		//compare the current distance of the player to the location of the goal 
		//depending on what direction it needs to go return an int to tell it what direction to go
		int decision = 0;
		double distance = Math.pow(Math.pow((GoalX - locX), 2) + Math.pow(GoalY - locY, 2), .5);
		double xdistance = GoalX - locX;
		double ydistance = GoalY - locY;
		double EndDistance = Math.pow(Math.pow((ObjX[0] - locX), 2)+Math.pow(ObjY[0] - locY, 2), .5);
		double EndDistanceX = ObjX[0] - locX;
		double EndDistanceY = ObjY[0] - locY;
		
			if(xdistance > 0){
//				if(EndDistance < 50 && goForGoal == false && EndDistanceY > GoalY)
//				{
//					decision = 4;
//				}
//				else if(EndDistance < 50 && goForGoal == false && EndDistanceY < GoalY){
//					decision = 3;
//				}
//				else
//				 if(EndDistance > 50 && xdistance > 0){
					 decision = 1;	 
//				 }
				
			}
			else if(xdistance < 0){
//				if(EndDistance < 50 && goForGoal == false && EndDistanceY > GoalY)
//				{
//					decision = 4;
//				}
//				else if(EndDistance <50 && goForGoal == false && EndDistance < GoalY)
//				{
//					decision = 3;
//				}
//				else 
//					if(EndDistance > 50 && xdistance > 0){
				decision = 2;
//					}
			}
			
			if(ydistance > 0){
//				if(EndDistance < 50 && goForGoal == false && EndDistanceX > GoalX){
//					decision = 2;
//				}
//				else if(EndDistance < 50 && goForGoal == false && EndDistanceX < GoalX){
//					decision = 1;
//				}
//				else if(EndDistance > 50 && ydistance > 0)
				decision = 3;
			}
			else if(ydistance < 0){
//				if(EndDistance < 50 && goForGoal == false && EndDistanceX > GoalX)
//				{
//					decision = 2;
//				}
//				else if(EndDistance < 50 && goForGoal == false & EndDistance < GoalX){
//					decision = 1;
//				}else if(EndDistance > 50 && ydistance > 0){
				decision = 4;
//				}
			}
		
		
		return decision;
	}
	public void move(int decision){
		if(decision == 1){ 
			goRight();
		}
		else if(decision == 2){
			goLeft();
		}
		else if(decision == 3){
			goUp();
		}
		else if(decision == 4){
			goDown();
		}
		else
		{
			return;
		}
		
	}
	
	public void goRight(){
		locX[0]++;
	}
	
	public void goLeft(){
		locX[0]--;
	}
	
	public void goUp(){
		locY[0]++;
	}
	
	public void goDown(){
		locY[0]--;
	}
	
}