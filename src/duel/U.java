package duel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class U
{
    /**
     * �ڿ���̨�϶�ȡһ���ַ���
     * @return ��ȡ���ַ����������ȡʧ�ܻ᷵���ַ���"null"
     */
    public static String duqu()
    {
        String str = "null";
        try
        {
            BufferedReader strin = new BufferedReader(new InputStreamReader(
                    System.in));

            str = strin.readLine();

        } catch (IOException e)
        {
            e.printStackTrace();
        }
        if (str.equals("gg")){
            
        }
        return str;
    }

    
    /**
     * ��ӡһ���ַ���������̨
     * @param str Ҫ��ӡ������
     */
    public static void dayin(String str)
    {
        System.out.println(str);
    }
    
    public static int s2i(String str){
        int i = Integer.parseInt(str);
        return i;
    }
    
    
    public static void showDeath(Hero enemy)
    {
        waitSeconds(Const.iterval);
        U.dayin(enemy.name + "�Ѿ�����������.");
    }

    public static void showShangHai(Hero enemy, int shanghai)
    {
        waitSeconds(Const.iterval);
        U.dayin(enemy.name + "�ܵ���" + shanghai + "���˺���");
    }

    public static void showXl(Hero p)
    {
        waitSeconds(Const.iterval/2);
        U.dayin("****" + p.name + "-HP:" + p.xl + "****");
    }
    

    public static void waitSeconds(double s)
    {
        try
        {
            Thread.sleep((long)(1000 * s));
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public static void showWin(Hero attacker)
    {
        waitSeconds(Const.iterval);
        U.dayin(attacker.name + "���ڻ����ʤ����");
    }

}
