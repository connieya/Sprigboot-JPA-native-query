# 기억보단 기록을!
[날짜변환](#native-query)

[native query](#native-query)

[연관관계](#연관관계)

# 날짜 변환
DB에서 날짜 별로 데이터를 가져오기 위해 url에 
2021-02-01 와 같은 날짜 데이터를 입력한다.
하지만 2021-02-01은 String 타입이기 때문에
Date 타입으로 받으려고하면 오류가 발생한다.
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