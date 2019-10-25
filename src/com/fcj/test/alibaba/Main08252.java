package com.fcj.test.alibaba;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by dormi on 2017/8/25.
 */
public class Main08252 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<UnilateralLine> lineList = new ArrayList<UnilateralLine>();
        while (scanner.hasNextLine()) {
            String[] options = scanner.nextLine().split(";");
            if (options.length < 5) {
                break;
            }
            lineList.add(new UnilateralLine(options[0], options[1], options[2], options[3], options[4], options[5]));
        }
        scanner.close();

        // wirte your code here
        List<String> result = calculateUnilateral(lineList);

        for (String str : result) {
            System.out.println(str);
        }
    }
    public static List<String> calculateUnilateral(List<UnilateralLine> lineList) {
        List<String> result = new ArrayList<String>();

        int num = lineList.size();
        boolean[] flags = new boolean[num];//判断是否被优化
        calRul1(lineList, result, num, flags);
        calRul2(lineList, result, num, flags);
        calRul3(lineList, result, num, flags);

        return result;
    }

    public static void calRul1(List<UnilateralLine> lineList, List<String> result, int num, boolean[] flags){
        for (int i = 0; i < num - 1; i++){
            UnilateralLine line1 = lineList.get(i);
            UnilateralLine line2 = lineList.get(i + 1);

            if (line1.getSCen().equals(line2.getECen()) && line1.getECen().equals(line2.getSCen())
                    && line1.getTType().equals(line2.getTType()) && !flags[i] && !flags[i + 1]){
                result.add("rule1:" + line1.getId() + "+" + line2.getId());
                flags[i] = true;
                flags[i + 1] = true;
            }
        }
    }

    public static void calRul2(List<UnilateralLine> lineList, List<String> result, int num, boolean[] flags){
        for (int i = 0; i < num - 2; i++){
            UnilateralLine line1 = lineList.get(i);
            UnilateralLine line2 = lineList.get(i + 1);
            UnilateralLine line3 = lineList.get(i + 2);

            if (line1.getECen().equals(line2.getSCen()) && line2.getECen().equals(line3.getSCen())
                    && line3.getECen().equals(line1.getSCen()) && line1.getTType().equals(line2.getTType())
                    && line2.getTType().equals(line3.getTType()) && !flags[i] && !flags[i + 1]){
                result.add("rule2:" + line1.getId() + "+" + line2.getId() + "+" + line3.getId());
                flags[i] = true;
                flags[i + 1] = true;
                flags[i + 2] = true;
            }
        }
    }

    public static void calRul3(List<UnilateralLine> lineList, List<String> result, int num, boolean[] flags){
        for (int i = 0; i < num - 1; i++){
            UnilateralLine line1 = lineList.get(i);
            UnilateralLine line2 = lineList.get(i + 1);

            if (line1.getSCen().equals(line2.getECen()) && line1.getEPro().equals(line2.getSPro())
                    && line1.getTType().equals(line2.getTType()) && !flags[i] && !flags[i + 1]){
                result.add("rule3:" + line1.getId() + "+" + line2.getId());
                flags[i] = true;
                flags[i + 1] = true;
            }
        }
    }


    public static class UnilateralLine {
        private String id;
        private String sCen;//出发分拨
        private String sPro;//出发省
        private String eCen;//到达分拨
        private String ePro;//到达省
        //9.6m/17.5m
        private String tType;//车型
        public UnilateralLine(String id, String sCen, String sPro, String eCen, String ePro,String tType) {
            this.id = id;this.sCen = sCen;this.sPro = sPro;this.eCen = eCen;this.ePro = ePro;this.tType = tType;}
        public String getId() {return id;}
        public void setId(String id) {this.id = id;}
        public String getSCen() {return sCen;}
        public void setSCen(String ePro) {this.ePro = ePro;}
        public String getSPro() {return sPro;}
        public void setSPro(String sPro) {this.sPro = sPro;}
        public String getECen() {return eCen;}
        public void setECen(String eCen) {this.eCen = eCen;}
        public String getEPro() {return ePro;}
        public void setEPro(String ePro) {this.ePro = ePro;}
        public String getTType() {return tType;}
        public void setTType(String tType) {this.tType = tType;}
    }
}
