# Jar File Link

https://github.com/cp-dm/file/blob/master/blog.jar

[jar file](https://github.com/cp-dm/file/blob/master/blog.jar)

```bash
java -jar blog.jar
```

# Environment

- Post : 8080
- Java Version : 11
- Open API KEY
  - [KaKao](https://developers.kakao.com)
  - [Naver](https://developers.naver.com)

# API

## 블로그 검색 API

### path
```http
GET /blog
```

### Request 
```
curl -v -X GET "http://localhost:8080/blog" \
--data-urlencode "query=카카오뱅크" \
```

#### Parameter
|Key|                 Desc                 | Required |
|:---:|:------------------------------------:|:---:|
|query|                 검색어                  |O|
|sort| 정렬 방식 : accuracy(정확도순),recency(최신순)  |X|
|page|    결과 페이지 번호, 1~50 사이의 값, 기본 값 1     |X|
|size| 한 페이지에 보여질 문서 수, 1~50 사이의 값, 기본 값 10 |X|

### Response
```json
{
  "content": [
    {
      "title": "[Google colab] 카페상세정보 크롤링하기 -1",
      "contents": "강북구 카페정보를 뽑은 csv 이렇게 csv파일로 저장이된다. https://velog.io/@eric2057/Selenium%<b>EC</b>%9D%84-%<b>EC</b>%9D%<b>B</b><b>4%</b><b>EC</b>%9A%A9%<b>ED</b>%95%B4-%<b>EC</b>%<b>B</b><b>9%</b><b>B</b><b>4%</b><b>EC</b>%<b>B</b><b>9%</b><b>B</b><b>4%</b><b>EC</b>%<b>98%</b><b>A4</b>%<b>EB</b>%A7%B5-%<b>ED</b>%<b>81%</b>AC%<b>EB</b>%A<b>1%</b><b>A4</b>%<b>EB</b>%A7%<b>81%</b><b>ED</b>%95%<b>98%</b>EA%<b>B</b>8%B0 Selenium을 이용해 카카오맵 크롤링하기 이전 포스팅에서 네이버 검색 API를 사용하여 식당...",
      "url": "http://cafezoa.tistory.com/2",
      "blogname": "키읔피읖",
      "thumbnail": "",
      "datetime": "2023-01-19T20:10:39.000+09:00"
    },
    {
      "title": "[엘든링] 미리암 : 마리카 &amp; 로렛타 : 월계수",
      "contents": "w/%<b>ED</b>%94%BC%<b>EB</b>%94%94(%<b>EC</b>%97%<b>98%</b><b>EB</b>%93%A0%20%<b>EB</b>%A7%81) 한때 셀브스의 흑막이 피디가 아닌가란 생각이 있었지만, 피디가 죽어도 카리아 서원에서 미리암은 존재...모르며, 카리아의 왕녀는 라니다. ​ ​ ​ https://namu.wiki/w/%<b>EC</b>%<b>85%</b>80%<b>EB</b>%<b>B</b>8%8C%<b>EC</b>%8A%<b>A4</b> 셀브스 [Seluvis] 의 모자는 천체의 운행을 떠올리는 모습이...",
      "url": "https://blog.naver.com/knock001/223009791623",
      "blogname": "무르 의 공방",
      "thumbnail": "https://search3.kakaocdn.net/argon/130x130_85_c/C8jyoNKb02L",
      "datetime": "2023-02-09T01:56:00.000+09:00"
    },
    {
      "title": "용병 VS 숙청",
      "contents": "A<b>1%</b>9C%<b>EC</b>%<b>B</b>8%A0%<b>ED</b>%82%<b>A4</b> 레프 [레오, 사자] 트로츠키를 비롯한 많은 지식인들은 앞서 애국 시인 [이오시프 스탈린] 과 기꺼이 함께 했다. ​ 사람들은 사람을...러시아의 권좌에 오히려 올랐다. ​ ​ ​ https://namu.wiki/w/%<b>EC</b>%9D%<b>B</b><b>4%</b><b>EC</b>%<b>98%</b><b>A4</b>%<b>EC</b>%<b>85%</b><b>B</b>0%<b>ED</b>%94%84%<b>EC</b>%<b>B</b><b>9%</b>B4 이오셰프카 (Iosefka, ヨセフカ). https://namu...",
      "url": "https://blog.naver.com/knock001/223020017973",
      "blogname": "무르 의 공방",
      "thumbnail": "",
      "datetime": "2023-02-18T15:29:00.000+09:00"
    },
    {
      "title": "들어봤니? &#39;카카오뷰&#39;에 갬블러크루가 나타났대!! &#34;소식전달&#34; &#34;정보 전달&#34; 그야말로 생생정보통 &#39;비보이...",
      "contents": "<b>EC</b>%<b>B</b><b>9%</b><b>B</b><b>4%</b><b>EC</b>%<b>B</b><b>9%</b><b>B</b><b>4%</b><b>EC</b>%<b>98%</b><b>A4</b>%20%<b>EB</b>%<b>B</b>7%<b>B</b>0%<b>EC</b>%97%90%<b>EC</b>%84%9C%20%EA%<b>B</b>0%AC%<b>EB</b>% <b>B</b>8%94%<b>EB</b>%9F%AC%<b>ED</b>%<b>81%</b>AC%<b>EB</b>%A3%A8%<b>EB</b>%A5%BC%20%<b>EB</b>%A7%8C%<b>EB</b>%82%<b>98%</b><b>EB</b>%<b>B</b>3%<b>B</b><b>4%</b><b>EC</b>%84%<b>B</b>8%<b>EC</b>%9A%94.%20%20%<b>EC</b>%<b>B</b><b>9%</b><b>B</b><b>4%</b><b>ED</b>%86%A<b>1%</b>20%<b>EC</b>%84%<b>B</b>8%20%<b>EB</b>%<b>B</b>2%88%<b>EC</b>%A7%<b>B</b>8%20%<b>EB</b>%<b>B</b>7%<b>B</b>0%<b>ED</b>%83%AD%20-%20%<b>EC</b>%<b>B</b><b>9%</b><b>B</b><b>4%</b><b>EC</b>%<b>B</b><b>9%</b><b>B</b><b>4%</b><b>EC</b>%<b>98%</b><b>A4</b>%20%<b>EB</b>%<b>B</b>7%<b>B</b>0%20%<b>EB</b>%<b>B</b>0...",
      "url": "https://blog.naver.com/gamblerzbboy/222846800576",
      "blogname": "갬블러크루 공식블로그",
      "thumbnail": "",
      "datetime": "2022-08-12T18:35:00.000+09:00"
    },
    {
      "title": "NodeJS - OAuth",
      "contents": "위해 만들어진 라이브러리도 많다. 그러나 han-py.tistory.com https://velog.io/@kjhxxxx/Node.js-%<b>EC</b>%<b>B</b><b>9%</b><b>B</b><b>4%</b><b>EC</b>%<b>B</b><b>9%</b><b>B</b><b>4%</b><b>EC</b>%<b>98%</b><b>A4</b>-%<b>EC</b>%86%8C%<b>EC</b>%<b>85%</b>9C-%<b>EB</b>%A<b>1%</b>9C%EA%<b>B</b>7%<b>B</b>8%<b>EC</b>%9D%B8-%EA%<b>B</b>5%AC%<b>ED</b>%<b>98%</b>84%<b>ED</b>%95%<b>98%</b>EA%<b>B</b>8%B0 [Node.js] 카카오 소셜 로그인 구현하기 실전 프로젝트를 진행하며 유저의 편의성을 위해 로그인...",
      "url": "http://doyoung-p.tistory.com/127",
      "blogname": "Young's Today",
      "thumbnail": "https://search4.kakaocdn.net/argon/130x130_85_c/HnVAajoEBEI",
      "datetime": "2023-01-03T00:10:39.000+09:00"
    },
    {
      "title": "20220708 블루아카이브 학생 소개-체리노(온천)&amp;치나츠(온천)&amp;토모에",
      "contents": "<b>EB</b>%<b>85%</b><b>B</b>8%<b>EB</b>%AF%<b>B</b>8%<b>EC</b>%95%BC%20%<b>EC</b>%<b>B</b><b>9%</b><b>98%</b><b>EB</b>%82%<b>98%</b><b>EC</b>%<b>B</b>8%A0/%<b>EC</b>%<b>98%</b>A8%<b>EC</b>%<b>B</b>2%9C 미들 신비 경장갑 스트라이커고 무기는 권총이라고 한다 일단 신비딜러니까...한섭 블루아카이브 트위터 https://namu.wiki/w/%<b>EC</b>%82%AC%<b>EC</b>%8B%9C%<b>EB</b>%A<b>1%</b>9C%20%<b>ED</b>%86%A0%<b>EB</b>%AA%A8%<b>EC</b>%97%90 배포 1성 백 서포터 관통 특수장갑 저격총이고...",
      "url": "http://kureowl.tistory.com/441",
      "blogname": "쿠빼미의 제2둥지",
      "thumbnail": "https://search1.kakaocdn.net/argon/130x130_85_c/AkPOxQe5iJu",
      "datetime": "2022-07-08T02:42:01.000+09:00"
    },
    {
      "title": "기록_방관자 효과와 담배",
      "contents": "<b>B</b><b>9%</b>84%<b>ED</b>%8C%90 ​ 불편한 진실 - 나무위키 - https://namu.wiki/w/%<b>EB</b>%<b>B</b>6%88%<b>ED</b>%8E%<b>B</b>8%<b>ED</b>%95%9C%20%<b>EC</b>%A7%84%<b>EC</b>%8B%A4#s-1.1 ​ 오멜라스를 떠나는 사람들...<b>EC</b>%A<b>1%</b><b>B</b>0%<b>EB</b>%A5%<b>B</b><b>4%</b><b>EC</b>%A<b>1%</b><b>B</b>0%20%<b>EC</b>%95%84%EA%<b>B</b>0%90%<b>EB</b>%<b>B</b>2%<b>A4</b>?from=%<b>ED</b>%<b>98%</b><b>B</b>8%<b>EB</b>%AA%A8%20%<b>EC</b>%82%AC%<b>EC</b>%BC%80%<b>EB</b>%A5%<b>B</b>4#%<b>ED</b>%<b>98%</b><b>B</b>8%<b>EB</b>%AA%A8%20%<b>EC</b>%82%AC%<b>EC</b>%BC%80...",
      "url": "https://blog.naver.com/ddowan/223013919368",
      "blogname": "ddowan님의 블로그",
      "thumbnail": "https://search2.kakaocdn.net/argon/130x130_85_c/6EB8Et7yrc2",
      "datetime": "2023-02-13T11:37:00.000+09:00"
    },
    {
      "title": "라캉, 프로이트부터 카진스키까지",
      "contents": "<b>ED</b>%<b>81%</b>AC%20%<b>EB</b>%9D%BC%<b>EC</b>%BA%89 프로이트주의를 자신의 언어로 재해석한 정신분석학자, 철학자이다. 라캉은 정신과 의사에서 시작하여 철학 및 정신분석학계에...끼쳤다. ​ 라캉철학 - 나무위키 - https://namu.wiki/w/%<b>EB</b>%9D%BC%<b>EC</b>%BA%89%<b>EC</b>%<b>B</b>2%A0%<b>ED</b>%95%99 캉의 사유는 계속해서 진화하고 진동하며, 심지어는 과거의...",
      "url": "https://blog.naver.com/ddowan/222982047474",
      "blogname": "ddowan님의 블로그",
      "thumbnail": "",
      "datetime": "2023-01-12T09:54:00.000+09:00"
    },
    {
      "title": "(1) 카카오 뱅크에 투자하는게 맞나?",
      "contents": "수익 영향 분석) *Reference - 카카오 뱅크 : https://www.kakaobank.com/Corp/About/Identity - 나무 위키(카카오 뱅크) : https://namu.wiki/w/%<b>EC</b>%<b>B</b><b>9%</b><b>B</b><b>4%</b><b>EC</b>%<b>B</b><b>9%</b><b>B</b><b>4%</b><b>EC</b>%<b>98%</b><b>A4</b>%<b>EB</b>%<b>B</b><b>1%</b><b>85%</b><b>ED</b>%<b>81%</b>AC - 다트(카카오 뱅크_2021.09분기 보고서) : https://dart.fss.or.kr/dsab007/main.do 부족하지만 읽어주셔서 감사합니다...",
      "url": "http://billionaire-hossa.tistory.com/4",
      "blogname": "Maktūb",
      "thumbnail": "https://search4.kakaocdn.net/argon/130x130_85_c/F6AvIHVA2Z5",
      "datetime": "2022-02-20T20:31:22.000+09:00"
    },
    {
      "title": "[Social Login] 구글, 네이버, 카카오 로그인 구현",
      "contents": "<b>B</b><b>4%</b><b>EC</b>%<b>98%</b><b>A4</b>-oauth-%<b>EC</b>%84%9C%<b>EB</b>%<b>B</b><b>9%</b>84%<b>EC</b>%8A%<b>A4</b>-%<b>EB</b>%93%<b>B</b><b>1%</b><b>EB</b>%A<b>1%</b>9D 3. OAuth2 설정 파일을 작성합니다. application-oauth.yml 파일을 작성하고 application.yml 파일에 추가해줍니다. spring: # Security OAuth security: oauth2.client: registration: google: clientId: &#39;GOOGLE_CLIENT_ID&#39; clientSecret: &#39;GOOCLE...",
      "url": "http://developerbee.tistory.com/245",
      "blogname": "Beelog",
      "thumbnail": "",
      "datetime": "2022-06-06T15:16:58.000+09:00"
    }
  ],
  "pageable": {
    "sort": {
      "empty": true,
      "sorted": false,
      "unsorted": true
    },
    "offset": 10,
    "page_number": 1,
    "page_size": 10,
    "paged": true,
    "unpaged": false
  },
  "last": false,
  "total_elements": 1855,
  "total_pages": 186,
  "size": 10,
  "number": 1,
  "sort": {
    "empty": true,
    "sorted": false,
    "unsorted": true
  },
  "first": false,
  "number_of_elements": 10,
  "empty": false
}
```

## 인기 검색어 API

### path
```http
GET /blog/rank
```

### Request
```
curl -v -X GET "http://localhost:8080/blog/rank"
```

### Response
```json
[
  {
    "keyword": "카카오뱅크2345646",
    "hit": 2
  },
  {
    "keyword": "카카오뱅크1",
    "hit": 2
  },
  {
    "keyword": "카카오뱅크234564657533234",
    "hit": 1
  },
  {
    "keyword": "카카오뱅크23456465753323",
    "hit": 1
  },
  {
    "keyword": "카카오뱅크2345646575332",
    "hit": 1
  },
  {
    "keyword": "카카오뱅크234564657533",
    "hit": 1
  },
  {
    "keyword": "카카오뱅크23456465753",
    "hit": 1
  },
  {
    "keyword": "카카오뱅크2345646575",
    "hit": 1
  },
  {
    "keyword": "카카오뱅크234564657",
    "hit": 1
  },
  {
    "keyword": "카카오뱅크23456465",
    "hit": 1
  }
]
```

# 기능

1. 블로그 검색 (API 장애시 외부 API 사용)
2. 인기 검색어 (redis 실패시 db 조회)

# 외부 라이브러리

- [lombok](https://github.com/projectlombok/lombok)
