package duel;

public class War7 extends Skill
{
    double xishu = 1.2;
    War7(Hero target, Hero sender, CreateHero c){
        this.mark = "7";
        this.name = "�������";
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
        
        int finalSH = (int)(xishu*ch.shanghai);
        int extraSH = finalSH - ch.shanghai;
        ch.shanghai = finalSH;
        U.dayin(sender.name+"ʹ����"+this.name+",��"+target.name+"�����"+extraSH+"������˺���");
        this.cishu++;
        return 0;
    }

}
