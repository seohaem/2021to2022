# springbatch-app
[스프링 배치] 실전 어플리케이션 개발

#### Job1
- 파일로부터 데이터를 읽어서 DB에 적재한다.

> 파일은 매일 생성되고, 매일 정해진 시간에 파일을 로드하고 데이터를 DB에 업데이트한다.
> 이미 처리한 파일은 다시 읽지 않도록한다.


#### Job2
- DB로부터 데이터를 읽어서 API 서버와 통신한다.

> Partitioning 기능을 통한 멀티 스레드 구조로 Chunk 기반 프로세스를 구현한다.
> 제품의 유형에 따라서 서로 다른 API 통신을 하도록 구성한다. (ClassfierCompositeItemWriter)
> API 서버는 3개로 구성하여 요청을 처리한다.
> 제품 내용과 API 통신 결과를 각 파일로 저장한다. (FlatFileWriter)


#### Scheduler
- 시간을 설정하여 정해진 시간에 주기적으로 Job1, Job2 를 실행시킨다.

> Quatz 오픈 소스 활용


<hr />

### 진행과정

##### 2022.04.14
- 프로젝트 생성 및 최초 설정
- package 구조 설정

##### 2022.04.18
- 배치 어플리케이션 개발 
- API 프로젝트 개발

##### 2022.04.19
- 스케줄링 (Quartz) 적용


##### 수강일지
| | | |
|-|-|-|
|Name|Status|수강일|
|실전! 스프링 배치 어플리케이션 개발|수강완료|2022/04/14|
|어플리케이션 예제 (1)|수강완료|2022/04/14|
|어플리케이션 예제 (2)|수강완료|2022/04/15|
|어플리케이션 예제 (3)|수강완료|2022/04/18|
|어플리케이션 예제 (4)|수강완료|2022/04/18|
|어플리케이션 예제 (5)|수강완료|2022/04/18|
|어플리케이션 예제 (6)|수강완료|2022/04/18|
|어플리케이션 예제 (7)|수강완료|2022/04/19|
|정리|수강완료|2022/04/19|