# 쿠버네티스 Ingress와 Egress: 네트워크 출입문

쿠버네티스(Kubernetes)는 클러스터 내부의 애플리케이션들이 안정적으로 통신하고 외부와 연결되도록 다양한 네트워크 구성 요소를 제공합니다. 그중에서도 **Ingress**와 **Egress**는 외부와 내부 간 트래픽 흐름의 "입구와 출구"를 담당하는 중요한 개념입니다.

---

##  Ingress

> **Ingress = 외부(클러스터 바깥)에서 내부(Pod)로 들어오는 HTTP/HTTPS 요청을 관리하는 규칙**

### Ingress의 역할

- 외부 사용자가 클러스터 내 서비스에 접속할 수 있게 해줌
- 도메인, 경로, 포트를 기반으로 트래픽을 적절한 서비스로 라우팅
- 예: `mydomain.com/web` → `web-service`로 전달

#### 구성 요소

- `Ingress Resource`: 라우팅 규칙 정의
- `Ingress Controller`: 규칙을 실제로 적용해 트래픽을 전달

---

### Ingress Resource

> **트래픽을 어떤 서비스로 보낼지 선언적으로 정의한 YAML 리소스**

```
apiVersion: networking.k8s.io/v1
kind: Ingress
metadata:
  name: example-ingress
  annotations:
    nginx.ingress.kubernetes.io/rewrite-target: /
spec:
  rules:
    - host: myapp.com
      http:
        paths:
          - path: /web
            pathType: Prefix
            backend:
              service:
                name: web-service
                port:
                  number: 80
```

#### 핵심 기능

- 여러 서비스에 경로 기반 라우팅 가능
- TLS(HTTPS) 적용 가능
- 인증, 리다이렉션 등 고급 옵션 설정 가능

---

### Ingress Controller

> **Ingress Resource의 규칙을 실질적으로 적용하는 컨트롤러**

Ingress 리소스는 "요청이 어떻게 흘러야 한다"는 **정책만 정의**하고, 이걸 **실제로 실행**해주는 게 Ingress Controller

#### 대표적인 Ingress Controller

- `nginx-ingress-controller` (가장 널리 사용됨)
- `traefik`
- `HAProxy`
- 클라우드 제공자의 Managed Ingress (`GKE`, `EKS`, `AKS` 등)

---

## Egress

> **Egress = 내부(Pod)에서 외부(인터넷 등)로 나가는 트래픽**

**Ingress**가 들어오는 트래픽을 제어하는 반면, **Egress는 나가는 트래픽을 제어**

EX:

- `Pod → 외부 API 서버 접속`
- `Pod → 외부 데이터베이스 연결`

#### Egress 제어 방법

- **Egress NetworkPolicy**를 통해 제어
- `policyTypes: - Egress egress: - to: - ipBlock: cidr: 0.0.0.0/0`
- 클러스터 외부로 나가는 트래픽을 제한하고 보안 강화

---

## 정리

|                        |                                                                |
| ---------------------- | -------------------------------------------------------------- |
| **Ingress**            | 외부에서 내부로 들어오는 HTTP/HTTPS 트래픽 관리                |
| **Ingress Resource**   | Ingress 규칙 정의 (경로, 도메인 등)                            |
| **Ingress Controller** | 규칙을 실제로 처리하는 실행체                                  |
| **Egress**             | 내부에서 외부로 나가는 트래픽 관리 (보통 NetworkPolicy로 제어) |

- **Ingress는 웹 트래픽의 입구** 역할을 하며, 사용자 요청을 서비스에 전달
- **Ingress Resource는 규칙 선언**, **Ingress Controller는 실제 실행**
- **Egress는 트래픽의 출구**를 관리하며 보안 제어에 중요
- 둘 다 잘 활용하면 보안성, 확장성, 운영 효율성이 크게 향상

---
