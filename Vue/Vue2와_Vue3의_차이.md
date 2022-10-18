오늘은 Vue 2와 Vue 3의 차이가 모르는 나를 위해 알아보도록 하겠다.

---

가장 큰 차이는 Vue 2는 Options API를 사용하고 Vue 3은 Composition API를 사용한다.

세부적인 내용은 시작해 보자!

## Creating App의 차이

> **Vue2**와** Vue3**은 앱을 만들 때부터 차이가 있다.

** Vue2**

```js
import Vue from "vue";
import App from "./App.vue";

Vue.config.productionTip = false;

new Vue({
  render: (h) => h(App),
}).$mount("#app");
```

** Vue3**

```js
import { createApp } from "vue";
import App from "./App.vue";
import "./index.css";

createApp(App).mount("#app");
```

## Multiple Root

> ** Vue2**에서는 template 안에 root node가 하나만 있어야 했다.
> ** Vue3**에서는 전혀 상관 없다.

** Vue2**

```Vue
<template>
	<div>
    	<p>모야호</p>
        <button>먕</button>
    </div>
</template>
```

** Vue3**

```Vue
<template>
    <p>모야호</p>
    <button>먕</button>
</template>
```

차이가 느껴지나? root node를 하나로 제한하기 위해 쓸데없이 태그 하나로 감쌀 필요가 사라졌다!
약간 스벨트가 생각이 난다

## Computed를 사용하는 방법의 차이

> ** Vue2**에서는 computed 블록 안에 계산될 값들을 넣어야 했다.
> ** Vue3**에서는 setup()안에서 변수 선언시 computed(() => {return \_}); 형식으로 사용이 가능하다.

## Watch를 사용하는 방법의 차이

watch는 특정 값을 바라보다 변경이 발생하면 호출된다. 대부분의 경우 computed 속성을 사용하는 것이 더 적절하다. 하지만 데이터 변경에 의한 응답으로 비동기 혹은 비용이 많이 드는 작업을 하려고 할 때 watch가 유용하다.

** Vue2**

```js
watch : {
	name(newVal, oldVal){
		console.log(`${newVal} ${oldVal}`);
    }
}
```

** Vue3**

```js
const name = ref("");
watchEffect(() => {
  console.log(name.value);
});
```
