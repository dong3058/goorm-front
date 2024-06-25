package objects.chap16;

public enum Gender {
    MALE("👦🏻"), FEMALE("👧🏼");

    private String emoji;
    Gender(String emoji) { this.emoji = emoji; }
    public String getEmoji() { return emoji; }
}