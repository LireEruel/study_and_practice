[##_Image|kage@RtuJx/btsNUvYMMXP/x0LtaVZgi9PDAkTT7aBShk/img.jpg|CDM|1.3|{"originWidth":939,"originHeight":439,"style":"alignCenter","caption":"쿠버네티스 클러스터 구성 요소"}_##]

## 컨트롤 플레인 컴포넌트

컨트롤 플레인 컴포넌트는 한마디로, 클러스터를 전반적으로 관리하는 핵심 컴포넌트이다.

**컨트롤 플레인 컴포넌트가 하는 일**

- 스케줄링 수행
- 클러스터 이벤트 감지 및 반응
  - 파드 생성, 노드 장애 등 이벤트를 감지하고 필요한 조치 수행 (→ kube-controller-manager가 담당)
- API 제공
  - kubectl 등에서 요청하면 이를 처리하고 상태를 etcd에 저장 / 조회
- 클러스터 상태 저장
- 원하는 상태 유지
  - 상태가 사용자가 정의한 상태와 다르면 자동으로 조절 (controller-manager)
- 네트워크 정보 전달

**컨트롤 플레인 컴포넌트의 위치**

- 클러스터 내 어떤 머신이라도 동작 가능
- 일반적으로 간결성을 위해 한 머신 안에 모든 컨트롤 플레인 컴포넌트를 구동 시킴.
  - 이 때, 사용자 컴포넌트는 해당 머신 상에 동작시키지 않음.
- 여러 머신에서 실행되는 컨트롤 플레인 예제 : [https://kubernetes.io/docs/setup/production-environment/tools/kubeadm/high-availability/](https://kubernetes.io/docs/setup/production-environment/tools/kubeadm/high-availability/)

[Creating Highly Available Clusters with kubeadm

This page explains two different approaches to setting up a highly available Kubernetes cluster using kubeadm: With stacked control plane nodes. This approach requires less infrastructure. The etcd members and control plane nodes are co-located. With an ex

kubernetes.io](https://kubernetes.io/docs/setup/production-environment/tools/kubeadm/high-availability/)

### 컨트롤 플레인 컴포넌트의 종류 

1.  kube-apiserver
2.  etcd
3.  kube-scheduler
4.  kube-controller-manager
5.  cloud-controller-manager

#### 1\. kube-apiserver

- 쿠버네티스 API를 노출하는 쿠버네티스 컨트롤 플레인 컴포넌트
- API 서버는 컨트롤 플레인의 Frontend 이다.
- 수평으로 확장되도록 디자인
  - 더 많은 인스턴스를 배포해서 확장 가능.
  - 여러 인스턴스를 실행하고 트래픽 조율 가능.

#### 2\. etcd

- 모든 클러스터의 데이터를 담는 key-value 저장소.
- 클러스터의 모든 상태 정보가 저장됨.
- Raft consensus 알고리즘 기반
  - 여러 노드 간 데이터 일관성 보장
- 역할
  - 클러스터 상태 저장
  - 고가용성 구성 가능
  - API 서버와 연동

#### 3\. kube-scheduler

- 노드가 배정되지 않은 새로 생성된 파드를 감지하고, 실행할 노드를 선택
- 스케줄링 방식
  1.  Filtering ㅣ 파드 수용 불가한 노드 제외
  2.  Scoring | 남은 노드 중 점수를 매겨 가장 적합한 노드 선택

#### 4\. kube-controller-manager

- 컨트롤러 프로세스를 실행하는 컨트롤 플레인 컴포넌트
- 각 컨트롤러는 **논리적으로 분리**된 프로세스지만, 복잡성을 낮추기 위해 모두 **단일 바이너리로 컴파일**되고 **단일 프로세스 내에서 실행**된다.
- 컨트롤러 종류
  - node controller
  - job controller
  - endpointslice controller
    - service와 pod 사이의 연결고리 제공을 위한 EndpointSlice 오브젝트를 채움.
  - serviceaccount controller
    - 새로운 namespace에 대한 기본 ServiceAccount 생성

#### 5\. cloud-controller-manager

- 클라우드별 컨트롤 로직을 포함하는 쿠버네티스 컨트롤 플레인 컴포넌트
  - 쿠버네티스가 AWS, GCP, Azure 같은 클라우드 서비스와 연결되도록 도움
  - cloud-controller-manager를 통해 클러스터를 클라우드 공급자의 API에 연결하고, 해당 클라우드 플랫폼과 상호작용하는 컴포넌트와 클러스터와만 상호작용하는 컴포넌트를 구분
  - cloud-controller-manager는 클라우드 제공자 전용 컨트롤러만 실행.
  - 만약 로컬에서 돌리는 경우, 클라우드랑 연결되지 않으므로 cloud-controller-manager는 실행되지 않음.
- 논리적 분리되었지만 단일 프로세스에서 실행
  - kube-controller-manager와 마찬가지로 각 컨트롤러는 **논리적으로 분리**된 프로세스지만, 복잡성을 낮추기 위해 모두 **단일 바이너리로 컴파일**되고 **단일 프로세스 내에서 실행**된다.
- cloud provider에 읜존성을 가지는 컨트롤러
  - 노드 컨트롤러
    - 노드가 응답을 멈춘 후 클라우드 상에서 삭제되었는지 판별을 위해 cloud provider에게 확인
  - 라우트 컨트롤러
    - 클라우드 인프라에 경로 구성
  - 서비스 컨트롤러
    - cloud provider loadbalencer를 생성, 업데이트, 삭제
