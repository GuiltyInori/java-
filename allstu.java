package manageSystem;

import javax.management.modelmbean.ModelMBean;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;


public class allstu {	
	//读取学生信息，展示在窗口
		
		ArrayList<student> arry=new ArrayList<student>();
		student stu=new student();
		JTable table = null;
	    DefaultTableModel model = null;
		//显示全部学生信息
	   public allstu() {
		    JFrame jf = new JFrame("显示符合条件的学生信息(点击表头可以按照升序降序排序");
		    //jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		    // 创建内容面板
		     JPanel panel = new JPanel();
		    // 表头（列名）
		  //  String[] columnNames ={"序号","学号","姓名","性别","年龄","电话号码","家庭住址","身份证号码" };  	
		    Vector columnNames=createColumnNames();	    
		    //需要查询的符合条件的,用字符串数组f记录		       
			 String [] f = new String [7];
				try{
					FileReader f1 = new FileReader("查询时暂时存放的文件.txt");
					BufferedReader br=new BufferedReader(f1);				
					//arry.clear();//	清除原数组列表中的数据
					String t=null;
					while ((t= br.readLine())!= null)
						{
						  f=t.split("\\s+");			//要查询的学生信息	 
						}
					
										
				  f1.close();
				  br.close();				  				  
					} catch (IOException e) {
								// TODO 自动生成的 catch 块
					e.printStackTrace();						
					}
								
				//记得清空，否则下次查询没有筛选条件时，查询的是上一次的条件
				 File file =new File("查询时暂时存放的文件.txt");
			        try {
			            if(!file.exists()) {
			                file.createNewFile();
			            }
			            FileWriter fileWriter =new FileWriter(file);
			            fileWriter.write("");
			            fileWriter.flush();
			            fileWriter.close();			    		            
			        } catch (IOException e) {
			            e.printStackTrace();			         
			        }		
			    
				//判断需要查询的是那些条件				
				ArrayList List = new ArrayList(); 
				for(int i=0;i<7;i++) {
					if(!f[i].equals("--"))     //需要满足的条件
						List.add(i); 							
				}
				//将满足查询条件的学生信息录入系统				 
				for(int i=0;i<List.size();i++)
					System.out.println(List.get(i));
				try{
						FileReader f1 = new FileReader("student.txt");
						BufferedReader br=new BufferedReader(f1);
						String t=null;
						int flag=0;
				        int t1=0;
				        
						arry.clear();//	清除原数组列表中的数据					
						while ((t= br.readLine())!= null)
							{
							  String [] s=t.split("\\s+");		
							 for(int i=0;i<List.size();i++)
							 {
								 t1=(int) List.get(i);
								 if(f[t1].equals(s[t1])) {
									 flag=flag+1;
								 }
							 }
							  if(flag==List.size()) {
								  student st=new student(s[0],s[1],s[2],s[3],s[4],s[5],s[6]);//注意若该文件每行没有七个字符串，则会出错
								 arry.add(st);
							  }							  
							  flag=0;
							  
							}
						     f1.close();
						     br.close();						     						     
							} catch (IOException e) {
									// TODO 自动生成的 catch 块
							e.printStackTrace();				
						}	
		    	 				
				Vector data=createTableModelData();
				
				// 创建一个默认的表格模型
			    model = new DefaultTableModel(data, columnNames);
			   table = new JTable(model);
		       table.setPreferredScrollableViewportSize(new Dimension(400, 80));
		       JScrollPane tablePanel = new JScrollPane(table);  
				
				
		        // 设置表格内容颜色
		        table.setForeground(Color.BLACK);                   // 字体颜色
		        table.setFont(new Font(null, Font.PLAIN, 14));      // 字体样式
		        table.setSelectionForeground(Color.DARK_GRAY);      // 选中后字体颜色
		        table.setSelectionBackground(Color.LIGHT_GRAY);     // 选中后字体背景
		        table.setGridColor(Color.GRAY);                     // 网格颜色

		        // 设置表头
		        table.getTableHeader().setFont(new Font(null, Font.BOLD, 14));  // 设置表头名称字体样式
		        table.getTableHeader().setForeground(Color.RED);                // 设置表头名称字体颜色
		        table.getTableHeader().setResizingAllowed(false);               // 设置不允许手动改变列宽
		        table.getTableHeader().setReorderingAllowed(false);             // 设置不允许拖动重新排序各列

		        // 设置行高
		        table.setRowHeight(40);

		        // 第一列列宽设置为40
		        table.getColumnModel().getColumn(0).setPreferredWidth(40);
	             
		        // 设置滚动面板视口大小（超过该大小的行数据，需要拖动滚动条才能看到）
		        table.setPreferredScrollableViewportSize(new Dimension(900, 320));
		        //排序器	        
		        RowSorter sorter = new TableRowSorter(model);
		        table.setRowSorter(sorter);
		        JScrollPane pane = new JScrollPane(table);      

		        // 把 表格 放到 滚动面板 中（表头将自动添加到滚动面板顶部）
		        JScrollPane scrollPane = new JScrollPane(table);

		        // 添加 滚动面板 到 内容面板
		        panel.add(scrollPane);
		       // JScrollPane pane = new JScrollPane(table);
		        // 设置 内容面板 到 窗口
		        jf.setContentPane(panel);
		        jf.pack();
		        jf.setSize(900, 600);
		        jf.add(scrollPane, BorderLayout.CENTER);
		        //数据居中显示
		        DefaultTableCellRenderer r = new DefaultTableCellRenderer();   
				r.setHorizontalAlignment(JLabel.CENTER);   
				table.setDefaultRenderer(Object.class, r);
				
				jf.setLocationRelativeTo(null);
				int t=arry.size();
				 //int t=table.getRowCount();
			        if(t<=0){
			        	JOptionPane.showMessageDialog(null, "该系统中没有符合条件的学生！！！");
			        	jf.setVisible(false);
			        }
			        else {
			        	jf.setVisible(true);
			        }
		    }
     private Vector createColumnNames() {
       Vector columnNames = new Vector();
       //columnNames.add("序号");
       columnNames.add("学号");
       columnNames.add("姓名");
       columnNames.add("性别");
       columnNames.add("年龄");
       columnNames.add("电话号码");
       columnNames.add("家庭住址");
       columnNames.add("身份证号码");
    
       return columnNames;
       }

     private Vector createTableModelData() {
    	 Vector data = new Vector();    	     	
         for(int i=0;i<arry.size();i++) {       	 
	    	 Vector<String> rowData=new Vector<>();	    	
	    	 rowData.add(arry.get(i).getStuID());
	    	 rowData.add(arry.get(i).getName());
	    	 rowData.add(arry.get(i).getSex());
	    	 rowData.add(arry.get(i).getAge());
	    	 rowData.add(arry.get(i).getCallnumber());
	    	 rowData.add(arry.get(i).getHome_place());
	    	 rowData.add(arry.get(i).getIdentityID());			    	 		    					  
    		 data.add(rowData);
    					  	    							   
		  }	   
         return data;
	  }  
    
}
