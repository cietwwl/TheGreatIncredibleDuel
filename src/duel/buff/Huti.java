package duel.buff;

import duel.Buff;
import duel.CreateHero;
import duel.Hero;
import duel.U;

public class Huti extends Buff
{
    double xishu = 0.8;

    public Huti(Hero target, Hero sender, CreateHero ch)
    {
        this.name = "����";
        this.type = "js";
        this.roundNum = 4;
        this.target = target;
        this.sender = sender;
        this.ch = ch;
    }

    @Override
    public void buffOn()
    {
        if (target.equals(ch.target)){
            int hutiSH = (int) (xishu * ch.shanghai);
            int jsSH = ch.shanghai - hutiSH;
            ch.shanghai = hutiSH;
            U.dayin(target.name + "��" + this.name + "buff����Ч��������" + jsSH + "���˺���");
        }
    }

    @Override
    public void buffOff()
    {

    }

    @Override
    public void roundStartDo()
    {

    }

    @Override
    public void roundExecuteDo()
    {
        if (this.roundNum > 0)
        {
            buffOn();
            this.roundNum--;
        }
    }

    @Override
    public void roundEndDo()
    {

    }

}
