#native query

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


# 연관관계
신청현황, 방문현황의 테이블을 봤을 때

신청현황(request)에는 방문에 대한 데이터를 참조 안했고

방문현황(access) 에는 신청에 대한 fk키를 참조했다.

그렇기 때문에 일대다가 아니라
다대일 관계이다.