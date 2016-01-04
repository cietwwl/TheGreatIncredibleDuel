package duel.skill.mageSkill;

import duel.Const;
import duel.Hero;
import duel.Skill;
import duel.U;
import duel.buff.Hbht;

public class Mage7 extends Skill
{
    String buffType = "hbht";

    public Mage7(Hero caster, Hero target)
    {
        this.mark = "7";
        this.name = "寒冰护体";
        this.caster = caster;
        this.target = target;
    }

    @Override
    public int perform()
    {
        U.deleteBuffByType(caster, buffType);
        caster.buffList.add(new Hbht(caster, target));

        caster.ultList.get(0).ultNum = caster.ultList.get(0).ultNum + 12;

        U.waitSeconds(Const.INTERVEL / 2);
        U.dayin(caster.name + "使用了<" + this.name + ">,获得此特效");
        return 0;
    }

}
