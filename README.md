# 백엔드 파트 

## 스택
- Java
- Spring Boot
- MYSQL
- Spring Data JPA

## 사용 구글 기술
- Google Cloud Compute Engine
- Google Cloud SQL
- Google Cloud Load Balancing

## 구글 기술 사용 방법
#### Google Cloud Compute Engine
- 스프링 부트 서버를 돌릴 클라우드 서버

#### Google Cloud SQL
- 데이터베이스 서버 역할

#### Google Cloud Load Balancing
- 서버 부하 조정 및 고정 ip연결을 통한 서버 연결

## 파트 구현 내용
- Spring Data Jpa를 통한 스프링 부트 서버와 데이터베이스 연결
- 회원가입 정보 저장
- 아이디 중복 확인
- 로그인 기능 제공
- 행사, 교육 등의 카테고리별 데이터 제공

## 파트 핵심 목표
- 안드로이드 앱에게 필요한 정보를 제공하고, 안드로이드 앱이 제공하는 정보를 저장하는 RESTful Server 구현
- 위에서 제공받은 정보들을 관리하는 DB 설계 및 관리

## 데이터베이스 테이블 설계
![프로젝트 ERD](https://github.com/youpport/youpport-backend/assets/52040863/0bd5887b-2abc-4185-9db6-0238635421ec)

- 보안 목적으로 쉽게 유추하지 못하도록 PK를 UUID로 설정

## 서버 접근 방법
고정 IP: http://34.22.95.241:8080
안드로이드 파트와 약속한 앤드포인트로 위 서버에 접속해서 앱에게 필요한 정보를 제공한다.

#### 서버 접근 앤드포인트
- http://34.22.95.241:8080/register (회원가입)
- http://34.22.95.241:8080/id/check/{checkmemberid} (중복 id 체크)
- http://34.22.95.241:8080/login (로그인)
- http://34.22.95.241:8080/data/{categoryname} (데이터 요청)

#### 앤드포인트별 요청방법1
- 회원가입: HTTP BODY에 JSON형식으로 담아 POST 요청
- 중복 id 체크: {checkmemberid}에 사용자가 입력한 아이디를 담아서 GET 요청
- 로그인: HTTP BODY에 JSON형식으로 담아 POST 요청
- 데이터 요청: {categoryname}에 사용자가 입력한 카테고리명을 담아서 GET 요청

#### 앤드포인트별 요청방법2
- 회원가입: JSON 형식 -> {"memberId" : "hwang00", "password" : "hwang00!","name" : "hwang"} (키만 불변, 값은 가변)
- 중복 id 체크: http://34.22.95.241:8080/id/check/hwang00 형식
- 로그인: JSON 형식 -> {"memberId" : "hwang00","password" : "hwang00!"} (키만 불변, 값은 가변)
- 데이터 요청: 다음 4개중 하나를 선택: All, EducationEmployment, HousingIncome, Etc / 예시 -> http://34.22.95.241:8080/data/All 
