# Chapter1 introduction

## 우리의 목표

- "느낌"과 용어를 얻는다.
- 더 깊고 자세히는 다음에 알아본다.
- 인터을 예제로 접근한다.

## 개요

- 인터넷이 무엇인가?
- 프로토콜이 무엇인가?
- network edge; hosts, access net, physical media
- 네트워크 코어 : packet/ circuit switching, internet structure
- 성능 : loss, delay, throughput(처리량)
- 보안
- 프로토콜 레이어와 서비스 모델
- 역사

## 1.1 What is the Internet

### 인터넷이란 무엇인가 : “nuts and bolts” view

- 수많은 연결된 네트워크 기기
  - hosts = end systems
    - running network apps
  - PC, server, 노트북, 스마트폰 등등
- communication links
  - fiber, copper, radio, astellite
  - transmission rate: bandwidth (전송률 : 대역폭)
- 패킷 스위치 : 패킷들(chunks of data)을 전송
  - 라우터와 스위치가 있다.
- internet은 "network of networks"이다.
  - 내부적으로 연결된 ISP들이다.
- protocol들로 메시지 전송, 수신을 컨트롤 한다.
  - e.g., TCP, IP, HTTP, Skype, 802.11
- 인터넷 표준
  - RFC : Request for comments
  - IETF : Internet Engineering Task Force

### 인터넷이란 무엇인가 : 서비스 관점

- 어플리케이션에 서비스를 제공하는 인프라
  - Web, VoIP, email, games, ecommerce, social nets,
- 앱에 프로그래밍 인터페이스를 제공
  - 인터넷에 "연결(connect)"하기 위해 앱 프로그램을 보내고 받는 것을 허용하는 훅
  - 우편서비스와 유사한 서비스 옵션을 제공

### 프로토콜이란 무엇인가?

프로토콜은 형식, 네트워크 엔티티 간에 주고 받는 메시지의 순서, 메시지 전송, 수신에 대한 조치를 정의합니다
