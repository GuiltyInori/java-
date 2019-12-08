package manageSystem;

//信息管理人员登陆后的界面
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;/*ArrayList;
import java.util.Hashtable;
*/
public class TeacherLogin extends JFrame implements  ActionListener{
	
	Modify fun=new Modify();
	
	//定义组件 
	JLabel lb1=new JLabel("当前是信息管理人员登录界面" );//JLabel 对象可以显示文本、图像
	JLabel lb2=new JLabel("提示：录入前请先输入学号，修改、删除根据学号修改信息");
	
  JTextField 编号,姓名,年龄,电话号码,所教课程,身份证号码;//输入学生基本信息得文本
  JRadioButton 男,女;//声明单选项对象，性别选择
  ButtonGroup group=null;//声明按钮组
  JButton 录入,查询,删除,修改,显示,返回;//声明相应的操作的按钮
  JPanel p1,p2,p3,p4,p5,p6,p7,pv,ph,pb;//调节布局的通道
  
  public TeacherLogin(){       //负责管理员登录的主窗口
      super("教师信息管理系统");
      编号=new JTextField(10);//创建文本信息的的对象
      姓名=new JTextField(10);
      电话号码=new JTextField(15);
      年龄=new JTextField(5);
      所教课程=new JTextField(15);

      
      group=new ButtonGroup();
      男=new JRadioButton("男");//初始化单选框,
      女=new JRadioButton("女");
      group.add(男);//把按钮添加到按钮组
      group.add(女);
      录入=new JButton("增加教师信息");//创建按钮对象
      查询=new JButton("查询符合条件的教师信息");
      删除=new JButton("删除教师信息");
      修改=new JButton("修改教师信息");
      显示=new JButton("显示全部教师信息");
      返回=new JButton("返回登录界面");
  
      pb=new JPanel();
      pb.add(lb1,JLabel.CENTER);
              
      p1=new JPanel();//创建一个面板     
     
      p1.add(lb2,JLabel.CENTER);
      p1.add(new JLabel("学号:",JLabel.CENTER));//JLabel.CENTER是指JLabel的中心点。CENTER是中心点的坐标
      p1.add(编号);
      
      p2=new JPanel();
      p2.add(new JLabel("姓名:",JLabel.CENTER));
      p2.add(姓名);
      p3=new JPanel();
      p3.add(new JLabel("性别:",JLabel.CENTER));
      p3.add(男);
      p3.add(女);
      p4=new JPanel();
      p4.add(new JLabel("年龄:",JLabel.CENTER));
      p4.add(年龄);
      p5=new JPanel();
      p5.add(new JLabel("电话号码:",JLabel.CENTER));
      p5.add(电话号码);    
      p6=new JPanel();
      p6.add(new JLabel("所选课程:",JLabel.CENTER));
      p6.add(所教课程);

     
      pv=new JPanel();//面板
      pv.setLayout(new GridLayout(7,1));   //把pv组件设置成第七行1列的网格布局
          
      pv.add(p1);//把面板放到容器中,add()代表容器
      pv.add(p2);
      pv.add(p3);
      pv.add(p4);
      pv.add(p5);
      pv.add(p6);

             
      ph=new JPanel();      
      ph.add(录入);
      ph.add(查询);
      ph.add(修改);
      ph.add(删除);    
      ph.add(显示);
      ph.add(返回);
             
      Container con=getContentPane();//建立容器对象con,取得容器面板
      con.setLayout(new BorderLayout());//设置布局为边框布局，边框布局分东南西北中5个方位来添加控件。
      //若没有指定方位，将添加到中间，上下左右都可以扩展
      con.add(pb, BorderLayout.NORTH);//Frame对象lb调用方法add（）,lb放在最北上方     
      con.add(pv, BorderLayout.CENTER);//pv在中间
      con.add(ph, BorderLayout.SOUTH);//ph在南边
      setDefaultCloseOperation(EXIT_ON_CLOSE);//置一个默认的关闭操作，也就是你的JFrame窗口的关闭按钮，点击它时，退出程序
      setBounds(100,100,900,450);//setBounds(x,y,width,height); x:组件在容器X轴上的起点 y:组件在容器Y轴上的起点 width:组件的长度 height:组件的高度
      setVisible(true);//目的是使控件可以显示出来,如果该控件已经被显示出来
        
      teacher tea=new teacher();
      ArrayList<teacher> arry=new ArrayList<teacher>();
      //添加监听
      //点击录入按钮  学号","姓名","性别","年龄","电话号码","家庭住址","身份证号码"  
      录入.addActionListener(new ActionListener() {
  	   public void actionPerformed(ActionEvent e) {		     		     
  		 String teaID = 编号.getText();    //获取文本框中内容
  		 if(fun.find(teaID)!=-1)
  		 {
  			 JOptionPane.showMessageDialog(null, "该编号对应的教师已经存在！！！\n\n请重新输入或者修改已经录入的教师");   			 
  			  //清空文本框
  			编号.setText("");
  			 姓名.setText("");
  			 年龄.setText("");
  			 电话号码.setText("");
  			所教课程.setText("");
  			 身份证号码.setText("");
  			 return;
  		 }      		 
  		 String tname = 姓名.getText();  		 
  		 //先判断学号和姓名是否为空，如果为空，直接退出
  		 if(teaID.equals("")||tname.equals(""))
  		 {
  			 JOptionPane.showMessageDialog(null, "录入的教师编号或姓名为空！！！\n\n请重新输入");
  			 return;
  		 }  	   		 	 
    		 String tage = 年龄.getText();     		 
    		 if(tage.equals(""))//年龄为空，没有输入
 			    tage="--";  		 
    		 String tcall = 电话号码.getText();
    		 if(tcall.equals(""))
    			  tcall="--";
    		 String thome = 所教课程.getText();
    		
			if(thome.equals(""))
    		    thome="--";
    		 String tiden = 身份证号码.getText();
    		if(tiden.equals(""))
    		   tiden="--";
    		 String tsex=null;
           if(男.isSelected()){//选择男女
              tsex=男.getText();
           }
           else{
               tsex=女.getText();
           }   
          
    		 tea.setteaID(teaID);
    		 tea.settAge(tage);
    		 tea.settName(tname);
    		 tea.settSex(tsex);
    		 tea.settCallnummber(tcall);

    		 tea.settIdentityID(tiden);
    		 
    		 //arry.clear();//	清除原数组列表中的数据	
    		// Input input=new Input(stu);
    		 System.out.println("信息管理员");
    		 System.out.println(tea.fileString());
    		 
    		 fun.add(tea);
    		 fun.writefile();
    		 
    		 JOptionPane.showMessageDialog(null, "录入成功！！！");
    		 //dispose();
    		 setVisible(false); 
    		 new ManagerLogin();
    		 
    		  //清空文本框
    		 /*
			学号.setText("");
			姓名.setText("");
			年龄.setText("");
			电话号码.setText("");
		    家庭住址.setText("");
			身份证号码.setText("");
			group.clearSelection();   //清空按钮已选状态
			*/
  	   }   	   
     });
      
                 
     //显示全部学生信息
        显示.addActionListener(new ActionListener() {
   	   public void actionPerformed(ActionEvent e) {     		   
   		   //show_stuall all=new show_stuall();     
   		   new show_stuall2();   		     		   
   	    }	     		   
        });
                    
      //查询某个学生信息       
      查询.addActionListener(new ActionListener() {
      	   public void actionPerformed(ActionEvent e) {      		  
      		   String tID = 编号.getText();    //获取文本框中内容 
      		   if(tID.equals(""))
      		     tID="--";       		   
        		  String tname = 姓名.getText();  		 
        		  if(tname.equals(""))
      			   tname="--";      		 	 
          	  String tage = 年龄.getText();     		 
          	  if(tage.equals(""))             //年龄为空，没有输入
       			    tage="--";  		 
          	  String tcall = 电话号码.getText();
          	 if(tcall.equals(""))
          			  tcall="--";
          		 String thome = 所教课程.getText();
          		if(thome.equals(""))
          		    thome="--";
          		 String tiden = 身份证号码.getText();
          		if(tiden.equals(""))
          		   tiden="--";
          		 String tsex=null;
                 if(男.isSelected()){//选择男女
                    tsex=男.getText();
                 }
                 else {
              	    if(女.isSelected())
                       tsex=女.getText();
                     else {
						  tsex="--";
					   }
                 }          		            
      	 		 //将要查询的符合条件的写入文件
      	 		FileWriter fw=null;
  				BufferedWriter out=null;//学号","姓名","性别","年龄","电话号码","家庭住址","身份证号码" };
  				try {
  					 fw = new FileWriter("查询时暂时存放的文件.txt");
  					 out = new BufferedWriter(fw);
  					 //姓名学号等中间隔一个空格
  					 out.write(tID+"  ");
  					 out.write(tname+"  ");
  					 out.write(tsex+"  ");
  					 out.write(tage+"  "); 					   					 
  					 out.write(tcall+"  ");
  					 out.write(thome+"  ");
  					 out.write(tiden+"  "); //每次覆盖写入，无需全部保存
  				   					 
  					out.close();
  					fw.close();
  						
  				} catch (IOException e1) {
  					e1.printStackTrace();
  					
  				}     				
  				//开始查询
  				new Showteacher();  
  				
  				//清空文本框
  				编号.setText("");
  				姓名.setText("");
  				年龄.setText("");
  				电话号码.setText("");
  				所教课程.setText("");
  				身份证号码.setText("");
  				group.clearSelection();
  				
      	    }	     		   
           }); 
     

     
     //删除学生信息,按学号删除
        删除.addActionListener(new ActionListener() {
      	   public void actionPerformed(ActionEvent e) {
      		   String tID = 编号.getText();    //获取文本框中内容
      		   int flag=fun.find(tID);
      		   if(flag==-1)
      		   {
      			   JOptionPane.showMessageDialog(null, "未查找到该编号的教师！！！\n\n请重新输入");       			    
      		   }
      		   else {
					 fun.delete(tID); 
      		     fun.writefile();
      		     JOptionPane.showMessageDialog(null, "删除成功！！！\n");
				 }
     		
      		   //清空文本框
      		 编号.setText("");
     			姓名.setText("");
     			年龄.setText("");
     			电话号码.setText("");
     			所教课程.setText("");
     			身份证号码.setText("");
     			group.clearSelection();
      		   
      	    }	     		   
           });       
        
        //修改学生信息
        修改.addActionListener(new ActionListener() {
        	   public void actionPerformed(ActionEvent e) {
        		  String teaID = 编号.getText();    //获取文本框中内容
        		 int flag=fun.find(teaID);    //查找是否存在      		
       		 if (flag==-1)
       		 {
   			   JOptionPane.showMessageDialog(null, "未查找到该编号的教师！！！\n\n请重新输入");
    			   return;  
   		    }    
       		else
    			   JOptionPane.showMessageDialog(null, "该系统中存在该教师数据\n\n,确认返回后请输入需要修改后的数据");
     			 		    		     		 
        		 String tage = 年龄.getText();     		 
        		 if(tage.equals(""))//年龄为空，没有输入
     			    tage="--";  		 
        		 String tcall = 电话号码.getText();
        		 if(tcall.equals(""))
        			  tcall="--";
        		 String thome = 所教课程.getText();
        		if(thome.equals(""))
        		    thome="--";
        		 String tiden = 身份证号码.getText();
        		if(tiden.equals(""))
        		   tiden="--";
        		 String tsex=null;
               if(男.isSelected()){//选择男女
                  tsex=男.getText();
               }
               else{
                   tsex=女.getText();
               }   
               String tname = 姓名.getText();  		 
      		 //先判断学号和姓名是否为空，如果为空，直接退出
      		 if(tname.equals(""))
      		 {
      			 JOptionPane.showMessageDialog(null, "录入的教师姓名为空！！！\n\n请重新输入");
      			 return;
      		 }  	
      		// student_information stu=new student_information();
        		 tea.setteaID(teaID);
        		 tea.settAge(tage);
        		 tea.settName(tname);
        		 tea.settSex(tsex);
        		 tea.settCallnummber(tcall);
        	
        		 tea.settIdentityID(tiden);
       		 
        		 fun.update(tea);       //修改
        		 fun.writefile();
        		 JOptionPane.showMessageDialog(null, "修改成功！！！");
        		  //清空文本框
        		 编号.setText("");
   			姓名.setText("");
   			年龄.setText("");
   			电话号码.setText("");
   			所教课程.setText("");
   			身份证号码.setText("");
   			group.clearSelection();	 		 			          		         		 
        	    }	     		             	   
             });
                      
  返回.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);      //目的是使控件不可以显示出来
			new firstLogin();
		}
	});
   }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}


