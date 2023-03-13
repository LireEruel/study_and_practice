class Main {
  constructor($body) {
    this.$body = $body;
    this.render();
    this.boxCount = 0;
  }

  render() {
    const $main = document.createElement("main");
    const $container = document.createElement("div");
    const $btnGroup = document.createElement("div");
    const $appendBoxButton = document.createElement("button");

    this.$body.appendChild($main);
    $main.appendChild($btnGroup);
    $btnGroup.appendChild($appendBoxButton);
    $main.appendChild($container);

    $appendBoxButton.textContent = "append New Box";
    $appendBoxButton.addEventListener("click", () => this.addBox($container));
    $container.className = "container";
  }

  addBox($container) {
    const $box = document.createElement("div");
    $box.textContent = "Box" + this.boxCount;
    $box.className = "box";
    $container.appendChild($box);
    this.boxCount++;
  }
}

export default Main;
