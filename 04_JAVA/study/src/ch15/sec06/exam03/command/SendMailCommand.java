package ch15.sec06.exam03.command;

import ch15.sec06.exam03.Message;
public class SendMailCommand implements Command{
    @Override
    public void execute(Message message){
        System.out.println(message.to+"님에게 메일을 보냅니다.");
    }
}
