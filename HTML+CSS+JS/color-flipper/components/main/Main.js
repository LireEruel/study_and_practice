class Main {
  constructor($body, mode) {
    this.$body = $body;
    this.mode = mode;
    this.backgroundColor = "#F1f5f8";
    this.render();
  }

  render() {
    const main = document.createElement("main");
    const container = document.createElement("div");
    const h2 = document.createElement("h2");
    const colorSpan = document.createElement("span");
    const button = document.createElement("button");

    main.appendChild(container);
    container.appendChild(h2);
    container.appendChild(button);

    container.setAttribute("class", "container");

    h2.textContent = "Background Color : ";

    button.textContent = "CLICK ME";
    h2.appendChild(colorSpan);
    colorSpan.textContent = this.backgroundColor;
    colorSpan.setAttribute("class", "color");

    button.addEventListener("click", () => {
      console.log(this.mode, this.backgroundColor);
    });

    this.$body.appendChild(main);
  }
}

export default Main;
