package duel.skill.warriorSkill;

import duel.Const;
import duel.Hero;
import duel.Main;
import duel.RandomIntList;
import duel.Skill;
import duel.U;
import duel.buff.Stun;

public class WarW extends Skill
{
    private double xishu = 0.4;
    String buffType = "Stun";

    public WarW(Hero caster, Hero target)
    {
        this.mark = "W";
        this.name = "�𵴲�";
        this.caster = caster;
        this.target = target;
        this.skillType = 1;
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
        target.buffList.add(new Stun(caster, target));

        U.incCaster(caster, Main.damage);

        U.waitSeconds(Const.INTERVEL / 2);
        U.dayin(caster.name + "ʹ����<" + this.name + ">,�����"
                + (int) (Main.damage + 0.5) + "���˺�����ʹ�Է����ԣ�");
        return 0;
    }

}
