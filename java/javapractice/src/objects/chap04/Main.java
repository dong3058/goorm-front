package objects.chap04;

public class Main {


    public static void main(String[] args) {
        SmartPhone phone = new SmartPhone();

        String pb = phone.powerButton;
        String ss = phone.sdCardSlot;
        String cu = phone.cpu; // ⚠️ 불가
    }
}
