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
}
