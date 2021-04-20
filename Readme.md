# 기억보단 기록을!
[날짜변환](#날짜-변환)

[native query](#native-query)

[연관관계](#연관관계)

[뮨자열변환](#문자열-변환)








# 날짜 변환
1. DB에서 날짜 별로 데이터를 가져오기 위해 url에 
2021-02-01 와 같은 날짜 데이터를 입력한다.
하지만 2021-02-01은 String 타입이기 때문에
Date 타입으로 받으려고하면 오류가 발생한다.

=> @DateTimeFormat 어노테이션 사용

2. 날짜 데이터 Calendar 클래스로 format 모듈화
작업 

`DateDate.java`
```java
public class DateData {
    
    public static Date getMonth(Date date){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR,0);

        Date time = calendar.getTime();
        
        return time;
    }
    public static Date getMonth2(Date date){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR,0);
        calendar.add(Calendar.MONTH,1);

        Date time = calendar.getTime();

        return time;
    }
}
```

중복된 코드 모듈화로 해결


`AccessController.java`

```java
@CrossOrigin
    @GetMapping("/access/visit/{date}")
    public Long 방문인원현황(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date){


        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY,0);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(date);
        c2.set(Calendar.HOUR_OF_DAY,0);
        c2.add(Calendar.MONTH,1);

        return accessService.방문인원현황(c.getTime(),c2.getTime());

    }
```
```java
@CrossOrigin
    @GetMapping("/access/visit/{date}")
    public Long 방문인원현황(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date){

        return accessService.방문인원현황(DateData.getMonth(date),DateData.getMonth2(date));

    }
```

중복된 코드 제거하면서 가독성 또한 좋아짐


*****
# native query

```java
  @Query(value = "select *" +
          "from vst_visit_request where name = ?1" ,nativeQuery = true)
  List<Request> SearchRequestByName(String name);

```

별 문제 없이 실행된다.


밑에 쿼리 처럼 하면

```
"select id , name from vst_visit_request where name = ?1"
```

오류가 발생한다.<br/>
`Request` 클래스에
id , name 뿐 아니라 다른 객체도 있기때문이다.

****
# 연관관계
신청현황, 방문현황의 테이블을 봤을 때

신청현황(request)에는 방문에 대한 데이터를 참조 안했고

방문현황(access) 에는 신청에 대한 fk키를 참조했다.

그렇기 때문에 일대다가 아니라
다대일 관계이다.


# 문자열 변환

```java
public String 방문차량최대시간(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date){

        String data =
                accessService.방문차량최대시간(DateData.getMonth(date),DateData.getMonth2(date));

        try {
            StringBuilder data2 = new StringBuilder(data);
            StringBuilder data3 = data2.insert(2, '일');
            data3.setCharAt(6, '시');
            data3.setCharAt(9, '분');
            data3.delete(10, 12);
            return data3.toString();

        } catch (Exception e) {
            System.out.println(e);

        }
        return null;

    }
```
StringBuilder 대신 subString으로 해당 문자 추출 후 포맷팅
& 가독성과 유지보수를 위해 모듈화 

```java
 public String 방문차량최대시간(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date){

        String data =
                accessService.방문차량최대시간(DateData.getMonth(date),DateData.getMonth2(date));

        return StringFormatting.문자열변환(data);
    }
```


`StringFormatting.java`

```java
public class StringFormatting {

    public static String 문자열변환(String data){

        int day = Integer.parseInt(data.substring(0, 2));
        System.out.println("날짜 -> 숫자로 전환 : " +day);
        int hour = Integer.parseInt(data.substring(3, 5));
        System.out.println("시간 -> 숫자로 전환 :" +hour);
        int minute = Integer.parseInt(data.substring(6, 8));
        System.out.println("분 -> 숫자로 전환 : "+minute);
        int totalHour = day * 24 + hour;
        System.out.println("총 시간 : "+totalHour );
        return totalHour+"시간"+minute+"분";


    }
}

```