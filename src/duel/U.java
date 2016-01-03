package duel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class U
{
    /**
     * �ڿ���̨�϶�ȡһ���ַ���
     * 
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
        return str;
    }

    /**
     * ��ӡһ���ַ���������̨
     * 
     * @param str
     *            Ҫ��ӡ������
     */
    public static void dayin(String str)
    {
        System.out.println(str);
    }

    public static int s2i(String str)
    {
        int i = Integer.parseInt(str);
        return i;
    }

    public static void showDeath(Hero enemy)
    {
        waitSeconds(Const.INTERVEL);
        U.dayin(enemy.name + "�Ѿ�����������.");
    }

    public static void showXl(Hero p)
    {
        waitSeconds(Const.INTERVEL / 2);
        String strBuff = "";
        for (Buff buff : p.buffList)
        {
            if (buff.roundNum > 0)
                strBuff = strBuff + "  *" + buff.name;
            buff.roundStartDo();
        }
        U.dayin(p.name + "\t����:" + p.xl + "\t����:" + p.ql + "\t����:" + p.gj
                + "\t����:" + p.fy + "  " + strBuff);
    }

    public static void waitSeconds(double s)
    {
        try
        {
            Thread.sleep((long) (1000 * s));
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public static void showWin(Hero attacker)
    {
        waitSeconds(Const.INTERVEL * 2);
        U.dayin(attacker.name + "�����ʤ����");
    }

    public static Boolean showSkillList(Hero caster)
    {
        String list = "";
        boolean cast = false;
        for (Skill skill : caster.skillList)
            if (1 == skill.area)
            {
                if (!skill.cast)
                    list = list + "X";
                list = list + skill.describeSkill() + "\t";
                if (skill.cast)
                    cast = true;
            }
        for (Skill skill : caster.ultList)
            if (1 == skill.area)
            {
                if (!skill.cast)
                    list = list + "X";
                list = list + skill.describeUlt() + "\t";
                if (skill.cast)
                    cast = true;
            }
        dayin(caster.name + "��ѡ���ܣ�");
        dayin(list);
        return (cast);
    }

    public static void deleteBuffByType(Hero target, String buffType)
    {
        int index = -1;
        do
        {
            index = -1;
            for (Buff buff : target.buffList)
                if (buff.type.equals(buffType))
                    index = target.buffList.indexOf(buff);
            if (index > -1)
                target.buffList.remove(index);
        } while (index > -1);
    }

    public static void deleteBuffByNum(Hero target)
    {
        int index = -1;
        do
        {
            index = -1;
            for (Buff buff : target.buffList)
                if (buff.roundNum <= 0)
                    index = target.buffList.indexOf(buff);
            if (index > -1)
                target.buffList.remove(index);
        } while (index > -1);
    }

    public static double critical(Hero caster)
    {
        int crit = RandomIntList.getInstance().getNext() % 100 + 1;
        double d = 1;
        if (crit <= 15)
            d = 1.2;
        else if (crit <= 20)
            d = 1.4;
        else if (crit <= 35)
            d = 0.7;
        for (Critical c : Main.critList)
            d = c.buffCrit(d, caster);
        return d;
    }

    public static void showCrit(Hero caster, double d)
    {
        if (1.2 == d)
            U.dayin(caster.name + "������һ�������ж���Ҫ��");
        else if (1.4 == d)
            U.dayin(caster.name + "�����������һ����Ч����Ⱥ!");
        else if (0.7 == d)
            U.dayin(caster.name + "��������һ����Ȼ����û��׼ȷ����");
        else if (1.8 == d)
            U.dayin(caster.name + "����һ��������ɶ��˺���");
    }

    public static void incCaster(Hero caster, double damage)
    {
        caster.ql = caster.ql + (int) (damage / 12 + 0.5);
    }

    public static void incTarget(Hero target, double damage)
    {
        target.ql = target.ql + (int) (damage / 20 + 0.5);
    }

    public static void over(Hero caster)
    {
        String ss = U.duqu();
        ss = U.duqu();
        ss = U.duqu();
        ss = ss + " ";
        waitSeconds(Const.INTERVEL * 3);
        U.dayin("��Ǹ");
        waitSeconds(Const.INTERVEL * 3);
        U.dayin("��������");
        waitSeconds(Const.INTERVEL * 2);
        U.dayin("XXX��" + caster.name + "ʩ��������һָ�����ʮ����˺���");
        waitSeconds(Const.INTERVEL * 2);
        U.dayin(caster.name + "�뿪��������");
        waitSeconds(Const.INTERVEL * 2);
        U.dayin("=========Game Over=========");
        System.exit(0);
    }
}
