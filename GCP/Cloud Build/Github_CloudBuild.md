오늘은 Cloud Build를 통해 CICD를 간단히 구축하는 방법에 대해 소개하겠습니다.

일단 Github는 owner 권한이 필요합니다.

## Github Repo Owner 권한 확인하기.

[##_Image|kage@y7ahu/btsNXzmoM5e/SrKbnOO6kPktKNHmvEWrK0/img.png|CDM|1.3|{"originWidth":371,"originHeight":76,"style":"alignCenter"}_##]

상단바에서 Setting으로 접속

[##_Image|kage@de6Y0N/btsNWG0pBdn/SsfQ0I751IJJS1pJPlwMIK/img.png|CDM|1.3|{"originWidth":357,"originHeight":163,"style":"alignCenter"}_##]

사이드바에 Collaborators and teams 클릭

[##_Image|kage@crUYY2/btsNWtN57hC/FtMP7KV3OGzDNk9sv8vAbk/img.png|CDM|1.3|{"originWidth":252,"originHeight":91,"style":"alignCenter"}_##]

본인의 역할이 admin 인 것을 확인!

## GCP에서 Cloud Build 설정하기

### Cloud Build 진입하기 

상단바에서 Cloud Build 검색 후 클릭

[##_Image|kage@yvTr2/btsNYCbAtD2/F7mSDIkVb5emCpgfPga7k1/img.png|CDM|1.3|{"originWidth":814,"originHeight":235,"style":"alignCenter"}_##]

사이드바에서 Repositores 선택

[##_Image|kage@4r7A8/btsNWSUlWWr/laQsiPWJGCYp2yADl7IJhk/img.png|CDM|1.3|{"originWidth":291,"originHeight":211,"style":"alignCenter"}_##][##_Image|kage@d9sxIE/btsNXCcpM9O/Kb5YvHzi6OtQvNFssmo5QK/img.png|CDM|1.3|{"originWidth":757,"originHeight":404,"style":"alignCenter"}_##]

2md gen 에서 진행합시다.   
순서는 Connection 생성 후 repository 연결입니다.

### Connection 생성하기

[##_Image|kage@yftxW/btsNX1bXsH1/oZ0CilKS8qmwepQazzK1i0/img.png|CDM|1.3|{"originWidth":532,"originHeight":160,"style":"alignCenter"}_##]

Create host connection 클릭

[##_Image|kage@bangYf/btsNXB5Gf2r/axIvyIvs9C0DxtXdqr8mik/img.png|CDM|1.3|{"originWidth":906,"originHeight":404,"style":"alignCenter"}_##]

region은 github의 리전과 같아야 합니다.

저는 서울로 하겠습니다.

[##_Image|kage@XtvJH/btsNYFsCTTL/uxjzuVC9reTK6UYk5LaHl1/img.png|CDM|1.3|{"originWidth":587,"originHeight":192,"style":"alignCenter"}_##]

이름은 원하는 것으로 하시면 됩니다.

[##_Image|kage@0M8fC/btsNW2oRGT8/dJXsjugdc5chTIFzQEkDdK/img.png|CDM|1.3|{"originWidth":125,"originHeight":74,"style":"alignCenter"}_##]

그리고 아래 Connect 클릭

[##_Image|kage@beQL0y/btsNXX1F3s8/VlmMCWHVL8Yb5Rhw2s7690/img.png|CDM|1.3|{"originWidth":201,"originHeight":131,"style":"alignCenter"}_##]

팝업창이 뜨면 Continue 클릭

[##_Image|kage@difEGi/btsNWrCGe6u/2QHFFGR9BYwtJoxdxTkS8K/img.png|CDM|1.3|{"originWidth":550,"originHeight":193,"style":"alignCenter"}_##]

연결하고자 하는 Repo가 있는 organigation을 선택해주세요.

[##_Image|kage@c6XQB6/btsNWlJdclU/rmfkZMD9449iJKcYOjhMcK/img.png|CDM|1.3|{"originWidth":768,"originHeight":110,"style":"alignCenter"}_##]

그럼 커넥션 생성 완료!

### Repository 연결하기

[##_Image|kage@tQ8Gp/btsNXoMgDmN/JsS9cM0zQWY5nJbxkXlM91/img.png|CDM|1.3|{"originWidth":193,"originHeight":85,"style":"alignCenter"}_##]

버튼 클릭

[##_Image|kage@bNAg7E/btsNV6Z9td8/3wacLNSecXsJAkIMvxndOK/img.png|CDM|1.3|{"originWidth":538,"originHeight":481,"style":"alignCenter"}_##]

아까 만든 커넥션을 선택하고 연결할 Repository 선택하기.  
여기서 만약 Repo가 보이지 않는다면 Repo에 Owner 권한 있는지 확인하기!

Member는 보이지 않아요!

선택 후 Link 버튼 클릭하기

## Trigger 생성하기

[##_Image|kage@lh45o/btsNXV3OuzF/KQEiZeB21oNHpDpLdfHhiK/img.png|CDM|1.3|{"originWidth":291,"originHeight":234,"style":"alignCenter"}_##]

사이드바에서 Triggers 클릭

[##_Image|kage@E79i3/btsNXPvMdJF/SUGykB3rJPzYvvh4uklfC1/img.png|CDM|1.3|{"originWidth":702,"originHeight":101,"style":"alignCenter"}_##]

상단바에서 Connect repository 클릭하기

[##_Image|kage@q7kX8/btsNXF73Egy/VoLV9E2mJw6JXnG2bFoQyk/img.png|CDM|1.3|{"originWidth":551,"originHeight":567,"style":"alignCenter"}_##]

아까랑 똑같이 Seoul 선택하기.

Authenticate 는 저는 알아서 하고 넘어갔는데 혹시 뭐 뜨는사람은 하라는 대로 인증하면 될겁니다.

[##_Image|kage@b3K26n/btsNXzmq1il/2fKiNtP8YM9X0ljpYcVH60/img.png|CDM|1.3|{"originWidth":551,"originHeight":498,"style":"alignCenter"}_##]

레포 선택하고 밑에 체크도 꼭 해야합니다.

그리고 Connect 클릭

[##_Image|kage@cwwcH8/btsNWrCHwtI/BRQ81CvdtNMKe7XajB29i0/img.png|CDM|1.3|{"originWidth":541,"originHeight":380,"style":"alignCenter"}_##]

그러면 밑에 이렇게 뜹니다. Create a trriger 클릭!

[##_Image|kage@lQrMI/btsNYpwORNu/yGkjVdeWdffn5Fsmk0YW3k/img.png|CDM|1.3|{"originWidth":557,"originHeight":200,"style":"alignCenter"}_##]

이름이 유니크 해야하니 유니크한 이름 잘 작성해줍니다. region도 잘 선택해주세요.

[##_Image|kage@bAiEAQ/btsNW5MFn9a/tjhSGucJm3J7FfeqDtERzK/img.png|CDM|1.3|{"originWidth":543,"originHeight":270,"style":"alignCenter"}_##]

설정도 잘 해줍니다.

[##_Image|kage@XV4sg/btsNXB5IliT/wo0JnBbmGNJ4JLZNOQKOZ1/img.png|CDM|1.3|{"originWidth":655,"originHeight":370,"style":"alignCenter"}_##]

[##_Image|kage@ei7mEK/btsNW5y7X3c/yTRJabTXqLMEWwb7NrFNlk/img.png|CDM|1.3|{"originWidth":567,"originHeight":554,"style":"alignCenter"}_##]

build logs를 Github에도 보 내게 설정하기.

그리고 서비스 어카운트를 적절하게 설정해줍니다.

[##_Image|kage@cePj8U/btsNYVIRspf/7LdIfzm8RKPS7953nSbPnk/img.png|CDM|1.3|{"originWidth":539,"originHeight":43,"style":"alignCenter"}_##]

여기서 Run을 누르면 수동으로 실행됩니다!

그러면 완성! Cloud Build에서 진행상황을 확인해보세요
