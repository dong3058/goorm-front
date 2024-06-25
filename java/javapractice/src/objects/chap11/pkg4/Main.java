package objects.chap11.pkg4;

//이파일을 돌리고싶으면 src로 가서 돌려야된다.
//왜냐 우리는 다른 파을의것을 참조하고있기에 좀더 큰범위에서 터미널을 돌려야되기떄문.
//즉 파일이 가진 소스와 명령을 내리는 소스의 위치관계가 중요하다는것임.
import objects.chap11.pkg1.Parent;
import objects.chap11.pkg3.*; // ⭐️ 와일드카드 해당 패키지내의 모든 클래스를 가져온다는말.

    public class Main {
        public static void main(String[] args) {
            Parent parent = new Parent();

            //  ⭐️ 패키지가 다른 동명의 클래스들을 불러올 경우
            objects.chap11.pkg1.Child child1 = new objects.chap11.pkg1.Child();
            objects.chap11.pkg2.Child child2 = new objects.chap11.pkg2.Child();

            Cls1 cls1 = new Cls1();
            Cls2 cls2 = new Cls2();
            Cls3 cls3 = new Cls3();
        }
    }

