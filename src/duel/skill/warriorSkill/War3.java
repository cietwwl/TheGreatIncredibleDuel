package duel.skill.warriorSkill;

import duel.Const;
import duel.Hero;
import duel.Main;
import duel.RandomIntList;
import duel.Skill;
import duel.U;

public class War3 extends Skill
{
    private double xishu = 0.9;

    public War3(Hero caster, Hero target)
    {
        this.mark = "3";
        this.name = "������";
        this.caster = caster;
        this.target = target;
    }

    @Override
    public int perform()
    {
        double d = U.critical(caster);
        U.showCrit(caster, d);
        int ran = RandomIntList.getInstance().getNext() / 1000;
        int exDam = 0;
        double comDam = xishu * (95 + ran) * (caster.gj + 15)
                / (target.fy + 15) * d;
        if (caster.gj > target.fy)
        {
            Main.damage = xishu * (95 + ran) * (caster.gj + 15)
                    / (target.fy + 15) * d * 2 - xishu * (95 + ran) * d * 1;
            exDam = (int) (Main.damage - comDam);
        } else
            Main.damage = comDam;

        caster.ultList.get(0).ultNum = caster.ultList.get(0).ultNum
                + Main.damage / 10;
        caster.ultList.get(1).ultNum = caster.ultList.get(1).ultNum + exDam
                * 0.4;
        U.incTarget(target, comDam);
        U.incCaster(caster, Main.damage + exDam);

        U.waitSeconds(Const.INTERVEL / 2);
        U.dayin(caster.name + "ʹ����<" + this.name + ">,�����"
                + (int) (Main.damage + 0.5) + "���˺�!(�����˺�" + exDam + "��)");
        return 0;
    }
}
