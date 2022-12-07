package com.example.consumer._admin;

/**
 실제 운영환경에서는 프로듀서와 컨슈머를 통해 데이터를 주고받는것 만큼 카프카에 설정된 내부 옵션을 설정하고 확인하는것이 중요하다.
 내부 옵션을 확인하는 가장 확실한 방법은 브로커 중 한대에 접속하여 카프카 브로커 옵션을 확인하는 것이다. 이는 매우 번거롭다.
 카프카 클라이언트에서는 내부 옵션들을 설정하거나 조회하기 위해 AdminClient 클래스를 제공한다.
 이 클래스를 활용하면 클러스터의 옵션과 관련된 부분을 자동화할 수 있다.

 활용예시
 1) 카프카 컨슈머를 멀티 스레드로 생성할때, 구독하는 파티션 개수만큼 스레드를 생성하고 싶을때, 스레드 생성 전에
 해당 토픽의 파티션 개수를 어드민 API를 통해 가져올 수 있다.
 2) AdminClient 클래스로 구현한 웹 대시보드를 통해 ACL(Access Control List)이 적용된 클러스터의 리소스 접근 권한
 규칙 추가를 할 수 있다.
 3) 특정 토픽의 데이터양이 늘어남을 감지하고 AdminClient 클래스로 해당 토픽의 파티션을 늘릴 수 있다.
 */
public class AdminClient_제공 {
}
