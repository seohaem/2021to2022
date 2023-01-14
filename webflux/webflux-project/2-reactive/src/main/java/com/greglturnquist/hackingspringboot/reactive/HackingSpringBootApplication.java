package com.greglturnquist.hackingspringboot.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * [리액티브 데이터 스토어 요건]
 * 리액티브 프로그래밍을 사용하려면 모든 과정이 리액티브여야 한다.
 * 웹 컨트롤러를 리액티브 방식으로 동작하게 만들고 서비스 계층도 리액티브 방식으로 동작하게 만들었는데,
 * 블로킹 방식으로 연결되는 데이터베이스를 호출하면 리액티브는 무너진다.
 * 리액터 기반 애플리케이션은 많은 수의 스레드를 가지고 있지 않으므로 데이터베이스 호출 후 블로킹되는 스레드가 많아지면
 * 스레드가 모두 고갈돼서 결국 전체 애플리케이션이 데이터베이스로부터 결과를 기다리면서 아무런 일도 할 수 없는 상태가 된다.
 *
 * 사용자 수가 적고 데이터도 많지 않다면 불필요한 오버헤드를 감수하면서 리액티브를 사용하는 것은 낭비다.
 * 웹에서 대규모의 트래픽이 발생하고 백엔드에서 대용량의 데이터를 처리하는 환경에서는
 * 리액티브 프로그래밍의 장점이 빛을 발하게된다. 즉, 리액티브 프로그래밍에서 스레드는 어떤 작업이 끝날때까지
 * 블로킹되어 기다리지 않고 다른 작업을 수행할 수 있다!
 *
 * 리액티브 런타임은 요청과 응답을 조율해서 시스템 자원이 허용하는 한도 내에서 스레드 사용 효율을 극대화한다.
 * 따라서 리액티브가 제대로 동작하려면 데이터베이스도 리액티브하게 동작해야한다.
 *
 * - 몽고디비
 * - 레디스
 * - 아파치 카산드라
 * - 엘라스틱서치
 * - 네오포제이 (Neo4j)
 * - 카우치베이스 (Couchbase)
 *
 * 관계형 데이터베이스를 사용할때 사용되는 기술 JDBC, JPA 등은 블로킹 API다.
 * 트랜잭션을 시작하는 메시지를 전송하고 쿼리를 포함하는 메시지를 전송하고, 결과가 나올때 클라이언트에게 스트리밍해주는 개념 자체가 없다.
 * 모든 데이터베이스 호출은 응답을 받을때까지 블로킹되어 기다려야한다.
 * 이는 리액티브 스트림 계층에서 사용할 수 있게 해주는 반쪽자리 솔루션도 있긴 하지만, 이는 일반적으로 숨겨진 내부 스레드 풀을 사용해서 동작한다.
 * > 내부 스레드 풀 사용의 문제점이 무엇인가?
 * 4코어 장비의 경우 4개의 스레드로 구성된 스레드 풀을 사용하는 것이 좋다.
 * 이 4코어 장비에 100개의 스레드를 만들어 사용하면 CPU 컨텍스트 스위칭 오버헤드가 증가하고 효율이 급격하게 떨어진다.
 * 실제로 비동기, 논블로킹 방식으로 동작하는 단일 스레드 애플리케이션이 블로킹 방식으로 동작하면서 스레드 100개를 사용하는
 * 애플리케이션보다 처리량(throughput)이 더 높게 나온다는 사실은 자바스크립트 진영에서 이미 입증되고 있다.
 *
 * 리액티브 프로그래밍에서 모든 것은 리액티브해야 하며, 일부라도 리액티브하지 않고 블로킹된다면 애플리케이션이 제대로 동작하지 않는다.
 * 100% 리액티브 애플리케이션을 만들려면 데이터베이스와의 물리적 연결과 상호작용 과정에 비동기, 논블로킹 개념을 적용할 수 있는
 * 데이터베이스 드라이버가 필요하다.
 *
 *  ex) mongodb-driver-sync (리액티브가 아닌 전통적인 몽고디비 드라이버)
 *
 *  spring-boot-starter-data-mongodb-reactive
 *  4개의 의존관계가 포함돼있다.
 *  1) spring-boot-starter : 스타터를 연결해서 사용할 수 있게 해주는 스프링 부트 핵심 모듈
 *  2) spring-data-mongodb : 블로킹 방식 몽고디비 드라이버가 제외된 스프링 데이터 몽고디비
 *  3) mongodb-driver-reactivestreams : 몽고디비 공식 리액티브 스트림 드라이버
 *  4) reactor-core : 프로젝트 리액터 코어 모듈
 */
@SpringBootApplication
public class HackingSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(HackingSpringBootApplication.class, args);
	}
}