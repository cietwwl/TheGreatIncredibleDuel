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
        this.name = "寒冰护体";
        this.type = "hbht";
        this.Quality = 1;
        this.roundNum = 4;
        this.caster = caster;
        this.target = target;
    }

    @Override
    public void buffOn()
    {
        if ((caster.equals(Main.target)) && (false == Main.ignDamDec))
        {
            double finalDam = xishu * Main.damage;
            int decDam = (int) (Main.damage - finalDam + 0.5);
            Main.damage = finalDam;
            U.dayin(target.name + "的  *" + this.name + "  生效，减少" + decDam
                    + "点伤害");
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

    }

    @Override
    public void roundEndDo()
    {
        if (this.roundNum > 0)
        {
            buffOn();
            this.roundNum--;
        }
    }
}
