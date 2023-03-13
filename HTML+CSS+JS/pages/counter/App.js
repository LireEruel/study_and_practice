class App {
  constructor($body) {
    this.$body = $body;
    this.render();
    this.count = 0;
  }

  render() {
    // element 추가
    const main = document.createElement("main");
    const container = document.createElement("div");
    const title = document.createElement("h1");
    const count = document.createElement("span");
    const buttonContainer = document.createElement("div");
    const decreaseBtn = document.createElement("button");
    const resetBtn = document.createElement("button");
    const increaseBtn = document.createElement("increase");

    // body에 element 연결

    this.$body.appendChild(main);
    main.appendChild(container);
    container.appendChild(title);
    container.appendChild(count);
    container.appendChild(buttonContainer);
    buttonContainer.appendChild(decreaseBtn);
    buttonContainer.appendChild(resetBtn);
    buttonContainer.appendChild(increaseBtn);

    container.className = "container";
    title.textContent = "Counter";
    count.id = "value";
    count.textContent = "0";

    buttonContainer.className = "button-container";

    decreaseBtn.classList = "btn decrease";
    decreaseBtn.textContent = "DECREASE";
    resetBtn.classList = "btn reset";
    resetBtn.textContent = "RESET";
    increaseBtn.classList = "btn increase";
    increaseBtn.textContent = "INCREASE";
  }
}

export default App;
