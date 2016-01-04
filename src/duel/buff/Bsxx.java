package duel.buff;

import duel.Buff;
import duel.Hero;
import duel.Main;
import duel.U;

public class Bsxx extends Buff
{
    double xishu = 0.3;

    public Bsxx(Hero caster, Hero target)
    {
        this.name = "��˪����";
        this.type = "bsxx";
        this.Quality = 2;
        this.roundNum = 2;
        this.caster = caster;
        this.target = target;
    }

    @Override
    public void buffOn()
    {
        if ((caster.equals(Main.target)) && (Main.damage > 0))
        {
            Main.damage = 0;
            U.dayin("Ȼ��" + target.name + "ֻ�Ǳ�����ԭ�أ�δ����κ��˺�");
        }
    }

    @Override
    public void buffOff()
    {

    }

    @Override
    public void roundStartDo()
    {

    }

    @Override
    public void roundExecuteDo()
    {
        buffOn();
    }

    @Override
    public void roundEndDo()
    {
        if (this.roundNum > 0)
        {
            this.roundNum--;
        }
    }

}
