package manageSystem;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class Gui extends JFrame implements ActionListener{
    Course course;

	Container c;
	JLabel label1;JLabel label2;JLabel label3;JLabel label5;JLabel label6;//�����ǩ
	JLabel label7;JLabel label8;JLabel label9;JLabel label10,label11;JLabel label12;JLabel label13;
	JButton button1,button2;//���尴ť
	JButton button3,button4;
	TextArea ta1,ta2;//������ʾ��
	JTextField t1,t2,t3,t4,t5,t6,t7,t8;//���嵥�п������
	CheckboxGroup cbg;//�����ѡ����
	JComboBox b4;JComboBox b5;//����������
	JCheckBox c1,c2,c3;//�����ѡ����Ŀ

	String time[]={"24","36","48","72"
			};
	String score[]={"1.0","2.0","3.0","4.0"
			};//��ѧʱ��ѧ��ʵ����
	
	
	public Gui(){
		setTitle("ѧ��ѡ��ϵͳ");//����GUI�ı���
		label1=new JLabel("�����������Ϣ����ѡ�γ�"
				+ "��                                     ");//ѡ����ʽ������Ҫ�ô����Ŀո���и����Ű棬�ҵ���JLabel��������ʵ����
		label7=new JLabel("�����뿪��Ŀγ̺���Ϣ��                                   ");
		label2=new JLabel("ѧ��������");
		label8=new JLabel("��ʦ������");
		label3=new JLabel("�Ա�:");
		cbg = new CheckboxGroup();//����ѡ���� 
		label9=new JLabel("�γ����ƣ�");
		label6=new JLabel("ѧ�ţ�");
		
		label10=new JLabel("�γ̱�ţ�");
		label5=new JLabel("�γ̣�");
		label11=new JLabel("�Ͽεص㣺");
		label12=new JLabel("��ʱ��");
		label13=new JLabel("ѧ�֣�");
		b4=new JComboBox(time);//����JComboBox���������������ʵ����
		b5=new JComboBox(score);
		c1=new JCheckBox("����");//��ѡ����Ŀʵ����
		c2=new JCheckBox("��ɢ");
		c3=new JCheckBox("����");
		ta1=new TextArea(17,35);
		ta2=new TextArea(17,35);
        button1=new JButton("ȷ��");
		button2=new JButton("ȡ��");
		button3=new JButton("ȷ��");
		button4=new JButton("ȡ��");
		t1=new JTextField("",5);
		t2=new JTextField("",10);
		t3=new JTextField("",5);
		t4=new JTextField("",5);
		t5=new JTextField("",5);
		t6=new JTextField("",5);
		t7=new JTextField("",5);
		t8=new JTextField("",5);
		setBounds(600,300,625,600);//���ô��ڴ�С
		try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch(Exception e){}//��ʼ�Դ��ڽ����Ű�
		c=getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.LEFT));//ѡ����ʽ����
		c.add(label1);
		c.add(label7);
		c.add(label2);
		c.add(t1);
		c.add(label3);
		c.add(new Checkbox("��", cbg, true)); //����Checkbox������ѡ����Ŀ����ʵ����
		c.add(new Checkbox("Ů", cbg, false));
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
		button1.addActionListener(this);//�԰�ť1���м���
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
	    	p  = new Course("����", "571", "��102","2.5","4.0");
	    	q  = new Course("��ɢ", "341", "��101","3.0","3.0");
	    	r  = new Course("����", "122", "��204","1.5","5.0");//����Course�ࡢStudents�࣬ʵ���������γ�����
			if(e.getSource()==button1)
				ta1.append("������"+t1.getText()+"\n"+
				"ѧ�ţ�"+t2.getText()+"\n"+"�Ա�"
				+cbg.getSelectedCheckbox().getLabel());//ѡ��ť1�����ʾ�����ݽ���¼��
				if(c1.isSelected() && e.getSource()==button1)
					ta1.append( "�γ̣�" + c1.getLabel()+" "+p.toString()+"\n");
					students = new Students(t1.getText(),t2.getText(),cbg.getSelectedCheckbox().getLabel(),p);//��ͬʱѡ����c1ѡ����Ͱ�ť1������ʾ���������������ݣ�ͬʱ����Students��������Ϣ¼��
				if(c2.isSelected() && e.getSource()==button1)
					ta1.append( "�γ̣�" + c2.getLabel()+" "+q.toString()+"\n");
					students = new Students(t1.getText(),t2.getText(),cbg.getSelectedCheckbox().getLabel(),q);
				if(c3.isSelected() && e.getSource()==button1)
					ta1.append( "�γ̣�" + c3.getLabel()+" "+r.toString()+"\n");
					students = new Students(t1.getText(),t2.getText(),cbg.getSelectedCheckbox().getLabel(),r);
					ta1.append("\n");
			
			if(e.getSource()==button3)ta2.append("��ʦ������"+t3.getText()+"\n"+"�γ����ƣ�"+t4.getText()+"\n"+"�Ͽεص㣺"+t6.getText()+"\n"+"�γ̱�ţ�"+t5.getText()+"\n"+"��ʱ��"+b4.getSelectedItem()
			+"\n"+"ѧ�֣�"+b5.getSelectedItem()+"\n");
			
			course = new Course(t4.getText(),t5.getText(),t6.getText(),t7.getText(),t8.getText());//ͬ������һ�����ж�ѡ��ť3�����Course��������

	}
	public static void main(String[] args){
		Gui g = new Gui();
	}
}
