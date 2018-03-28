# ping-check-clj

ping-check-clj is an open source study material that makes it easy to test for deploying kubenetes.
a

### Download and Install

0. lein new luminus ping-check-clj +mongodb +auth +swagger +service

1. lein run 

2. you can connect swagger url -> localhost:3000/swagger-ui


### Distributions

0. lein uberjar

1. sudo docker build -t ping-image .

2. sudo docker run -it --rm -p 3000:3000 --name ping-container ping-image

   or

   sudo docker run -d --rm -p 3000:3000 --name ping-container ping-image






### 구현 계획

- 프론트(react)
http://alisabzevari.github.io/2017/09/30/2017-10-3-react-simple-state-management/
https://news.ycombinator.com/item?id=12371248
- API GateWay(Kong) -> or remove CORS

- 회원서비스 (facebook oauth2?)

- 엔드포인트 서비스 (kong)

- 알림 서비스 (iOS, Android push)

- 이메일 전송 서비스

- 슬랙 메시지 전송 서비스

- 리포트 서비스 (통계) -> react 뷰 + api

- 체킹하는(사이트 오류가 있을때) <-
- Cron Job Manager (이게 의문..)

- Cron Job(con~~ n par~~, abstraction??)

- 이 몇개가 되야 하는 걸까 (사용자 마다 site를 array 로 가지고 있어야 겠지?)

- 오류 트리거 발생 -> 사이트에 해당하는 유저 확인 -> 통보하기(알림 + 이메일 + 슬랙 + 리포트?)
- n (User) * n (Site) * n (알림 + 이메일 + 슬랙) = 총 쓰레드

- 오류 트리거 발생(웹사이트 오류 발생) = 비주기적

- 정상 트리거 발생(웹사이트 정상) = 주기적

- concurrency and parallelism

- thread kill (Go Nim Rust vs erlang)
- process
- case ->
- |>알림
- |>이메일
- |>슬랙
- |>리포트
- ex) 100명 * 1분 순차처리 = 100분 이상 error 처리..
- ex) 100명 * 1분 병렬처리 = 1분 이상 error 처리..

- 구현 스택 (랭귀지 설계...) (https://hashrocket.com/blog/posts/websocket-shootout)

- clojure (https://developer.atlassian.com/blog/2016/03/why-clojure/)
- rust (https://rustbyexample.com/primitives.html)
- go
- nim (https://nim-by-example.github.io/hello_world/)
- elixir
- erlang (https://www.slideshare.net/ezmobius/erlangfactory/11-Erlang_VM)
- javascript es6 destructuring, symbol, set, map, iter & gene(*), promise

- 구현 환경

- emacs
- cider
- luminus (http://www.luminusweb.net/)

- lein new luminus myapp +mongodb +auth +swagger +service
- monger (http://clojuremongodb.info/)
- leinengen -> docker build (terminal)
- sudo docker run -it --rm -p 3000:3000 --name clojure-instance clj-image
sudo docker build -t clj-image .

- 배포하기
- kubernetes 로..