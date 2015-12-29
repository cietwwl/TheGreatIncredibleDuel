package duel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class U
{
    /**
     * 在控制台上读取一行字符串
     * 
     * @return 读取的字符串，如果读取失败会返回字符串"null"
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
     * 打印一行字符串到控制台
     * 
     * @param str
     *            要打印的内容
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
        U.dayin(enemy.name + "已经爬不起来了.");
    }

    public static void showXl(Hero p)
    {
        waitSeconds(Const.INTERVEL / 2);
        U.dayin(p.name + "**生命:" + p.xl + "**能量:" + p.ql + "**攻击:" + p.gj
                + "**防御:" + p.fy);
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
        U.dayin(attacker.name + "获得了胜利！");
    }

    public static Boolean showSkillList(Hero caster)
    {
        String list = "";
        boolean cast = false;
        for (Skill skill : caster.skillList)
            if (1 == skill.area)
            {
                list = list + skill.describeSkill();
                if (false == skill.cast)
                    list = list + "X";
                list = list + "\t";
                cast = true;
            }
        for (Skill skill : caster.ultList)
            if (1 == skill.area)
            {
                list = list + skill.describeUlt();
                if (false == skill.cast)
                    list = list + "X";
                list = list + "\t";
                cast = true;
            }
        dayin(caster.name + "请选择技能：");
        dayin(list);
        return(cast);
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
        return d;
    }

    public static void showCrit(Hero caster, double d)
    {
        if (1.2 == d)
            U.dayin(caster.name + "轻轻打出一击，命中对手要害");
        else if (1.4 == d)
            U.dayin(caster.name + "打出了致命的一击，效果拔群!");
        else if (0.7 == d)
            U.dayin(caster.name + "发出奋力一击，然而并没有准确命中");
    }

    public static void incCaster(Hero caster, double damage)
    {
        caster.ql = caster.ql + (int) (damage / 10 + 0.5);
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
        waitSeconds(Const.INTERVEL);
        U.dayin("抱歉");
        waitSeconds(Const.INTERVEL * 6);
        U.dayin("XXX对" + caster.name + "施放了死亡一指，造成十万点伤害。");
        waitSeconds(Const.INTERVEL);
        U.dayin(caster.name + "离开了人世。");
        waitSeconds(Const.INTERVEL);
        U.dayin("=========Game Over=========");
        System.exit(0);
    }
}
