package _onjava8._enums;

public enum  OzWitch {

    WEST("Miss Gulch, aka the Wicked Witch of the west"),
    NORTH("nnnnnnnnnnnnnnnnnnnnnnnnnnn"),
    EAST("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEE"),
    SOUTH("SSSSSSSSSSSSSSSSSSSSSSSSSSSSS");

    private String description;
    private OzWitch(String des) {
        description = des;
    }

    public String getDescription() { return description; }

    public static void main(String[] args) {
        for (OzWitch witch : OzWitch.values()) {
            System.out.println(witch + ": " + witch.getDescription());
        }
    }
}
