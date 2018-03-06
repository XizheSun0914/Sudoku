import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
public class Sudoku{
	private Spot Background[][]=new Spot[9][9];
	public void setValue(int value,int x,int y){
		this.Background[x-1][y-1].setValue(value,x,y);
	}
	public Sudoku(){
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				Background[i][j]=new Spot(-1);
			}
		}
		
	}
	public static int determineSquare(int x,int y){
		int square_num=0;
		if (x>=1&&x<=3){
			if(y>=1&&y<=3)square_num=1;
			if(y>=4&&y<=6)square_num=4;
			if(y>=7&&y<=9)square_num=7;
		}
		if (x>=4&&x<=6){
			if(y>=1&&y<=3)square_num=2;
			if(y>=4&&y<=6)square_num=5;
			if(y>=7&&y<=9)square_num=8;
		}
		if (x>=7&&x<=9){
			if(y>=1&&y<=3)square_num=3;
			if(y>=4&&y<=6)square_num=6;
			if(y>=7&&y<=9)square_num=9;
		}
		if (square_num>9||square_num<1)System.out.println("Error in whichSquare");
		return square_num;
	}
	public void print(){
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){  
				if(this.Background[j][i].getValue()<=0){
					this.Background[j][i].printPoss();////
				}
				
				System.out.print("::");////	/
				System.out.print(this.Background[j][i].getValue()+" ");
				if((j+1)%3==0)System.out.print("  ");
			}
			System.out.println("\n");
			if((i+1)%3==0)System.out.println("\n");
		}
	}
	public static void readInput(Scanner s,Sudoku temp){
		int n=0;
			int x=1;
			int y=1;
			while ((n = s.nextInt())>=0&&n<10){
				temp.setValue(n,x,y);
				if(x==9&&y==9){
					System.out.println("The chart is full.");
					break;
				}
				if(x==9){
					x=1;
					y++;
				}else{
					x++;
				}
			} // Scans the next token of the input as an int.
			if(x!=9||y!=9)System.out.println("Input number not in the range");
	}
	public static void crossOut(int x,int y,Sudoku temp){
		int currSquare=determineSquare(x,y);
		for (int i=0;i<9;i++){
			for (int j=0;j<9;j++){
				if (determineSquare(i+1,j+1)==currSquare||j==y-1||i==x-1){
					temp.Background[i][j].delPoss(temp.Background[x-1][y-1].getValue());
				}
			}
		}
	}
	public static void main(String[] args){
		Sudoku temp=new Sudoku();
		Scanner s;
        if (args.length > 0){
        	try{
        		s = new Scanner(new File(args[0]));
        	} catch(java.io.FileNotFoundException e){
        		System.out.printf("Unable to open %s\n",args[0]);
        		return;
        	}
        	System.out.printf("Reading input values from %s.\n", args[0]);
        }else{
        	s = new Scanner(System.in);
			System.out.println("Reading input line by line from standard input: ");
        }
		readInput(s,temp);
		for(int k=0;k<20;k++){
			for (int i=1;i<=9;i++){
				for (int j=1;j<=9;j++){

					if(temp.Background[i-1][j-1].getFlag()==false&&temp.Background[i-1][j-1].getValue()>0){
						crossOut(i,j,temp);
					}
					if(temp.Background[i-1][j-1].getPossSize()==1&&temp.Background[i-1][j-1].getValue()==0){
						temp.Background[i-1][j-1].setValue(temp.Background[i-1][j-1].getPoss(0),i-1,j-1);
					}
					
				}
			}
		}
		//once finished
		//crossOut(4,4,temp);
		s.close(); 
		temp.print();
	}
}