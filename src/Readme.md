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
