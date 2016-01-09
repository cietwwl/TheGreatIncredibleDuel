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
        this.name = "��������";
        this.caster = caster;
        this.target = target;
        this.skillType = 2;
    }

    @Override
    public int perform()
    {
        U.deleteBuffByType(caster, buffType);
        caster.buffList.add(new Hbht(caster, target));

        caster.ultList.get(2).ultNum = caster.ultList.get(2).ultNum + 12;

        U.waitSeconds(Const.INTERVEL / 2);
        U.dayin(caster.name + "ʹ����<" + this.name + ">,����������������");
        return 0;
    }

}
