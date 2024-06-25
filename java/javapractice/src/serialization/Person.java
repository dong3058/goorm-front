package serialization;

//  ⭐️ 직렬화되려면 Serializable 구현
public class Person implements Serializable {

    //직렬화는 자바의 인스턴스를 바이트 스트림으로바꿔서 다른곳 즉 json처럼 다른 언어라던가에서
    //사용될수있게 바꿔버리는것을 의미함. 여기선 serializable을 받음으로서
    //에으 인스턴스들은 다른곳에서도 쓰일수있게 되었다.

    //  💡 serialVersionUID : 클래스의 버전 번호로 사용
    private static final long serialVersionUID = 1L;//다른곳에서 쓴 이 person 이란클래스가 현재 내가쓰는 애와는
    //차이가 이잇을수있다. 그 버ㅓ전 차이를 구분하기위해서 넣는거싱다
    //받는쪽에서 name을 주석처리하고 아래를 활성화시키자.아래의 strin fullanme의 경우null이 나온돠
    // 왜냐 person인스턴스는 속성값을 name으로 받고있기떄문. 즉 보내는이는 name으로 보내나 받는애가 다르기떄문
    //근대 오류는 안터진다.
    //또한 받는쪽에서 타입을 바꿀경우에는 오류가 난다. (버전이 같을떄).
    private String name;
    //private String fullName;
    private int age;
    private double height;
    private boolean married;

    //  💡 transient : 직렬화에서 제외 즉 애내는 제외하고 바뀐다는의미.
    transient private String bloodType;
    transient private double weight;

    //  ⭐️ 직렬화에 포함되려면 해당 클래스도 Serializable 구현
    private Career career;//애도 직렬화가 구현되있음.

    public Person(
            String name, int age, double height, boolean married,
            String bloodType, double weight, Career career
    ) {
        this.name = name;
        //this.fullName = name;
        this.age = age;
        this.height = height;
        this.married = married;
        this.bloodType = bloodType;
        this.weight = weight;
        this.career = career;
    }
}