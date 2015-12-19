package duel;

public class CreateHero
{
    public int chaju = 30;
    public int zhiye, k;
    public Hero p1, p2;
    int gj = 63, fy = 63, xl = 223; // for���������������
    
    
    
    public CreateHero()
    {
        String input = "";
        U.dayin("�������ܽ��ܵĲ�ࣺ");
        input = U.duqu();
        chaju = U.s2i(input);

        U.dayin("*****��ʼѡ��ְҵ******");

        // p1
        startSuiJi(63, 63, 223);
        U.dayin("��ѡ��һ��ְҵ  1 սʿ  2 ��ʦ");
        input = U.duqu();
        zhiye = U.s2i(input);
        if (zhiye == 1)
        {
            p1 = new Warrior();
            p1.type = 1;
        }
        if (zhiye == 2)
        {
            p1 = new Mage();
            p1.type = 2;
        }
        p1.name = "p1";
        p1.gj = gj;
        p1.fy = fy;
        p1.xl = xl;

        // p2
        startSuiJi(63, 63, 223);
        U.dayin("��ѡ��һ��ְҵ  1 սʿ  2 ��ʦ");
        input = U.duqu();
        zhiye = U.s2i(input);
        if (zhiye == 1)
        {
            p2 = new Warrior();
            p2.type = 1;
        }
        if (zhiye == 2)
        {
            p2 = new Mage();
            p2.type = 2;
        }
        p2.name = "p2";
        p2.gj = gj;
        p2.fy = fy;
        p2.xl = xl;
    }

    private int startSuiJi(int c_gj, int c_fy, int c_xl)
    {
        int sj = 0;
        int total = 0;
        do
        {

            for (int i = 1; i <= 6; i++)
            {
                double sui2ji1 = Math.random() * 10;
                sj = sj + (int) sui2ji1;
            }
            gj = c_gj + sj;
            sj = 0;
            for (int i = 1; i <= 6; i++)
            {
                double sui2ji1 = Math.random() * 10;
                sj = sj + (int) sui2ji1;
            }
            fy = c_fy + sj;
            sj = 0;
            for (int i = 1; i <= 6; i++)
            {
                double sui2ji1 = Math.random() * 20;
                sj = sj + (int) sui2ji1;
            }
            xl = c_xl + sj;
            total = gj + fy + (int) xl * 9 / 28;
            // U.dayin(""+total);
        } while ((total < (270 - chaju)) || (total > (270 + chaju)));
        U.dayin("************************");
        U.dayin("������ = " + gj);
        U.dayin("������ = " + fy);
        U.dayin("����ֵ = " + xl);

        return gj;
    }

    public String startFight()
    {
        while (p1.xl > 0 && p2.xl > 0)
        {
            showXl(p1);
            showXl(p2);
            waitSeconds(Const.iterval*2);

            huihe(p1, p2);

            huihe(p2, p1);
        }

        U.dayin("=========================");
        U.dayin("=========================");
        U.dayin("Ҫ������ ��Y/N��");
        String jixu = U.duqu();
        return jixu;
    }

    private void huihe(Hero attacker, Hero enemy)
    {
        if (attacker.xl > 0)
        {
            waitSeconds(Const.iterval);

            int shanghai = attacker.attack(enemy);
            enemy.xl = enemy.xl - shanghai;
            showShangHai(enemy, shanghai);
            if (enemy.xl <= 0)
            {
                waitSeconds(Const.iterval);
                showDeath(enemy);
                waitSeconds(Const.iterval);
                showWin(attacker);
            }
        }

    }

    private void waitSeconds(double s)
    {
        try
        {
            Thread.sleep((long)(1000 * s));
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    private void showWin(Hero attacker)
    {
        U.dayin(attacker.name + "���ڻ����ʤ����");
    }

    private void showDeath(Hero enemy)
    {
        U.dayin(enemy.name + "�Ѿ�����������.");
    }

    private void showShangHai(Hero enemy, int shanghai)
    {
        U.dayin(enemy.name + "�ܵ���" + shanghai + "���˺���");
    }

    private void showXl(Hero p)
    {
        U.dayin("****" + p.name + "-HP:" + p.xl + "****");
    }

    public static void main(String[] args)
    {
        String jixu = "Y";
        while (jixu.equals("Y"))
        {
            U.dayin("**********��Ϸ��ʼ**************");
            CreateHero ch = new CreateHero();
            jixu = ch.startFight();
            jixu = jixu.toUpperCase();
        }

    }
}
