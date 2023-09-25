var choiceForm = document.getElementById("ipform");
var resultImage = document.getElementById("resultImage");

function result() {
  const selectedChoice = document.querySelector(
    'input[name="favclub"]:checked'
  );

  if (selectedChoice) {
    var choiceValue = selectedChoice.value;

    if (choiceValue === "Kachori") {
      alert("Taste of Gujarat!!!");
      return true;
    } else if (choiceValue === "Jalebi") {
      alert("The sweet noodle of India!!!");
      return true;
    } else if (choiceValue === "Pakora") {
      alert("A quintessential Indian snack!!!");
      return true;
    } else if (choiceValue === "Chaat") {
      alert("The watery snack of India!!");
      return true;
    } else if (choiceValue === "Vadapav") {
      alert("Burger of India!!");
      return true;
    } else if (choiceValue === "Idli") {
      alert("Savory Indian Cake!!!");
      return true;
    } else if (choiceValue === "Naan") {
      alert("The exclusive Indian Breads!!!");
      return true;
    }
  } else {
    alert("Please select a choice.");
    return false;
  }
}
