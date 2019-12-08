package manageSystem;

public class Course {
	    String Name;
        String getName() {
    return Name;
   }
        String Num;
        String getNum() {
    return Num;
   }
        String Place;
        String getPlace (){
    return Place;
   }
        String Time;
        String getTime(){
    return Time;
   }
        String Score;
        String getScore(){
    return Score;
   }
public Course(String name,String num,String place,String time,String score) {
        this.Name=name;
        this.Num=num;
        this.Place=place;
        this.Time=time;
        this.Score=score;
   }
public String toString() {
    return ("课程属性：课程名称："+Name+" 课程编号："+Num+" 上课地点："+Place+" 上课时间："+Time+" "
   + "课程学分："+Score);
   }

   }