# **Cloud Monitoring overview**

[Cloud Monitoring overview | Google Cloud](https://cloud.google.com/monitoring/docs/monitoring-overview)

## Cloud Monitoring services란?

Cloud Monitoring은 사용 중인 다른 Google Cloud 서비스와 application의 상태와 성능을 파악하는 데 사용할 수 있는 다양한 서비스를 제공한다.

### Alerts and notifications

Performance metric의 값이 사전에 정의한 수치에 닿았을 때 알림을 보낼 수 있는 서비스. 이렇게 하려면 alerting police를 생성하면 된다. ([https://cloud.google.com/monitoring/alerts](https://cloud.google.com/monitoring/alerts))

이때 알림은 email, Cloud Mobile App, Slack 같은 서비스로 보낼 수 있다.

### **Data collection and storage**

Cloud Monitoring이 수집 및 저장하는 metric data의 종류

- Google Cloud services에서 생성된 system metrics
  - 서비스가 어떻게 동작하는지 정보를 제공
- System and application metrics
  - Ops Agent가 수집한 Compute Engine instance에서 실행되는 application 및 system resources 의 Metric
  - Ops Agent가 third-party plugin에서 Metric을 수집하도록 구성할 수 있다.
    - Apache, Nginx web servers, MongoDB, PostgreSQL
- 사용자 정의 metric (User defined metrics)
  - Cloud Monitoring API를 사용하거나 OpenTelemetry 같은 라이브러리를 사용하여 수집
- External metrics
  - 오픈 소스 라이브러리나 third-party에서 정의한 외부 metric
- Prometheus metric
  - Google Cloud Managed Service for Prometheus 에서 수집 하거나 Ops Agent와 **Prometheus receiver** 또는 **OTLP receiver**를 사용하여 수집한 metric
- Log-based metrics
  - [Cloud Logging](https://cloud.google.com/logging/docs) 에 기록된 로그에 대한 숫자 정보를 기록하는 [로그 기반](https://cloud.google.com/logging/docs/logs-based-metrics) 측정 항목
  - Google-defined log-based metrics에는 서비스에서 감지된 오류 수와 Google Cloud 프로젝트에서 수신한 총 로그 항목 수가 포함된다.
  - 로그 기반 측정 항목을 직접 정의할 수도 있다.

## **Cloud Monitoring data model**

- **Metric type**
  - Monitoring의 측정 대상을 나타낸다.
  - 예시에는 VM의 CPU utilization 과 Disk의 사용량 등이 있다.
- **Time series**
  - 메트릭의 타임스탬프가 찍힌 측정값들과, 그 측정값의 출처 및 의미에 대한 정보를 담고 있는 데이터 구조
  - points
  - 시간 정보가 측정 값 배열
  - time series의 time stamp, time pointer 정도로 이해하면 된다.
    - 값의 의미를 이해하려면 time series에 포함된 다른 데이터와 해당 데이터의 정의 참조 필요resource
  - `"points": [ { "interval": { "startTime": "2020-07-27T20:20:21.597143Z", "endTime": "2020-07-27T20:20:21.597143Z" }, "value": { "doubleValue": 0.473005 } }, { "interval": { "startTime": "2020-07-27T20:19:21.597239Z", "endTime": "2020-07-27T20:19:21.597239Z" }, "value": { "doubleValue": 0.473025 } }, ],`
  - 모니터링 되고 있는 하드웨어 또는 소프트웨어 컴포넌트의 정보
  - 클라우드 모니터링에서는 하드웨어 또는 소프트웨어 컴포넌트를 `*monitored resource` 로 부른다.\*
    - `monitored resource` 의 종류
      - Compute Engine instances
      - App Engine applications
      - [Monitored resource types | Cloud Monitoring | Google Cloud](https://cloud.google.com/monitoring/api/resources)
  - `resource` 필드의 예시

    - `type`
      - 모니터링되는 리소스 나열
      - `type` 이 `gce_instance` 라는 것은 측정이 **Compute Engine VM instance**에서 이루어진다는 것을 의미
    - `labels`
      - 모니터링되는 리소스에 대한 추가 정보를 제공하는 키-값 쌍
      - `gce_instance` 유형의 경우 라벨은 모니터링 대상 VM 인스턴스를 식별

    **metric**

  - `"resource": { "type": "gce_instance", "labels": { "instance_id": "2708613220420473591", "zone": "us-east1-b", "project_id": "sampleproject" } }`
  - 측정 중인 항목 정보
  - **metric** 필드 예시
    - **labels**
      - 측정에 대한 추가 정보를 제공하는 키-값 쌍이 포함
      - [\*\*`MetricDescriptor`](https://cloud.google.com/monitoring/api/ref_v3/rest/v3/projects.metricDescriptors?hl=ko#MetricDescriptor) 의 일부로 정의\*\*
      - [**`compute.googleapis.com/instance/cpu/utilization`**](https://cloud.google.com/monitoring/api/metrics_gcp?hl=ko#compute/instance/cpu/utilization) 측정항목의 **`MetricDescriptor`**에는 **`instance_name`** 라벨이 포함
    - **type**
      - GCP의 경우 `type` 필드는 서비스 및 모니터링되는 항목을 지정
      - `type`이 `custom` 으로 시작하면 커스텀 측정 항목
      - `type`이 `external` 로 시작하면 서드 파티 측정 항목metricKind
  - `"metric": { "labels": { "instance_name": "test" }, "type": "compute.googleapis.com/instance/cpu/utilization" },`
  - 시계열 내의 인접한 측정 값 간의 관계
  - **`GAUGE`** 측정항목은 특정 시점에 측정되는 항목의 값을 저장(예: 시간별 온도 기록).
  - **`CUMULATIVE`** 측정항목은 특정 시점에 측정되는 항목의 누적 값을 저장(예: 차량의 주행 거리).
  - **`DELTA`** 측정항목은 지정된 기간 동안 측정된 항목의 값 변화량을 저장(예: 주식 종목의 손익을 나타내는 종목 요약)
  - valueType
  - 측정 값의 데이터 유형
  - 타입 : **`INT64`**, **`DOUBLE`**, **`BOOL`**, **`STRING`**, **`DISTRIBUTTION`**
