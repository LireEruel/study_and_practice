import Header from "./components/header/Header.js";
import Main from "./components/main/Main.js";

let isSimpleMode = true;

const setMode = (mode) => {
  isSimpleMode = mode;
  main.setMode(mode);
  main.render(mode);
};

new Header(document.querySelector("body"), setMode);
const main = new Main(document.querySelector("body"), isSimpleMode);
