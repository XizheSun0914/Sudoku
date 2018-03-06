import java.util.ArrayList;
public class Spot{
	private int value;
	private ArrayList<Integer> possibility;
	private int x;
	private int y;
	private boolean flag;

	public Spot(int value){
		this.value=value;
		this.possibility=new ArrayList<Integer>();
		this.flag=false;
	
		for(int i=1;i<=9;i++){
			this.possibility.add(i);
		}
	}
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	public int getValue(){
		return this.value;
	}
	public boolean getFlag(){
		return this.flag;
	}
	public void setFlag(boolean flag){
		this.flag=flag;
	}
	public void setValue(int value,int x,int y){
		this.value=value;
		this.x=x;
		this.y=y;
	}
	public int getPoss(int index){
		return this.possibility.get(index).intValue();
	}
	public int getPossSize(){
		return this.possibility.size();
	}
	public void printPoss(){
		for(int i=0;i<this.possibility.size();i++){
			System.out.print(this.possibility.get(i).toString());
		}
	}
	public void delPoss(int value){
		Integer intObj=Integer.valueOf(value);
		this.possibility.remove(intObj);
	}
	
}