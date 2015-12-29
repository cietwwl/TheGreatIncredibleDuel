package duel.buff;

import duel.Buff;
import duel.Hero;
import duel.Main;
import duel.U;

public class Hbht extends Buff
{
    double xishu = 0.7;

    public Hbht(Hero caster, Hero target)
    {
        this.name = "��������";
        this.type = "hbht";
        this.roundNum = 4;
        this.caster = caster;
        this.target = target;
    }

    @Override
    public void buffOn()
    {
        if (caster.equals(Main.target))
        {
            double hutiSH = xishu * Main.damage;
            int jsSH = (int) (Main.damage - hutiSH + 0.5);
            Main.damage = hutiSH;
            U.dayin(target.name + "��<" + this.name + ">����Ч��������" + jsSH + "���˺�");
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
        if (this.roundNum > 0)
        {
            buffOn();
            this.roundNum--;
        }
    }

    @Override
    public void roundEndDo()
    {

    }
}
