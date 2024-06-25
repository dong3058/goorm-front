package objects.chap16;

// ⭐️  레코드로 작성
public record Child(
        String name,
        int birthYear,
        Gender gender
) {}

//레코드 필드는 final이며  전부다 private이며 레코드 그자체는 final 즉 상속이나 abstract가 불가. getter가 기본적으로 생성됨.
//또한 이게 자동적으로 생성자의 형식을 함.