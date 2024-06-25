package errorandexception.makerror;

public class NotEnoughManaException extends RuntimeException {
    public NotEnoughManaException(MagicKnight mk, int neededMana) {
        super(
                "마나가 %d 부족합니다."
                        .formatted(neededMana - mk.mana)
        );
    }
}
