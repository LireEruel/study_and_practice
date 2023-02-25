let inputText = document.getElementById("input");

const Clear = () => {
  inputText.value = "";
};

const Solve = (input) => {
  switch (input) {
    case "%":
      if (isNatualNumber(inputText.value[inputText.value.length - 1])) {
        inputText.value += input;
      } else {
      }
      break;
    case "/":
      if (isNatualNumber(inputText.value[inputText.value.length - 1])) {
        inputText.value += input;
      } else {
      }
      break;
    case "*":
      if (isNatualNumber(inputText.value[inputText.value.length - 1])) {
        inputText.value += input;
      } else {
      }
      break;
    case "-":
      if (isNatualNumber(inputText.value[inputText.value.length - 1])) {
        inputText.value += input;
      } else {
      }
      break;
    case "+":
      if (isNatualNumber(inputText.value[inputText.value.length - 1])) {
        inputText.value += input;
      } else {
      }
      break;
    case "00":
      if (
        inputText.value[inputText.value.length - 1] == "0" ||
        isNatualNumber(inputText.value[inputText.value.length - 1])
      ) {
        inputText.value += input;
      } else {
      }
      break;
    case "0":
      if (
        inputText.value[inputText.value.length - 1] == "0" ||
        isNatualNumber(inputText.value[inputText.value.length - 1])
      ) {
        inputText.value += input;
      } else {
      }
      break;
    case ".":
      if (isNatualNumber(inputText.value[inputText.value.length - 1])) {
        inputText.value += input;
      } else {
      }
      break;
    default:
      inputText.value += input;
      break;
  }
};

function isNatualNumber(char) {
  console.log(char);
  const num = parseInt(char);
  if (num > 0 && num < 10) return true;
  else return false;
}

function Back() {
  if (inputText.value.length > 0) {
    inputText.value = inputText.value.slice(0, -1);
    console.log(inputText.value);
  }
}
