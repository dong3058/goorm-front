package thread.waitnotify;

public class Main {

    PhoneBooth phoneBooth = new PhoneBooth();

        Arrays.stream("김병장,이상병,박일병,최이병".split(","))
            .forEach(s -> new Thread(
                        new SoldierRun(s, phoneBooth)
                ).start());






    CoffeeMachine coffeeMachine = new CoffeeMachine();

        Arrays.stream("철수,영희,돌준,병미,핫훈,짱은,밥태".split(","))
            .forEach(s -> new Thread(
                        new CustomerRun(s, coffeeMachine)
                ).start());

        new Thread(new ManagerRun(coffeeMachine)).start();
}
