package duel;

public class PuGong extends Skill
{

    public PuGong(Hero target, Hero sender, CreateHero c)
    {
        this.mark = "0";
        this.name = "��ͨ����";
        this.target = target;
        this.sender = sender;
        this.ch = c;
        this.cishu = 0;
    }

    @Override
    public int perform()
    {

        int ran = RandomIntList.getInstance().getNext() / 5;
        ch.shanghai = (int) 50 * sender.gj / target.fy + ran;

        if (ran < 15)
        {
            U.dayin(sender.name + "�������չ���");
        } else
        {
            U.dayin(sender.name + "�������չ������ֱ�����");
        }

        return 0;
    }

}
