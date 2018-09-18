package checkF;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.FileHandler;

import javax.swing.JTable;

public class Check {
    ArrayList<ArrayList<Double>> data = new ArrayList<ArrayList<Double>>();
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

    public void setData(ArrayList<ArrayList<Double>> data) {
        this.data = data;
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
    public void getTableData(JTable table){
    	int row = table.getRowCount();
    	int column = table.getColumnCount();
    	for(int i = 1;i<= row;i++){
    		data.add(new ArrayList<Double>());
    		for(int j = 1;j<= column;j++){
    			if(table.getValueAt(row, column) != null)
    				data.get(i-1).add((Double) table.getValueAt(i, j));//这里可能有问题
    		}
    	}
    		
    }
    public void setDataToTable(JTable table){
    	
    }
    public static void main(String [] args){

        try {
            Check main1 = new Check();
            File file = new File("C:/Users/Heanzy/workspace/checkF/src/checkF/data.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            //BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            String [] nam = br.readLine().split("\t");
            System.out.println(nam[0]);
            main1.setM(Integer.parseInt(nam[0]));
            main1.setN(Integer.parseInt(nam[1]));
            for(int i = 0;i<main1.getM();i++){
                String temp = br.readLine();
                System.out.println(temp);
                String [] sp = temp.split("\t");
                main1.getData().add(new ArrayList<Double> ());
                for(int j = 0;j < sp.length;j++){
                	
                    main1.getData().get(i).add( Double.parseDouble(sp[j]));              
                }
                System.out.println();

            }

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
            br.close();
        }catch (IOException E){
        	//E.printStackTrace();
        	System.out.println("error");
        }

    }
}
