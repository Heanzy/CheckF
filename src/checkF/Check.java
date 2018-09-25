package checkF;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.logging.FileHandler;

import javax.swing.JFileChooser;
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
    public void CleanArray() {
    	data.clear();
    	average.clear();
    }
   public void setDatabase() {
	   try {
//		JFileChooser jFileChoosera = new JFileChooser();
//   		jFileChoosera.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
//   		JFileChooser jFileChooserb = new JFileChooser();
//   		jFileChooserb.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
//   		int returnVala = jFileChoosera.showOpenDialog(null);
//   		File file_chooseda = jFileChoosera.getSelectedFile();
//   		int returnValb = jFileChooserb.showOpenDialog(null);
//   		File file_choosedb = jFileChooserb.getSelectedFile();
   		File filea = new File("C:/CheckF/src/checkF/FCheck(a).txt");
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
			
		} catch (Exception e) {
			// TODO: handle exception
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
    				data.get(i-start[0]).add(Double.valueOf(table.getValueAt(i, j).toString()));//�������������
    			System.out.println("ok");
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
public int [] FindTableDataStart(JTable table) {
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
	System.out.println("��ʼ�����ǣ�"+start[0]+start[1]);	
			
	
	return start;
    }
    public void outputToconsole(){


            Check main1 = new Check();
            main1.setDataFromFile();

            main1.setAverage();
            for(Double e:main1.getAverage())
            	System.out.println(e);
            main1.setN1();
            System.out.println(main1.getN1());
            main1.setAverageX();
            System.out.println(main1.getAverageX());
            main1.setQ1();
            System.out.println(main1.getQ1());
            main1.setQ2();
            System.out.println(main1.getQ2());
            main1.setV1();
            System.out.println(main1.getV1());
            main1.setV2();
            System.out.println(main1.getV2());
            main1.setS1();
            System.out.println(main1.getS1());
            main1.setS2();
            System.out.println(main1.getS2());
            main1.setF();
            System.out.println(main1.getF());

    }
}
