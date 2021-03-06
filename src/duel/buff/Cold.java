package duel.buff;

import duel.Buff;
import duel.Hero;
import duel.Main;
import duel.Skill;
import duel.U;

public class Cold extends Buff
{
    public boolean cold = false;

    public Cold(Hero caster, Hero target)
    {
        this.name = "冻结";
        this.type = "Cold";
        this.Quality = 2;
        this.roundNum = 3;
        this.caster = caster;
        this.target = target;
    }

    @Override
    public void buffOn()
    {
        if (target.equals(Main.attacker))
        {
            for (Skill skill : target.skillList)
                skill.cast = false;
            for (Skill skill : target.ultList)
                skill.cast = false;
        }
    }

    public void buffOn2()
    {
        if ((target.equals(Main.target)) && (Main.damage > 0)
                && (false == Main.ignDamDec) && (cold))
        {
            Main.damage = 0;
            U.dayin(target.name + "的  *" + this.name + "  生效,伤害被免疫");
        }
    }

    @Override
    public void buffOff()
    {

    }

    @Override
    public void roundStartDo()
    {
        buffOn();
    }

    @Override
    public void roundExecuteDo()
    {

    }

    @Override
    public void roundEndDo()
    {
        buffOn2();
        if (this.roundNum > 0)
            this.roundNum--;
        if (0 == this.roundNum)
            cold = false;
        if (1 == this.roundNum)
            cold = true;
    }

}
