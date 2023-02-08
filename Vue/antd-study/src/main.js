import { createApp } from "vue";
import Antd from "ant-design-vue";
import App from "./App";
import "ant-design-vue/dist/antd.css";
import "./assets/global.css";

const app = createApp(App);

app.use(Antd).mount("#app");
