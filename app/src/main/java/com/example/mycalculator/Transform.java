package com.example.mycalculator;

public class Transform {
    private double num1;
    private String num;
    private String[] systemResult = new String[5];

    public Transform(double num1){
        this.num1 = num1;
    }

    public Transform(String num){
        this.num = num;
    }

    public double[] getLengthResult(int item){
        double[] lengthResult=new double[11];
        switch(item){
            case 0://千米
                lengthResult[1] = num1;//千米
                lengthResult[2] = 1000*num1;//米
                lengthResult[3] = 10000*num1;//分米
                lengthResult[4] = 100000*num1;//厘米
                lengthResult[5] = 1000000*num1;//毫米
                lengthResult[6] = 1E9*num1;//微米
                lengthResult[7] = 1E12*num1;//纳米
                lengthResult[8] = 1E15*num1;//皮米
                lengthResult[9] = 39370*num1;//英寸
                lengthResult[10] = 3280.84*num1;//英尺
                break;
            case 1://米
                lengthResult[1] = 0.001*num1;//千米
                lengthResult[2] = num1;//米
                lengthResult[3] = 10*num1;//分米
                lengthResult[4] = 100*num1;//厘米
                lengthResult[5] = 1000*num1;//毫米
                lengthResult[6] = 1000000*num1;//微米
                lengthResult[7] = 1E9*num1;//纳米
                lengthResult[8] = 1E12*num1;//皮米
                lengthResult[9] = 39.370*num1;//英寸
                lengthResult[10] = 3.28084*num1;//英尺
                break;
            case 2://分米
                lengthResult[1] = 0.0001*num1;//千米
                lengthResult[2] = 0.1*num1;//米
                lengthResult[3] = num1;//分米
                lengthResult[4] = 10*num1;//厘米
                lengthResult[5] = 100*num1;//毫米
                lengthResult[6] = 100000*num1;//微米
                lengthResult[7] = 1E8*num1;//纳米
                lengthResult[8] = 1E11*num1;//皮米
                lengthResult[9] = 3.9370*num1;//英寸
                lengthResult[10] = 0.328084*num1;//英尺
                break;
            case 3://厘米
                lengthResult[1] = 0.00001*num1;//千米
                lengthResult[2] = 0.01*num1;//米
                lengthResult[3] = 0.1*num1;//分米
                lengthResult[4] = num1;//厘米
                lengthResult[5] = 10*num1;//毫米
                lengthResult[6] = 10000*num1;//微米
                lengthResult[7] = 1E7*num1;//纳米
                lengthResult[8] = 1E10*num1;//皮米
                lengthResult[9] = 0.39370*num1;//英寸
                lengthResult[10] = 0.0328084*num1;//英尺
                break;
            case 4://毫米
                lengthResult[1] = 0.000001*num1;//千米
                lengthResult[2] = 0.001*num1;//米
                lengthResult[3] = 0.01*num1;//分米
                lengthResult[4] = 0.1*num1;//厘米
                lengthResult[5] = num1;//毫米
                lengthResult[6] = 1000*num1;//微米
                lengthResult[7] = 1E6*num1;//纳米
                lengthResult[8] = 1E9*num1;//皮米
                lengthResult[9] = 0.039370*num1;//英寸
                lengthResult[10] = 0.00328084*num1;//英尺
                break;
            case 5://微米
                lengthResult[1] = 1E-9*num1;//千米
                lengthResult[2] = 1E-6*num1;//米
                lengthResult[3] = 1E-5*num1;//分米
                lengthResult[4] = 0.0001*num1;//厘米
                lengthResult[5] = 0.001*num1;//毫米
                lengthResult[6] = num1;//微米
                lengthResult[7] = 1000*num1;//纳米
                lengthResult[8] = 1000000*num1;//皮米
                lengthResult[9] = 0.0000394*num1;//英寸
                lengthResult[10] = 3.2808E-6*num1;//英尺
                break;
            case 6://纳米
                lengthResult[1] = 1E-12*num1;//千米
                lengthResult[2] = 1E-9*num1;//米
                lengthResult[3] = 1E-8*num1;//分米
                lengthResult[4] = 1E-7*num1;//厘米
                lengthResult[5] = 1E-6*num1;//毫米
                lengthResult[6] = 0.001*num1;//微米
                lengthResult[7] = num1;//纳米
                lengthResult[8] = 1000*num1;//皮米
                lengthResult[9] = 3.9370E-8*num1;//英寸
                lengthResult[10] = 3.2808E-9*num1;//英尺
                break;
            case 7://皮米
                lengthResult[1] = 1E-15*num1;//千米
                lengthResult[2] = 1E-12*num1;//米
                lengthResult[3] = 1E-11*num1;//分米
                lengthResult[4] = 1E-10*num1;//厘米
                lengthResult[5] = 1E-9*num1;//毫米
                lengthResult[6] = 0.000001*num1;//微米
                lengthResult[7] = 0.001*num1;//纳米
                lengthResult[8] = num1;//皮米
                lengthResult[9] = 3.9370E-11*num1;//英寸
                lengthResult[10] = 3.2808E-12*num1;//英尺
                break;
            case 8://英寸
                lengthResult[1] = 0.0000254*num1;//千米
                lengthResult[2] = 0.0254*num1;//米
                lengthResult[3] = 0.254*num1;//分米
                lengthResult[4] = 2.54*num1;//厘米
                lengthResult[5] = 25.4*num1;//毫米
                lengthResult[6] = 25400*num1;//微米
                lengthResult[7] = 25400000*num1;//纳米
                lengthResult[8] = 2.54E10*num1;//皮米
                lengthResult[9] = num1;//英寸
                lengthResult[10] = 0.0833333*num1;//英尺
                break;
            case 9://英尺
                lengthResult[1] = 0.0003048	*num1;//千米
                lengthResult[2] = 0.3048*num1;//米
                lengthResult[3] = 3.048*num1;//分米
                lengthResult[4] = 30.48*num1;//厘米
                lengthResult[5] = 304.8*num1;//毫米
                lengthResult[6] = 304800*num1;//微米
                lengthResult[7] = 304800000*num1;//纳米
                lengthResult[8] = 3.048E11*num1;//皮米
                lengthResult[9] = 12*num1;//英寸
                lengthResult[10] = num1;//英尺
                break;
        }

        return lengthResult;
    }

    public String[] getSystemResult(int item){
        String[] systemResult=new String[5];
        switch(item){
            case 0://二进制
                systemResult[1] = num;//二进制
                systemResult[2] = Integer.toOctalString(Integer.parseInt(num,2));//八进制
                systemResult[3] = Integer.toHexString(Integer.parseInt(num,2));//十六进制
                systemResult[4] = Integer.parseInt(num,2)+"";//十进制
                break;
            case 1://八进制
                systemResult[1] = Integer.toBinaryString(Integer.parseInt(num,8));;//二进制
                systemResult[2] = num;//八进制
                systemResult[3] = Integer.toHexString(Integer.parseInt(num,8));//十六进制
                systemResult[4] = Integer.parseInt(num,8)+"";//十进制
                break;
            case 2://十六进制
                systemResult[1] = Integer.toBinaryString(Integer.parseInt(num,16));//二进制
                systemResult[2] = Integer.toOctalString(Integer.parseInt(num,16));//八进制
                systemResult[3] = num;//十六进制
                systemResult[4] = Integer.parseInt(num,16)+"";//十进制
                break;
            case 3://十进制
                systemResult[1] = Integer.toBinaryString(Integer.parseInt(num,10));//二进制
                systemResult[2] = Integer.toOctalString(Integer.parseInt(num,10));//八进制
                systemResult[3] = Integer.toHexString(Integer.parseInt(num,10));//十六进制
                systemResult[4] = num;//十进制
                break;
        }
        return systemResult;
    }

}
