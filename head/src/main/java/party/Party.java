package party;

import java.awt.*;

/**
 * party.Party time code!
 */
public class Party {
    public void buildInvite() {
        Frame frame = new Frame();
        Label label = new Label("party.Party Time!");
        Button b = new Button("Enter at party.Party");
        Button b1 = new Button("Exit");
        Panel panel = new Panel();
        panel.add(label);
    }

    public static void main(String[] args) {
        Party party = new Party();
        party.buildInvite();
    }
}
