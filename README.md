一、	实验目的
分析学生选课系统
使用GUI窗体及其组件设计窗体界面
完成学生选课业务逻辑编程
基于文件保存并读取数据
处理异常

二、	实验要求
1.设计GUI窗体，支持学生注册、添加课程、学生选课、学生退课、打印学生选课列表等操作。
2.基于事件模型对业务逻辑编程，实现在界面上支持上述操作。
3.针对操作过程中可能会出现的各种异常，做异常处理。
4.基于输入/输出编程，支持学生、教师等数据的读写操作。

三、  核心代码

              //登录界面
              public  class firstLogin extends JFrame implements  ActionListener{
	      //定义组件
	        JFrame frame=new JFrame();
                JPanel jp1,jp2,jp3;//面板
	        JLabel jlb1,jlb2;//标签
	        JButton jb1,jb2;//按钮
	
		//创建面板
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		//创建标签
		jlb1=new JLabel("请登陆！");
		
		//创建按钮
		jb1=new JButton("学生");
		jb2=new JButton("教师");

		//设置布局管理
		frame.setLayout(new GridLayout(4, 1));//网格式布局
		
		//加入各个组件
		jp1.add(jlb1);
			
		jp3.add(jb1);
		jp3.add(jb2);
		
		
		//加入到JFrame
		frame.add(jp2);
		frame.add(jp1);
		//this.add(jp2);
		frame.add(jp3);
		
		//设置窗体
		frame.setTitle("用户登录界面");//窗体标签
		frame.setSize(400, 300);//窗体大小
		frame.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//退出关闭JFrame
		frame.setVisible(true);//显示窗体
		
		//锁定窗体
		//this.setResizable(false);
				
		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   frame.setVisible(false);
				new ManagerLogin();
			}
		});
    //修改，删除，增加某个学生信息

        class Modify {
        ArrayList<teacher> arry=new ArrayList<teacher>();  			
	public Modify()           //读文件，将文件中的学生信息存放在数组列表
	{
		this.readfile();
	}
	//根据学号查找学生信息，找到返回学号，找不到返回-1
	public int find(String str) 
	{		
	    for (int i = 0; i<arry.size(); i++)
	      if (arry.get(i).getteaID().equals(str))
						return i;//等于在数组列表的位置
			return -1;
	}	
	
	//修改学生信息
	public void update(teacher tea) {
		int flag=find(tea.getteaID());    //查找是否存在
		arry.set(flag, tea);		   //替换 flag 处的学生信息
	}	
	// 读文件
	public boolean readfile() {					 
			String t=null;
			try{
				FileReader f1 = new FileReader("teacher.txt");
				BufferedReader br=new BufferedReader(f1);				
				arry.clear();    //	清除原数组列表中的数据				
				while ((t= br.readLine())!= null)
					{
					  String [] s=t.split("\\s+");				 
					  teacher te=Teacher_information(s[0],s[1],s[2],s[3],s[4],s[5],s[6]);//注意若该文件每行没有七个字符串，则会出错
					  arry.add(te);
					  System.out.println("读取文件：");
					  System.out.println(s[0]);
					}
				     f1.close();
				     br.close();				     
				     return true;
					} catch (IOException e) {
							// TODO 自动生成的 catch 块
					e.printStackTrace();
					return false;
				}	
		     }
	//读取学生信息，展示在窗口

	public class show_stuall2 {	
	
	JTable table = null;
    	DefaultTableModel model = null;
	//显示全部学生信息
   	public show_stuall2() {
	JFrame jf = new JFrame("显示全部信息(点击表头可以按照升序降序排序)");	   
	// 创建内容面板
	JPanel panel = new JPanel();
	// 表头（列名）
	Vector tcolumnNames=createColumnNames();
	 Vector tdata=createTableModelData();	   
	 // 创建一个默认的表格模型
	model = new DefaultTableModel(tdata, tcolumnNames);
	table = new JTable(model);
       	table.setPreferredScrollableViewportSize(new Dimension(400, 80));
       	JScrollPane tablePanel = new JScrollPane(table);  				        
	// 设置表格内容颜色
	....
public class Main {
	 public static void main(String[] args) {
			new firstLogin();
		    }

}
四、运行结果
![image](https://github.com/GuiltyInori/java-/blob/master/1.png)
![image](https://github.com/GuiltyInori/java-/blob/master/3.png)
![image](https://github.com/GuiltyInori/java-/blob/master/2.png)
五、  编程体会
通过这次实验我复习了GUI窗体的设计程序，在之前的基础上添加了文件保存并读取数据的程序，加深了我对输出流和输入流的理解。此外，因此次实验结合了之前学习的内容，在发现并解决问题的过程中，帮助我锻炼了编程思维，加深了我对java编程的理解。
