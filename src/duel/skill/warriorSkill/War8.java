package duel.skill.warriorSkill;

import duel.Const;
import duel.Hero;
import duel.Skill;
import duel.U;
import duel.buff.Dpfs;

public class War8 extends Skill
{
    String buffType = "dpfs";

    public War8(Hero caster, Hero target)
    {
        this.mark = "8";
        this.name = "���Ʒ���";
        this.caster = caster;
        this.target = target;
    }

    @Override
    public int perform()
    {
        U.deleteBuffByType(caster, buffType);
        caster.buffList.add(new Dpfs(caster, target));

        caster.ultList.get(2).ultNum = caster.ultList.get(2).ultNum + 12;

        U.waitSeconds(Const.INTERVEL / 2);
        U.dayin(caster.name + "ʹ����<" + this.name + ">,��ô���Ч");
        return 0;
    }

}