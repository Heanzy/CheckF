package checkF;
import java.io.*;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.logging.FileHandler;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Check {
    ArrayList<ArrayList<Double>> data = new ArrayList<ArrayList<Double>>();
    ArrayList<ArrayList<Double>> database = new ArrayList<ArrayList<Double>>();
    ArrayList<Double> average = new ArrayList<>();
    double averageX;
     int n;
     int m;
    int N1;
    double Q1;
    double Q2;
    int v1;
    int v2;
    double s1;
    double s2;
    double F;
    double S;
    public double getS() {
		return S;
	}
    public void setS() {
    	double sum = 0d;
    	for(ArrayList<Double> E:data)
    		for(double e: E)
    			sum += (e-averageX)*(e-averageX)/(N1-1);
    	S = Math.sqrt(sum);
	}
    public void CleanArray() {
    	data.clear();
    	average.clear();
    }
   public void setDatabase(String a) {
	   try {
//		JFileChooser jFileChoosera = new JFileChooser();
//   		jFileChoosera.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
//   		JFileChooser jFileChooserb = new JFileChooser();
//   		jFileChooserb.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
//   		int returnVala = jFileChoosera.showOpenDialog(null);
//   		File file_chooseda = jFileChoosera.getSelectedFile();
//   		int returnValb = jFileChooserb.showOpenDialog(null);
//   		File file_choosedb = jFileChooserb.getSelectedFile();
		File filea = null;
		if(a.equals("0.05"))
			filea = new File("src/checkF/FCheck(a).txt");
		if(a.equals("0.01"))
			filea = new File("src/checkF/FCheck(b).txt");
   		//File fileb = new File("C:/CheckF/src/checkF/FCheck(b).txt");
   		System.out.println("FileOK");
		BufferedReader bra = new BufferedReader(new FileReader(filea));
		//BufferedReader brb = new BufferedReader(new FileReader(fileb));
		System.out.println("BufferOK");
		String everyline;
		//Iterator<ArrayList<Double>> iterator = database.iterator();
		while((everyline=bra.readLine())!=null){
			System.out.println(everyline);
			ArrayList<Double> tempA = new ArrayList<>();			
			String [] temp=everyline.split("\t");
			
			for(int i = 0;i<temp.length;i++)
				tempA.add(Double.parseDouble(temp[i]));
			System.out.println(tempA.size());
			database.add(tempA);
		}
		bra.close();
		//brb.close();
	} catch (IOException e) {
		// TODO: handle exception
		System.out.println(e.getMessage());
		System.out.println("error");
	}
   }
   public ArrayList<ArrayList<Double>> getDatabase() {
	return database;
}
    public void setAverageX() {
        Double sum = 0d;
        for(ArrayList<Double> E:data){

            for(Double e:E){
                sum += e;
            }
        }
        averageX = (double)(sum/N1);
    }

    public double getAverageX() {
        return averageX;
    }

    public void setAverage() {
        for(ArrayList<Double> E:data){
            Double sum = 0d;
            for(Double e:E){
                sum += e;
            }
            average.add((double)(sum/E.size()));
        }
    }

    public ArrayList<Double> getAverage() {
        return average;
    }

    public void setN1() {
        N1 = n*m;
    }

    public int getN1() {
        return N1;
    }

    public void setDataFromFile() {
    	try {
    		JFileChooser jFileChooser = new JFileChooser();
    		jFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
    		int returnVal = jFileChooser.showOpenDialog(null);
    		File file_choosed = jFileChooser.getSelectedFile();
    		
    		//File file = new File("C:/Users/Heanzy/workspace/checkF/src/checkF/data.txt");
            BufferedReader br = new BufferedReader(new FileReader(file_choosed));
            //BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            String [] nam = br.readLine().split("\t");
            System.out.println(nam[0]);
            setM(Integer.parseInt(nam[0]));
            setN(Integer.parseInt(nam[1]));
            for(int i = 0;i<getM();i++){
                String temp = br.readLine();
                System.out.println(temp);
                String [] sp = temp.split("\t");
                getData().add(new ArrayList<Double> ());
                for(int j = 0;j < sp.length;j++){
                	
                    getData().get(i).add( Double.parseDouble(sp[j]));              
                }
                System.out.println();

            }
			
		} catch (IOException e) {
			// TODO: handle exception
			//JOptionPane.showMessageDialog(null, "读取失败", "标题",JOptionPane.WARNING_MESSAGE);  
			System.out.println("error");
		}
    	
    }

    public void setM(int m) {
        this.m = m;
    }

    public void setF() {
        F = s1/s2;
    }

    public  void setN(int n) {
        this.n = n;
    }

    public void setQ1() {
        for(Double E:average){
            Q1 += n*(E-averageX)*(E-averageX);
        }
    }

    public void setQ2() {
        for(int i = 0;i<data.size();i++){
            for(int j = 0;j<data.get(i).size();j++)
                Q2 += (data.get(i).get(j)-average.get(i))*(data.get(i).get(j)-average.get(i));
        }
    }

    public void setS1() {
        s1 = Q1/v1;
    }

    public void setV1() {
        v1 = m -1;
    }

    public void setV2() {
        v2 = n*m - m;
    }

    public void setS2() {
        s2 = Q2/v2;
    }

    public ArrayList<ArrayList<Double>> getData() {
        return data;
    }

    public double getQ1() {
        return Q1;
    }

    public double getQ2() {
        return Q2;
    }

    public double getF() {
        return F;
    }

    public double getS1() {
        return s1;
    }

    public  int getM() {
        return m;
    }

    public double getS2() {
        return s2;
    }

    public  int getN() {
        return n;
    }

    public int getV1() {
        return v1;
    }

    public int getV2() {
        return v2;
    }
    public void setTableData(JTable table,int []start){
    	int row = table.getRowCount();
    	System.out.println(row);
    	int column = table.getColumnCount();
    	System.out.println(column);
    	for(int i = start[0];i< start[0]+m;i++){
    		data.add(new ArrayList<Double>());
    		for(int j = start[1];j< start[1]+n;j++){
    			if(table.getValueAt(i, j) != "")
    				data.get(i-start[0]).add(Double.valueOf(table.getValueAt(i, j).toString()));//这里可能有问题
    			System.out.println(data);
    		}
    	}
    		
    }
    public double getTableCheck(int v1,int v2) {
    	return database.get(v2-1).get(v1-1);
    }
    public int setNFromTable(JTable table,int [] start) {
    	int column = table.getColumnCount();
    	int row = table.getRowCount();
    	int N = 0;
    	for(int i = start[1];i<column;i++)
    		if(table.getValueAt(start[0], i)!="")
    			N++;
    	return N;		
    }
    public int setMFromTable(JTable table,int [] start) {
    	int row = table.getRowCount();
    	int M = 0;
    	for(int i = start[0];i<row;i++)
    		if(table.getValueAt(i, start[1])!="")
    			M++;
    	return M;	
    }
    public int FindTableDataStartRow(JTable table) {
    	int row = table.getRowCount();
    	int M = 0;
    	for(int i = 0;i<row;i++)
    		if(table.getValueAt(i, 0)=="")
    			M++;
    	return M;	
    }
public int [] FindTableDataStart(JTable table)throws Exception {
	int [] start =new int[2];
	int column = table.getColumnCount();
	int row = table.getRowCount();
	int N = 0;
	boolean isFound = false;
	for(int i = 0;i<row&&!isFound;i++)
		for(int j = 0;j<column&&!isFound;j++){
			if(table.getValueAt(i, j)!=""){
				start[0]=i;
				start[1]=j;
				isFound = true;
			}
		}
	System.out.println("起始坐标是："+start[0]+start[1]);	
	if(!isFound)
		throw new Exception();
	
	return start;
    }
	/*
	 * F保留两位小数
	 */
	public String RetainedDecimal2F(){
		 NumberFormat nf = NumberFormat.getNumberInstance();
		 // 保留两位小数
		 nf.setMaximumFractionDigits(2); 
		 // 如果不需要四舍五入，可以使用RoundingMode.DOWN
		 nf.setRoundingMode(RoundingMode.UP);
		 return nf.format(F);
	}
	/*
	 * 总平均值保留两位小数
	 */
	public String RetainedDecimal2AverageX(){
		 NumberFormat nf = NumberFormat.getNumberInstance();
		 // 保留两位小数
		 nf.setMaximumFractionDigits(2); 
		 // 如果不需要四舍五入，可以使用RoundingMode.DOWN
		 nf.setRoundingMode(RoundingMode.UP);
		 return nf.format(averageX);
	}
	/*
	 * 组间方差保留两位小数
	 */
	public String RetainedDecimal2S1(){
		 NumberFormat nf = NumberFormat.getNumberInstance();
		 // 保留两位小数
		 nf.setMaximumFractionDigits(2); 
		 // 如果不需要四舍五入，可以使用RoundingMode.DOWN
		 nf.setRoundingMode(RoundingMode.UP);
		 return nf.format(s1);
	}
	/*
	 * 组内方差保留两位小数
	 */
	public String RetainedDecimal2S2(){
		 NumberFormat nf = NumberFormat.getNumberInstance();
		 // 保留两位小数
		 nf.setMaximumFractionDigits(2); 
		 // 如果不需要四舍五入，可以使用RoundingMode.DOWN
		 nf.setRoundingMode(RoundingMode.UP);
		 return nf.format(s2);
	}
	/*
	 * 总标准差保留两位小数
	 */
	public String RetainedDecimal2S(){
		 NumberFormat nf = NumberFormat.getNumberInstance();
		 // 保留两位小数
		 nf.setMaximumFractionDigits(2); 
		 // 如果不需要四舍五入，可以使用RoundingMode.DOWN
		 nf.setRoundingMode(RoundingMode.UP);
		 return nf.format(S);
	}
	
	public String RetainedDecimal3F(){
		 NumberFormat nf = NumberFormat.getNumberInstance();
		 // 保留两位小数
		 nf.setMaximumFractionDigits(3); 
		 // 如果不需要四舍五入，可以使用RoundingMode.DOWN
		 nf.setRoundingMode(RoundingMode.UP);
		 return nf.format(F);
	}
	
	public String RetainedDecimal5F(){
		 NumberFormat nf = NumberFormat.getNumberInstance();
		 // 保留两位小数
		 nf.setMaximumFractionDigits(5); 
		 // 如果不需要四舍五入，可以使用RoundingMode.DOWN
		 nf.setRoundingMode(RoundingMode.UP);
		 return nf.format(F);
	}
	public String RetainedDecimal7F(){
		 NumberFormat nf = NumberFormat.getNumberInstance();
		 // 保留两位小数
		 nf.setMaximumFractionDigits(7); 
		 // 如果不需要四舍五入，可以使用RoundingMode.DOWN
		 nf.setRoundingMode(RoundingMode.UP);
		 return nf.format(F);
	}
	
	public String RetainedDecimal3AverageX(){
		 NumberFormat nf = NumberFormat.getNumberInstance();
		 // 保留两位小数
		 nf.setMaximumFractionDigits(3); 
		 // 如果不需要四舍五入，可以使用RoundingMode.DOWN
		 nf.setRoundingMode(RoundingMode.UP);
		 return nf.format(averageX);
	}
	public String RetainedDecimal7AverageX(){
		 NumberFormat nf = NumberFormat.getNumberInstance();
		 // 保留两位小数
		 nf.setMaximumFractionDigits(7); 
		 // 如果不需要四舍五入，可以使用RoundingMode.DOWN
		 nf.setRoundingMode(RoundingMode.UP);
		 return nf.format(averageX);
	}
	public String RetainedDecimal5AverageX(){
		 NumberFormat nf = NumberFormat.getNumberInstance();
		 // 保留两位小数
		 nf.setMaximumFractionDigits(5); 
		 // 如果不需要四舍五入，可以使用RoundingMode.DOWN
		 nf.setRoundingMode(RoundingMode.UP);
		 return nf.format(averageX);
	}
	public String RetainedDecimal3S1(){
		 NumberFormat nf = NumberFormat.getNumberInstance();
		 // 保留两位小数
		 nf.setMaximumFractionDigits(3); 
		 // 如果不需要四舍五入，可以使用RoundingMode.DOWN
		 nf.setRoundingMode(RoundingMode.UP);
		 return nf.format(s1);
	}
	public String RetainedDecimal5S1(){
		 NumberFormat nf = NumberFormat.getNumberInstance();
		 // 保留两位小数
		 nf.setMaximumFractionDigits(5); 
		 // 如果不需要四舍五入，可以使用RoundingMode.DOWN
		 nf.setRoundingMode(RoundingMode.UP);
		 return nf.format(s1);
	}
	public String RetainedDecimal7S1(){
		 NumberFormat nf = NumberFormat.getNumberInstance();
		 // 保留两位小数
		 nf.setMaximumFractionDigits(7); 
		 // 如果不需要四舍五入，可以使用RoundingMode.DOWN
		 nf.setRoundingMode(RoundingMode.UP);
		 return nf.format(s1);
	}
	public String RetainedDecimal3S2(){
		 NumberFormat nf = NumberFormat.getNumberInstance();
		 // 保留两位小数
		 nf.setMaximumFractionDigits(3); 
		 // 如果不需要四舍五入，可以使用RoundingMode.DOWN
		 nf.setRoundingMode(RoundingMode.UP);
		 return nf.format(s2);
	}
	public String RetainedDecimal5S2(){
		 NumberFormat nf = NumberFormat.getNumberInstance();
		 // 保留两位小数
		 nf.setMaximumFractionDigits(5); 
		 // 如果不需要四舍五入，可以使用RoundingMode.DOWN
		 nf.setRoundingMode(RoundingMode.UP);
		 return nf.format(s2);
	}
	public String RetainedDecimal7S2(){
		 NumberFormat nf = NumberFormat.getNumberInstance();
		 // 保留两位小数
		 nf.setMaximumFractionDigits(7); 
		 // 如果不需要四舍五入，可以使用RoundingMode.DOWN
		 nf.setRoundingMode(RoundingMode.UP);
		 return nf.format(s2);
	}
	public String RetainedDecimal3S(){
		 NumberFormat nf = NumberFormat.getNumberInstance();
		 // 保留两位小数
		 nf.setMaximumFractionDigits(3); 
		 // 如果不需要四舍五入，可以使用RoundingMode.DOWN
		 nf.setRoundingMode(RoundingMode.UP);
		 return nf.format(S);
	}
	public String RetainedDecimal5S(){
		 NumberFormat nf = NumberFormat.getNumberInstance();
		 // 保留两位小数
		 nf.setMaximumFractionDigits(5); 
		 // 如果不需要四舍五入，可以使用RoundingMode.DOWN
		 nf.setRoundingMode(RoundingMode.UP);
		 return nf.format(S);
	}
	public String RetainedDecimal7S(){
		 NumberFormat nf = NumberFormat.getNumberInstance();
		 // 保留两位小数
		 nf.setMaximumFractionDigits(7); 
		 // 如果不需要四舍五入，可以使用RoundingMode.DOWN
		 nf.setRoundingMode(RoundingMode.UP);
		 return nf.format(S);
	}
    public   void CalculateFromFile(){
    		 setDataFromFile();
             setAverage();
             for(Double e:getAverage())
             	System.out.println(e);
             setN1();
             System.out.println(getN1());
             setAverageX();
             System.out.println(getAverageX());
             setQ1();
             System.out.println(getQ1());
             setQ2();
             System.out.println(getQ2());
             setV1();
             System.out.println(getV1());
             setV2();
             System.out.println(getV2());
             setS1();
             System.out.println(getS1());
             setS2();
             System.out.println(getS2());
             setF();
             System.out.println(getF());
             setS();
             System.out.println(getS());		                  
    }
    public boolean isPass(){
    	if(F<database.get(v2-1).get(v1-1))
    		return true;
    	else
    		return false;
    }
}
