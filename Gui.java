package manageSystem;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class Gui extends JFrame implements ActionListener{
    Course course;

	Container c;
	JLabel label1;JLabel label2;JLabel label3;JLabel label5;JLabel label6;//定义标签
	JLabel label7;JLabel label8;JLabel label9;JLabel label10,label11;JLabel label12;JLabel label13;
	JButton button1,button2;//定义按钮
	JButton button3,button4;
	TextArea ta1,ta2;//定义显示框
	JTextField t1,t2,t3,t4,t5,t6,t7,t8;//定义单行可输入框
	CheckboxGroup cbg;//定义可选择组
	JComboBox b4;JComboBox b5;//定义下拉框
	JCheckBox c1,c2,c3;//定义可选择项目

	String time[]={"24","36","48","72"
			};
	String score[]={"1.0","2.0","3.0","4.0"
			};//将学时和学分实例化
	
	
	public Gui(){
		setTitle("学生选课系统");//设置GUI的标题
		label1=new JLabel("请输入个人信息和所选课程"
				+ "。                                     ");//选择流式布局需要用大量的空格进行辅助排版，且调用JLabel方法进行实例化
		label7=new JLabel("请输入开设的课程和信息。                                   ");
		label2=new JLabel("学生姓名：");
		label8=new JLabel("教师姓名：");
		label3=new JLabel("性别:");
		cbg = new CheckboxGroup();//设置选择组 
		label9=new JLabel("课程名称：");
		label6=new JLabel("学号：");
		
		label10=new JLabel("课程编号：");
		label5=new JLabel("课程：");
		label11=new JLabel("上课地点：");
		label12=new JLabel("课时：");
		label13=new JLabel("学分：");
		b4=new JComboBox(time);//调用JComboBox方法对下拉框进行实例化
		b5=new JComboBox(score);
		c1=new JCheckBox("物理");//对选择项目实例化
		c2=new JCheckBox("离散");
		c3=new JCheckBox("体育");
		ta1=new TextArea(17,35);
		ta2=new TextArea(17,35);
        button1=new JButton("确定");
		button2=new JButton("取消");
		button3=new JButton("确定");
		button4=new JButton("取消");
		t1=new JTextField("",5);
		t2=new JTextField("",10);
		t3=new JTextField("",5);
		t4=new JTextField("",5);
		t5=new JTextField("",5);
		t6=new JTextField("",5);
		t7=new JTextField("",5);
		t8=new JTextField("",5);
		setBounds(600,300,625,600);//设置窗口大小
		try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch(Exception e){}//开始对窗口进行排版
		c=getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.LEFT));//选择流式布局
		c.add(label1);
		c.add(label7);
		c.add(label2);
		c.add(t1);
		c.add(label3);
		c.add(new Checkbox("男", cbg, true)); //调用Checkbox方法对选择项目进行实例化
		c.add(new Checkbox("女", cbg, false));
		c.add(new JLabel("           "));
		c.add(label8);
		c.add(t3);
		c.add(new JLabel("                          "));
		c.add(label6);
		c.add(t2);
		c.add(new JLabel("                        "));
		c.add(label9);
		c.add(t4);
		c.add(new JLabel("                          "));
		

		c.add(label11);
		c.add(t6);
		c.add(new JLabel("                         "));
		c.add(label5);c.add(c1);c.add(c2);c.add(c3);
		c.add(new JLabel("               "));
		c.add(label10);
		c.add(t5);
		c.add(new JLabel("                                                   "));
		c.add(label12);
		c.add(b4);
		c.add(new JLabel("                                                   "));
		c.add(label13);
		c.add(b5);
		

		c.add(new JLabel("                      "));
		c.add(ta1);
		c.add(new JLabel("     "));
		c.add(ta2);
		c.add(new JLabel("                               "));
		c.add(button1);

		c.add(new JLabel("                                        "));
		c.add(button3);
		c.add(new JLabel("                                        "));
		c.add(new JLabel("                                          "));
		c.add(button4);
		button1.addActionListener(this);//对按钮1进行监听
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		this.getContentPane().setBackground(Color.gray);

		}
	public void actionPerformed(ActionEvent e){

		    Course p = null;
	    	Course q = null;
	    	Course r = null;
	    	Students students = null;
	    	Course course = null;
	    	p  = new Course("物理", "571", "教102","2.5","4.0");
	    	q  = new Course("离散", "341", "教101","3.0","3.0");
	    	r  = new Course("体育", "122", "教204","1.5","5.0");//调用Course类、Students类，实例化三个课程属性
			if(e.getSource()==button1)
				ta1.append("姓名："+t1.getText()+"\n"+
				"学号："+t2.getText()+"\n"+"性别："
				+cbg.getSelectedCheckbox().getLabel());//选择按钮1后对显示的内容进行录入
				if(c1.isSelected() && e.getSource()==button1)
					ta1.append( "课程：" + c1.getLabel()+" "+p.toString()+"\n");
					students = new Students(t1.getText(),t2.getText(),cbg.getSelectedCheckbox().getLabel(),p);//若同时选择了c1选择项和按钮1则在显示框中体现如下内容，同时调用Students方法将信息录入
				if(c2.isSelected() && e.getSource()==button1)
					ta1.append( "课程：" + c2.getLabel()+" "+q.toString()+"\n");
					students = new Students(t1.getText(),t2.getText(),cbg.getSelectedCheckbox().getLabel(),q);
				if(c3.isSelected() && e.getSource()==button1)
					ta1.append( "课程：" + c3.getLabel()+" "+r.toString()+"\n");
					students = new Students(t1.getText(),t2.getText(),cbg.getSelectedCheckbox().getLabel(),r);
					ta1.append("\n");
			
			if(e.getSource()==button3)ta2.append("教师姓名："+t3.getText()+"\n"+"课程名称："+t4.getText()+"\n"+"上课地点："+t6.getText()+"\n"+"课程编号："+t5.getText()+"\n"+"课时："+b4.getSelectedItem()
			+"\n"+"学分："+b5.getSelectedItem()+"\n");
			
			course = new Course(t4.getText(),t5.getText(),t6.getText(),t7.getText(),t8.getText());//同理于上一步，判断选择按钮3后调用Course方法将教

	}
	public static void main(String[] args){
		Gui g = new Gui();
	}
}
