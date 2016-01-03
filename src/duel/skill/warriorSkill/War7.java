package duel.skill.warriorSkill;

import duel.Buff;
import duel.Const;
import duel.Hero;
import duel.Main;
import duel.Skill;
import duel.U;

public class War7 extends Skill
{

    public War7(Hero caster, Hero target)
    {
        this.mark = "7";
        this.name = "�Ƶ�ŭ��";
        this.caster = caster;
        this.target = target;
    }

    @Override
    public int perform()
    {
        String strBuff = "";
        if (1 == Main.half)
        {
            if (target.gj > Main.gj1)
            {
                target.gj = Main.gj1;
                strBuff = strBuff + "  ���ӹ���";
            } else if (target.fy > Main.fy1)
            {
                target.fy = Main.fy1;
                strBuff = strBuff + "  ���ӷ���";
            }
        } else
        {
            if (target.gj > Main.gj2)
            {
                target.gj = Main.gj2;
                strBuff = strBuff + "  ���ӹ���";
            } else if (target.fy > Main.fy2)
            {
                target.fy = Main.fy2;
                strBuff = strBuff + "  ���ӷ���";
            }
        }

        int index = -1;
        do
        {
            index = -1;
            for (Buff buff : target.buffList)
                if (1 == buff.Quality)
                    index = target.buffList.indexOf(buff);
            if (index > -1)
            {
                strBuff = strBuff + "  *" + target.buffList.get(index).name;
                target.buffList.remove(index);
            }
        } while (index > -1);
        if (strBuff.equals(""))
            strBuff = "��";

        caster.ultList.get(2).ultNum = caster.ultList.get(2).ultNum + 12;
        if (target.ql > 50)
            target.ql = target.ql - 50;
        else
            target.ql = 0;
        caster.ql = caster.ql + 20;

        U.waitSeconds(Const.INTERVEL / 2);
        U.dayin(caster.name + "ʹ����<" + this.name + ">,����ס�˵з�����ɢ�Է���Ч" + strBuff);
        return 0;
    }

}
