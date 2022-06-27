# 01. 팀원  소개 및 역할

<strong>박동규</strong>: 마이페이지 관리 기능

<strong>배서현</strong>: 로그인, 회원가입, 세션유지 기능

<strong>황지원</strong>: 설문조사 생성 기능

<strong>이수민</strong>: 배포 전 요구사항 설정 기능

<strong>원종혁</strong>: 결과 페이지 조회 기능

# 02. 프로젝트 소개 
데이터 수집의 중요성이 커진 요즘 시대이니만큼 크고 작은 사업에 있어서 타겟이 되는 고객들이 원하는 요구를 파악하는 것이 중요해졌습니다.

이러한 정보들을 모으는 효과적인 방법중 하나가 설문조사를 통한 데이터 수집입니다. 하지만 대다수 사람은 설문조사에 잘 응해주지 않아 정보를 모으기 쉽지 않은 게 가장 큰 문제점입니다.

이러한 문제점을 해결하고자 저희는 설문조사 대행 서비스를 만들게 되었습니다. 의뢰인이 설문조사 지를 작성하고 저희 서비스에 요청하게 되면 요구되는 설문 인원수와 마감 날짜 등을 맞춰서 대리로 사람들에게 설문에 대한 응답을 받아줍니다.

이러한 서비스를 통해 의뢰인은 원하는 만큼의 설문 응답을 받을 때까지의 수고와 시간을 줄여서 효과적인 사업 계획을 기획하는 데 이바지할 수 있습니다.

# 03. 기술 스택
<img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"> <strong>2.7.0</strong><br><br>
<img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white"> <strong>8.0.29</strong><br><br>
<img src="https://img.shields.io/badge/gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white"> 

<img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">
<img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white">
<img src="https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white">


# 04. 스토리보드
[MIRO Link](https://miro.com/app/board/uXjVO16-60E=/)

# 05. 요구사항

### 😀 **USER**
#### 1. 회원가입
#### 2. 로그인
#### 3. 로그아웃
#### 4. 회원정보 수정
#### 5. 모든 회원정보 조회 

### 📃 **SURVEY**
#### 1. 모든 설문조사 조회
#### 2. 설문조사 생성
#### 3. 특정 사용자의 설문조사 조회
#### 4. 설문조사 내용 수정
#### 5. 설문조사 삭제

### 🧾 **RESULT**
#### 1. 설문 결과 조회


# 06. 도메인 정보

- 사용자
    - 설문조사를 만드는 주체
- 설문조사
    - 통계 자료를 얻기 위하여 어떤 주제에 대해 문제를 내어 묻는 조사.
- 질문
    - 설문조사에 포함된 각각의 문제
- 대답
    - 문제에 대한 결과, 응답


# 07. ERD 

![image](https://user-images.githubusercontent.com/103519499/175857221-720fb0c6-77dc-4907-8aed-3968736d7380.png)

- USER

| attribute | type | description |
| --- | --- | --- |
| user_id (PK) | int | 사용자 PK |
| bank_accout | varchar(255) | 은행 계좌 |
| birth | DATE | 생일 |
| email | varchar(255) | 이메일 주소 |
| password | varchar(255) | 비밀번호 |
| phone_number | varchar(255) | 전화번호 |
| user_name | varchar(255) | 사용자 이름 |
- SURVEY

| attribute | type | description |
| --- | --- | --- |
| survey_id (PK) | int | 설문조사 PK |
| publish_start | DATE | 배포 시작일 (예정일) |
| publish_end | DATE | 배포 종료일 (마감일) |
| publish_state | varchar(255) | 배포 상태 (배포 전, 배포 중, 배포 끝) |
| required | int | 설문 요구 인원 |
| survey_name | varchar(255) | 설문조사 이름  |
| user_id (FK) | int | 설문조사 생성자  |
- QUESTION

| attribute | type | description |
| --- | --- | --- |
| question_id (PK) | int | 설문의 질문 PK |
| question_content | varchar(255) | 질문 내용 |
| survey_id (FK) | int | 설문조사 FK |
- QUESTION VALUE

| attribute | type | description |
| --- | --- | --- |
| qustion_value_id | int | 대답 PK |
| value | int | 질문에 대한 대답 내용 |
| question_id (FK) | int | 질문 FK |

# 08. API 명세서
 [OPEN API](https://documenter.getpostman.com/view/21185840/UzBsHjS8)

# 09. 트러블 슈팅
![image](https://user-images.githubusercontent.com/81737413/175856775-8979f833-c5d7-480d-87e4-a039613b68d7.png)

-테이블을 여러 Entity를 만들고 양방향 맵핑을 하고 결과를 확인하는 과정에서 똑같은 데이터가 반복적으로 출력되어 서버가 죽는 현상이 발생했습니다. 이를 해결하기 위해서 부모 클래스에 @JsonManagedReference, 자식 클래스에는 @JsonBackReference를 코드를 작성해줌으로써 문제점을 해결할 수 있었습니다.

# 10. 느낀점 

<strong>박동규</strong>: 되게 오랫동안 진행된 프로젝트라서 느슨하게 진행해도 될 것 같았다고 생각했지만, 실제 개발은 프로젝트 막바지에 거의 다 한 것 같습니다. 계획을 세우고 이에 따라 작은 미션을을 해결하는 방식으로 프로젝트가 진행되었다면 좋았을 것 같은 아쉬움이 있습니다. 다들 고생 많으셨습니다. 

<strong>배서현</strong>:

<strong>황지원</strong>:

<strong>이수민</strong>: 혼자라면 못했을 프로젝트를 좋은 팀원들을 만나 할 수 있었던 것 같습니다. 이 프로젝트로 맵핑을 처음 해봤는데 맵핑이 꼬이면 실행되지 않고 맵핑 부분에서 많은 시간을 소비한 것 같습니다. 하지만 그 과정에서 팀원들끼리 다양한 방법으로 오류를 해결해 나가는 부분이 좋았습니다! 중간프로젝트로 인해 시간이 부족하여 원하는 결과를 도출하지 못한 것이 아쉬웠습니다. 프로젝트 진행하면서 많이 도와주고 서로서로 응원하는 모습 좋았습니다. 다들 감사했습니다!

<strong>원종혁</strong>: 이번 프로젝트를 통해 이전에 감이 잡히지 않았던 spring과 Annotation을 활용하는 방법들을 이해하고 활용하는 방법을 알게 되었습니다. 또한 팀원들이 각자 작성한 코드를 merge로 병합하는 과정을 통해 git으로 협업해보고 아이디어 구상부터 코드 병합까지 협업하는 전체적인 흐름을 알 수 있는 좋은 경험이었습니다.  

