package isp.lab3.exercise2;
private int length=2;
private int width=1;
private  string color ='red';
public rectangle(){}
    public rectangle(int length, int width){
    this.length=length;
    this.width=width;}
    public rectangle(int length, int width,string color){
    this.length=length;
    this.width=width;
    this.color=color;
}
    public int getlength(){
    return this.length;
}
    public int getwidth(){
    return this.width;}
    public string getcolor(){
    return this.color;}
    public class MainOfExercise2 {
    public int getparameter()
    {
        return 2*this.length+2*this.width;
    }
    public int aria(){
        retirm this.length*this.width;
    
    }
    public string toString()
    {
        return "rectangle width"+this.width
    }
}
