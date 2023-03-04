import Header from "./components/header/Header.js";
import Main from "./components/main/Main.js";

let isSimpleMode = true;
const setMode = (mode) => {
  isSimpleMode = mode;
};

new Header(document.querySelector("body"), setMode);
new Main(document.querySelector("body"), isSimpleMode);
