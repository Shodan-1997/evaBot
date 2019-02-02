import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;
import java.util.Arrays;


public class Main extends ListenerAdapter {
    public static void main(String[] args) throws LoginException {
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        String token = "NTQwNDc4ODQxMjY5OTExNTUz.DzRiDQ.hkO0-vopROdkE_AxU2M_fjQmd6g";
        builder.setToken(token);
        builder.addEventListener(new Main());
        builder.build();
    }

    public void onMessageReceived(MessageReceivedEvent event) {
        System.out.println("We received a message from " +
                event.getAuthor().getName() + ": " +
                event.getMessage().getContentDisplay()
        );
        if (event.getAuthor().isBot()) {
            return;
        }
        String arrivedMessage = event.getMessage().getContentRaw().toLowerCase();
        arrivedMessage = arrivedMessage.replaceAll("[^a-z\\s]", "");
        String[] seperateWords = arrivedMessage.split(" ");

        System.out.println(arrivedMessage);
        for (int i = 0; i < seperateWords.length; i++) {
            if (Arrays.asList("hi", "hii", "hiii","hey", "heyy", "heyyy", "hiya", "hoi", "hello", "howdy", "bonjour", "salut").contains(seperateWords[i])) {
                event.getChannel().sendMessage("Hiya~").queue();
            }
            else {
                ;
            }
        }
    }
}



