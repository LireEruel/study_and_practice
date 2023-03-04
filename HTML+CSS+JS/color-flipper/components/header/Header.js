class Header {
  constructor($body) {
    this.$body = $body;
    this.render();
  }

  render() {
    const nav = document.createElement("nav");
    const div = document.createElement("div");
    const h4 = document.createElement("h4");
    const ul = document.createElement("ul");

    nav.appendChild(div);
    div.appendChild(h4);
    div.appendChild(ul);

    nav.setAttribute("class", "nav");
    div.setAttribute("class", "nav-center");

    h4.textContent = "Color Flipper";
    h4.setAttribute("class", "title");

    this.addListItem(ul, "Simple");
    this.addListItem(ul, "Hex");

    this.$body.appendChild(nav);
  }

  addListItem(ul, text) {
    console.log;
    const li = document.createElement("li");
    const anchor = document.createElement("a");
    ul.appendChild(li);
    li.appendChild(anchor);
    anchor.textContent = text;
  }
}

export default Header;
