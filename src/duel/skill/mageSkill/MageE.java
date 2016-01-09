package duel.skill.mageSkill;

import duel.Const;
import duel.Hero;
import duel.Main;
import duel.RandomIntList;
import duel.Skill;
import duel.U;
import duel.buff.Cold;
import duel.hero.Mage;

public class MageE extends Skill
{
    private double xishu = 0.8;
    String buffType = "Cold";

    public MageE(Hero caster, Hero target)
    {
        this.mark = "E";
        this.name = "��ȶ���";
        this.caster = caster;
        this.target = target;
        this.skillType = 2;
    }

    @Override
    public int perform()
    {
        double d = U.critical(caster);
        U.showCrit(caster, d);
        int ran = RandomIntList.getInstance().getNext() / 1000;
        Main.damage = xishu * (95 + ran) * (caster.gj + 15) / (target.fy + 15)
                * d;
        U.deleteBuffByType(target, buffType);
        target.buffList.add(new Cold(caster, target));
        Mage m = (Mage) caster;
        m.mageE = true;
        m.coldCount(2, caster, target);
        m.mageE = false;

        U.incCaster(caster, Main.damage);

        U.waitSeconds(Const.INTERVEL / 2);
        U.dayin(caster.name + "ʹ����<" + this.name + ">,�����"
                + (int) (Main.damage + 0.5) + "���˺�,�����Է�����");
        return 0;
    }
}
