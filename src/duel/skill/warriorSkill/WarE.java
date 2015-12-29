package duel.skill.warriorSkill;

import duel.Const;
import duel.Hero;
import duel.Main;
import duel.RandomIntList;
import duel.Skill;
import duel.U;

public class WarE extends Skill
{
    private double xishu = 1.6;

    public WarE(Hero caster, Hero target)
    {
        this.mark = "E";
        this.name = "��糵";
        this.caster = caster;
        this.target = target;
    }

    @Override
    public int perform()
    {
        double d = U.critical(caster);
        if (d < 1)
            d = 1;
        U.showCrit(caster, d);
        int ran = RandomIntList.getInstance().getNext() / 1000;
        double extraSH = 0;
        if (caster.gj > target.fy)
            extraSH = xishu * (95 + ran) * (caster.gj + 15) / (target.fy + 15)
                    * d * 2 - xishu * (95 + ran) * d * 2;
        Main.damage = extraSH + xishu * (95 + ran) * (caster.gj + 15) / 100 * d;
        U.incCaster(caster, Main.damage);

        U.waitSeconds(Const.INTERVEL / 2);
        U.dayin(caster.name + "ʹ����<" + this.name + ">,�����"
                + (int) (Main.damage + 0.5) + "���˺�!(����" + (int) extraSH + "��)");
        return 0;
    }

}
