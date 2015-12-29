package duel.skill.warriorSkill;

import duel.Const;
import duel.Hero;
import duel.Main;
import duel.RandomIntList;
import duel.Skill;
import duel.U;

public class WarW extends Skill
{
    private double xishu = 0.4;

    public WarW(Hero caster, Hero target)
    {
        this.mark = "W";
        this.name = "�𵴲�";
        this.caster = caster;
        this.target = target;
    }

    @Override
    public int perform()
    {
        double d = U.critical(caster);
        U.showCrit(caster, d);
        int ran = RandomIntList.getInstance().getNext() / 1000;
        Main.damage = xishu * (95 + ran) * (caster.gj + 15) / (target.fy + 15)
                * d;
        U.incCaster(caster, Main.damage);
        for (Skill skill : target.skillList)
            skill.cast = false;
        for (Skill skill : target.ultList)
            skill.cast = false;

        U.waitSeconds(Const.INTERVEL / 2);
        U.dayin(caster.name + "ʹ����<" + this.name + ">,�����"
                + (int) (Main.damage + 0.5) + "���˺�����ʹ�Է����ԣ�");
        return 0;
    }

}
