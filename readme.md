## 1차 요구사항 구현
- [x] 유저가 루트 url로 접속시에 게시글 리스트 페이지가 나온다.
- [x] 리스트 페이지에서는 등록 버튼이 있고 버튼을 누르면 http://주소:포트/article/create 경로로 이동하고 등록 폼이 나온다.
- [x] 등록을 하면 http://주소:포트/article/create로 POST 요청을 보내어 DB에 해당 내용을 저장한다.
- [x] 등록이 되면 해당 게시글 상세 페이지로 리다이렉트 된다. 해당 경로는 http://주소:포트/article/detail/{id} 가 된다.
- [x] 게시글 상세 페이지에는 목록 버튼이 있다. 목록 버튼을 누르면 게시글 리스트 페이지로 이동하게 된다.
- (추가 기능이나 구현기능설명이 필요한 경우 서술)

## 미비사항 or 막힌 부분
- 프론트 구성이 막힘

## MVC 패턴
- MVC 는 Model, View, Controller의 약자 입니다. 하나의 애플리케이션, 프로젝트를 구성할 때 그 구성요소를 세가지의 역할로 구분한 패턴입니다.

## 스프링에서 의존성 주입(DI) 방법
- 의존성주입과 IoC

Class A{

new b = new B();

}


위 클래스 A는 클래스 B의 의존하고 있는 형태이다
하지만 이렇게 되면 의존성이 너무 강해지는 느낌이랄까
그래서 IoC라는 제어의 역전을 사용하게 되면 Spring 같은 여러 프레임워크에서 제어를 할 수 있도록 해준다

이때 사용되는 프레임워크를 컨테이너라고도 하는 것 같기도하고 어쨋든 컨테이너를 통해서 의존성 주입을 하게 되면 결합도를 낮춰서 확장이 편하게 해주는 그런 개념으로 이해를 했다

그리고

프레임워크에서 제어를 하게 해주면 아래와 같은 과정을 알아서 해주게 되는 것 같다

스프링 컨테이너 생성
스프링 빈 생성
의존 관계 주입
초기화 콜백
사용
소멸 전 콜백
스프링 종료