package net.blogjava.welldoer;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotButton;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;
import org.junit.Test;


public class SWTBotDemoTest 
{
    @Test
    public void test() 
    {
        SWTBotPreferences.PLAYBACK_DELAY = 100; // slow down tests...Otherwise we won't see anything

        Display display = new Display().getDefault();
        Shell shell = new SampleSWTUI().showGUI(display);
        SWTBot bot = new SWTBot(shell);

        SWTBotButton loginButton = bot.button("Login");
        SWTBotText userText = bot.textWithLabel("User Name: ");
        SWTBotText passwordText = bot.textWithLabel("Password: ");

        userText.setFocus();
        userText.setText("Superman");

        assert(userText.getText().equals("Superman"));

        passwordText.setFocus();
        passwordText.setText("test123");

        assert(passwordText.getText().equals("test123"));

        loginButton.setFocus();
        loginButton.click();    


        userText.setFocus();
        userText.setText("Favonius");

        assert(userText.getText().equals("Favonius"));

        passwordText.setFocus();
        passwordText.setText("abcd123");

        assert(passwordText.getText().equals("abcd123"));

        loginButton.setFocus();
        loginButton.click();    

//        while (!shell.isDisposed()) {
//             if (!display.readAndDispatch()) display.sleep();
//        }

        display.dispose();
    }
}