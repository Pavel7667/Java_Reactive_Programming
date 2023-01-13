package org.reactor.assignment.sink;

import org.reactor.utils.Utils;

public class SlackDemo {

    public static void main(String[] args) {

        SlackRoom slackRoom = new SlackRoom("reactor");

        SlackMember sam = new SlackMember("sam");
        SlackMember javke = new SlackMember("javke");
        SlackMember mike = new SlackMember("mike");

        slackRoom.joinsRoom(sam);
        slackRoom.joinsRoom(javke);

        sam.says("HI to ALL");
        Utils.sleepSeconds(4);

        javke.says("Hey!");
        sam.says("How are you ??");

        slackRoom.joinsRoom(mike);
        mike.says("glad to be her, gays");


    }
}
